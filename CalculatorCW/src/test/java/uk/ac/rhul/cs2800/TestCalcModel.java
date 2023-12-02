package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Comments for TestCalcModel class.
 */
class TestCalcModel {

  /**
   * Test method for solving infix expression using CalcModel.
   */
  @Test
  void testEvaluateWithInfix() {
    CalcModel calcModel = new CalcModel();
    try {
      float result = calcModel.evaluate("2 + 3 * 4", true);
      assertEquals(20, result, 0.001);
    } catch (InvalidExpressionException | StackEmptyException e) {
      fail("Exception not expected: " + e.getMessage());
    }
  }

  /**
   * Test method for solving reverse polish notation expression using CalcModel.
   */
  @Test
  void testEvaluateWithReversePolish() {
    CalcModel calcModel = new CalcModel();
    try {
      float result = calcModel.evaluate("2 3 4 * +", false);
      assertEquals(14, result, 0.001);
    } catch (InvalidExpressionException | StackEmptyException e) {
      fail("Exception not expected: " + e.getMessage());
    }
  }

  /**
   * Test method for checking whether InvalidExpressionException is thrown correctly.
   */
  @Test
  void testInvalidExpressionException() {
    CalcModel calcModel = new CalcModel();
    assertThrows(InvalidExpressionException.class, () -> {
      calcModel.evaluate("2 + +", true);
    });
  }

  /**
   * Test method for checking StackEmptyException and its error message.
   */
  @Test
  void testStackEmptyException() {
    String errorMessage = "Error.";
    StackEmptyException exception = new StackEmptyException(errorMessage);
    assertEquals(errorMessage, exception.getMessage());
  }
}
