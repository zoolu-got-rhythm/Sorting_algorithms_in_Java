// keep methods/units of code pure & testable(and so they only do 1 thing well)
package slime.ac.uk;
import slime.ac.uk.TestClass.*;

/* TODO:
- ci: TIME on target enviornment and send back report
- make method generic?
-


*/

public class Sort{
  //private size = 50;
  // big o:

  public static void main(String[] args){
    int[] data = {5, 2, 6, 2, 3, 1, 4, 7};
    int[] mergeSorted = merge(data);
    System.out.println(mergeSorted);
  }



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

  public static int[] selection(int[] input){
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

  public static int[] merge(int[] input){
    return new MergeSort(){
      public int[] divide(int[] input){
        if(input.length < 2) // can't be divided anymore
          return input;
        int[] arrLeft = new int[input.length / 2];
        int[] arrRight = new int[input.length / 2];

        for(int j = 0; j < arrLeft.length; j++){
          arrLeft[j] = input[j];
        }

        for(int i = 0; i < arrRight.length; i++){
          arrRight[i] = input[input.length / 2 + i];
        }


        System.out.println("left arr");
        for (int l : arrLeft)
          System.out.println(l);
        System.out.println("right arr");
        for (int r : arrRight)
          System.out.println(r);
        int[] left = this.divide(arrLeft);
        int[] right = this.divide(arrRight);
        return doMerge(left, right);
        /*
          doMerge(left, right)
        */
        // return this.merge(left, right);
      }

      public int[] doMerge(int[] left, int[] right){
        int[] temp = new int[left.length + right.length];

        int l = 0;
        int r = 0;
        for(int i = 0; i < temp.length; i++){
          if((r >= right.length) || (l < left.length && left[l] <= right[r])){
            temp[i] = left[l];
            l++;
          }else{
            temp[i] = right[r];
            r++;
          }
        }
        System.out.println("merged arr");
        for(int n : temp)
          System.out.println(n);
        System.out.println("merged arr end");
        return temp;
      }
    }.divide(input);
  }

  interface MergeSort{
    int[] divide(int[] arr);
    int[] doMerge(int[] left, int[] right);
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
