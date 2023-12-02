package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests functionality of StandardCalc class.
 */
class TestStandardCalc {

  /**
   * Test 1. Test case for solving valid expression.
   *
   * @throws InvalidExpressionException If invalid expression is entered
   * @throws StackEmptyException If stack is empty
   */
  @Test
  void testEvaluateValidExpression() throws InvalidExpressionException, StackEmptyException {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("3 + 4 * 2");
    assertEquals(14, result, 0.001);
  }

  /**
   * Test 2. Test case for evaluating invalid expression.
   */
  @Test
  void testEvaluateInvalidExpression() {
    StandardCalc calculator = new StandardCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 + * 2"));
  }

  /**
   * Test 3. Test case for evaluating expression having unbalanced parentheses.
   */
  @Test
  void testEvaluateUnbalancedExpression() {
    StandardCalc calculator = new StandardCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 + 4 * 2 )"));
  }

  /**
   * Test 4. Test case for evaluating empty expression.
   *
   * @throws InvalidExpressionException If invalid expression is entered
   * @throws StackEmptyException If stack is empty
   */
  @Test
  void testEvaluateEmptyExpression() throws InvalidExpressionException, StackEmptyException {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("");
    assertEquals(0, result, 0.001);
  }
}
