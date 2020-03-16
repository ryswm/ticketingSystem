import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend {

  /**
   * @param args the command line arguments
   */
  static ArrayList<String> transactions = new ArrayList<String>();
  static ArrayList<String> accounts = new ArrayList<String>();
  static ArrayList<String> tickets = new ArrayList<String>();
    
    
  public static void readFiles() throws FileNotFoundException{
    //TODO Proper fatal error reporting to terminal (currently reports java error type without any parsing)
    //TODO Read daily transaction file an split at each logout so we know current user

    /*
      Open and Read 3 Input Files
    */
    //Open and read transaction file
    try{
      File dt = new File(System.getProperty("user.dir") + "/transactionFiles.txt"); // Daily Transaction File
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
      File accountsFile = new File(System.getProperty("user.dir") + "/AccountFiles.txt"); // Accounts File
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
      File ticketsFile = new File(System.getProperty("user.dir") + "/eventFiles.txt");
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
    System.out.println(transactions);
    System.out.println(tickets);
    System.out.println(accounts);
        
  } 

  public void writeFiles(){

  }
    
  public static void createUser(){
        
  }
    
  public static void deleteUser(){
        
  }

  public void refundUser(){

  }

  public void createEvent(){

  }

  public void buyTicket(){

  }

  public void addCredit(){

  }
    
  public static void main(String[] args) throws FileNotFoundException {
    readFiles();  //Read the 3 input files


    //TODO handle all transactions from daily transactions file (fill out methods)

    //TODO write 2 output files (new events + new accounts; fill out method)
      
    for (String transaction : transactions) {
      if(transaction.startsWith("01")){
        System.out.println("Transaction file says code 01, create a user.");
			  //backend.createUser(name,type,credit);
      }   
    }
  }
}
