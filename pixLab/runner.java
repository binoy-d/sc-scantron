import java.util.ArrayList;
class Runner{
  public static void main(String[] args){
    ArrayList<Convolution> masterList = new  ArrayList<Convolution>();
    masterList = generateMasterList();
    ScalarArray grayScale = new ScalarArray(32,32);
    ArrayList<ScalarArray> layer1 = new ArrayList<ScalarArray>();
    for(int i = 0; i < 5; i ++){
      masterList.get(i).formDoubleArray();
      layer1.add(masterList.get(i).convolude(grayScale));
    }
    relu(layer1);
    pool(layer1);
    ArrayList<ScalarArray> layer2 = new ArrayList<ScalarArray>();
    for(int i = 5; i < 30; i ++){
      masterList.get(i).formDoubleArray();
      //get an array list and sum them
    }
  }
  public static void relu(ArrayList<ScalarArray> inputLayer){
    for(ScalarArray sa : inputLayer){
      sa.relu();
    }
  }
  public static void pool(ArrayList<ScalarArray> inputLayer){
    for(ScalarArray sa : inputLayer){
      sa.pool();
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
        ids[index] = "3" + i + "4" + j;
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