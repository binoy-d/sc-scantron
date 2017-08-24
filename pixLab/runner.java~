class Runner{
  public static void main(String[] args){
    double[][] nums = new double[32][32];
    for(int i = 0; i < 32; i ++){
      for(int j = 0; j < 32; j ++){
        nums[i][j] = Math.random();
      }
    }
    Convolution test = new Convolution("notsmall",nums);
    String[][] q = new String[32][32];
    for(int i = 0; i < 32; i ++){
      q[i] = test.getText().split(" ")[i].split(",");
    }
    double[][] parsed = new double[32][32];
     for(int i = 0; i < 32; i ++){
       for(int j = 0; j < 32; j ++){
         parsed[i][j] = Double.parseDouble(q[i][j]);
       }
     }
  }
}