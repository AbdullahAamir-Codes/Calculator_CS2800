package uk.ac.rhul.cs2800;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

/**
 * Implements LayoutManager interface to provide custom layout for Swing components by using
 * MigLayout.
 * 
 * @author abdul
 */
public class MigLayout implements LayoutManager {
  @Override
  public void addLayoutComponent(String name, Component comp) {}

  @Override
  public void removeLayoutComponent(Component comp) {}

  /**
   * Calculates and returns the preferred size of container based on current components and their
   * constraints.
   *
   * @param parent container whose preferred size is being calculated.
   * @return preferred size of container.
   */
  @Override
  public Dimension preferredLayoutSize(Container parent) {
    return null;
  }

  /**
   * Calculates and returns the minimum size of container based on current components and their
   * constraints.
   *
   * @param parent container whose minimum size is being calculated.
   * @return minimum size of container.
   */
  @Override
  public Dimension minimumLayoutSize(Container parent) {
    return null;
  }

  /**
   * Lays components in container. Responsible for positioning and sizing each component in
   * container.
   *
   * @param parent container to be laid out.
   */
  @Override
  public void layoutContainer(Container parent) {}
}
