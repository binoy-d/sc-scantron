import java.io.IOException;

class Convolution{
  private String file_name = "";
  private String id;
  private double[][] values;
  public Convolution(String name){
    file_name = "C:\\Users\\francisconichola8928\\Desktop\\sc-scantron\\pixLab\\textfiles\\" + name + ".txt";
    id = name;
  }
  public Convolution(String name,String text){
    file_name = "C:\\Users\\francisconichola8928\\Desktop\\sc-scantron\\pixLab\\textfiles\\" + name + ".txt";
    id = name;
    try{
      WriteFile file = new WriteFile(file_name);
      file.writeToFile(text);
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }
  public Convolution(String name,double[][] input){
    file_name = "C:\\Users\\francisconichola8928\\Desktop\\sc-scantron\\pixLab\\textfiles\\" + name + ".txt";
    id = name;
    String text = "";
    for(int i = 0; i < values.length; i ++){
      for(int j = 0; j < values[0].length; j ++){
        text += roundDouble(values[i][j]);
        if(j != values[0].length-1){
          text += ",";
        }
      }
      if(i != values.length-1){
        text += "q";
      }
    }
    try{
      WriteFile file = new WriteFile(file_name);
      file.writeToFile(text);
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }
  public void write(String text){
    try{
      WriteFile file = new WriteFile(file_name);
      file.writeToFile(text);
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }
  public void write(double[][] input){
    values = input;
    String text = "";
    for(int i = 0; i < values.length; i ++){
      for(int j = 0; j < values[0].length; j ++){
        text += roundDouble(values[i][j]);
        if(j != values[0].length-1){
          text += ",";
        }
      }
      if(i != values.length-1){
        text += "q";
      }
    }
    try{
      WriteFile file = new WriteFile(file_name);
      file.writeToFile(text);
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
  }
  private double roundDouble(double d){
    return ((double)((int)(d*100000)))/100000;
  }
  public String getText(){
    String rtn = "";
    try{
      ReadFile file = new ReadFile(file_name);
      String[] aryLines = file.OpenFile();
      int i;
      for(i = 0; i < aryLines.length; i ++){
        rtn += aryLines[i];
      }
    }catch(IOException e){
      System.out.println(e.getMessage());
    }
    return rtn;
  }
  public String getId(){
    return id;
  }
  public void formDoubleArray(){
    String[] textWithCommas = getText().split("q");
    values = new double[textWithCommas.length][textWithCommas.length];
    double[][] nums = new double[textWithCommas.length][textWithCommas.length];
    for(int r = 0; r < 3; r ++){
      for(int c = 0 ; c < 3; c ++){
        values[r][c] = Double.parseDouble(textWithCommas[r].split(",")[c]);
      }
    }
  }
  public ScalarArray convolude(ScalarArray input){
    double[][] rtn = new double[input.getSize()][input.getSize()];
    for(int r = 0; r < rtn.length; r ++){
      for(int c = 0; c < rtn.length; c ++){
        double sum = 0;
        for(int i = -1; i <= 1; i ++){
          for(int j = -1; j <= 1; j++){
            if((r+i >= 0 && r+i < rtn.length && c+j >= 0 && c+j < rtn.length)){
              sum += input.getNum(r+i,c+j)*values[i+1][j+1];
            }
          }
        }
        rtn [r][c] = sum;
      }
    }
    ScalarArray output = new ScalarArray(rtn);
    return output;
  }
  public double fc(ScalarArray input){
    double score = 0;
    for(int r = 0; r < input.getSize(); r ++){
      for(int c = 0; c < input.getSize(); c ++){
        score += input.getNum(r,c)*values[r][c];
      }
    }
    return score;
  }
  public double[][] getDoubleArray(){
    return values;
  }
  public void modify(){
    values[(int)(Math.random()*values.length)][(int)(Math.random()*values[0].length)] = Math.random()*2-1;
    }
}