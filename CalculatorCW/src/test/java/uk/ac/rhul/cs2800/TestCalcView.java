package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TestCalcView class.
 * 
 * @author abdul
 */
class TestCalcView {

  /**
   * CalcView instance for testing.
   */
  private CalcView calcView;

  /**
   * Setup method for initializing CalcView instance before each test.
   */
  @BeforeEach
  void setUp() {
    calcView = new CalcView();
  }

  /**
   * Tests setCalculateListener method.
   */
  @Test
  void testSetCalculateListener() {
    ActionListenerMock actionListenerMock = new ActionListenerMock();
    calcView.setCalculateListener(actionListenerMock);
    calcView.getBtnNewButton().doClick();
  }

  /**
   * Tests setRadioListener method.
   */
  @Test
  void testSetRadioListener() {
    ActionListenerMock actionListenerMock = new ActionListenerMock();
    calcView.setRadioListener(actionListenerMock);
    calcView.getRdbtnNewRadioButton().doClick();
    assertTrue(actionListenerMock.actionPerformedCalled);

    calcView.getRdbtnNewRadioButtonOne().doClick();
    assertTrue(actionListenerMock.actionPerformedCalled);
  }

  /**
   * Tests setAnswer method.
   */
  @Test
  void testSetAnswer() {
    String answer = "123";
    calcView.setAnswer(answer);
    assertEquals(answer, calcView.getLblNewLabelThree().getText());
  }

  /**
   * Tests getInfixString method.
   */
  @Test
  void testGetInfixString() {
    assertEquals("Infix", calcView.getInfixString());
  }

  /**
   * Tests getQuestion method.
   */
  @Test
  void testGetQuestion() {
    String question = "2 + 2";
    calcView.getTextField().setText(question);
    assertEquals(question, calcView.getQuestion());
  }

  /**
   * Tests setAnswerString method.
   */
  @Test
  void testSetAnswerString() {
    String answer = "456";
    calcView.setAnswerString(answer);
    assertEquals(answer, calcView.getLblNewLabelThree().getText());
    assertEquals(java.awt.Color.GRAY, calcView.getLblNewLabelThree().getBackground());
  }

  /**
   * Tests setFailString method.
   */
  @Test
  void testSetFailString() {
    String report = "Error!";
    calcView.setFailString(report);
    assertEquals(report, calcView.getLblNewLabelThree().getText());
    assertEquals(java.awt.Color.RED, calcView.getLblNewLabelThree().getBackground());
  }

  /**
   * ActionListenerMock class for testing.
   */
  private static class ActionListenerMock implements java.awt.event.ActionListener {
    /**
     * Flag to indicate whether actionPerformed method was called or not.
     */
    boolean actionPerformedCalled = false;

    /**
     * Override of actionPerformed method.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      actionPerformedCalled = true;
    }
  }
}
