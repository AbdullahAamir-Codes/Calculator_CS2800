package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. It's some content and java doc in pending.
 *
 * @author abdul
 */
public interface Calculator {

  /**
   * Evaluates given mathematical expression and returns result as type float.
   * 
   * @param string Mathematical expression to be evaluated.
   * @return Result of evaluation as float.
   * @throws InvalidExpressionException when expression is invalid or cannot be evaluated.
   * @throws StackEmptyException when attempt is made to pop from empty stack during evaluation.
   */
  float evaluate(String string) throws InvalidExpressionException, StackEmptyException;

}
