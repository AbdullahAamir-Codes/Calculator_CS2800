package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Contains tests for the Stack class.
 *
 * @author abdul
 */
public class TestStack {
  private Stack stack;

  @BeforeEach
  public void setUp() {
    stack = new Stack();
  }

  /**
   * Test 1. Tests whether the stack is empty.
   */
  @Test
  public void testIsEmpty() {
    assertTrue(stack.isEmpty());
    stack.push(new Entry(1));
    assertFalse(stack.isEmpty());
  }

  /**
   * Test 2. Tests pushing and popping elements from the stack.
   *
   * @throws StackEmptyException if the stack is empty when popping.
   * @throws BadType if the entry type is incorrect.
   */
  @Test
  public void testPushAndPop() throws StackEmptyException, BadType {
    stack.push(new Entry(1));
    stack.push(new Entry(2));
    stack.push(new Entry(3));

    assertEquals(3, stack.pop().getValue());
    assertEquals(2, stack.pop().getValue());
    assertEquals(1, stack.pop().getValue());
    assertTrue(stack.isEmpty());
  }

  /**
   * Test 3. Tests retrieving the top element of the stack without removing it.
   *
   * @throws StackEmptyException if the stack is empty when using the top method.
   * @throws BadType if the entry type is incorrect.
   */
  @Test
  public void testTop() throws StackEmptyException, BadType {
    stack.push(new Entry(1));
    stack.push(new Entry(2));

    assertEquals(2, stack.top().getValue());
    assertEquals(2, stack.top().getValue()); // Top should not remove the element.
  }


  /**
   * Test 4. Tests the size of the stack.
   */
  @Test
  public void testSize() {
    assertEquals(0, stack.size());
    stack.push(new Entry(1));
    assertEquals(1, stack.size());
    stack.push(new Entry(2));
    assertEquals(2, stack.size());
    assertDoesNotThrow(() -> stack.pop());
    assertEquals(1, stack.size());
  }

  /**
   * Test 5. Tests popping from an empty stack, expecting a StackEmptyException.
   */
  @Test
  public void testEmptyStackPop() {
    assertThrows(StackEmptyException.class, () -> stack.pop());
  }

  /**
   * Test 6. Test retrieving the top element from an empty stack, expecting a StackEmptyException.
   */
  @Test
  public void testEmptyStackTop() {
    assertThrows(StackEmptyException.class, () -> stack.top());
  }
}
