package assignment5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;

/**
 * The Block type for use in BlockChain
 * 
 * @author Ally
 * @author Charun Upara - uparacha@grinnell.edu
 * @author Milo Reynolds - reynolds4@grinnell.edu
 */
public class Block {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Block number/place in chain
   */
  int blockNum;
  
  /**
   * Block data (transaction amount)
   */
  int data;
  
  /**
   * Hash of previous block (null for first block)
   */
  Hash prevHash;
  
  /**
   * Block's nonce
   */
  long nonce;
  
  /**
   * Block's Hash
   */
  Hash hash;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a new Block, mines nonce
   */
  public Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException {
    this.blockNum = num;
    this.data = amount;
    this.prevHash = prevHash;

    long i = 0; // nonce starting value
    boolean valid = false; // tracks whether nonce is valid
    while (!valid) {
      MessageDigest md = MessageDigest.getInstance("sha-256");
      md.update(ByteBuffer.allocate(4).putInt(this.blockNum).array());
      md.update(ByteBuffer.allocate(4).putInt(this.data).array());
      if (prevHash != null) {
        md.update(this.prevHash.getData());
      } // if first block
      md.update(ByteBuffer.allocate(8).putLong(i).array());
      Hash hashResult = new Hash(md.digest());
      valid = hashResult.isValid();
      i++;
    } // while
    this.nonce = --i;

    // Re-mine hash with correct nonce
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(ByteBuffer.allocate(4).putInt(this.blockNum).array());
    md.update(ByteBuffer.allocate(4).putInt(this.data).array());
    if (this.prevHash != null) {
      md.update(this.prevHash.getData());
    } // if first block
    md.update(ByteBuffer.allocate(8).putLong(i).array());
    this.hash = new Hash(md.digest());
  } // Block(int num, int amount, Hash prevHash)

  /**
   * Creates a new Block with given nonce
   */
  public Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
    this.blockNum = num;
    this.data = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;

    // Mine hash with given nonce
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(ByteBuffer.allocate(4).putInt(this.blockNum).array());
    md.update(ByteBuffer.allocate(4).putInt(this.data).array());
    md.update(this.prevHash.getData());
    md.update(ByteBuffer.allocate(8).putLong(nonce).array());
    this.hash = new Hash(md.digest());
  } // Block(int num, int amount, Hash prevHash, long nonce)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Gets the Block's number/ place in BlockChain
   */
  public int getNum() {
    return this.blockNum;
  } // getNum()

  /**
   * Gets the amount/ transaction logged in the Block
   */
  public int getAmount() {
    return this.data;
  } // getAmount()

  /**
   * Gets the block's nonce
   */
  public long getNonce() {
    return this.nonce;
  } // getNonce()

  /**
   * Gets the previous block's Hash
   */
  public Hash getPrevHash() {
    return this.prevHash;
  } // getPrevHash()

  /**
   * Gets the block's Hash
   */
  public Hash getHash() {
    return this.hash;
  } // getHash()

  /**
   * Gets the string equivalent to the Block
   */
  public String toString() {
    return "Block " + (this.blockNum - 1) + " (Amount: " + this.data + ", Nonce: " + this.nonce
        + ", prevHash: " + this.prevHash + ", hash: " + this.hash + ")";
  } // toString()

} // class Block
