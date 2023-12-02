package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the StrStack class.
 *
 * @author abdul
 */
class TestStrStack {

  private StrStack stack;

  /**
   * Sets new StrStack instance before each test.
   */
  @BeforeEach
  void setUp() {
    stack = new StrStack();
  }

  /**
   * Test 1. Tests StrStack push() and pop() methods.
   *
   * @throws StackEmptyException if empty stack is popped
   */
  @Test
  void testPushAndPop() throws StackEmptyException {
    assertTrue(stack.isEmpty());

    stack.push("First");
    assertFalse(stack.isEmpty());

    stack.push("Second");
    assertEquals("Second", stack.pop());
    assertFalse(stack.isEmpty());

    assertEquals("First", stack.pop());
    assertTrue(stack.isEmpty());
  }

  /**
   * Test 2. Tests StrStack pop() method when stack is empty.
   */
  @Test
  void testPopEmptyStack() {
    assertTrue(stack.isEmpty());

    assertThrows(StackEmptyException.class, () -> stack.pop());
  }

  /**
   * Test 3. Tests for StrStack isEmpty() method.
   *
   * @throws StackEmptyException if popping empty stack
   */
  @Test
  void testIsEmpty() throws StackEmptyException {
    assertTrue(stack.isEmpty());

    stack.push("Test");
    assertFalse(stack.isEmpty());

    stack.pop();
    assertTrue(stack.isEmpty());
  }
}
