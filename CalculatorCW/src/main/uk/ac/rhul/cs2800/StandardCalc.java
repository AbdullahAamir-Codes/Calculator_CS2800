package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Implements Calculator's interface and provides
 * functionality for solving mathematical problems in standard notation.
 *
 * @author abdul
 */
public class StandardCalc implements Calculator {
  private RevPolishCalc rpCalc;
  private OpStack transStack;
  private StrStack revStack;

  /**
   * Constructs new StandardCalc object.
   */
  public StandardCalc() {
    this.rpCalc = new RevPolishCalc();
    this.transStack = null;
    this.revStack = null;
  }

  /**
   * Solves provided mathematical expression in standard notation.
   *
   * @param string Mathematical expression to be evaluated.
   * @return Result of evaluation.
   * @throws InvalidExpressionException If expression is invalid.
   * @throws StackEmptyException If stack becomes empty unexpectedly during evaluation.
   */
  @Override
  public final float evaluate(final String string)
      throws InvalidExpressionException, StackEmptyException {
    final Scanner expr = new Scanner(string);
    final StringBuilder retVal = new StringBuilder();
    this.transStack = new OpStack();
    this.revStack = new StrStack();
    while (expr.hasNext()) {
      this.revStack.push(expr.next());
    }
    expr.close();
    boolean expectNumber = true;
    while (!this.revStack.isEmpty()) {
      String nextToken = null;
      nextToken = this.revStack.pop();
      if (Character.isDigit(nextToken.charAt(0)) && expectNumber) {
        retVal.append(String.valueOf(nextToken) + " ");
        expectNumber = false;
      } else {
        Symbol what = Symbol.INVALID;
        Symbol[] values;
        for (int length = (values = Symbol.values()).length, i = 0; i < length; ++i) {
          final Symbol val = values[i];
          if (val.toString().equals(nextToken)) {
            what = val;
            break;
          }
        }
        if (what == Symbol.LEFT_BRACKET) {
          for (Symbol nextOp = this.transStack.pop(); nextOp != Symbol.RIGHT_BRACKET; nextOp =
              this.transStack.pop()) {
            retVal.append(String.valueOf(nextOp.toString()) + " ");
          }
          continue;
        }
        if (what != Symbol.RIGHT_BRACKET && expectNumber) {
          throw new InvalidExpressionException("Invalid expression");
        }
        if (what == Symbol.MINUS) {
          what = Symbol.APPROX;
        } else if (what == Symbol.DIVIDE) {
          what = Symbol.EXPODIVIDE;
        }
        OpStack opStack = new OpStack();
        opStack.push(what);
        expectNumber = true;
      }
    }
    while (!this.transStack.isEmpty()) {
      Symbol nextOp2 = Symbol.INVALID;
      nextOp2 = this.transStack.pop();
      if (nextOp2 == Symbol.RIGHT_BRACKET) {
        throw new InvalidExpressionException("Unbalanced expression");
      }
      retVal.append(String.valueOf(nextOp2.toString()) + " ");
    }
    return this.rpCalc.evaluate(retVal.toString());
  }
}

