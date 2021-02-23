package assignment5;

import java.io.PrintWriter;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

/**
 * Program to track transactions between Alice and Bob
 * 
 * @author Ally
 * @author Charun Upara - uparacha@grinnell.edu
 * @author Milo Reynolds - reynolds4@grinnell.edu
 */
public class BlockChainDriver {
  /**
   * Takes user input of base amount, continually accepts new commands until "quit" command entered
   *
   * @pre Exactly one command line argument is given, an integer > 0
   * @pre User must follow rules of each command (exceptions handled by their respective classes)
   * @throws Exception if first precondition not met
   */
  public static void main(String[] args) throws Exception, NoSuchAlgorithmException {
    if (args.length != 1) {
      throw new Exception("Invalid number of arguments");
    }

    // Initializations
    BlockChain chain = new BlockChain(Integer.parseInt(args[0]));
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner reader = new Scanner(System.in); // Reading from System.in

    // Print initial chain
    pen.println(chain.toString());

    // Print commands
    pen.println("Valid commands:");
    pen.println("   mine: discovers the nonce for a given transaction");
    pen.println("   append: appends a new block onto the end of the chain");
    pen.println("   remove: removes the last block from the end of the chain");
    pen.println("   check: checks that the block chain is valid");
    pen.println("   report: reports the balances of Alice and Bob");
    pen.println("   help: prints this list of commands");
    pen.println("   quit: quits the program");

    // Get initial command
    pen.println("Enter a command: ");
    String command = reader.next();
    pen.println();

    // Initialize next block to append (updated when mine command called)
    Block toAppend = null;

    // Get and execute commands until command "quit" entered
    while (!command.equals("quit")) {
      if (command.equals("mine")) {
        pen.println("Enter transaction amount: ");
        int transAmnt = reader.nextInt();
        toAppend = chain.mine(transAmnt);
        pen.println("amount = " + transAmnt + ", nonce = " + toAppend.getNonce());
      } else if (command.equals("append")) {
        if (toAppend == null) {
          pen.println("Must mine before appending");
        } else {
          chain.append(toAppend);
        } // else
      } else if (command.equals("remove")) {
        if (chain.removeLast() == false) {
          pen.println("Cannot remove initial entry");
        } // if
      } else if (command.equals("check")) {
        if (chain.isValidBlockChain()) {
          pen.println("Block chain is valid");
        } else {
          pen.println("Invalid block chain");
        } // else
      } else if (command.equals("report")) {
        chain.printBalances();
      } else if (command.equals("help")) {
        pen.println("Valid commands:");
        pen.println("   mine: discovers the nonce for a given transaction");
        pen.println("   append: appends a new block onto the end of the chain");
        pen.println("   remove: removes the last block from the end of the chain");
        pen.println("   check: checks that the block chain is valid");
        pen.println("   report: reports the balances of Alice and Bob");
        pen.println("   help: prints this list of commands");
        pen.println("   quit: quits the program");
      } else {
        pen.println("Invalid command " + command);
      } // else

      // Print BlockChain and get next command
      pen.println();
      pen.println(chain.toString());
      pen.println("Enter a command: ");
      command = reader.next();
      pen.println();
    } // while
    reader.close();
    System.exit(0);
  } // main

} // class BlockChainDriver

// Unused code
/*
 * pen.println("Enter transaction amount: "); int transAmnt = reader.nextInt();
 * pen.println("Enter nonce: "); long newNonce = reader.nextLong();
 */
