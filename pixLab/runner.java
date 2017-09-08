import java.util.ArrayList;
class Runner{
  public static void main(String[] args){
    ArrayList<Convolution> masterList = generateMasterList();
    ArrayList<ScalarArray> grayScales = new ArrayList<ScalarArray>();
    formDoubleArrays(masterList);
    for(int i = 0; i < 100; i ++){
      grayScales.add(new ScalarArray(32,32));
    }
    int[] answers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
    for(int j = 0; j < 100; j ++){
      String output = "";
      for(int i = 0; i < 25; i ++){
        output += learn(grayScales, answers, masterList) + " ";
      }
      System.out.println(output);
    }
  }
  public static int learn(ArrayList<ScalarArray> grayScales, int[] answers, ArrayList<Convolution> masterList){
    int score = getScore(grayScales, answers, masterList);
    modify(masterList,50);
    int newScore = getScore(grayScales, answers,masterList);
    if(score < newScore){
      save(masterList);
      return newScore;
    }else{
      formDoubleArrays(masterList);
      return score;
    }
  }
  
  public static int getScore(ArrayList<ScalarArray> grayScales, int[] answers, ArrayList<Convolution> masterList){
    int score = 0;
    for(int i = 0; i < answers.length; i ++ ){
      if(identify(grayScales.get(i),masterList) == answers[i]){
        score ++;
      }
    }
    return score;
  }
  
  public static void save(ArrayList<Convolution> masterList){
    for(Convolution c : masterList){
      c.write(c.getDoubleArray());
    }
  }
  public static void modify(ArrayList<Convolution> masterList,int n){
    for(n = n; n >= 0; n--){
      masterList.get((int)(Math.random()*340)).modify();
    }
  }
  public static int identify(ScalarArray grayScale,ArrayList<Convolution> masterList){
    ArrayList<ScalarArray> layer1 = new ArrayList<ScalarArray>();
    for(int i = 0; i < 5; i ++){
      layer1.add(masterList.get(i).convolude(grayScale));
    }
    relu(layer1);
    pool(layer1);
    ArrayList<ScalarArray> layer2 = new ArrayList<ScalarArray>();
    for(int j = 1; j < 6; j ++){
      ArrayList<ScalarArray> toBeSummed = new ArrayList<ScalarArray>();
      for(int i = 0; i < 5; i ++){
        ScalarArray term = new ScalarArray(layer1.get(i).getDupeValues());
        toBeSummed.add(masterList.get(5*j+i).convolude(term));
      }
      layer2.add(sum(toBeSummed));
    }
    relu(layer2);
    pool(layer2);
    double[] scores = new double[62];
    for(int j = 6; j < 68; j ++){
      double score = 0;
      for(int i = 0; i < 5; i ++){
        score += masterList.get(5*j+i).fc(layer2.get(i));
      }
      scores[j-6] = score;
    }
    int finalIndex = 0;
    for(int i = 0; i < 62; i ++){
      if(scores[i] > scores[finalIndex]){
        finalIndex = i;
      }
    }
    return finalIndex;
  }
  public static void randomizeValues(ArrayList<Convolution> masterList){
    for(int i = 0; i < 340; i ++){
      if(i < 30){
        masterList.get(i).write(getRandomDoubleArray(3));
      }else{
        masterList.get(i).write(getRandomDoubleArray(8));
      }
    }
  }
  public static void formDoubleArrays(ArrayList<Convolution> masterList){
    for(Convolution c : masterList){
      c.formDoubleArray();
    }
  }
  public static ScalarArray sum(ArrayList<ScalarArray> input){
    ScalarArray rtn = new ScalarArray(input.get(0).getSize(),input.get(0).getSize());
    for(int r = 0; r < rtn.getSize(); r ++){
      for(int c = 0; c < rtn.getSize(); c++){
        int sum = 0;
        for(ScalarArray sa : input){
          sum += sa.getNum(r,c);
        }
        rtn.setNum(r,c,sum);
      }
    }
    return rtn;
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
  public static double[][] getRandomDoubleArray(int size){
    double[][] rtn = new double[size][size];
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