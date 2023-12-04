package uk.ac.rhul.cs2800;

import java.util.ArrayList;

/**
 * Some code of this class is taken from Dave COHEN (from a jar file on Moodle).Represents a stack
 * data structure that can contain different types of Entry objects.
 */
public final class Stack {
  private final ArrayList<Entry> contents;
  private int size;

  /**
   * Constructs an empty stack.
   */
  public Stack() {
    this.contents = new ArrayList<>();
    this.size = 0;
  }

  /**
   * Checks if the stack is empty.
   *
   * @return 0 if the stack is empty, otherwise returns size.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Pushes an Entry onto the stack.
   *
   * @param entry The Entry to push onto the stack.
   */
  public void push(final Entry entry) {
    this.contents.add(entry);
    ++this.size;
  }

  /**
   * Returns the top Entry on the stack without removing it.
   *
   * @return The top Entry on the stack.
   * @throws StackEmptyException if the stack is empty.
   */
  public Entry top() throws StackEmptyException {
    if (this.size == 0) {
      throw new StackEmptyException("Top taken for empty stack");
    }
    return this.contents.get(this.size - 1);
  }

  /**
   * Gets the number of elements currently in the stack.
   *
   * @return The number of elements in the stack.
   */
  public int size() {
    return this.size;
  }

  /**
   * Removes and returns the top Entry from the stack.
   *
   * @return The Entry removed from the top of the stack.
   * @throws StackEmptyException if the stack is empty.
   */
  public Entry pop() throws StackEmptyException {
    if (this.size == 0) {
      throw new StackEmptyException("Pop is taken for empty stack");
    }
    --this.size;
    final Entry retval = this.contents.remove(this.size);
    return retval;
  }
}
