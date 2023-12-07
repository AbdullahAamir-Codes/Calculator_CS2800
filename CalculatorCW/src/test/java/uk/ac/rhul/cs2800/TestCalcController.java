package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Responsible for testing functionality of CalcController class.
 *
 * @author abdul
 */
class TestCalcController {

  private CalcModel model;
  private ConcreteTestView view;
  private CalcController controller;

  /**
   * Sets up test environment before each test case.
   */
  @BeforeEach
  void setUp() {
    model = new CalcModel();
    view = new ConcreteTestView();
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
    view.triggerRadioButtonClick();

    System.out.println("IsInfix: " + controller.isInfix());
    System.out.println("InfixString: " + view.getInfixString());
    assertTrue(controller.isInfix());
  }

  /**
   * ConcreteTestView class extends TestView for testing.
   */
  public class ConcreteTestView extends TestView {
    @Override
    public String getExpression() {
      return null;
    }

    public Object getAnswerString() {
      return "4";
    }

    public void setInfixString(String string) {}

    public void setQuestion(String string) {}

    @Override
    public void setAnswer(String a) {}

    @Override
    public void startView() {}

    @Override
    public void addCalculateObserver(Runnable f) {}

    @Override
    public void addTypeObserver(Consumer<OpType> c) {}

    @Override
    public void setVisible(boolean b) {}

    @Override
    public String getViewName() {
      return null;
    }
  }

  /**
   * Abstract TestView class for providing base for testing ViewInterface.
   */
  public abstract class TestView implements ViewInterface {

    private ActionListener calculateListener;
    private ActionListener radioListener;

    @Override
    public void setCalculateListener(ActionListener listener) {
      this.calculateListener = listener;
    }

    public void triggerButtonClick() {
      if (calculateListener != null) {
        calculateListener
            .actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
      }
    }

    public void setRadioListener(ActionListener listener) {
      this.radioListener = listener;
    }

    public void triggerRadioButtonClick() {
      System.out.println("Triggering radio button click");
      if (radioListener != null) {
        radioListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
      }
    }

    @Override
    public String getQuestion() {
      return "4";
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
