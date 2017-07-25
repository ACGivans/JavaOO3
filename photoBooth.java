/**
   Name: Andrew Givans
   Date: 3/29/2016
   
  
            Description: photoBooth Implementation class
     
     The purpose of this class is to ask the user for the name of the family 
   hosting the wedding. It then allows the user to create as many family 
   invitation objects as the users wishes. Once the list has been created, a
   menu is presented to the user allowing them to either rescind invitations,
   choose the food options for each family member, or exit the program.
   
**/

import javax.swing.JOptionPane;
public class photoBooth{
   public static void main(String[] args){
   
   Photograph.setBrideEmail(JOptionPane.showInputDialog(null, "Please enter the bride's email address: "));
   Photograph.setMaxPhotosTake(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the maximum number of photos to be taken: ")));
   do{
   Photograph.setMaxPhotosPrint(Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the maximum number of photos to be printed: ")));
   }while(Photograph.getMaxPhotosTake() <= Photograph.getMaxPhotosPrint());
   
   Photograph[] photographs = new Photograph[Photograph.getMaxPhotosTake()];
   
   addPhoto(photographs);
   
   printSummaryReport(photographs);
   
  }
   
   private static void addPhoto(Photograph[] photographs){
   
   int x = Photograph.getNumPhotosTaken();
   
   do{
   
   photographs[x] = new Photograph();
   
   photographs[x].setPhotoTitle(JOptionPane.showInputDialog(null, "Please enter the title of this photo: "));
   
   photographs[x].setPrintPhoto(JOptionPane.showInputDialog(null, "Are you going to print this photo?"));
   
   do{

   String email = JOptionPane.showInputDialog(null, "Enter a participant email");

    if (!photographs[x].setParticipantEmailAddress(email)) {
   		   JOptionPane.showMessageDialog(null, "Ineligible email!");
            email = Photograph.getBrideEmail();		
         }
 
   }while(JOptionPane.showConfirmDialog(null, "Add another participant email?") == JOptionPane.YES_OPTION || photographs[x].getNumParticipants() >= Photograph.MAX_NUM_PARTICIPANTS);
   
   JOptionPane.showMessageDialog(null, "The number of photos available to take is: " + Photograph.calculatePhotosTakeAvailable() +
   "\n The number of photos available to print is: " + Photograph.calculatePhotosPrintAvailable());
    
   }while(JOptionPane.showConfirmDialog(null, "Take a photo?") == JOptionPane.YES_OPTION || Photograph.getMaxPhotosTake() <= Photograph.getNumPhotosTaken());
   }

  
  public static void printSummaryReport(Photograph[] photographs){
  String output = "Photo Report \n\n";
      for (int a=0; a <= Photograph.getNumPhotosTaken(); a++){		
         output += photographs[a].toString();
        //"Photo tile: " + photographs[x].getPhotoTitle() +  
         //"\n Printed: " + photographs[X].getPrintPhoto() +
         //"\n Participant emails: ";
         //for (int i=0; i < photographs[x].getNumParticipants(); i++){	
         //   output += photographs[x].getParticipantEmailAddresses();
         //}
      }
      
      output+= "\n Number of photos taken: " + (Photograph.getNumPhotosTaken() + 1) +
      "\n Number of photos printed: " + Photograph.getNumPhotosPrinted() +
      "\n Refund amount: " + calculateRefund ();
  
  JOptionPane.showMessageDialog(null, output);
  }
  
 
 
   //Purpose: To allow user to search through emails   
   //Parameters: participantEmailAddresses
   //Return type: String

 // private static String findEmail (String [] participantEmailAddresses)
 //   {
 //     for (int x = 0; x < photographs[x].getNumParticipants(); x++)
 //        if (participantEmailAddresses[x].equalsIgnoreCase(participantEmailAddresses[x]))    
 //   }

   //Purpose: To calculate a refund amount   
   //Parameters: None
   //Return type: int
  private static int calculateRefund(){
      int refundAmount = ((Photograph.getMaxPhotosTake() - Photograph.getNumPhotosTaken())* 2);
      
      return refundAmount;
  }
  
  }





