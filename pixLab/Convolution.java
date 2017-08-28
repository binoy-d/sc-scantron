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
}