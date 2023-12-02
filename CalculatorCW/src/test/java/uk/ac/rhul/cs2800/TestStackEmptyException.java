package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Set of test cases for the StackEmptyException class.
 *
 * @author abdul
 */
public class TestStackEmptyException {

  /**
   * Test 1. Tests case to verify the StackEmptyException constructor with error message.
   */
  @Test
  public void testStackEmptyExceptionWithMessage() {
    String errorMessage = "Error.";
    StackEmptyException exception = new StackEmptyException(errorMessage);
    assertEquals(errorMessage, exception.getMessage());
  }

  /**
   * Test 2. Tests case to verify the StackEmptyException constructor without error message.
   */
  @Test
  public void testStackEmptyExceptionWithoutMessage() {
    StackEmptyException exception = new StackEmptyException();
    assertNull(exception.getMessage());
  }
}
