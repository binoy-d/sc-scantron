import java.util.ArrayList;
class Runner{
  public static void main(String[] args){
    ArrayList<Convolution> masterList = new  ArrayList<Convolution>();
    masterList = generateMasterList();
    ScalarArray grayscale = new ScalarArray(32,32);
    ArrayList<ScalarArray> Layer2 = new  ArrayList<ScalarArray>();
    for(int i = 0; i < 5; i ++){
      
    }
  }
  public static ArrayList<Convolution> generateMasterList(){
    ArrayList<Convolution> rtn = new  ArrayList<Convolution>();
    int[] ids = new int[340];
    int index = 0;
    for(index = 0; index < 5; index++){
      //ids[index] = 
    }
    System.out.print(index);
    for(int id : ids){
      rtn.add(new Convolution("" + id));
    }
    return rtn;
  }
}