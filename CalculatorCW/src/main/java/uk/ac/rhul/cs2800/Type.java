package uk.ac.rhul.cs2800;

/**
 * Represents different types for a token.
 *
 * @author abdul
 */
public enum Type {
  /**
   * Represents a numeric value.
   */
  NUMBER("NUMBER", 00),
  /**
   * Represents a symbol or operator.
   */
  SYMBOL("SYMBOL", 10),
  /**
   * Represents a string.
   */
  STRING("STRING", 20),
  /**
   * Represents an invalid or unrecognized token.
   */
  INVALID("INVALID", 30);

  private final String name;
  private final int ordinal;

  private Type(final String name, final int ordinal) {
    this.name = name;
    this.ordinal = ordinal;
  }

  /**
   * Returns name associated with Type.
   *
   * @return name of Type.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns ordinal value associated with Type.
   *
   * @return Ordinal value of Type.
   */
  public int getOrdinal() {
    return ordinal;
  }
}
