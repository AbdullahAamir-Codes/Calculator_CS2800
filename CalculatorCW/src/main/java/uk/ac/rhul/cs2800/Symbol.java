package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle.
 * 
 * @author abdul Enumeration of mathematical symbols used in expressions. Each symbol has a name,
 *         ordinal value, and a string representation. Enumeration represents mathematical symbols
 *         like +, *, -, and so on.
 */
public enum Symbol {
  /**
   * Addition symbol.
   */
  PLUS("PLUS", 0, "+"),
  /**
   * Multiplication symbol.
   */
  MULTI("TIMES", 1, "*"),
  /**
   * Subtraction symbol.
   */
  MINUS("MINUS", 2, "-"),
  /**
   * Unary minus symbol (negation).
   */
  APPROX("APPROX", 3, "~"),
  /**
   * Division symbol.
   */
  DIVIDE("DIVIDE", 4, "/"),
  /**
   * Exponentiation (power) symbol.
   */
  EXPODIVIDE("EXPODIVIDE", 5, "`"),
  /**
   * Left parenthesis symbol.
   */
  LEFT_BRACKET("LEFT_BRACKET", 6, "("),
  /**
   * Right parenthesis symbol.
   */
  RIGHT_BRACKET("RIGHT_BRACKET", 7, ")"),
  /**
   * Invalid or unknown symbol.
   */
  INVALID("INVALID", 8, "!");


  /**
   * The string representation of the symbol.
   */
  private String str;


  /**
   * Private constructor for the Symbol enum.
   * 
   * @param name The name of the symbol.
   * @param ordinal The ordinal value of the symbol
   * @param what The string representation of the symbol
   */
  private Symbol(final String name, final int num, final String how) {
    str = how;
  }


  /**
   * Get the string representation of the symbol.
   * 
   * @return The string representation of the symbol.
   */
  @Override
  public String toString() {
    return new String(str);
  }
}
