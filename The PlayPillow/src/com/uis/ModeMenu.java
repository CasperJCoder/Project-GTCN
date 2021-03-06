package com.uis;

import com.view.Menu;
import javax.swing.JOptionPane;

/**
 * This menu is used to choose from modes.
 *
 * @version 2.6
 * @author Ilona, Casper.
 */
public class ModeMenu extends Menu implements com.upload.SystemConstants {

    // The MainMenu object to go back to
    private Menu mainMenu;
    // Set when an DLL has occured
    private boolean DLLError = false;
    // The selected mode from the menu by the user.
    private String selectedMode = null;

    /**
     * Creates new form ModeMenu. Meant for debugging.
     */
    public ModeMenu() {
        initComponents();
        setScreen();
    }

    /**
     * Creates new form ModeMenu that initialize the mainMenu object.
     */
    public ModeMenu(Menu mainMenu) {
        initComponents();
        setScreen();
        this.mainMenu = mainMenu;
    }

    /**
     * Retreive the mode selected.
     *
     * @return the selected mode.
     */
    public String getSelectedMode() {
        return selectedMode;
    }

    /**
     * Sets the selectedMode.
     *
     */
    public void setSelectedMode(String mode) {
        selectedMode = mode;
    }

    /**
     * Alerts this object that there has an DLL error occured (or not), so it
     * wil be displayed to the user.
     *
     * @param err
     */
    public void setDDLError(boolean err) {
        DLLError = err;
    }

    /**
     * Retreives info whether there has occured an error or not.
     *
     * @return true when there is an dll error and false otherwise.
     */
    public boolean isDLLError() {
        return DLLError;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        backButton = new javax.swing.JButton();
        inlineTitle = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        okayButton = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The PlayPillow 1.0 - Mode Menu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        backButton.setText("Terug");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        inlineTitle.setFont(new java.awt.Font("Kristen ITC", 0, 36)); // NOI18N
        inlineTitle.setText("Modes");
        getContentPane().add(inlineTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jRadioButton1.setText("FreeStyleMode");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 250, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jRadioButton2.setText("EasyGameMode");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        jRadioButton4.setText("MediumGameMode");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 270, 30));

        okayButton.setFont(new java.awt.Font("Kristen ITC", 0, 24)); // NOI18N
        okayButton.setText("Okay");
        okayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(okayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/GUIMenu.jpg"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Brings the user back to the mainmenu.
     *
     * @param evt from the user.
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        mainMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * Display the COMSelector after some checking has been done.
     *
     */
    public void showCOMSelector() {
        String title = "Mode";

        // Check if anything is selected, if not fill the appropiate message.
        if (selectedMode == null) {
            String message = null;

            message = "Er is geen mode geselecteerd";

            javax.swing.JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
            return;
        }



        // Provide some instructions
        String message = "Om de " + selectedMode + " te activeren moet u de USB kabel in bij de aansluiting inpluggen.\nDruk na het aansluiten op 'Volgende'.";
        String options[] = {"Volgende", "Annuleren"};
        int choice = JOptionPane.showOptionDialog(this, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

        // If the previous dialog is closed by the user stop the process of uploading.
        if (choice == -1 || choice == JOptionPane.NO_OPTION) {
            return;
        }

        // Check if an DDL error is set by other classes. If not, launch the COMSelector.
        if (DLLError) {
            JOptionPane.showMessageDialog(this, "Het lijkt er op dat u het bestand 'rxtxSerial.dll' nog niet heeft kopieer of dat deze corrupt is geraakt.\n"
                    + "Kopieer het bestand 'rxtxSerial.dll' naar " + javaLibPathWindows + " en herstart het programma.\nHet bestand 'rxtxSerial.dll' kunt "
                    + "u op de installatie CD terugvinden.",
                    "Error: missing rxtxSerial.dll", JOptionPane.ERROR_MESSAGE);
        } else {
            // Pass on the control to the COMSelector GUI.
            new COMSelector(this).setVisible(true);
        }
    }

    /**
     * Determines which radio button was pressed.
     *
     * @return the name of the button
     */
    public String getSelectedRadioButton() {
        // Check which button is selected

        if (jRadioButton1.isSelected()) {
            return jRadioButton1.getText();
        }
        if (jRadioButton2.isSelected()) {
            return jRadioButton2.getText();
        }
       
        if (jRadioButton4.isSelected()) {
            return jRadioButton4.getText();   
        }
        return null;
    }
    
    
    /**
     * Unselect all the radio buttons to nice it.
     *
     */
    public void unSelectRButtons() {
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton4.setSelected(false);
    }

    /**
     * This method will launch the COMSelector and provide instructions to the
     * user.
     *
     * @param evt generated by the user
     */
    private void okayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayButtonActionPerformed
        // Get the selected radio button
        String selectedMode = getSelectedRadioButton();
        setSelectedMode(selectedMode);

        // Okay now that all the necessary data is there, we can select the right COMPort for uploading.
        showCOMSelector();
    }//GEN-LAST:event_okayButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel inlineTitle;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton okayButton;
    // End of variables declaration//GEN-END:variables
}
