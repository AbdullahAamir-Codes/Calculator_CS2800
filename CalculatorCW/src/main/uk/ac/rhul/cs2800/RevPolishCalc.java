package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Implements Calculator interface for solving
 * expressions in RPN. Uses a approach like stack to process RPN expressions and then calculates the
 * result.
 *
 * @author abdul
 */
public class RevPolishCalc implements Calculator {
  /**
   * Stack used for evaluating expressions in RPN.
   */
  private NumStack evalStack;

  /**
   * Constructs new RevPolishCalc object with un-initialized evaluation stack.
   */
  public RevPolishCalc() {
    this.evalStack = null;
  }

  /**
   * Evaluates given expression in RPN.
   *
   * @param string RPN expression to be solved.
   * @return Result.
   * @throws InvalidExpressionException If expression is empty, null, unbalanced, or contains other
   *         operators.
   */
  @Override
  public final float evaluate(final String string) throws InvalidExpressionException {
    if (string == null || string.equals("")) {
      throw new InvalidExpressionException("Can't evaluate an empty or null string");
    }
    this.evalStack = new NumStack();
    final Scanner input = new Scanner(string);
    float retVal;
    try {
      while (input.hasNext()) {
        if (input.hasNextFloat()) {
          this.evalStack.push(input.nextFloat());
        } else {
          final String nextToken = input.next();
          Symbol what = Symbol.INVALID;
          Symbol[] values;
          for (int length = (values = Symbol.values()).length, i = 0; i < length; ++i) {
            final Symbol val = values[i];
            if (val.toString().equals(nextToken)) {
              what = val;
              break;
            }
          }
          switch (what) {
            case PLUS: {
              this.evalStack.push(this.evalStack.pop() + this.evalStack.pop());
              continue;
            }
            case APPROX: {
              this.evalStack.push(this.evalStack.pop() - this.evalStack.pop());
              continue;
            }
            case MINUS: {
              final float arg2 = this.evalStack.pop();
              this.evalStack.push(this.evalStack.pop() - arg2);
              continue;
            }
            case MULTI: {
              this.evalStack.push(this.evalStack.pop() * this.evalStack.pop());
              continue;
            }
            case EXPODIVIDE: {
              this.evalStack.push(this.evalStack.pop() / this.evalStack.pop());
              continue;
            }
            case DIVIDE: {
              final float arg2 = this.evalStack.pop();
              this.evalStack.push(this.evalStack.pop() / arg2);
              continue;
            }
            default: {
              throw new InvalidExpressionException("Unknown Operator");
            }
          }
        }
      }
      input.close();
      retVal = this.evalStack.pop();
      if (!this.evalStack.isEmpty()) {
        throw new InvalidExpressionException("Unbalanced expression " + string);
      }
    } catch (Exception e) {
      throw new InvalidExpressionException("Unbalanced expression " + string);
    }
    return retVal;
  }
}
