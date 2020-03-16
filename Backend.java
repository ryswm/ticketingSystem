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
    //TODO file not found should be fatal to the backend

    //Open and Read 3 Input Files
    File dt = new File(System.getProperty("user.dir") + "/transactionFile.txt"); // Daily Transaction File
    Scanner sc = new Scanner(dt); 
    File accountsFile = new File(System.getProperty("user.dir") + "/AccountFile.txt"); // Accounts File
    Scanner sc2 = new Scanner(accountsFile);
    File ticketsFile = new File(System.getProperty("user.dir") + "/eventFile.txt");
    Scanner sc3 = new Scanner(ticketsFile);
    
    //Read Daily Transaction file
    while (sc.hasNextLine()){
      //System.out.println(sc.nextLine());
      transactions.add(sc.nextLine());
    }
    //Read Accounts file
    while (sc2.hasNextLine()){ 
      //System.out.println(sc.nextLine());
      accounts.add(sc2.nextLine());
    }
    //Read Events file
    while (sc3.hasNextLine()){ 
      //System.out.println(sc.nextLine());
      tickets.add(sc3.nextLine());
    }

    //Print Arrays after reading
    System.out.println(transactions);
    System.out.println(tickets);
    System.out.println(accounts);
        
  } 
    
  public static void createUser(){
        
        
  }
    
  public static void deleteUser(){
        
        
  }
    
  public static void main(String[] args) throws FileNotFoundException {
    readFiles();  //Read the 3 input files


    //TODO handle all transactions from daily transactions file

    //TODO write 2 output files (new events + new accounts)
      
    for (String transaction : transactions) {
      if(transaction.startsWith("01")){
        System.out.println("Transaction file says code 01, create a user.");
			  //backend.createUser(name,type,credit);
      }   
    }
  }
}
