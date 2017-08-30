import java.util.ArrayList;
class Runner{
  public static void main(String[] args){
    ArrayList<Convolution> masterList = new  ArrayList<Convolution>();
    masterList = generateMasterList();
    ScalarArray grayScale = new ScalarArray(4,4);
    System.out.println(grayScale + "\n");
    ArrayList<ScalarArray> layer1 = new ArrayList<ScalarArray>();
    for(int i = 0; i < 5; i ++){
      masterList.get(i).formDoubleArray();
      layer1.add(masterList.get(i).convolude(grayScale));
    }
    for(ScalarArray sa : layer1){
      System.out.println(sa + "\n");
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