package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestStandardCalc {

  /**
   * Test 1.
   *
   * @throws InvalidExpressionException If invalid expression is entered
   * @throws StackEmptyException If stack is empty
   */
  @Test
  void testEvaluateValidExpression() throws InvalidExpressionException, StackEmptyException {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("3 + 4 * 2");
    assertEquals(11, result, 0.001); // Adjust the delta value as needed
  }

  /**
   * Test 2.
   * 
   */
  @Test
  void testEvaluateInvalidExpression() {
    StandardCalc calculator = new StandardCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 + * 2"));
  }

  /**
   * Test 3.
   */
  @Test
  void testEvaluateUnbalancedExpression() {
    StandardCalc calculator = new StandardCalc();
    assertThrows(InvalidExpressionException.class, () -> calculator.evaluate("3 + 4 * 2 )"));
  }

  /**
   * Test 4.
   *
   * @throws InvalidExpressionException If invalid expression is entered
   * @throws StackEmptyException If stack is empty
   */
  @Test
  void testEvaluateEmptyExpression() throws InvalidExpressionException, StackEmptyException {
    StandardCalc calculator = new StandardCalc();
    float result = calculator.evaluate("");
    assertEquals(0, result, 0.001); // Assuming an empty expression should evaluate to 0
  }
}
