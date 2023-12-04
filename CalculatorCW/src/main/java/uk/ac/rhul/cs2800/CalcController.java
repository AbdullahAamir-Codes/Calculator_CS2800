package uk.ac.rhul.cs2800;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Controls calculator in MVC architecture.
 * Updates model and view according to it.
 * 
 * @author abdul
 */
public final class CalcController {
  private CalcView view;
  private static CalcModel model = new CalcModel();
  private boolean isInfix;

  /**
   * Main method to launch the calculator.
   * 
   * @param args Command line arguments.
   */
  public static void main(final String[] args) {
    new CalcController(model, null);
  }

  /**
   * Constructor for CalcController. Initializes model, view, and sets up event listeners.
   * 
   * @param model represents calculator model.
   * @param view1 interface for the calculator.
   */
  CalcController(CalcModel model, ViewInterface view) {
    this.model = new CalcModel();
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          CalcController.this.view = new CalcView();
          CalcController.this.view.setVisible(true);
          new RadioListener();
          new ButtonListener();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Sets isInfix flag based on provided boolean.
   * 
   * @param isInfix boolean value to set isInfix flag.
   */
  private void setIsInfix(boolean isInfix) {
    this.isInfix = isInfix;
  }

  /**
   * ActionListener for calculator buttons. Evaluates expression and updates view.
   */
  private final class ButtonListener implements ActionListener {
    private ButtonListener() {
      CalcController.this.view.setCalculateListener(this);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
      try {
        final String answer = new StringBuilder().append(CalcController.this.model
            .evaluate(CalcController.this.view.getQuestion(), CalcController.this.isInfix))
            .toString();
        CalcController.this.view.setAnswerString(answer);
      } catch (InvalidExpressionException report) {
        CalcController.this.view.setFailString(report.getMessage());
      } catch (StackEmptyException e1) {
        e1.printStackTrace();
      }
    }
  }

  /**
   * ActionListener for radio buttons. Updates isInfix flag based on user selection.
   */
  private final class RadioListener implements ActionListener {
    private final String infix;

    private RadioListener() {
      CalcController.this.view.setRadioListener(this);
      this.infix = CalcController.this.view.getInfixString();
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
      setIsInfix(e.getActionCommand().equals(this.infix));
    }
  }
}
