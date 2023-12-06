package uk.ac.rhul.cs2800;

import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * Represents interface for calculator view. It defines methods to observe and interact with
 * calculator view. It can handle user interactions and can update view accordingly.
 *
 * @author Dave Cohen (d.cohen@rhul.ac.uk)
 * @author abdul
 */
public interface ViewInterface {

  /**
   * Adds observer for calculate action.
   *
   * @param f Runnable which will execute when calculate action is triggered.
   */
  void addCalculateObserver(Runnable f);

  /**
   * Adds observer for type of operation.
   *
   * @param c Consumer that handles operation type when it changes.
   */
  void addTypeObserver(Consumer<OpType> c);

  /**
   * Retrieves expression from view.
   *
   * @return String representing current expression in view.
   */
  String getExpression();

  /**
   * Sets answer to be displayed in view.
   *
   * @param a answer to be displayed in view.
   */
  void setAnswer(String a);

  /**
   * Starts calculator view.
   */
  void startView();

  /**
   * Sets ActionListener for calculate action.
   *
   * @param listener ActionListener to notify when calculate action occurs.
   */
  void setCalculateListener(ActionListener listener);

  /**
   * Sets ActionListener for radio button action.
   *
   * @param listener ActionListener to notify when radio button action occurs.
   */
  void setRadioListener(ActionListener listener);

  /**
   * Retrieves question from view.
   *
   * @return String representing current question in view.
   */
  String getQuestion();

  /**
   * Retrieves infix string from view.
   *
   * @return String representing infix notation of current expression in view.
   */
  String getInfixString();

  /**
   * Sets answer string to be displayed in view.
   *
   * @param answer string to be displayed in view.
   */
  void setAnswerString(String answer);

  /**
   * Sets error message to be displayed in case of calculation failure.
   *
   * @param errorMessage error message to be displayed in view.
   */
  void setFailString(String errorMessage);

  void setVisible(boolean b);

  String getViewName();
}
