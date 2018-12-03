/*Austin Van Braeckel
11/28/2018
Represents a study note which includes an identification number, textual information,

 */

/**
 *
 * @author Family
 */
public class Note {
    
    private String text;
    private int IDNumber;
    
    //Default onstructor
    public Note(){
        text = "N/A";
        IDNumber = -1;
    }
    
    //Constructor
    public Note(int id, String info){
        this();
        text = info;
        IDNumber = id;
    }
    
    /**
     * Retrieves the textual information that the note possesses
     * @return String of the information
     */
    public String getText(){
        return text;
    }
    
    /**
     * Sets the textual information of the note to the given String
     * @param s String of the information to which it will be set
     */
    public void setText(String s){
        text = s;
    }
    
    /**
     * Retrieves the identification number of the note
     * @return integer of the ID number
     */
    public int getID(){
        return IDNumber;
    }
    
    /**
     * Sets the identification number of the note to the given integer
     * @param n Integer of the ID number to which it will be set
     */
    public void setID(int n){
        IDNumber = n;
    }
    
    /**
     * Retrieves a formatted String of the Note data representation
     * @return String of Note info
     */
    public String toString(){
        return "ID: " + IDNumber + "\nINFO: " + text;
    }
}
