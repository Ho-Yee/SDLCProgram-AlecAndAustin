/*Austin Van Braeckel
*12/3/2018
*A Study guide interface that interactively allows the user to browse information
about the SDLC.
*/

import javax.swing.JOptionPane;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class StudyGuide extends javax.swing.JFrame {

    /**
     * Creates new form StudyGuide
     */
    public StudyGuide() {
        initComponents();
        //fills the notes array with the information from the data file
        readNotes(notes);
        //Displays the default notes (default seleciton of combo box)
        displayNotes(1);
        
    }
    
    //Initializes array for notes
    public Note[] notes;
    //Initializes a variable for the second window
    private Quiz secondWindow;
    
    /**
     * Reads the notes from the notes data file and stores all of them in an array
     * of Note objects
     * @param array of Note objects that is to be filled
     */
    public void readNotes(Note[] array){
        try {//Read file
            InputStream in = StudyGuide.class.getResourceAsStream("notes.txt");
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            /*
            FileReader fr = new FileReader("src\\notes.txt");
            BufferedReader br = new BufferedReader(fr);
            */
            //Set-up variables to be used in the loop
            boolean eof = false;
            String sID, text;
            int ID;
            //Create array list to temporarily store the notes
            ArrayList<Note> list = new ArrayList();
        
            //Repeats until the end of the file
            while(!eof){
                sID = br.readLine(); //Reads the first line
                if (sID == null){ //End of the file is reached
                    eof = true;
                } else { //Not end of the file
                    ID = Integer.parseInt(sID);
                    text = br.readLine();
                    //Creates note with the data file record and adds to list
                    Note n = new Note(ID, text);
                    list.add(n);
                }   
            }//End while loop
            
            //Fill array with the values in the list
            notes = new Note[list.size()];
            for (int i = 0; i < notes.length; i++){
                notes[i] = list.get(i); 
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "SDLC Study Guide - Alec & Austin", JOptionPane.ERROR_MESSAGE); //Prints error message for reading the file
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnQuiz = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        cbxCat = new javax.swing.JComboBox<>();
        lblCat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDLC Study Guide - Alec & Austin");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(640, 445));
        setPreferredSize(new java.awt.Dimension(640, 445));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 445));

        btnQuiz.setBackground(new java.awt.Color(153, 153, 255));
        btnQuiz.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btnQuiz.setText("Go to Quiz");
        btnQuiz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuizActionPerformed(evt);
            }
        });

        txtNotes.setEditable(false);
        txtNotes.setColumns(1);
        txtNotes.setLineWrap(true);
        txtNotes.setRows(5);
        txtNotes.setToolTipText("");
        txtNotes.setWrapStyleWord(true);
        txtNotes.setMaximumSize(new java.awt.Dimension(416, 230));
        txtNotes.setMinimumSize(new java.awt.Dimension(416, 230));
        txtNotes.setPreferredSize(new java.awt.Dimension(416, 230));
        txtNotes.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(txtNotes);
        txtNotes.getAccessibleContext().setAccessibleName("");

        lblTitle.setFont(new java.awt.Font("Stencil Std", 0, 60)); // NOI18N
        lblTitle.setText("SDLC Study Guide");

        cbxCat.setBackground(new java.awt.Color(153, 153, 255));
        cbxCat.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        cbxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SDLC", "Systems", "Gantt Charts", "Waterfall Model" }));
        cbxCat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCatActionPerformed(evt);
            }
        });

        lblCat.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        lblCat.setText("Choose a Category:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblCat)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 102, Short.MAX_VALUE)
                        .addComponent(btnQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuizActionPerformed
        //Check if the quiz window has already been created
        if(secondWindow == null){
            secondWindow = new Quiz(this);
        }
        //Hide this window (Study Guide)
        this.setVisible(false);
        //Set the other window to be visible (Quiz)
        secondWindow.setVisible(true);
    }//GEN-LAST:event_btnQuizActionPerformed

    public void displayNotes(int num){
        //Show the selected note categories
        
        //Creates a temporary String to store the selected category's notes
        String output = "";
        //Loops through the array and adds any of the related notes to the output
        for(Note n: notes){
            if (n.getID() == num){
                output += "\n  - " + n.getText();
            }
        } //end loop
        
        //Display the notes to the user
        txtNotes.setText(output);
        
    }
    
    private void cbxCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCatActionPerformed
        
        //Set-up variable to determine the category
        int catNum = 0;
        //Determines which category the user wishes to see
        if (cbxCat.getSelectedItem().equals(cbxCat.getItemAt(0))){
            catNum = 1;
        } else if (cbxCat.getSelectedItem().equals(cbxCat.getItemAt(1))) {
            catNum = 2;
        } else if (cbxCat.getSelectedItem().equals(cbxCat.getItemAt(2))) {
            catNum = 3;
        } else if (cbxCat.getSelectedItem().equals(cbxCat.getItemAt(3))) {
            catNum = 4;
        }
        
        //Display the notes of the specified category
        displayNotes(catNum);
    }//GEN-LAST:event_cbxCatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudyGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudyGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudyGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudyGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudyGuide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuiz;
    private javax.swing.JComboBox<String> cbxCat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtNotes;
    // End of variables declaration//GEN-END:variables
}
