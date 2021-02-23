package assignment5;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

/**
 * BlockChain for tracking transactions between Alice and Bob
 * 
 * @author Ally
 * @author Charun Upara - uparacha@grinnell.edu
 * @author Milo Reynolds - reynolds4@grinnell.edu
 */
public class BlockChain {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * First node in chain
   */
  Node<Block> first;

  /**
   * Last node in chain
   */
  Node<Block> last;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create new BlockChain with given initial amount
   * 
   * @pre amount must be > 0
   * @throws Exception if precondition not met
   */
  public BlockChain(int initial) throws Exception, NoSuchAlgorithmException {
    if (initial <= 0) {
      throw new Exception("Initial amount must be > 0");
    } // if
    this.first = new Node<Block>(new Block(1, initial, null), null);
    this.last = null;
  } // BlockChain(int initial)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Mine a new valid block with given amount
   * 
   * @pre amount must be valid (does not represent more money than reflected by current balance)
   * @throws IllegalArgumentException if precondition not met
   */
  public Block mine(int amount) throws IllegalArgumentException, NoSuchAlgorithmException {
    int chainSize;
    Hash lastHash;
    if (this.last == null) { // if BlockChain is length 1
      chainSize = 1;
      lastHash = this.first.value.getHash();
    } else {
      chainSize = this.last.value.getNum();
      lastHash = this.last.value.getHash();
    } // else
    int maxMoney = this.first.value.getAmount(); // maximum valid balance
    int currMoney = maxMoney; // current balance
    Node<Block> currNode = this.first.next;
    for (int i = 1; i < chainSize; i++) {
      currMoney += currNode.value.getAmount();
      currNode = currNode.next;
    } // for (iterate through BlockChain)
    currMoney += amount;
    if (currMoney > maxMoney || currMoney < 0) {
      throw new IllegalArgumentException("Transaction amount " + amount + " invalid");
    } // if
    return new Block(chainSize + 1, amount, lastHash); // mine new block
  } // mine(int amount)

  /**
   * Get the total size (number of entries) in the BlockChain
   */
  public int getSize() {
    if (this.last == null) {
      return 1;
    } // if
    return this.last.value.getNum();
  } // getSize()

  /**
   * Appends Block blk to end of BlockChain
   * 
   * @pre blk must be valid (matches BlockChain and has valid amount)
   * @throws IllegalArgumentException if precondition not met
   */
  public void append(Block blk) throws IllegalArgumentException {
    int chainSize;
    Hash lastHash;
    if (this.last == null) { // if BlockChain is length 1
      chainSize = 1;
      lastHash = this.first.value.getHash();
    } else {
      chainSize = this.last.value.getNum();
      lastHash = this.last.value.getHash();
    } // else

    // Check validity of block number
    if (blk.getNum() != chainSize + 1) {
      throw new IllegalArgumentException("Block number invalid");
    } // if block number invalid

    // Check if amount of blk is valid
    int maxMoney = this.first.value.getAmount(); // maximum valid balance
    int currMoney = maxMoney; // current balance
    Node<Block> currNode = this.first.next;
    for (int i = 1; i < chainSize; i++) {
      currMoney += currNode.value.getAmount();
      currNode = currNode.next;
    } // for (iterate through BlockChain)
    currMoney += blk.getAmount();
    if (currMoney > maxMoney || currMoney < 0) {
      throw new IllegalArgumentException("Transaction amount " + blk.getAmount() + " invalid");
    } // if

    // Other checks for block validity
    if (blk.getPrevHash() != lastHash) {
      throw new IllegalArgumentException("Block prevHash invalid");
    } // if prevHash invalid
    if (!(blk.getHash().isValid())) {
      throw new IllegalArgumentException("Block Hash invalid");
    } // if Hash invalid

    // Add new node to end of BlockChain
    Node<Block> newNode = new Node<Block>(blk, null);
    if (this.last == null) {
      this.first.next = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    } // else
  } // append(Block blk)

  /**
   * Remove the last element/entry in the BlockChain
   * 
   * @return true if element removed (chain length starts > 1), otherwise false
   */
  public boolean removeLast() {
    if (this.last == null) {
      return false;
    } // if BlockChain has only one element
    if (this.last.value.getNum() == 2) { // If BlockChain has 2 elements
      this.first.next = null;
      this.last = null;
    } else { // If BlockChain has more than 2 elements
      int newLastIndex = this.last.value.getNum() - 1;
      Node<Block> currNode = this.first;
      for (int i = 0; i < newLastIndex; i++) {
        currNode = currNode.next;
      } // for
      currNode.next = null;
      this.last = currNode;
    } // else
    return true;
  } // removeLast()

  /**
   * Get the Hash of the last Block in the chain
   */
  public Hash getHash() {
    if (this.last == null) {
      return this.first.value.getHash();
    } // if
    return this.last.value.getHash();
  } // getHash()

  /**
   * Checks if BlockChain is valid
   * 
   * @return true if valid, otherwise false
   */
  public boolean isValidBlockChain() throws NoSuchAlgorithmException {
    // Check first Block

    if (this.first.value.getNum() != 1 || this.first.value.prevHash != null
        || !(this.first.value.getHash().isValid())) {
      return false;
    } // if first block invalid

    // See if chain size = 1
    if (this.last == null) {
      return true;
    } // if chain is length 1

    // Check all other block in the chain
    Node<Block> prevNode = this.first;
    Node<Block> thisNode = this.first.next;
    int chainSize = this.last.value.getNum();
    for (int i = 1; i < chainSize; i++) {
      if (!(thisNode.value.getPrevHash().equals(prevNode.value.getHash()))) {
        return false;
      } // if prevHash doesn't match Hash of previous block
      if (thisNode.value.getNum() != i + 1 || !(thisNode.value.getHash().isValid())) {
        return false;
      } // if block's hash doesn't match hash mined from its contents
      prevNode = prevNode.next;
      thisNode = thisNode.next;
    } // for
    return true;
  } // isValidBlockChain()

  /**
   * Print the current balances for Alice and Bob
   */
  public void printBalances() {
    PrintWriter pen = new PrintWriter(System.out, true);
    int chainSize;
    if (this.last == null) { // if BlockChain is length 1
      chainSize = 1;
    } else {
      chainSize = this.last.value.getNum();
    } // else
    int maxMoney = this.first.value.getAmount(); // maximum valid balance
    int currMoney = maxMoney; // current balance
    Node<Block> currNode = this.first.next;
    for (int i = 1; i < chainSize; i++) {
      currMoney += currNode.value.getAmount();
      currNode = currNode.next;
    } // for (iterate through BlockChain)
    pen.println("Alice: " + currMoney + ", Bob: " + (maxMoney - currMoney));
  } // printBalances()

  /**
   * Get the string representation of the entire BlockChain
   */
  public String toString() {
    int chainSize;
    if (this.last == null) { // if BlockChain is length 1
      chainSize = 1;
    } else {
      chainSize = this.last.value.getNum();
    } // else
    String result = new String("");
    Node<Block> current = this.first;
    for (int i = 0; i < chainSize; i++) {
      result += current.value.toString() + "\n";
      current = current.next;
    } // for
    return result;
  } // toString()

} // class BlockChain
