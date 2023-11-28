package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Represents thrown exception when invalid
 * expression is encountered.
 *
 * @author abdul
 */
public class InvalidExpressionException extends Exception {
  /**
   * Unique identifier for the serial version of this exception class.
   */
  private static final long serialVersionUID = -04523626274577L;

  /**
   * Constructs a new InvalidExpressionException with error message.
   *
   * @param message A description of error which caused this exception to be thrown
   */

  public InvalidExpressionException(final String message) {
    super(message);
  }
}
