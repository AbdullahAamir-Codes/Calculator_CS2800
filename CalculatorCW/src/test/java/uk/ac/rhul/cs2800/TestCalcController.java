package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests functionality of CalcController.
 * 
 * @author abdul
 */
class TestCalcController {

  private CalcModel model;
  private ConcreteTestView view;
  private CalcController controller;

  /**
   * Sets up test environment before each test method is executed.
   */
  @BeforeEach
  void setUp() {
    model = new CalcModel();
    controller = new CalcController(model, view);
  }

  /**
   * Tests button listener functionality.
   */
  @Test
  void testButtonListener() {
    view.setQuestion("2 + 2");
    view.setInfixString("Infix");
    view.triggerButtonClick();

    assertEquals("4", view.getAnswerString());
  }

  /**
   * Tests radio button listener functionality.
   */
  @Test
  void testRadioListener() {
    view.setInfixString("Infix");
    controller.new RadioListener().actionPerformed(null);

    System.out.println("IsInfix: " + controller.isInfix());
    System.out.println("InfixString: " + view.getInfixString());
    assertTrue(controller.isInfix());
  }

  /**
   * Abstract class extending TestView. Used for testing purposes.
   */
  public abstract class ConcreteTestView extends TestView {

    private String infixString;

    @Override
    public String getExpression() {
      return null;
    }

    public Object getAnswerString() {
      return null;
    }

    /**
     * Sets infix string for testing purposes.
     *
     * @param string is infix string to set.
     */
    public void setInfixString(String string) {
      this.infixString = string;
    }

    /**
     * Sets question string for testing purposes.
     *
     * @param string is question string to set.
     */
    public void setQuestion(String string) {}

    @Override
    public void setAnswer(String a) {}

    @Override
    public void startView() {}

    @Override
    public void addCalculateObserver(Runnable f) {}

    @Override
    public void addTypeObserver(Consumer<OpType> c) {}
  }

  /**
   * Abstract class implementing ViewInterface. Used for testing purposes.
   */
  public abstract class TestView implements ViewInterface {

    private ActionListener calculateListener;
    private ActionListener radioListener;

    @Override
    public void setCalculateListener(ActionListener listener) {
      this.calculateListener = listener;
    }

    /**
     * Triggers button click event for testing purposes.
     */
    public void triggerButtonClick() {
      if (calculateListener != null) {
        calculateListener
            .actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
      }
    }

    /**
     * Sets radio button listener for testing purposes.
     *
     * @param listener is radio button listener to set.
     */
    public void setRadioListener(ActionListener listener) {
      this.radioListener = listener;
    }

    /**
     * Triggers radio button click event for testing.
     */
    public void triggerRadioButtonClick() {
      System.out.println("Triggering radio button click");
      if (radioListener != null) {
        radioListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
      }
    }

    @Override
    public String getQuestion() {
      return null;
    }

    @Override
    public String getInfixString() {
      return null;
    }

    @Override
    public void setAnswerString(String answer) {}

    @Override
    public void setFailString(String errorMessage) {}

    @Override
    public void addCalculateObserver(Runnable f) {}

    @Override
    public void addTypeObserver(Consumer<OpType> c) {}

    @Override
    public String getExpression() {
      return null;
    }

    @Override
    public void setAnswer(String a) {}

    @Override
    public void startView() {}
  }
}
