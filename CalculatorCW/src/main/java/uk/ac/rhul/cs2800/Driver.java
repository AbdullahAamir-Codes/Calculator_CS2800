package uk.ac.rhul.cs2800;

/**
 * By Dave Cohen, taken from moodle (calculator provided in CW2 description). Initializes and runs
 * the calculator. Main method creates view, runs calculator. CreateView method creates view based
 * on console availability and runCalculator method creates model, associating view with last view.
 * 
 * @author abdul
 */
public class Driver {

  /**
   * Entry point of program that initialize and run calculator.
   * 
   * @param args cmd arguments.
   */
  public static void main(String[] args) {
    ViewInterface view = createView();
    runCalculator(view);
  }

  /**
   * Initializes and runs calculator using provided view, also creates new calculator model, sets
   * last view by using ViewFactory, creates controller, and starts view.
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
   * Creates appropriate view based on console availability. If console is not available, it returns
   * instance of CalcView. Otherwise, it returns AsciiView instance.
   * 
   * @return instance of ViewInterface representing created view.
   */
  private static ViewInterface createView() {
    ViewInterface view = new AsciiView();
    if (System.console() == null) {
      view = CalcView.getInstance();
    }

    return view;
  }
}
