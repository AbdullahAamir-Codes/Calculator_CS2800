package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Contains tests for OpType enumeration.
 * 
 * @author abdul
 */
class TestOpType {

  /**
   * Test method for STANDARD operation type.
   */
  @Test
  void testStandardOpType() {
    assertEquals(OpType.STANDARD, OpType.valueOf("STANDARD"));
  }

  /**
   * Test method for REV_POLISH operation type.
   */
  @Test
  void testRevPolishOpType() {
    assertEquals(OpType.REV_POLISH, OpType.valueOf("REV_POLISH"));
  }

  /**
   * Tests OpTypeValues method to ensure it returns all OpType values.
   */
  @Test
  void testOpTypeValues() {
    OpType[] opTypes = OpType.values();
    assertEquals(2, opTypes.length);
    assertEquals(OpType.STANDARD, opTypes[0]);
    assertEquals(OpType.REV_POLISH, opTypes[1]);
  }

  /**
   * Test method for the STANDARD and REV_POLISH operation types.
   */
  @Test
  void testOpTypeToString() {
    assertEquals("STANDARD", OpType.STANDARD.toString());
    assertEquals("REV_POLISH", OpType.REV_POLISH.toString());
  }
}
