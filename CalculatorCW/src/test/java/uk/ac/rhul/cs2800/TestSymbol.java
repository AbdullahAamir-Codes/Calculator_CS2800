package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Ensures that 'toString' method returns expected string representations for many Symbol enum
 * values.
 * 
 * @author abdul
 */
public class TestSymbol {

  /**
   * Verifies `toString` method of each Symbol enum constant returns expected string representation.
   * Test 1. Tests if `toString` method of the Symbol.PLUS enum constant returns the expected string
   * "+".Tests if the `toString` method of the Symbol.MULTI enum constant returns the expected
   * string "*". Tests if the `toString` method of the Symbol.MINUS enum constant returns the
   * expected string "-". Tests if the `toString` method of the Symbol.APPROX enum constant returns
   * the expected string "~". Tests if the `toString` method of the Symbol.DIVIDE enum constant
   * returns the expected string "/". Tests if the `toString` method of the Symbol.EXPODIVIDE enum
   * constant returns the expected string "`". Tests if the `toString` method of the
   * Symbol.LEFT_BRACKET enum constant returns the expected string "(". Tests if `toString` method
   * of the Symbol.RIGHT_BRACKET enum constant returns expected ")". Tests if `toString`method of
   * the Symbol.INVALID enum constant returns expected string "!".
   */
  @Test
  public void testSymbolToString() {
    assertEquals("+", Symbol.PLUS.toString());
    assertEquals("*", Symbol.MULTI.toString());
    assertEquals("-", Symbol.MINUS.toString());
    assertEquals("~", Symbol.APPROX.toString());
    assertEquals("/", Symbol.DIVIDE.toString());
    assertEquals("`", Symbol.EXPODIVIDE.toString());
    assertEquals("(", Symbol.LEFT_BRACKET.toString());
    assertEquals(")", Symbol.RIGHT_BRACKET.toString());
    assertEquals("!", Symbol.INVALID.toString());
  }
}
