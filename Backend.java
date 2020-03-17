import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
    
  public static void createUser(String transaction) throws FileNotFoundException{
    // split up the transaction string into substrings by whitespace
    String[] split = transaction.split("\\s+");
    /* First string is not used to create user, since its the code 01,
      split[1] is username
      split[2] is account type
      split[3] is credit
    */
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/AccountFiles.txt", true));
      writer.write(split[1]);
      for(int i = 0; i < (16 - split[1].length()); i++){ // Adding amount of whitespace needed to have proper formatting.
        writer.write(" ");
      }
      writer.write(split[2] + " " + split[3]);
      writer.newLine();
      writer.close();  
    }
    catch(Exception e){
      System.out.println(e);
      System.exit(0);
    }
    
    
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

    //TODO Read daily transaction file an split at each logout so we know current user
    for (String transaction : transactions){
      
    }

    

    //TODO handle all transactions from daily transactions file (fill out methods)

    //TODO write 2 output files (new events + new accounts; fill out method)
      
    for (String transaction : transactions) {
      if(transaction.startsWith("01")){
        System.out.println("Transaction file says code 01, create a user.");
			  createUser(transaction);
      }
      else if(transaction.startsWith("02")){
        System.out.println("Transaction file says code 01, create a user.");
			  createUser(transaction);
      }
      else if(transaction.startsWith("03")){
        System.out.println("Transaction file says code 01, create a user.");
			  createUser(transaction);
      }
      else if(transaction.startsWith("04")){
        System.out.println("Transaction file says code 01, create a user.");
			  createUser(transaction);
      }
      else if(transaction.startsWith("05")){
        System.out.println("Transaction file says code 01, create a user.");
			  createUser(transaction);
      }
      else if(transaction.startsWith("06")){
        System.out.println("Transaction file says code 01, create a user.");
			  createUser(transaction);
      }     
    }


  }
}
