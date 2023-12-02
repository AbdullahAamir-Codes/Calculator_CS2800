package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Contains JUnit tests for the NumStack class.
 *
 * @author abdul
 */
class TestNumStack {

  /**
   * Test 1. Tests push and pop operations of NumStack class.
   *
   * @throws StackEmptyException if attempts to pop from empty stack
   */
  @Test
  void testPushAndPop() throws StackEmptyException {
    NumStack numStack = new NumStack();
    numStack.push(5.0f);
    numStack.push(10.0f);

    assertFalse(numStack.isEmpty());

    assertEquals(10.0f, numStack.pop(), 0.0001f);
    assertEquals(5.0f, numStack.pop(), 0.0001f);

    assertTrue(numStack.isEmpty());
  }

  /**
   * Test 2. Tests isEmpty method of NumStack class.
   *
   * @throws StackEmptyException if attempts to pop from empty stack
   */
  @Test
  void testIsEmpty() throws StackEmptyException {
    NumStack numStack = new NumStack();
    assertTrue(numStack.isEmpty());

    numStack.push(3.0f);
    assertFalse(numStack.isEmpty());

    numStack.pop();
    assertTrue(numStack.isEmpty());
  }

  /**
   * Test 3. Tests if popping from empty stack throws StackEmptyException.
   */
  @Test
  void testPopEmptyStackThrowsException() {
    NumStack numStack = new NumStack();
    assertThrows(StackEmptyException.class, numStack::pop);
  }
}
