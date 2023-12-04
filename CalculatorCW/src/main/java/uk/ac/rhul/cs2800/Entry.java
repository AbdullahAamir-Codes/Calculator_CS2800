package uk.ac.rhul.cs2800;

/**
 * Some code of this class is taken from Dave COHEN (from a jar file on Moodle). Represents an entry
 * in a symbolically, A Symbol, Number, or String.
 *
 * @author abdul
 */
public class Entry {
  private Symbol symbol;
  private float number;
  private String str;
  private Type type;

  /**
   * Constructor for Entry object for a Symbol.
   *
   * @param operator The Symbol to be stored in Entry.
   */
  public Entry(final Symbol operator) {
    this.type = Type.SYMBOL;
    this.symbol = operator;
  }

  /**
   * Constructor for Entry object for a Number.
   *
   * @param f The floating-point number to be stored in this Entry.
   */
  public Entry(final float f) {
    this.type = Type.NUMBER;
    this.number = f;
  }

  /**
   * Constructor for Entry object for a String.
   *
   * @param s The string to be stored in this Entry.
   */
  public Entry(final String s) {
    this.type = Type.STRING;
    this.str = s;
  }

  /**
   * Gets type of this Entry.
   *
   * @return The Type of this Entry, which can be SYMBOL, NUMBER, or STRING.
   */
  public final Type getType() {
    return this.type;
  }

  /**
   * Gets the value of the Entry if it is a Number.
   *
   * @return floating-point number of this Entry.
   * @throws BadType if this Entry is NUMBER.
   */
  public final float getValue() throws BadType {
    if (this.type != Type.NUMBER) {
      throw new BadType("Expected NUMBER, but it is " + this.type);
    }
    return this.number;
  }

  /**
   * Gets the Symbol stored in Entry.
   *
   * @return Symbol stored in Entry.
   * @throws BadType if this Entry is not SYMBOL.
   */
  public final Symbol getSymbol() throws BadType {
    if (this.type != Type.SYMBOL) {
      throw new BadType("Expected SYMBOL, but it is " + this.type);
    }
    return this.symbol;
  }

  /**
   * Gets String stored in Entry.
   *
   * @return String stored in Entry.
   * @throws BadType if this Entry is not STRING.
   */
  public final String getString() throws BadType {
    if (this.type != Type.STRING) {
      throw new BadType("Expected STRING, but it is " + this.type);
    }
    return this.str;
  }

  /**
   * Computes hash code for Entry.
   *
   * @return Hash code for Entry.
   */
  @Override
  public final int hashCode() {
    int result = 1;
    result = 31 * result + Float.floatToIntBits(this.number);
    result = 31 * result + ((this.symbol == null) ? 0 : this.symbol.hashCode());
    result = 31 * result + ((this.type == null) ? 0 : this.type.hashCode());
    return result;
  }

  /**
   * Compares Entry to another object for equality.
   *
   * @param obj The object to compare with Entry.
   * @return true if the objects are equal, otherwise returns false.
   */
  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final Entry other = (Entry) obj;

    if (type != other.type) {
      return false;
    }

    if (type == Type.SYMBOL) {
      if (symbol == null) {
        return other.symbol == null;
      } else {
        return symbol.equals(other.symbol);
      }
    } else if (type == Type.NUMBER) {
      return Float.floatToIntBits(number) == Float.floatToIntBits(other.number);
    } else { // Type.STRING
      if (str == null) {
        return other.str == null;
      } else {
        return str.equals(other.str);
      }
    }
  }
}
