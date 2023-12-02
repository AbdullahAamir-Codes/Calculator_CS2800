package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Contains JUnit tests for the RevPolishCalc class.
 *
 * @author abdul
 */
class TestRevPolishCalc {

  /**
   * Test 1. Tests evaluate method with valid expression.
   */
  @Test
  void testEvaluateValidExpression() {
    RevPolishCalc calculator = new RevPolishCalc();
    try {
      float result = calculator.evaluate("5 3 +");
      assertEquals(8, result, 0.001);
    } catch (InvalidExpressionException e) {
      fail("Unexpected InvalidExpressionException: " + e.getMessage());
    }
  }

  /**
   * Test 2. Tests evaluate method with invalid expression.
   */
  @Test
  void testEvaluateInvalidExpression() {
    RevPolishCalc calculator = new RevPolishCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("5 +"));
  }

  /**
   * Test 3. Tests evaluate method with empty expression.
   */
  @Test
  void testEvaluateEmptyExpression() {
    RevPolishCalc calculator = new RevPolishCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(""));
  }

  /**
   * Test 4. Tests evaluate method with null expression.
   */
  @Test
  void testEvaluateNullExpression() {
    RevPolishCalc calculator = new RevPolishCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate(null));
  }

  /**
   * Test 5. Tests evaluate method with unbalanced expression.
   */
  @Test
  void testEvaluateUnbalancedExpression() {
    RevPolishCalc calculator = new RevPolishCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("5 3 + *"));
  }
}
