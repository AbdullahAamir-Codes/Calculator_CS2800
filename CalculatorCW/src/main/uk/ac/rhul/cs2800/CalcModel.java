package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Represents calculator model that uses two
 * calculators for solving expressions: Reverse Polish Notation calculator and Infix calculator.
 *
 * @author abdul
 */
public class CalcModel {
  /**
   * Reverse Polish Notation calculator is used by CalcModel.
   */
  private final Calculator rpCalc;

  /**
   * Infix calculator is used by CalcModel.
   */
  private final Calculator infixCalc;

  /**
   * Constructs new CalcModel with default Reverse Polish Notation and Infix calculators.
   */
  public CalcModel() {
    this.rpCalc = new RevPolishCalc();
    this.infixCalc = new StandardCalc();
  }

  /**
   * Evaluates given expression using specified evaluation method.
   *
   * @param question Mathematical expression to be solved.
   * @param infix Boolean flag indicates if expression is in infix notation.
   * @return Result of evaluation.
   * @throws InvalidExpressionException If expression is invalid or cannot be solved.
   * @throws StackEmptyException If there is attempt to pop element from empty stack during
   *         evaluation.
   */
  public final float evaluate(final String question, final boolean infix)
      throws InvalidExpressionException, StackEmptyException {
    if (infix) {
      return this.infixCalc.evaluate(question);
    }
    return this.rpCalc.evaluate(question);
  }
}
