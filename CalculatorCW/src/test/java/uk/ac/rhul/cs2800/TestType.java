package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests the ordinal values and names of the Type enum constants.
 * 
 * @author abdul
 */
public class TestType {
  /**
   * Test 1. Tests the ordinal values of the Type enumeration and checks that the ordinal values of
   * the Type enum constants are as expected.
   */
  @Test
  public void testTypeValues() {
    assertEquals(00, Type.NUMBER.getOrdinal(),
        "The NUMBER type should have the correct ordinal value.");
    assertEquals(10, Type.SYMBOL.getOrdinal(),
        "The SYMBOL type should have the correct ordinal value.");
    assertEquals(20, Type.STRING.getOrdinal(),
        "The STRING type should have the correct ordinal value.");
    assertEquals(30, Type.INVALID.getOrdinal(),
        "The INVALID type should have the correct ordinal value.");
  }

  /**
   * Test 2. Tests the names of the Type enumeration constants. It checks that the names of the Type
   * enum constants are as expected.
   */
  @Test
  public void testTypeNames() {
    assertEquals("NUMBER", Type.NUMBER.name(), "The NUMBER type should have the correct name.");
    assertEquals("SYMBOL", Type.SYMBOL.name(), "The SYMBOL type should have the correct name.");
    assertEquals("STRING", Type.STRING.name(), "The STRING type should have the correct name.");
    assertEquals("INVALID", Type.INVALID.name(), "The INVALID type should have the correct name.");
  }
}
