package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. NumStack uses an underlying Stack. Provides
 * stack operations like push, pop, and isEmpty.
 *
 * @author abdul
 */
public class NumStack {
  /**
   * Underlying stack used by NumStack.
   */
  private final Stack myStack;

  /**
   * Constructs new NumStack with empty underlying stack.
   */
  public NumStack() {
    this.myStack = new Stack();
  }

  /**
   * Pushes floating-point onto stack.
   *
   * @param i is float value to be pushed onto stack.
   */
  public final void push(final float i) {
    this.myStack.push(new Entry(i));
  }

  /**
   * Pops and retrieves topmost floating-point value from stack.
   *
   * @return float value popped from stack.
   * @throws StackEmptyException If stack is empty when pop is called.
   */
  public final float pop() throws StackEmptyException {
    try {
      return this.myStack.pop().getValue();
    } catch (BadType e) {
      return Float.POSITIVE_INFINITY;
    }
  }

  /**
   * Checks if stack is empty.
   *
   * @return true if stack is empty, otherwise false.
   */
  public final boolean isEmpty() {
    return this.myStack.size() == 0;
  }
}

