package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionListener;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

/**
 * Test cases for ViewFactory.
 * 
 * @author abdul
 */
public class TestViewFactory {

  /**
   * Tests setLastView and getLastView methods of ViewFactory class.
   */
  @Test
  public void testSetAndGetLastView() {
    ViewInterface view1 = new MockView("View 1");
    ViewInterface view2 = new MockView("View 2");
    ViewFactory.setLastView(view1);
    assertEquals(view1, ViewFactory.getLastView());
    ViewFactory.setLastView(view2);
    assertEquals(view2, ViewFactory.getLastView());
  }

  /**
   * Implements ViewInterface for testing.
   */
  private static class MockView implements ViewInterface {
    private String name;

    /**
     * Constructs MockView with specified name.
     * 
     * @param name of view.
     */
    public MockView(String name) {
      this.name = name;
    }

    @Override
    public String getViewName() {
      return name;
    }

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

    @Override
    public void setCalculateListener(ActionListener listener) {}

    @Override
    public void setRadioListener(ActionListener listener) {}

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
    public void setVisible(boolean b) {}
  }
}
