package slime.ac.uk;
import slime.ac.uk.Sort;

// import all static methods of Assert
import static org.junit.Assert.*;
import org.junit.Test;


// you can use unit tests to test your model: buisness rules and logic
// to make sure functional works as intended as you incrementally develop -
// your tasks from user-stories

// BDD is when you design your systems around real-world-scenarios (& systems) and requirements
// think about BDD keyboard cat: scenario's that could happen: how is your software tool/system -
// robust to fend againt all of these different possibilities?

public class SortUnitTests{

  // @Before
  // set up: make an array

  @Test
  public void testJunitWorks() {
    final int x = 5;
    final int y = 2;
    assertEquals(7, x + y);
    // System.out.println("asfsa");
  }

  @Test
  public void testBubbleSort() {
    int[] arr = {5, 2, 4, 3, 1};
    int[] actual = Sort.bubble(arr);
    int[] predicted = {1, 2, 3, 4, 5};
    assertArrayEquals(predicted, actual);
    // System.out.println("asfsa");
  }
  @Test
  public void testInsertionSort() {
    int[] arr = {5, 2, 4, 3, 1};
    int[] actual = Sort.insertion(arr);
    int[] predicted = {1, 2, 3, 4, 5};
    assertArrayEquals(predicted, actual);
    // System.out.println("asfsa");
  }

  @Test
  public void testArrayCopy(){
    int[] arr = {5, 2, 4, 3, 1};
    int[] copy = Sort.copyArr(arr);
    assertNotEquals("assert object references are different", arr, copy);
  }

  // test object reference is the same(mutated)

}
