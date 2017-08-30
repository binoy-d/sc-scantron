import java.util.ArrayList;
class ScalarArray{
  double[][] arr;
  public ScalarArray(int rows, int cols){
    arr = new double[rows][cols];
    for(int r = 0; r < rows; r ++){
      for(int c = 0; c < cols; c ++){
        arr[r][c] = Math.random(); 
      }
    }
  }
  public ScalarArray(double[][] values){
    arr = values;
  }
  public int getSize(){
    return arr.length;
  }
  public void setValues(double[][] values){
    arr = values;
  }
  public double[][] getValues(){
    return arr;
  }
  public double getNum(int r,int c){
    return arr[r][c];
  }
  public String toString(){
    String rtn = "";
    for(int r = 0; r < arr.length; r ++){
      for(int c = 0; c < arr[0].length; c ++){
        if(r != arr.length-1){
          rtn += arr[r][c] + ", ";
        }
      }
      rtn += "\n";
    }
    return rtn; 
  }
  public void relu(){
    for(int r = 0; r < arr.length; r ++){
      for(int c = 0; c < arr[0].length; c ++){
        if(arr[r][c] < 0){
          arr[r][c] = 0;
        }
      }
    }
  }
  public void pool(){
    double[][] newArr = new double[arr.length/2][arr[0].length/2];
    for(int r = 0; r < arr.length; r += 2){
      for(int c = 0; c < arr[0].length; c += 2){
        newArr[r/2][c/2] = Math.max(arr[r][c],Math.max(arr[r+1][c],Math.max(arr[r][c+1],arr[r+1][c+1])));
      }
    }
    arr = newArr;
  }
  public static ScalarArray sum(ArrayList<ScalarArray> inputs){
    //return something
  }
}