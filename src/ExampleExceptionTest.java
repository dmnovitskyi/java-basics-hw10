import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {2 ,0 ,0},
        {64, 256 ,16384}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
        {-8, -4},
        {-4, 0}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a,b),c);
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    try {
      ExampleException.rectangleArea(a, b);
      fail("IllegalArgumentExeption expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "input below zero");
    }
  }
}