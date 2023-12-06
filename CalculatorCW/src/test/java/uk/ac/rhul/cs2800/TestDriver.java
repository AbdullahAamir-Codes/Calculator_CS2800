package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests functionality of Driver class.
 * 
 * @author abdul
 */
public class TestDriver {

  private MockView mockView;

  /**
   * Sets up testing environment before each test case. Configures system output to null and
   * initializes MockView instance.
   */
  @BeforeEach
  public void setUp() {
    System.setOut(null);
    mockView = new MockView();
  }

  /**
   * Restores system output into its original state after each test case.
   */
  @AfterEach
  public void tearDown() {
    System.setOut(System.out);
  }

  /**
   * Tests calculation functionality of Driver. Sets specific expression on MockView, runs
   * calculator, and asserts that result matches expected value.
   */
  @Test
  public void testSuccessfulCalculation() {
    MockView mockView = new MockView();
    mockView.setExpression("2 + 3");
    Driver.runCalculator(mockView);
    assertEquals("5", mockView.getAnswer());
  }

  /**
   * Test method for testing different expression.
   */
  @Test
  public void testDifferentExpression() {}

  /**
   * Test method for testing something else.
   */
  @Test
  public void testSomethingElse() {}

  /**
   * Test method for testing console environment.
   */
  @Test
  public void testConsoleEnvironment() {}

  /**
   * Returns MockView instance associated with this TestDriver.
   *
   * @return MockView instance.
   */
  public MockView getMockView() {
    return mockView;
  }

  /**
   * Sets MockView instance for this TestDriver.
   *
   * @param mockView instance to be set.
   */
  public void setMockView(MockView mockView) {
    this.mockView = mockView;
  }
}
