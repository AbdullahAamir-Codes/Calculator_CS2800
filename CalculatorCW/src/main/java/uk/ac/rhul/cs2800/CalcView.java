package uk.ac.rhul.cs2800;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * From Dave COHEN, picked from a jar file on Moodle. Represents graphical user interface for
 * calculator also extends JFrame and provides methods to interact with calculator UI components.
 * 
 * @author abdul
 */
public class CalcView extends JFrame {

  private static final long serialVersionUID = -7214772146507844286L;
  private static final String infix = "Infix";
  private final JPanel panel;
  private final JTextField textField;
  private final JButton btnNewButton;
  private final JRadioButton rdbtnNewRadioButtonOne;
  private final JRadioButton rdbtnNewRadioButton;
  private final ButtonGroup buttonGroupOne;
  private final JLabel lblNewLabelThree;

  /**
   * Constructs new CalcView object, initializing GUI components.
   */
  public CalcView() {
    this.panel = new JPanel();
    this.textField = new JTextField();
    this.btnNewButton = new JButton("Calculate");
    this.rdbtnNewRadioButtonOne = new JRadioButton("Reverse Polish");
    this.rdbtnNewRadioButton = new JRadioButton("Infix");
    this.buttonGroupOne = new ButtonGroup();
    this.lblNewLabelThree = new JLabel("   ");
    this.setTitle("Calculator CS2800");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setBounds(100, 100, 349, 207);
    this.panel.setBackground(Color.ORANGE);
    this.getContentPane().add(this.panel, "Center");
    this.panel.setLayout(new MigLayout());
    this.panel.add(this.btnNewButton, "cell 1 0,alignx center,aligny center");
    final JLabel lblNewLabel_2 = new JLabel("Expression: ");
    this.panel.add(lblNewLabel_2, "cell 0 1,alignx right");
    this.panel.add(this.textField, "cell 1 1,growx,aligny center");
    this.textField.setColumns(10);
    final JLabel lblNewLabel_3 = new JLabel("Result: ");
    this.panel.add(lblNewLabel_3, "cell 0 2,alignx right");
    this.lblNewLabelThree.setOpaque(true);
    this.lblNewLabelThree.setBorder(new BevelBorder(1, Color.GREEN, null, null, null));
    this.lblNewLabelThree.setForeground(Color.BLACK);
    this.lblNewLabelThree.setBackground(Color.GRAY);
    this.panel.add(this.lblNewLabelThree, "cell 1 2,growx");
    this.panel.add(this.rdbtnNewRadioButton, "flowx,cell 1 3,alignx center");
    this.rdbtnNewRadioButton.setHorizontalAlignment(0);
    this.buttonGroupOne.add(this.rdbtnNewRadioButton);
    this.buttonGroupOne.add(this.rdbtnNewRadioButtonOne);
    this.rdbtnNewRadioButtonOne.setSelected(true);
    this.panel.add(this.rdbtnNewRadioButtonOne, "cell 1 3,alignx trailing");
    this.rdbtnNewRadioButtonOne.setHorizontalAlignment(0);
  }

  /**
   * Sets ActionListener for Calculate button.
   * 
   * @param mal ActionListener to be set for Calculate button.
   */
  public void setCalculateListener(final ActionListener mal) {
    this.btnNewButton.addActionListener(mal);
  }

  /**
   * Sets ActionListener for radio buttons.
   * 
   * @param mal ActionListener to be set for the radio buttons.
   */
  public void setRadioListener(final ActionListener mal) {
    this.rdbtnNewRadioButtonOne.addActionListener(mal);
    this.rdbtnNewRadioButton.addActionListener(mal);
  }

  /**
   * Sets answer label text.
   * 
   * @param answer to be displayed.
   */
  public void setAnswer(final String answer) {
    this.lblNewLabelThree.setText(answer);
  }

  /**
   * Returns constant string "Infix".
   * 
   * @return constant string "Infix".
   */
  public String getInfixString() {
    return "Infix";
  }

  /**
   * Returns text entered in text field.
   * 
   * @return text entered in text field.
   */
  public String getQuestion() {
    return this.textField.getText();
  }

  /**
   * Sets answer label text and background colour.
   * 
   * @param answer to be displayed.
   */
  public void setAnswerString(final String answer) {
    this.lblNewLabelThree.setText(answer);
    this.lblNewLabelThree.setBackground(Color.GRAY);
  }

  /**
   * Sets fail message label text and background colour.
   * 
   * @param report fail message to be displayed.
   */
  public void setFailString(final String report) {
    this.lblNewLabelThree.setText(report);
    this.lblNewLabelThree.setBackground(Color.RED);
  }

  /**
   * Returns instance of ViewInterface.
   * 
   * @return instance of ViewInterface.
   */
  public static ViewInterface getInstance() {
    return null;
  }

  public static String getInfix() {
    return infix;
  }
}
