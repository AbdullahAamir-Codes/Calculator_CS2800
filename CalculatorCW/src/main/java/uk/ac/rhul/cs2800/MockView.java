package uk.ac.rhul.cs2800;

import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * Implements ViewInterface and serves as mock view for testing purposes.
 * 
 * @author abdul
 */
public class MockView implements ViewInterface {

  private String expression;
  private String answer;

  /**
   * Adds runnable as calculate observer.
   *
   * @param f is runnable which will be added as calculate observer.
   */
  @Override
  public void addCalculateObserver(Runnable f) {}

  /**
   * Adds consumer as type observer.
   *
   * @param c is Consumer which will be added as type observer.
   */
  @Override
  public void addTypeObserver(Consumer<OpType> c) {}

  /**
   * Retrieves current expression.
   *
   * @return Current expression.
   */
  @Override
  public String getExpression() {
    return expression;
  }

  /**
   * Sets answer string.
   *
   * @param a Answer string to be set.
   */
  @Override
  public void setAnswer(String a) {
    System.out.println("Setting answer: " + a);
    this.answer = a;
  }

  /**
   * Retrieves current answer string.
   *
   * @return Current answer string.
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * Starts view.
   */
  @Override
  public void startView() {}

  /**
   * Sets ActionListener for calculate button.
   *
   * @param listener ActionListener to be set.
   */
  @Override
  public void setCalculateListener(ActionListener listener) {}

  /**
   * Sets ActionListener for radio buttons.
   *
   * @param listener ActionListener to be set.
   */
  @Override
  public void setRadioListener(ActionListener listener) {}

  /**
   * Retrieves current question.
   *
   * @return current question.
   */
  @Override
  public String getQuestion() {
    return null;
  }

  /**
   * Retrieves current infix expression string.
   *
   * @return Current infix expression string.
   */
  @Override
  public String getInfixString() {
    return null;
  }

  /**
   * Sets answer string.
   *
   * @param answer string to be set.
   */
  @Override
  public void setAnswerString(String answer) {}

  /**
   * Sets fail string for error messages.
   *
   * @param errorMessage is fail string for error messages.
   */
  @Override
  public void setFailString(String errorMessage) {}

  /**
   * Sets expression string.
   *
   * @param expression expression string to be set.
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }

  /**
   * Sets visibility of view.
   *
   * @param b Boolean value representing visibility of view.
   */
  @Override
  public void setVisible(boolean b) {

  }

  @Override
  public String getViewName() {
    // TODO Auto-generated method stub
    return null;
  }
}
