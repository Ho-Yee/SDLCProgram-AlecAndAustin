/*Austin Van Braeckel
12/2/2018
A quiz interface that conducts an interactive multiple-choice quiz, also giving
a grade when the quiz is finished. Keeps track of the number of correct answers that
the user gets, and offers the option to restart the quiz.
 */

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;

public class Quiz extends javax.swing.JFrame {

    //Creates a variable for the first window
    private StudyGuide firstWindow;
    //Create array list to store the questions
    ArrayList<Question> questions = new ArrayList();
    //Set-up variable to store the correct answer's location (A, B, C, or D), and the correct question object
    private String correctLetter;
    private Question current;
    //Set-up variables to keep track of the user's score
    private int correctAnswers = 0, questionsLeft = 10, questionsAnswered = 0;

    /**
     * Creates new form Quiz
     *
     * @param m main window of the application - study guide
     */
    public Quiz(StudyGuide m) {
        initComponents();
        firstWindow = m;
        readQuestions(questions); //Fills the questions ArrayList
        //Displays first question
        correctLetter = nextQuestion(questions);
    }

    /**
     * Evaluates the user's answer, updates their score, and displays it, as
     * well as the correct answer as feedback if they are incorrect
     *
     * @param answer String of the correct letter - eg. "A"
     */
    public void evaluate(String answer) {
        //Set-up boolean to indicate if user is correct
        boolean correct = false;
        //Determines if the user's answer is correct
        if (btnA.isSelected() && answer.equalsIgnoreCase("A")) {
            correct = true;
        } else if (btnB.isSelected() && answer.equalsIgnoreCase("B")) {
            correct = true;
        } else if (btnC.isSelected() && answer.equalsIgnoreCase("C")) {
            correct = true;
        } else if (btnD.isSelected() && answer.equalsIgnoreCase("D")) {
            correct = true;
        } else { //incorrect
            //Displays correct answer
            txtQuestion.setText(txtQuestion.getText() + "\n----------\nIncorrect! Correct answer was \"" + answer + "\"!");
        }

        //adds to the user's score if they are correct
        if (correct) {
            correctAnswers++;
            txtQuestion.setText(txtQuestion.getText() + "\n----------\nCorrect!");
        }

        //Updates the other score variables and displays the new data
        questionsLeft--;
        questionsAnswered++;
        lblCorrectAnswers.setText("" + correctAnswers);
        lblQuestionsLeft.setText("" + questionsLeft);
        lblQuestionsAnswered.setText("" + questionsAnswered);
    }

    /**
     * Displays the next random question from the remaining questions in the
     * given array list and randomizes the position of the correct answer
     *
     * @param list ArrayList of Question objects that provides the questions to
     * display
     * @return String of the correct letter (to show the user if they get it
     * wrong)
     */
    public String nextQuestion(ArrayList<Question> list) {
        //Set-up variable to store the location of the correct answer
        String correctLetter;
        //generates a random number between 0 and the list size
        int rnum = (int) (Math.random() * list.size());
        current = list.remove(rnum).clone(); //removes the random question from the list and sets it as the current one
        //display current question with randomized answer positions
        String a, b, c, d;
        rnum = (int) (Math.random() * 4 + 1); //generates a random number between 1 and 4
        //determines the position of the correct answer
        if (rnum == 1) {
            a = current.getCorrect();
            //Fills the remaining letters with incorrect answers
            b = current.getIncorrect1();
            c = current.getIncorrect2();
            d = current.getIncorrect3();
            //Sets the correct letter to A
            correctLetter = "A";
        } else if (rnum == 2) {
            b = current.getCorrect();
            //Fills the remaining letters with incorrect answers
            a = current.getIncorrect1();
            c = current.getIncorrect2();
            d = current.getIncorrect3();
            //Sets the correct letter to B
            correctLetter = "B";
        } else if (rnum == 3) {
            c = current.getCorrect();
            //Fills the remaining letters with incorrect answers
            a = current.getIncorrect1();
            b = current.getIncorrect2();
            d = current.getIncorrect3();
            //Sets the correct letter to C
            correctLetter = "C";
        } else {
            d = current.getCorrect();
            //Fills the remaining letters with incorrect answers
            a = current.getIncorrect1();
            b = current.getIncorrect2();
            c = current.getIncorrect3();
            //Sets the correct letter to D
            correctLetter = "D";
        }//end if/else

        //displays question and answers
        txtQuestion.setText(current.getQuestion());
        txtA.setText(a);
        txtB.setText(b);
        txtC.setText(c);
        txtD.setText(d);

        return correctLetter;
    }

    /**
     * Reads the data from the "questions.txt" file and adds it to the given
     * array list
     *
     * @param list ArrayList of Question objects that to which the data is added
     */
    public void readQuestions(ArrayList<Question> list) {

        //Try to read file
        try {
            FileReader fr = new FileReader("src\\questions.txt");
            BufferedReader br = new BufferedReader(fr);

            //set-up variables for the loop
            boolean eof = false;
            String sIDNum, q, c, i1, i2, i3;
            int IDNum;

            //Repeats until end of file is reached
            while (!eof) {
                //Read first line of the record
                sIDNum = br.readLine();
                if (sIDNum == null) { //End of file is reached
                    eof = true;
                } else {
                    //Convert ID number String to an integer
                    IDNum = Integer.parseInt(sIDNum);
                    //Read the rest of the record into the variables
                    q = br.readLine();
                    c = br.readLine();
                    i1 = br.readLine();
                    i2 = br.readLine();
                    i3 = br.readLine();
                    //Create a question object with the data and add to the list
                    Question temp = new Question(q, c, i1, i2, i3, IDNum);
                    list.add(temp);
                }
            }//End loop

        } catch (IOException e) {
            System.out.println("Error: " + e); //Prints error message about reading the file
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        MultipleChoice = new javax.swing.ButtonGroup();
        btnBack = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        btnA = new javax.swing.JRadioButton();
        btnC = new javax.swing.JRadioButton();
        btnD = new javax.swing.JRadioButton();
        btnB = new javax.swing.JRadioButton();
        btnAnswer = new javax.swing.JButton();
        lblCorrectText = new javax.swing.JLabel();
        lblTotalText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCorrectAnswers = new javax.swing.JLabel();
        lblQuestionsAnswered = new javax.swing.JLabel();
        lblQuestionsLeft = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtB = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtC = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDLC Study Guide - Alec & Austin");
        setMaximumSize(new java.awt.Dimension(640, 445));
        setMinimumSize(new java.awt.Dimension(640, 445));
        setPreferredSize(new java.awt.Dimension(640, 445));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 445));

        btnBack.setBackground(new java.awt.Color(153, 153, 255));
        btnBack.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRestart.setBackground(new java.awt.Color(153, 153, 255));
        btnRestart.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btnRestart.setText("Restart");
        btnRestart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestart.setEnabled(false);
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        txtQuestion.setEditable(false);
        txtQuestion.setColumns(2);
        txtQuestion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQuestion.setLineWrap(true);
        txtQuestion.setRows(5);
        txtQuestion.setWrapStyleWord(true);
        txtQuestion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtQuestion);

        MultipleChoice.add(btnA);
        btnA.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        btnA.setText("A - ");
        btnA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });

        MultipleChoice.add(btnC);
        btnC.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        btnC.setText("C - ");
        btnC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        MultipleChoice.add(btnD);
        btnD.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        btnD.setText("D -");
        btnD.setToolTipText("");
        btnD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });

        MultipleChoice.add(btnB);
        btnB.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        btnB.setText("B - ");
        btnB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });

        btnAnswer.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 14)); // NOI18N
        btnAnswer.setText("Answer!");
        btnAnswer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnswer.setEnabled(false);
        btnAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });

        lblCorrectText.setText("Correct Answers:");

        lblTotalText.setText("Total Questions Answered:");

        jLabel1.setText("Questions Left to Answer:");

        lblCorrectAnswers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorrectAnswers.setText("       ");

        lblQuestionsAnswered.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestionsAnswered.setText("       ");

        lblQuestionsLeft.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestionsLeft.setText("       ");

        txtA.setEditable(false);
        txtA.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txtA.setColumns(2);
        txtA.setLineWrap(true);
        txtA.setRows(3);
        txtA.setWrapStyleWord(true);
        txtA.setBorder(null);
        jScrollPane2.setViewportView(txtA);

        txtB.setEditable(false);
        txtB.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txtB.setColumns(2);
        txtB.setLineWrap(true);
        txtB.setRows(3);
        txtB.setWrapStyleWord(true);
        txtB.setBorder(null);
        jScrollPane3.setViewportView(txtB);

        txtC.setEditable(false);
        txtC.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txtC.setColumns(2);
        txtC.setLineWrap(true);
        txtC.setRows(3);
        txtC.setWrapStyleWord(true);
        txtC.setBorder(null);
        jScrollPane4.setViewportView(txtC);

        txtD.setEditable(false);
        txtD.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        txtD.setColumns(2);
        txtD.setLineWrap(true);
        txtD.setRows(3);
        txtD.setWrapStyleWord(true);
        txtD.setBorder(null);
        jScrollPane5.setViewportView(txtD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblTotalText)
                                    .addComponent(lblCorrectText))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuestionsAnswered)
                                    .addComponent(lblQuestionsLeft)
                                    .addComponent(lblCorrectAnswers)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnAnswer))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnA)
                        .addComponent(btnB))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnC)
                                .addComponent(btnD))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCorrectText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalText)
                                    .addComponent(lblQuestionsAnswered))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lblQuestionsLeft)))
                            .addComponent(lblCorrectAnswers))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //Goes back to the study guide interface
        this.setVisible(false); //hides the quiz interface
        firstWindow.setVisible(true); //Shows the study guide
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        //Confirms that the user wishes to restart
        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to restart? You will lose your progress on this quiz, and will not be able to receive a grade.",
                 "SDLC Study Guide - Alec & Austin", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) { //yes/true - Confirms that they'd like to restart
            //Disables restart button
            btnRestart.setEnabled(false);
            //Sets all radio buttons to deselected (Default) and enabled (Default)
            btnA.setSelected(false);
            btnB.setSelected(false);
            btnC.setSelected(false);
            btnD.setSelected(false);
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnC.setEnabled(true);
            btnD.setEnabled(true);
            //Resets the display of questions
            txtA.setText(" ");
            txtB.setText(" ");
            txtC.setText(" ");
            txtD.setText(" ");
            //Resets scores and their displays
            correctAnswers = 0;
            questionsAnswered = 0;
            questionsLeft = 10;
            lblQuestionsAnswered.setText("   ");
            lblQuestionsLeft.setText("   ");
            lblCorrectAnswers.setText("   ");
            //Restarts the quiz
            questions = new ArrayList(); //resets array list
            readQuestions(questions); //reads questions from data file
            correctLetter = nextQuestion(questions); //displays first random question
            //Sets the text of the "Answer" button to "Answer!"
            btnAnswer.setText("Answer!");
        } //If "no" is selected, nothing happens

    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
        //Enables the answer button
        btnAnswer.setEnabled(true);

    }//GEN-LAST:event_btnAActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
        //Enables the answer button
        btnAnswer.setEnabled(true);

    }//GEN-LAST:event_btnBActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        //Enables the answer button
        btnAnswer.setEnabled(true);

    }//GEN-LAST:event_btnCActionPerformed

    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDActionPerformed
        //Enables the answer button
        btnAnswer.setEnabled(true);

    }//GEN-LAST:event_btnDActionPerformed

    private void btnAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerActionPerformed
        if (btnAnswer.getText().equals("Answer!")) {
            //Enables the restart button
            btnRestart.setEnabled(true);
            //Sets all radio buttons to deselected (Default) and disabled
            btnA.setSelected(false);
            btnB.setSelected(false);
            btnC.setSelected(false);
            btnD.setSelected(false);
            btnA.setEnabled(false);
            btnB.setEnabled(false);
            btnC.setEnabled(false);
            btnD.setEnabled(false);
            //Evaluate the user's answer
            evaluate(correctLetter);
            if (questionsLeft > 0){
                //set button's text to "Next!"
                btnAnswer.setText("Next!");
            } else { //No questions left
                btnAnswer.setText("Finish!");
            }
        } else if (btnAnswer.getText().equals("Next!")) { //the button says "Next!" and there are remaining questions
            //Displays next question
            correctLetter = nextQuestion(questions);
            //Enables all buttons (Default)
            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnC.setEnabled(true);
            btnD.setEnabled(true);
            //Set button's text to "Answer!"
            btnAnswer.setText("Answer!");
        } else { //Button says "Finish!" and it is the end of the quiz
            //Calculate and display score to user
        }
    }//GEN-LAST:event_btnAnswerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup MultipleChoice;
    private javax.swing.JRadioButton btnA;
    private javax.swing.JButton btnAnswer;
    private javax.swing.JRadioButton btnB;
    private javax.swing.JButton btnBack;
    private javax.swing.JRadioButton btnC;
    private javax.swing.JRadioButton btnD;
    private javax.swing.JButton btnRestart;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCorrectAnswers;
    private javax.swing.JLabel lblCorrectText;
    private javax.swing.JLabel lblQuestionsAnswered;
    private javax.swing.JLabel lblQuestionsLeft;
    private javax.swing.JLabel lblTotalText;
    private javax.swing.JTextArea txtA;
    private javax.swing.JTextArea txtB;
    private javax.swing.JTextArea txtC;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextArea txtQuestion;
    // End of variables declaration//GEN-END:variables
}
