import org.junit.After;
import org.junit.Before;
import slime.ac.uk.Sort;

// import all static methods of Assert
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;


// you can use unit tests to test your model: buisness rules and logic
// to make sure functional works as intended as you incrementally develop -
// your tasks from user-stories

// BDD is when you design your systems around real-world-scenarios (& systems) and requirements
// think about BDD keyboard cat: scenario's that could happen: how is your software tool/system -
// robust to fend againt all of these different possibilities?

public class SortUnitTests{
  private int[] unorderedNumbers;
  final private int[] orderedNumbers = {1, 3, 3, 4, 4, 5 ,6, 8};
  final private int[] unorderedNumbersUnParsed = {5, 1, 4, 3, 6, 3, 8, 4};
  private boolean runAfter;

  // @Before
  // set up: make an array

  @Before
  public void setup(){
    this.unorderedNumbers = new int[] {5, 1, 4, 3, 6, 3, 8, 4};
    this.runAfter = true;
  }

  @After
  public void testForMutationsOnArray(){
    if(runAfter)
      assertArrayEquals("there's been a mutation on array",
              this.unorderedNumbers, this.unorderedNumbersUnParsed);
  }

  @Test
  public void testJunitWorks() {
    final int x = 5;
    final int y = 2;
    assertEquals(7, x + y);
  }

  @Test
  public void testBubbleSort() {
    int[] actual = Sort.bubble(this.unorderedNumbers);
    int[] predicted = this.orderedNumbers;
    assertArrayEquals(predicted, actual);
  }

  @Test
  public void testQuickSort(){
    int[] actual = Sort.quick(this.unorderedNumbers);
    int[] predicted = this.orderedNumbers;
    assertArrayEquals(predicted, actual);
  }

  @Test
  public void testMergeSort(){
    int[] actual = Sort.merge(this.unorderedNumbers);
    int[] predicted = this.orderedNumbers;
    assertArrayEquals(predicted, actual);
  }

  @Test
  public void testSelectionSort() {
    int[] actual = Sort.selection(this.unorderedNumbers);
    int[] predicted = this.orderedNumbers;
    assertArrayEquals(predicted, actual);
  }

  @Test
  public void testArrayCopy(){
    int[] arr = {5, 2, 4, 3, 1};
    int[] copy = Sort.copyArr(arr);
    assertNotEquals("assert object references are different", arr, copy);
  }

  @Test
  public void testSwapUtil(){

    // swap is designed to mutate the array that is parsed to it

    Sort.swap(this.unorderedNumbers, 0,1);
    String mutatedArrayAsString = Arrays.toString(this.unorderedNumbers);
    String originalStringRepresentation = Arrays.toString(this.unorderedNumbersUnParsed);
    assertTrue(!mutatedArrayAsString.equals(originalStringRepresentation));
    this.runAfter = false;
  }

  // test object reference is the same(mutated)

}
