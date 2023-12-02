package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Represents stack of symbols used in calculator and executes operations like push, pop, and checks
 * for emptiness. Tests for the OpStack.
 *
 * @author abdul
 */
class TestOpStack {

  /**
   * Test 1. Tests constructor of OpStack.
   */
  @Test
  void testOpStack() {
    OpStack opStack = new OpStack();
    assertNotNull(opStack);
  }

  /**
   * Test 2. Tests pop method of OpStack.
   */
  @Test
  void testPop() {
    OpStack opStack = new OpStack();
    assertTrue(opStack.isEmpty());

    assertThrows(StackEmptyException.class, () -> opStack.pop());

    Symbol symbol = Symbol.MINUS;
    opStack.push(symbol);
    assertFalse(opStack.isEmpty());

    try {
      Symbol poppedSymbol = opStack.pop();
      assertEquals(symbol, poppedSymbol);
      assertTrue(opStack.isEmpty());
    } catch (StackEmptyException e) {
      fail("Unexpected StackEmptyException");
    }
  }

  /**
   * Test 3. Tests push method of OpStack.
   */
  @Test
  void testPush() {
    OpStack opStack = new OpStack();
    assertTrue(opStack.isEmpty());

    Symbol symbol = Symbol.PLUS;
    OpStack opStack2 = new OpStack();
    opStack2.push(symbol);

    assertFalse(opStack.isEmpty());
    try {
      assertEquals(symbol, opStack.pop());
    } catch (StackEmptyException e) {
      fail("Unexpected StackEmptyException");
    }
  }

  /**
   * Test 4. Tests isEmpty method of OpStack.
   */
  @Test
  void testIsEmpty() {
    OpStack opStack = new OpStack();
    assertTrue(opStack.isEmpty());

    Symbol symbol = Symbol.INVALID;
    opStack.push(symbol);

    assertFalse(opStack.isEmpty());
  }
}
