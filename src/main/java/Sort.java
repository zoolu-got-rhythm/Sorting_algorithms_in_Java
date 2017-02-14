// keep methods/units of code: testable(and so they only do 1 thing well)
package slime.ac.uk;

public class Sort{
  //private size = 50;
  // big o:

  public static void main(String[] args){
    int[] data = {5, 2, 6, 2, 3, 1, 4};
    int[] sorted = bubble(data);
    for(int n : sorted){
      System.out.println(n);
    }

    for(int n : data){
      System.out.println(n);
    }

    int[] insertionSorted = insertion(data);
    for(int n : insertionSorted){
      System.out.println(n);
    }

  }

  // private static getRandomNumber(int min, int max){
  //
  // }


  // big o-notation: n squared(can reduce to n * log(n)?)
  public static int[] bubble(int[] input){
    // remember java methods are parsed by value of reference?
    int[] output = copyArr(input);

    // int[] temp = int[arr.length];
    for(int i = 0; i < output.length - 1; i++)
      for(int j = i + 1; j < output.length; j++)
        if(output[i] > output[j]){
          //swap
          int temp = output[i];
          output[i] = output[j];
          output[j] = temp;
        }
    return output;
  }

  public static int[] insertion(int[] input){
    int[] output = copyArr(input);
    int min = 0; //min index
    int temp;
    for(int i = 0; i < output.length - 1; i++){
      min = i;
      for(int j = i + 1; j < output.length; j++){
        if(output[min] > output[j]){
          min = j;
        }
      }
      // swap
      temp = output[i];
      output[i] = output[min];
      output[min] = temp;
    }
    return output;
  }

  public static int[] copyArr(int[] input){
    int[] output = new int[input.length];
    System.arraycopy(input, 0, output, 0, output.length);
    return output;
  }





  // private static int[] selection(){
  //
  // }




}
