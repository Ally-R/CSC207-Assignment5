package assignment5;

import java.util.Arrays;

/**
 * A Hash (byte array) wrapper class.
 * 
 * @author Ally
 * @author Charun Upara - uparacha@grinnell.edu
 * @author Milo Reynolds - reynolds4@grinnell.edu
 */
public class Hash {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The Hash (byte array)
   */
  byte[] hash;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new Hash from given byte array
   */
  public Hash(byte[] data) {
    this.hash = new byte[data.length];
    for (int i = 0; i < data.length; i++) {
      this.hash[i] = data[i];
    } // for
  } // Hash(byte[] data)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the Hash
   */
  public byte[] getData() {
    return this.hash;
  } // getData()

  /**
   * Determine whether this hash is valid (begins with three 0's)
   */
  public boolean isValid() {
    return (this.hash[0] == 0) && (this.hash[1] == 0) && (this.hash[2] == 0);
  } // isValid()

  /**
   * Get string equivalent of hash
   */
  public String toString() {
    String hashStr = "";
    for (int i = 0; i < this.hash.length; i++) {
      hashStr += String.format("%x",  Byte.toUnsignedInt(this.hash[i]));
    } // for
    return hashStr;
  } // String toString()

  /**
   * Check if Hash is equal to other
   */
  public boolean equals(Object other) {
    if (other instanceof Hash) {
      Hash otherHash = (Hash) other;
      return Arrays.equals(this.hash, otherHash.getData());
    } // if
    return false;
  } // equals(Object other)
  
} // class Hash
