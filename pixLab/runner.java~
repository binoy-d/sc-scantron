import java.util.ArrayList;
class Runner{
  public static void main(String[] args){
    ArrayList<Convolution> masterList = new  ArrayList<Convolution>();
    masterList = generateMasterList();
    for(Convolution c : masterList){
      c.write(getRandomDoubleArray());
    }
    String[] textWithCommas = masterList.get(0).getText().split("q");
    double[][] nums = new double[3][3];
    for(int r = 0; r < 3; r ++){
      for(int c = 0 ; c < 3; c ++){
        nums[r][c] = Double.parseDouble(textWithCommas[r].split(",")[c]);
        System.out.print(nums[r][c] + " ");
      }
      System.out.println();
    }
  }
  public static double[][] getRandomDoubleArray(){
    double[][] rtn = new double[3][3];
    for(int r = 0;r < rtn.length; r ++){
      for(int c = 0;c < rtn.length; c ++){
        rtn[r][c] = Math.random();
      }
    }
    return rtn;
  }
  public static ArrayList<Convolution> generateMasterList(){
    ArrayList<Convolution> rtn = new  ArrayList<Convolution>();
    String[] ids = new String[340];
    int index = 0;
    for(int i = 0; i < 5; i++){
      ids[index] = "000" + i;
      index ++;
    }
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        ids[index] = "3" + j + "4" + i;
        index ++;
      }
    }
    for(int i = 0; i < 62; i++){
      for(int j = 0; j < 5; j++){
        ids[index] = "3" + j + "4" + i;
        index ++;
      }
    }
    for(String id : ids){
      rtn.add(new Convolution(id));
    }
    return rtn;
  }
}