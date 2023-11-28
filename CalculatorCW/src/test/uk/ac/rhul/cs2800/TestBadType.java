package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * A test class for the custom exception "BadType".
 *
 * @author abdul
 */

public class TestBadType {
  /**
   * Test 1. Tests "BadType" exception by throwing it and verifying its error message.
   */
  @Test
  public void testBadType() {
    // The error message used in the exception
    String errorMessage = "This is a bad type exception.";
    try {
      // Attempt to throw the "BadType" exception with error message
      throw new BadType(errorMessage);
    } catch (BadType e) {
      // Ensure that the exception was thrown and has the correct message
      assertNotNull(e);
      assertEquals(errorMessage, e.getMessage());
    }
  }
}
