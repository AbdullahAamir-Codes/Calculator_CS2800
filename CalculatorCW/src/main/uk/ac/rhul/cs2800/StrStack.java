package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Represents stack of strings with push and pop
 * operations.
 */

public class StrStack {
  /**
   * Internal stack for storing string entries.
   */
  private final Stack myStack;

  /**
   * Constructs empty StrStack.
   */
  public StrStack() {
    this.myStack = new Stack();
  }

  /**
   * Removes and returns top string from stack.
   *
   * @return Top string from stack.
   * @throws StackEmptyException if stack is empty.
   */
  public final String pop() throws StackEmptyException {
    try {
      return this.myStack.pop().getString();
    } catch (BadType e) {
      return null;
    }
  }

  /**
   * Pushes new string onto stack.
   *
   * @param i String to be pushed onto stack.
   */
  public final void push(final String i) {
    this.myStack.push(new Entry(i));
  }

  /**
   * Checks if stack is empty.
   *
   * @return True if stack is empty, otherwise returns false.
   */
  public final boolean isEmpty() {
    return this.myStack.size() == 0;
  }
}
