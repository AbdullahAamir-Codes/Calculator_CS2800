package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Represents a custom exception,
 * StackEmptyException, used to indicate that a operation was attempted on an empty stack.
 *
 * @author abdul
 */
public class StackEmptyException extends Exception {
  private static final long serialVersionUID = -8769847646565L;

  /**
   * Constructs new StackEmptyException with detail message.
   *
   * @param string Detailed message that describes reason for the exception.
   */
  public StackEmptyException(final String string) {
    super(string);
  }

  /**
   * Constructs a new StackEmptyException with no specified detail message.
   */
  public StackEmptyException() {}
}
