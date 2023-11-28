package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Validates functionality of the Entry class, methods for getting back the type, value, symbol, and
 * string associated with an Entry object. Tests the getType, getValue, getSymbol, and getString
 * methods
 *
 * @author abdul
 */

public class TestEntry {

  /**
   * Test 1. Tests the getType() function of Entry class to ensure that it correctly returns the
   * type of the entry object.
   */
  @Test
  public void testGetType() {
    Entry symbolEntry = new Entry(Symbol.PLUS);
    Entry numberEntry = new Entry(42.0f);
    Entry stringEntry = new Entry("test");
    assertEquals(Type.SYMBOL, symbolEntry.getType());
    assertEquals(Type.NUMBER, numberEntry.getType());
    assertEquals(Type.STRING, stringEntry.getType());
  }

  /**
   * Test 2. Tests the getValue() function of the Entry class to ensure that it correctly returns
   * the value of a numeric entry object, and raises exception for non-numeric entry objects.
   */
  @Test
  public void testGetValue() {
    Entry numberEntry = new Entry(42.0f);
    try {
      float value = numberEntry.getValue();
      assertEquals(42.0f, value, 0.0);
    } catch (BadType e) {
      fail("Expected Type.NUMBER but got an exception");
    }

    Entry symbolEntry = new Entry(Symbol.PLUS);

    try {
      symbolEntry.getValue();
      fail("Expected a WrongEntryType exception but didn't get one");
    } catch (BadType e) {
      // This is expected
    }
  }

  /**
   * Test 3. Tests the getSymbol() function of the Entry class to ensure that it correctly returns
   * the symbol of a symbol entry object, and raises an exception for non-symbol entry objects.
   */
  @Test
  public void testGetSymbol() {
    Entry symbolEntry = new Entry(Symbol.PLUS);

    try {
      Symbol symbol = symbolEntry.getSymbol();
      assertEquals(Symbol.PLUS, symbol);
    } catch (BadType e) {
      fail("Expected Type.SYMBOL but got an exception");
    }

    Entry numberEntry = new Entry(42.0f);

    try {
      numberEntry.getSymbol();
      fail("Expected a WrongEntryType exception but didn't get one");
    } catch (BadType e) {
      // This is expected
    }
  }

  /**
   * Test 4. Tests the getString() function of the Entry class to ensure that it correctly returns
   * the string value of a string entry object, and raises an exception for non-string entry
   * objects.
   */
  @Test
  public void testGetString() {
    Entry stringEntry = new Entry("test");

    try {
      String str = stringEntry.getString();
      assertEquals("test", str);
    } catch (BadType e) {
      fail("Expected Type.STRING but got an exception");
    }

    Entry numberEntry = new Entry(42.0f);

    try {
      numberEntry.getString();
      fail("Expected a WrongEntryType exception but didn't get one");
    } catch (BadType e) {
      // This is expected
    }
  }
}
