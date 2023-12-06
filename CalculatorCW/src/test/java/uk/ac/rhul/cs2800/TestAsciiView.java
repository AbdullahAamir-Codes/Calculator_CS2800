package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests functionality of AsciiView class by simulating user input and checking output.
 *
 * @author abdul
 */
class TestAsciiView {

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final InputStream originalIn = System.in;

  /**
   * Sets up stream to capture console output before each test.
   */
  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outputStream));
  }

  /**
   * Restores original output stream after each test.
   */
  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  /**
   * Tests AsciiView class by simulating user input and checking output against expected values.
   */
  @Test
  void testAsciiView() {
    String input = "C\nQ\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    AsciiView asciiView = new AsciiView();
    asciiView.startView();
    String output = outputStream.toString();
    assertTrue(output.contains("Use one of the following:"));
    assertTrue(output.contains("C - to calculate"));
    assertTrue(output.contains("Q - to exit"));
    assertTrue(output.contains("Error: Calculation not set."));
    assertTrue(output.contains("Bye"));
  }
}
