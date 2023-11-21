package uk.ac.rhul.cs2800;

import java.io.Serializable;

/**
 * Constructs a new BadType exception. Custom exception class representing a BadType. Throws an
 * exception to indicate error related to wrong or unexpected type.
 * 
 * @author abdul
 */
public class BadType extends Exception implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new BadType exception with the message.
   * 
   * @param message The detail message which describes issue related to the BadType
   */
  public BadType(String message) {
    super(message);
  }
}
