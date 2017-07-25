/**
   Name: Andrew Givans
   Date: 3/29/2016
   
  
                     Description: Photograph DDC
                     
      The purpose of this class is to contain the instance variables 
    with their mutators and accessors as well as a default constructor 
    to create each instance of a Photograph object. It also contains 
    validators for the instance variables and special purpose methods.  
      
**/

public class Photograph{
   private static String brideEmail;
   private static int maxPhotosTake;
   private static int maxPhotosPrint;
   private static int numPhotosTaken;
   private static int numPhotosPrinted;
   public static final int MAX_NUM_PARTICIPANTS = 5;
   
   private String photoTitle;
   private String[] participantEmailAddresses;
   private String printPhoto;
   private int numParticipants = 0;
   
   //Purpose: The purpose of this default constructor is to create 
   //         a default Invitation object
   //Parameters: None
   //Return type: None
   public Photograph(){
        participantEmailAddresses = new String[MAX_NUM_PARTICIPANTS];
      
   }
   
   //Purpose: The purpose of this specific constructor is to create
   //         a Photograph object with a family name and the number of
   //         family members
   //Parameters: photoTitle, participantEmailAddresses, photoPrint
   //Return type: None
   public Photograph(String photoTitle, String printPhoto){
        this();
        this.photoTitle = photoTitle;
        this.printPhoto = printPhoto;
        this.participantEmailAddresses = new String[MAX_NUM_PARTICIPANTS];
        numPhotosTaken++;
        //this.participantEmailAddresses = participantEmailAddresses;
        
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: brideEmail
   //Return type: void
   public static void setBrideEmail(String brideEmail){
      Photograph.brideEmail = brideEmail;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public static String getBrideEmail(){
      return brideEmail;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: brideEmail
   //Return type: void
   public static void setMaxPhotosTake(int maxPhotosTake){
      Photograph.maxPhotosTake = maxPhotosTake;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public static int getMaxPhotosTake(){
      return maxPhotosTake;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: maxPhotosPrint
   //Return type: void
   public static void setMaxPhotosPrint(int maxPhotosPrint){
      Photograph.maxPhotosPrint = maxPhotosPrint;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getMaxPhotosPrint(){
      return maxPhotosPrint;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getNumPhotosTaken(){
      return numPhotosTaken;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: int
   public static int getNumPhotosPrinted(){
      return numPhotosPrinted;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: photoTitle
   //Return type: void
   public void setPhotoTitle(String photoTitle){
      this.photoTitle = photoTitle;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public String getPhotoTitle(){
      return photoTitle;
   }
   
   //Purpose: The purpose of this set method is to set the values passed in
   //         This method validates all the emails!
   //Parameters: participantEmailAddresses
   //Return type: void
   public boolean setParticipantEmailAddress(String participantEmailAddress){
   
   
   if(participantEmailAddress.indexOf('@')== -1 || participantEmailAddress.indexOf('.') == -1){
      return false;
   }
    
   if(participantEmailAddress.indexOf('@')<0){
      return false;
   }
   
   if(participantEmailAddress.indexOf('@')> participantEmailAddress.indexOf('.')){
      return false;
   }
   
   if(!Character.isDigit(participantEmailAddress.charAt(0))){
      return false;
   }
   
    
   if(!Character.isLetter(participantEmailAddress.charAt(0))){
      return false;
   }


   else{
      this.participantEmailAddresses[numParticipants] = participantEmailAddress;
      numParticipants++;
      return true;
   }
   
   }
  
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
  // public String getParticipantEmailAddresses(){
   
		//String emails = "";
		//for (int x = 0; x < photographs[x].numParticipants; x++) {
		//	emails += participantEmailAddresses[x];
       //  if (x < numParticipants - 1) {
       //     emails += ", ";
       //  }         
     // }
		//return emails;
	//}

   //Purpose: The purpose of this set method is to set the values passed in
   //Parameters: printPhoto
   //Return type: void
   public void setPrintPhoto(String printPhoto){
      this.printPhoto = printPhoto;
   }
   
   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public String getPrintPhoto(){
      return printPhoto;
   }

   //Purpose: The purpose of this get method is to get the value requested
   //Parameters: None
   //Return type: String
   public int getNumParticipants(){
      return numParticipants;
   }
   
   public static int calculatePhotosTakeAvailable(){
      int photosTakeAvailable = maxPhotosTake - numPhotosTaken;
      
      return photosTakeAvailable;
   }
   
   public static int calculatePhotosPrintAvailable(){
      int photosPrint = maxPhotosPrint - numPhotosPrinted;
      
      return photosPrint;
   }
 
   public String toString(){
       String output = "Photo Title: " + this.photoTitle +
       "\n Was the Photo printed? " + this.printPhoto +
            // for (int x=0; x < Photograph.getNumPhotosTaken(); x++){		
         "\n Participant emails: ";
        // for (int i=0; i < photographs[x].getNumParticipants(); i++){	
          //  output += photographs[x].getParticipantEmailAddresses();
         //}
        for (int x = 0; x < this.numParticipants; x++) {
            output += this.participantEmailAddresses[x] + "\n";
         }
      output+= "\n";
    
       return output;
   }
}


