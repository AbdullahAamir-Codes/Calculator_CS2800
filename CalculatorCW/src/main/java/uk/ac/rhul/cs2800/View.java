package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Represents graphical user interface (GUI). It contains button and label that can be manipulated
 * through user interactions.
 * 
 * @author abdul
 */
public class View {

  /**
   * Main button in the GUI.
   */
  @FXML
  private Button mainButton;

  /**
   * Label in GUI displays information.
   */
  @FXML
  private Label label;

  /**
   * Handles action event when main button is pressed. Sets the label text to "Pressed".
   * 
   * @param event ActionEvent triggered when button is pressed.
   */
  @FXML
  void isPressed(ActionEvent event) {
    label.setText("Pressed");
  }
}
