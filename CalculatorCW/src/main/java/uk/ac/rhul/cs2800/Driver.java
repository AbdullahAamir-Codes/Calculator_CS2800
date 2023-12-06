package uk.ac.rhul.cs2800;

/**
 * By Dave Cohen, taken from moodle (calculator provided in CW2 description). Serves as entry point
 * for calculator and Creates necessary components like model, view, and controller.
 * 
 * @author abdul
 */
public class Driver {

  /**
   * Main method of calculator. Creates a view, initializes calculator with the created view.
   * 
   * @param args Cmd arguments.
   */
  public static void main(String[] args) {
    ViewInterface view = createView();
    runCalculator(view);
  }

  /**
   * Initializes calculator with given view and starts calculator.
   * 
   * @param view to be associated with calculator.
   */
  public static void runCalculator(ViewInterface view) {

    CalcModel model = new CalcModel();

    ViewFactory.setLastView(view);

    new CalcController(model, view);

    if (view != null) {
      view.startView();
    }
  }

  /**
   * Creates and returns appropriate view for calculator. Default view is AsciiView, but if console
   * is not available, CalcView.getInstance() will be used.
   * 
   * @return The created view.
   */
  private static ViewInterface createView() {
    ViewInterface view = new AsciiView();
    if (System.console() == null) {
      view = CalcView.getInstance();
    }

    return view;
  }
}
