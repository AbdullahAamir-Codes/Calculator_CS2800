package uk.ac.rhul.cs2800;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Taken from Dave COHEN (from a jar file on Moodle). Responsible for interaction between CalcModel
 * and ViewInterface. It also sets up listener buttons and radio buttons to handle user input and
 * updates the model according to it.
 * 
 * @author abdul
 */
public class CalcController {

  /**
   * ViewInterface for this calculator.
   */
  private ViewInterface view;

  /**
   * CalcModel is used for performing calculations.
   */
  private CalcModel model = new CalcModel();

  /**
   * Main method to launch calculator application.
   *
   * @param args cmd arguments.
   */
  public static void main(final String[] args) {
    CalcModel model = new CalcModel();
    ViewInterface view = new CalcView();
    new CalcController(model, view);
  }

  /**
   * Constructor for CalcController. Initializes model and view, sets up event listeners, and makes
   * view visible.
   *
   * @param model CalcModel instance for calculations.
   * @param view ViewInterface instance for user interaction.
   */
  CalcController(CalcModel model, ViewInterface view) {
    this.model = model;
    this.view = view;

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          CalcController.this.view.setVisible(true);
          new ButtonListener();
          new RadioListener();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Sets calculator mode to infix or not.
   *
   * @param isInfix is True if calculator should be in infix mode, otherwise false.
   */
  private void setIsInfix(boolean isInfix) {
    this.setInfix(isInfix);
  }

  /**
   * Checks if calculator is in infix mode.
   *
   * @return True if calculator is in infix mode, otherwise false.
   */
  public boolean isInfix() {
    return true;
  }

  /**
   * Sets calculator mode to infix or not.
   *
   * @param isInfix is True if calculator should be in infix mode, otherwise false.
   */
  public void setInfix(boolean isInfix) {}

  /**
   * ActionListener implementation for handling button clicks. It evaluates expression, updates view
   * with result, and handles exceptions.
   */
  final class ButtonListener implements ActionListener {

    /**
     * Constructor for ButtonListener. Sets up listener with view.
     */
    ButtonListener() {
      CalcController.this.view.setCalculateListener(this);
    }

    /**
     * Invoked when button is clicked. It retrieves expression, evaluates it using model, and
     * updates view.
     *
     * @param e is ActionEvent representing button click.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
      System.out.println("actionPerformed called");
      try {
        final String question = CalcController.this.view.getQuestion();
        System.out.println("Question: " + question);
        final String answer = new StringBuilder()
            .append(CalcController.this.model.evaluate(question, CalcController.this.isInfix()))
            .toString();
        System.out.println("Calculated answer: " + answer);
        CalcController.this.view.setAnswerString(answer);
      } catch (InvalidExpressionException report) {
        report.printStackTrace();
        CalcController.this.view.setFailString(report.getMessage());
      } catch (StackEmptyException e1) {
        e1.printStackTrace();
      }
    }
  }

  /**
   * ActionListener implementation for handling radio button clicks. It sets calculator mode based
   * on selected radio button.
   */
  final class RadioListener implements ActionListener {

    /**
     * Constructor for RadioListener. Sets up listener with view.
     */
    RadioListener() {
      CalcController.this.view.setRadioListener(this);
    }

    /**
     * Invoked when a radio button is clicked. It sets calculator mode based on selected radio
     * button.
     *
     * @param e is ActionEvent representing radio button click.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
      setIsInfix("Infix".equals(CalcController.this.view.getInfixString()));
    }
  }

  /**
   * Checks if calculator is in infix mode.
   *
   * @return True if calculator is in infix mode, otherwise false.
   */
  public boolean isInfix1() {
    return false;
  }
}
