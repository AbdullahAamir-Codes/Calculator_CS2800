package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * A test class for the InvalidExpressionException class.
 *
 * @author abdul
 */
public class TestInvalidExpressionException {
  /**
   * Test 1. Tests the constructor of the InvalidExpressionException class. Creates an instance of
   * InvalidExpressionException with a message then asserts the getMessage() method which returns
   * the expected message.
   */
  @Test
  public void testConstructor() {
    InvalidExpressionException exception = new InvalidExpressionException("Test Message");
    assertEquals("Test Message", exception.getMessage());
  }
}
