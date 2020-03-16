import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend1 {

  /**
   * @param args the command line arguments
   */
  static ArrayList<String> transactions = new ArrayList<String>();
  static ArrayList<String> accounts = new ArrayList<String>();
  static ArrayList<String> tickets = new ArrayList<String>();
    
    
  public Backend1() throws FileNotFoundException{
    System.out.println(System.getProperty("user.dir"));
    File dt = new File(System.getProperty("user.dir") + "/transactionFile.txt"); // Daily Transaction File
    Scanner sc = new Scanner(dt); 
        
    File accountsFile = new File(System.getProperty("user.dir") + "/AccountFile.txt"); // Accounts File
    Scanner sc2 = new Scanner(accountsFile);
        
    File ticketsFile = new File(System.getProperty("user.dir") + "/eventFile.txt");
    Scanner sc3 = new Scanner(ticketsFile);
        
    while (sc.hasNextLine()){ 
      //System.out.println(sc.nextLine());
      transactions.add(sc.nextLine());
    }
    while (sc2.hasNextLine()){ 
      //System.out.println(sc.nextLine());
      accounts.add(sc.nextLine());
    }
    while (sc3.hasNextLine()){ 
      //System.out.println(sc.nextLine());
      tickets.add(sc.nextLine());
    }
    System.out.println(transactions);
    System.out.println(tickets);
    System.out.println(accounts);
        
  } 
    
  public static void createUser(){
        
        
  }
    
  public static void deleteUser(){
        
        
  }
    
  public static void main(String[] args) throws FileNotFoundException {
    Backend1 backend = new Backend1();
      
    for (String transaction : transactions) {
      if(transaction.startsWith("01")){
        System.out.println("Transaction file says code 01, create a user.");
			  //backend.createUser(name,type,credit);
      }   
    }
  }
}
