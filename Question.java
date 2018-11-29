/*
 * Alec Godfrey
 * November 28th 2018
 * Definition of a question, allows question object to be created and allows user to access and mutate all attributes of the question
 */

/**
 *
 * @author algod5628
 */
public class Question {

    //variables
    String question;
    String correct;
    String incorrect1;
    String incorrect2;
    String incorrect3;
    int idNum;

    /**
     * First constructor allows a question to be created with no input and preset values
     */
    public Question() {
        question = "";
        correct = "";
        incorrect1 = "";
        incorrect2 = "";
        incorrect3 = "";
        idNum = 0;
    }

    /**
     * Second constructor allows a question to be created with input values
     * @param q question string
     * @param c correct answer string
     * @param ic1 incorrect answer string
     * @param ic2 incorrect answer string
     * @param ic3 incorrect answer string
     * @param i questions index integer
     */
    public Question(String q, String c, String ic1, String ic2, String ic3, int i) {
        question = q;
        correct = c;
        incorrect1 = ic1;
        incorrect2 = ic2;
        incorrect3 = ic3;
        idNum = i;

    }

    /**
     * Accessor for question
     * @return question string
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Accessor for correct answer
     * @return correct answer string
     */
    public String getCorrect() {
        return correct;
    }

    /**
     * Accessor for first incorrect answer
     * @return incorrect answer string
     */
    public String getIncorrect1() {
        return incorrect1;
    }

    /**
     * Accessor for second incorrect answer
     * @return incorrect answer string
     */
    public String getIncorrect2() {
        return incorrect2;
    }

    /**
     * Accessor for third incorrect answer 
     * @return incorrect answer string
     */
    public String getIncorrect3() {
        return incorrect3;
    }

    /**
     * Accessor for index number
     * @return index integer
     */
     public int getIDNum(){
        return idNum;
    }
     
     /**
      * mutator for question
      * @param newQ new question
      */
     public void setQuestion(String newQ){
         question = newQ;
     }
     
     /**
      * mutator for correct answer
      * @param newC new correct answer
      */
     public void setCorrect(String newC){
         correct = newC;
     }
     
     /**
      * Mutator for first incorrect answer
      * @param newIC new incorrect answer
      */
     public void setIncorrect1(String newIC){
         incorrect1 = newIC;
     }
     
     /**
      * Mutator for second incorrect answer
      * @param newIC new incorrect answer
      */
     public void setIncorrect2(String newIC){
         incorrect2 = newIC;
     }
     
     /**
      * Mutator for third incorrect answer
      * @param newIC new incorrect answer
      */
     public void setIncorrect3(String newIC){
         incorrect3 = newIC;
     }
     
     /**
      * Mutator for index number
      * @param newID new index number
      */
     public void setIDNum(int newID){
         idNum = newID;
     }
     
     /**
      * Creates a string containing all information about the question
      * @return output string
      */
     public String toString(){
         return "Question: " + question + "\nCorrect Answer: " + correct + "\nIncorrect Answer 1: " + incorrect1
                 + "\nIncorrect Answer 2: " + incorrect2 + "\nIncorrect Answer 3: " + incorrect3 + "\nID: " + idNum;
     }
}
