package uk.ac.rhul.cs2800;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
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
public class CalcView extends JFrame implements ViewInterface {

  private static final long serialVersionUID = -7214772146507844286L;
  private static final String infix = "Infix";
  /**
   * Main panel which holds all graphical components of calculator.
   */
  private final JPanel panel;

  /**
   * Text field where user can input mathematical expressions.
   */
  private final JTextField textField;

  /**
   * CCalculate button that triggers calculation process.
   */
  private final JButton btnNewButton;

  /**
   * Radio button for selecting Reverse Polish notation.
   */
  private final JRadioButton rdbtnNewRadioButtonOne;

  /**
   * Radio button for selecting Infix notation.
   */
  private final JRadioButton rdbtnNewRadioButton;

  /**
   * Button group to ensure exclusive selection between two radio buttons.
   */
  private final ButtonGroup buttonGroupOne;

  /**
   * Label used to display result or error messages.
   */
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
    this.panel.add(this.getBtnNewButton(), "cell 1 0,alignx center,aligny center");
    final JLabel lblNewLabel_2 = new JLabel("Expression: ");
    this.panel.add(lblNewLabel_2, "cell 0 1,alignx right");
    this.panel.add(this.getTextField(), "cell 1 1,growx,aligny center");
    this.getTextField().setColumns(10);
    final JLabel lblNewLabel_3 = new JLabel("Result: ");
    this.panel.add(lblNewLabel_3, "cell 0 2,alignx right");
    this.getLblNewLabelThree().setOpaque(true);
    this.getLblNewLabelThree().setBorder(new BevelBorder(1, Color.GREEN, null, null, null));
    this.getLblNewLabelThree().setForeground(Color.BLACK);
    this.getLblNewLabelThree().setBackground(Color.GRAY);
    this.panel.add(this.getLblNewLabelThree(), "cell 1 2,growx");
    this.panel.add(this.getRdbtnNewRadioButton(), "flowx,cell 1 3,alignx center");
    this.getRdbtnNewRadioButton().setHorizontalAlignment(0);
    this.buttonGroupOne.add(this.getRdbtnNewRadioButton());
    this.buttonGroupOne.add(this.getRdbtnNewRadioButtonOne());
    this.getRdbtnNewRadioButtonOne().setSelected(true);
    this.panel.add(this.getRdbtnNewRadioButtonOne(), "cell 1 3,alignx trailing");
    this.getRdbtnNewRadioButtonOne().setHorizontalAlignment(0);
  }

  /**
   * Sets ActionListener for Calculate button.
   * 
   * @param mal ActionListener to be set for Calculate button.
   */
  public void setCalculateListener(final ActionListener mal) {
    this.getBtnNewButton().addActionListener(mal);
  }

  /**
   * Sets ActionListener for radio buttons.
   * 
   * @param mal ActionListener to be set for radio buttons.
   */
  public void setRadioListener(final ActionListener mal) {
    this.getRdbtnNewRadioButtonOne().addActionListener(mal);
    this.getRdbtnNewRadioButton().addActionListener(mal);
  }

  /**
   * Sets answer label text.
   * 
   * @param answer to be displayed.
   */
  public void setAnswer(final String answer) {
    this.getLblNewLabelThree().setText(answer);
  }

  /**
   * Returns constant string called Infix".
   * 
   * @return constant string called Infix".
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
    return this.getTextField().getText();
  }

  /**
   * Sets answer label text and background colour.
   * 
   * @param answer to be displayed.
   */
  public void setAnswerString(final String answer) {
    this.getLblNewLabelThree().setText(answer);
    this.getLblNewLabelThree().setBackground(Color.GRAY);
  }

  /**
   * Sets fail message label text and background colour.
   * 
   * @param report fail message to be displayed.
   */
  public void setFailString(final String report) {
    this.getLblNewLabelThree().setText(report);
    this.getLblNewLabelThree().setBackground(Color.RED);
  }

  /**
   * Returns instance of ViewInterface.
   * 
   * @return instance of ViewInterface.
   */
  public static ViewInterface getInstance() {
    return null;
  }

  /**
   * Returns constant string "Infix".
   * 
   * @return constant string "Infix".
   */
  public static String getInfix() {
    return infix;
  }

  /**
   * Returns Calculate button.
   * 
   * @return Calculate button.
   */
  public JButton getBtnNewButton() {
    return btnNewButton;
  }

  /**
   * Returns first radio button.
   * 
   * @return first radio button.
   */
  public JRadioButton getRdbtnNewRadioButton() {
    return rdbtnNewRadioButton;
  }

  /**
   * Returns second radio button.
   * 
   * @return second radio button.
   */
  public JRadioButton getRdbtnNewRadioButtonOne() {
    return rdbtnNewRadioButtonOne;
  }

  /**
   * Returns answer label.
   * 
   * @return answer label.
   */
  public JLabel getLblNewLabelThree() {
    return lblNewLabelThree;
  }

  /**
   * Returns text field.
   * 
   * @return text field.
   */
  public JTextField getTextField() {
    return textField;
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
  public void startView() {}

  @Override
  public String getViewName() {
    return null;
  }
}
