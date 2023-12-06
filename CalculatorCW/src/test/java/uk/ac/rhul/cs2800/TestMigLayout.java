package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Component;
import java.awt.Container;
import java.io.Serializable;
import org.junit.jupiter.api.Test;

/**
 * Tests MigLayout class.
 * 
 * @author abdul
 */
class TestMigLayout {

  /**
   * Test method for AddLayoutComponent.
   */
  @Test
  void testAddLayoutComponent() {
    // Creates instance of MigLayout
    MigLayout migLayout = new MigLayout();
    // Adds layout component with specified name and mocked Component
    migLayout.addLayoutComponent("name", mock(Component.class));
  }

  /**
   * Private utility method for mocking Component.
   *
   * @param class1 is class to mock.
   * @return Mocked Component.
   */
  private Component mock(Serializable class1) {
    return null;
  }

  /**
   * Test method for RemoveLayoutComponent.
   */
  @Test
  void testRemoveLayoutComponent() {
    // Creates instance of MigLayout
    MigLayout migLayout = new MigLayout();
    // Removes layout component by providing mocked Component
    migLayout.removeLayoutComponent(mock(Component.class));
  }

  /**
   * Test method for PreferredLayoutSize.
   */
  @Test
  void testPreferredLayoutSize() {
    // Creates instance of MigLayout
    MigLayout migLayout = new MigLayout();
    // Creates mocked Container
    Container parent = (Container) mock(Container.class);
    // Assert that preferred layout size is null
    assertEquals(null, migLayout.preferredLayoutSize(parent));
  }

  /**
   * Test method for MinimumLayoutSize.
   */
  @Test
  void testMinimumLayoutSize() {
    // Creates instance of MigLayout
    MigLayout migLayout = new MigLayout();
    // Creates mocked Container
    Container parent = (Container) mock(Container.class);
    // Asserts that minimum layout size is null
    assertEquals(null, migLayout.minimumLayoutSize(parent));
  }

  /**
   * Test method for LayoutContainer.
   */
  @Test
  void testLayoutContainer() {
    // Creates instance of MigLayout
    MigLayout migLayout = new MigLayout();
    // Creates mocked Container
    Container parent = (Container) mock(Container.class);
    // Layout container using MigLayout
    migLayout.layoutContainer(parent);
  }
}
