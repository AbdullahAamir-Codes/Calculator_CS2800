package uk.ac.rhul.cs2800;

import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * By Dave Cohen, taken from moodle (calculator provided in CW2 description). Reads an expression
 * from the user and evaluates it and prints out the answer.
 * 
 * @author abdul
 */
public class AsciiView implements ViewInterface {
  private String question;

  Runnable doCalculation = null;

  Consumer<OpType> setCalculatorType = null;

  private void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C':
          if (doCalculation != null) {
            doCalculation.run();
          } else {
            System.out.println("Error: Calculation not set.");
          }
          break;
        case '?':
          System.out.print("Enter an expression: ");
          setExpression(s.next());
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  S - change to a standard calculator");
    System.out.println("  R - change to a reverse polish calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return "0";
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println("Answer is just around the corner");
  }

  @Override
  public void addCalculateObserver(Runnable f) {}

  @Override
  public void addTypeObserver(Consumer<OpType> c) {}

  @Override
  public void startView() {
    menu();
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public void setExpression(String expression) {
    System.out.println("Expression set to: " + expression);
  }

  @Override
  public void setCalculateListener(ActionListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setRadioListener(ActionListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public String getInfixString() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setAnswerString(String answer) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setFailString(String errorMessage) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setVisible(boolean b) {
    // TODO Auto-generated method stub

  }

  @Override
  public String getViewName() {
    // TODO Auto-generated method stub
    return null;
  }
}
