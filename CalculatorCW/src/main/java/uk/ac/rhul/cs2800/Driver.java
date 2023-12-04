package uk.ac.rhul.cs2800;

/**
 * Taken from moodle (calculator provided in CW2 description).
 * 
 * @author abdul
 */
public class Driver {

  /**
   * The entry point for the calculator.
   * 
   * @param args ignored - could be used to choose which view to load in future?
   */
  public static void main(String[] args) {
    ViewInterface view = new AsciiView();

    CalcModel model = new CalcModel();
    System.out.println("hello");

    // Decide which view to build.
    if (System.console() == null) {
      System.out.println("hello");
      view = CalcView.getInstance();
    }
    new CalcController(model, view);
    // All ready so begin the interface.
    view.startView();
  }
}
