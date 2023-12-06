package uk.ac.rhul.cs2800;

/**
 * Manages views in application. It also provide methods to get last view and set last view.
 * 
 * @author abdul
 */
public class ViewFactory {

  /**
   * lastView variable stores reference to last view.
   */
  private static ViewInterface lastView;

  /**
   * Retrieves last view that was set.
   *
   * @return Last ViewInterface object that was set.
   */
  public static ViewInterface getLastView() {
    return lastView;
  }

  /**
   * Sets last view to specified ViewInterface object.
   *
   * @param view is ViewInterface object to be set as last view.
   */
  public static void setLastView(ViewInterface view) {
    lastView = view;
  }
}
