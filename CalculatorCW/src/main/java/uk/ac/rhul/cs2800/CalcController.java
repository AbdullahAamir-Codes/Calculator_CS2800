package uk.ac.rhul.cs2800;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Taken from Dave COHEN (from a jar file on Moodle). Serves as controller in MVC architecture for
 * calculator. It connects ViewInterface with CalcModel.
 * 
 * @author abdul
 */
public class CalcController {

  /**
   * User interface instance associated with controller.
   */
  private ViewInterface view;

  /**
   * Model instance for performing calculations.
   */
  private CalcModel model = new CalcModel();

  /**
   * Flag indicating whether calculator is currently using infix notation.
   */
  private boolean isInfix;

  /**
   * Main method to initiate calculator.
   * 
   * @param args Command line arguments
   */
  public static void main(final String[] args) {
    CalcModel model = new CalcModel();
    ViewInterface view = new CalcView();
    new CalcController(model, view);
  }

  /**
   * Constructor for CalcController.
   * 
   * @param model is calculation model to be associated with controller.
   * @param view user interface to be associated with controller.
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
   * Sets value of isInfix flag.
   * 
   * @param isInfix is boolean value which indicates whether calculator is in infix notation.
   */
  private void setIsInfix(boolean isInfix) {
    this.setInfix(isInfix);
  }

  /**
   * Gets current state of `isInfix` flag.
   * 
   * @return `true` if calculator is in infix notation, otherwise false.
   */
  public boolean isInfix() {
    return isInfix;
  }

  /**
   * Sets value of `isInfix` flag.
   * 
   * @param isInfix is boolean value indicating whether calculator is in infix notation.
   */
  public void setInfix(boolean isInfix) {
    this.isInfix = isInfix;
  }

  /**
   * Inner class implementing ActionListener interface for handling button clicks.
   */
  final class ButtonListener implements ActionListener {
    /**
     * Constructor for ButtonListener.
     */
    ButtonListener() {
      CalcController.this.view.setCalculateListener(this);
    }

    /**
     * Handles actionPerformed event when button is clicked.
     * 
     * @param e ActionEvent representing button click.
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
   * Inner class implementing ActionListener interface for handling radio button clicks.
   */
  final class RadioListener implements ActionListener {
    /**
     * Constructor for RadioListener.
     */
    RadioListener() {
      CalcController.this.view.setRadioListener(this);
    }

    /**
     * Handles actionPerformed event when radio button is clicked and sets infix flag based on
     * selected radio button.
     * 
     * @param e ActionEvent representing radio button click.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
      setIsInfix("Infix".equals(CalcController.this.view.getInfixString()));
    }
  }

  /**
   * Placeholder method with similar name to demonstrate redundancy.
   * 
   * @return Always returns false.
   */
  public boolean isInfix1() {
    return false;
  }
}
