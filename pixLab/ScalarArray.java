class ScalarArray{
  double[][] arr;
  public ScalarArray(int rows, int cols){
    arr = new double[rows][cols];
    for(int r = 0; r < rows; r ++){
      for(int c = 0; c < cols; c ++){
        arr[r][c] = Math.random()*2-1; 
      }
    }
  }
  public ScalarArray(double[][] values){
    arr = values;
  }
}