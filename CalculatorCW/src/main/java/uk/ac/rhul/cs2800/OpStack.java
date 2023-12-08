package uk.ac.rhul.cs2800;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Represents stack of symbols used in
 * calculator. Uses underlying stack data structure to perform push and pop operations.
 * 
 * @author abdul
 */
public class OpStack {
  private static Stack myStack = new Stack();

  /**
   * Constructs new OpStack with empty underlying stack.
   */
  public OpStack() {
    OpStack.myStack = new Stack();
  }

  /**
   * Removes and returns top symbol from the stack.
   *
   * @return Symbol at the top of stack.
   * @throws StackEmptyException If stack is empty and pop operation is attempted.
   */
  public final Symbol pop() throws StackEmptyException {
    try {
      return OpStack.myStack.pop().getSymbol();
    } catch (BadType e) {
      return Symbol.INVALID;
    }
  }

  /**
   * Pushes new symbol onto top of stack.
   *
   * @param i Symbol to be pushed onto stack.
   */
  public final void push(final Symbol i) {
    myStack.push(new Entry(i));
  }

  /**
   * Checks if stack is empty.
   *
   * @return True if stack is empty, otherwise returns false.
   */
  public final boolean isEmpty() {
    return OpStack.myStack.size() == 0;
  }
}
