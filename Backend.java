import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend {
  /**
   * @param args the command line arguments
   **/



  //Lines read from files
  static ArrayList<String> transactions = new ArrayList<String>();
  static ArrayList<String> accounts = new ArrayList<String>();
  static ArrayList<String> tickets = new ArrayList<String>();

  //Current users
  static ArrayList<String> sessionUsers = new ArrayList<String>();

  //Event & account names
  static ArrayList<String> eventNames = new ArrayList<String>();
  static ArrayList<String> users = new ArrayList<String>();
  


  //------------------------ Read & Write functions
    
  public static void readFiles() throws FileNotFoundException{
    //TODO Proper fatal error reporting to terminal (currently reports java error type without any parsing)
    
    /*
      Open and Read 3 Input Files
    */
    //Open and read transaction file
    try{
      File dt = new File(System.getProperty("user.dir") + "/transactionFile.txt"); // Daily Transaction File
      Scanner sc = new Scanner(dt); 
      while (sc.hasNextLine()){
        //System.out.println(sc.nextLine());
        transactions.add(sc.nextLine());
      }
      sc.close();
    } catch (Exception e){
      System.out.println(e);
      System.exit(0);
    }
    //Open and read account file
    try{
      File accountsFile = new File(System.getProperty("user.dir") + "/AccountFile.txt"); // Accounts File
      Scanner sc2 = new Scanner(accountsFile);
      while (sc2.hasNextLine()){ 
        //System.out.println(sc.nextLine());
        accounts.add(sc2.nextLine());
      }
      sc2.close();
    } catch (Exception e){
      System.out.println(e);
      System.exit(0);
    }
    //Open and read event file
    try{
      File ticketsFile = new File(System.getProperty("user.dir") + "/eventFile.txt");
      Scanner sc3 = new Scanner(ticketsFile);
      while (sc3.hasNextLine()){ 
        //System.out.println(sc.nextLine());
        tickets.add(sc3.nextLine());
      }
      sc3.close();
    } catch (Exception e){
      System.out.println(e);
      System.exit(0);
    }

    //Print Arrays after reading
    //System.out.println(transactions);
    //System.out.println(tickets);
    //System.out.println(accounts);

    //Get event and user names
    getEventNames();
    getAccountNames();
  } 



  public static void writeFiles(){

  }

  //-----------------






  //----------------- Helper functions
  
  public static void getEventNames(){
    for(String event : tickets){
      eventNames.add(event.substring(0, 18).trim());
    }
  }

  public static void getAccountNames(){
    for(String account : accounts){
      users.add(account.substring(0,15).trim());
    }
  }
//----------------------








//---------------------- Transaction functions
  public static void createUser(String transaction) throws FileNotFoundException{
    // split up the transaction string into substrings by whitespace
    String[] split = transaction.split("\\s+");
    /* First string is not used to create user, since its the code 01,
      split[1] is username
      split[2] is account type
      split[3] is credit
    */
    String account = split[1];
    
    for(int i = 0; i < (16 - split[1].length()); i++){ // Adding amount of whitespace needed to have proper formatting.
      account += " ";
    }
    account += split[2] + " " + split[3];
    System.out.println(account);
    accounts.add(account);
    System.out.println(accounts);
  }
    
  public static void deleteUser(String transaction){
              String username = transaction.substring(3, 31).trim();
              accounts.remove(username);
  }

  public static void refundUser(String transaction){
        String buyer = transaction.substring(3, 18).trim();
        String seller = transaction.substring(19,34).trim();
        double refundTemp = Double.parseDouble(transaction.substring(35,44).trim());

        for(String buyerName : accounts){
          if(buyerName.substring(0,15).trim().equals(buyer)){
            int index = accounts.indexOf(buyerName);

            Double creditTemp = Double.parseDouble(buyerName.substring(20,28).trim());

            creditTemp += refundTemp;
            String newBalance = String.format("%.2f",creditTemp);
            newBalance = String.format("%9s", newBalance).replace(" ", "0");
            
            accounts.set(index, buyerName.substring(0, 19) + newBalance);
          }
        }

        for(String sellerName : accounts){
          if(sellerName.substring(0,15).trim().equals(seller)){
            int index = accounts.indexOf(sellerName);

            Double creditTemp = Double.parseDouble(sellerName.substring(20,28).trim());

            creditTemp -= refundTemp;
            String newBalance = String.format("%.2f",creditTemp);
            newBalance = String.format("%9s", newBalance).replace(" ", "0");
            
            accounts.set(index, sellerName.substring(0, 19) + newBalance);
          }
        }
  }

  public static void createEvent(String transaction){
    Boolean add = true;

    String eventName = transaction.substring(3,21).trim();
    String sellerName = transaction.substring(22,37).trim();
    String tixQuantity = transaction.substring(38,41);
    String tixPrice = transaction.substring(42,48);

    //Check for duplicates
    for(String e : eventNames){
      if(eventName.equals(e)){
        add = false;
        //TODO Print constraint error
      }
    }

    //If no duplicates, add event
    if(add == true){
      eventNames.add(0, eventName); //Add to list of event names

      String newEventName = String.format("%-18s",eventName); //Format event name
      sellerName = String.format("%-15s",sellerName); //Format seller name
      String newEvent = newEventName + " " + sellerName + " " + tixQuantity + " " + tixPrice; //Create string

      tickets.add(0,newEvent);  //Add to list of events
    }
    System.out.println(tickets);
  }

  public static void buyTicket(String transaction)
  {
    String eventName = transaction.substring(3,21).trim();
    String sellerName;
  }

  public static void addCredit(String transaction){
    // Split up the transaction string into substrings by whitespace
    String[] split = transaction.split("\\s+");
    int index;
    double newCredit;
    String updatedAccount;
    for(String account : accounts){

        if(account.substring(0, 15).contains(split[1])){ // if user from transaction matches a user in accounts
          index = accounts.indexOf(account);
          String[] accountSplit = account.split("\\s+");
          
          newCredit = Double.parseDouble(accountSplit[2]) + Double.parseDouble(split[3]);
          accountSplit[2] = Double.toString(newCredit);
          updatedAccount = accountSplit[0];
          for(int i = 0; i < (16 - accountSplit[1].length()); i++){ // Sorry for nested for loops 
            updatedAccount += " ";
          }
          updatedAccount += accountSplit[1] + " " + accountSplit[2];

          accounts.set(index, updatedAccount);
          System.out.println(updatedAccount);
          System.out.println(accounts);

        }

    }

  }

  //------------------------------










  //------------------------------  Main function
  public static void main(String[] args) throws FileNotFoundException {
    int currentUser = 0; //First user is the first user in sessionUser

    readFiles();  //Read the 3 input files

    //Find all logouts, make list of users from the day
    for (String transaction : transactions){
      if(transaction.startsWith("00")){
        String username = transaction.substring(3, 18).trim();
        sessionUsers.add(username);
      }
    }

    //TODO handle all transactions from daily transactions file (fill out methods)  
    for (String transaction : transactions) {
      if(transaction.startsWith("01")){
			  createUser(transaction);
      }
      else if(transaction.startsWith("02")){
			  deleteUser(transaction);
      }
      else if(transaction.startsWith("03")){
        createEvent(transaction);
      }
      else if(transaction.startsWith("04")){
			  buyTicket(transaction);
      }
      else if(transaction.startsWith("05")){
			  refundUser(transaction);
      }
      else if(transaction.startsWith("06")){
        addCredit(transaction);
      }
      else if(transaction.startsWith("00")){
        currentUser++; //Once user logsout, update current user (index of sessionUser)
      }
    }

    //TODO write 2 output files (new events + new accounts; fill out method)
    writeFiles();

  }
}
