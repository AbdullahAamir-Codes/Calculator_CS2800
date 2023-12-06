package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Represents test class for MockView.
 * 
 * @author abdul
 */
class TestMockView {
  /**
   * Test method for SetAnswer.
   */
  @Test
  void testSetAnswer() {
    MockView mockView = new MockView();
    String expectedAnswer = "42";

    mockView.setAnswer(expectedAnswer);
    String actualAnswer = mockView.getAnswer();

    assertEquals(expectedAnswer, actualAnswer);
  }

  /**
   * Test method for SetExpression.
   */
  @Test
  void testSetExpression() {
    MockView mockView = new MockView();
    String expectedExpression = "2 + 2";
    mockView.setExpression(expectedExpression);
    String actualExpression = mockView.getExpression();
    assertEquals(expectedExpression, actualExpression);
  }

  /**
   * Test method for SetExpression.
   */
  @Test
  void testGetQuestion() {
    MockView mockView = new MockView();
    assertNull(mockView.getQuestion());
  }
}
