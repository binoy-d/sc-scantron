import java.util.ArrayList;
class Region{
  private ArrayList<Coordinate> region;
  public Region(){
    this.region = new ArrayList<Coordinate>();
  }
  void add(Coordinate coord){
    region.add(coord);
  }
  ArrayList<Coordinate> getRowegion(){
    return region;
  }
  int getSize(){
   return region.size(); 
  }
  double getScore(){
   return ((double)getSize())/getArea();
  }
  
  
  public Coordinate getTL(){
    
    Coordinate rtn = region.get(0);
    int min  = rtn.getRow()+rtn.getCol();
    for(Coordinate c: region){
      if(c.getRow()+c.getCol()<min){
       min  = c.getRow()+c.getCol();
       rtn = c;
      }
    }
    return rtn;
  }
  public Coordinate getTR(){
    Coordinate rtn = region.get(0);
    int min  = rtn.getRow()-rtn.getCol();
    for(Coordinate c: region){
      if(c.getRow()-c.getCol()<min){
       min  = c.getRow()+c.getCol();
       rtn = c;
      }
    }
    return rtn;
  }
  public Coordinate getBR(){
    Coordinate rtn = region.get(0);
    int min  = -rtn.getRow()-rtn.getCol();
    for(Coordinate c: region){
      if(-c.getRow()-c.getCol()<min){
       min  = c.getRow()+c.getCol();
       rtn = c;
      }
    }
    return rtn;
  }
  public Coordinate getBL(){
    Coordinate rtn = region.get(0);
    int min  = rtn.getCol()-rtn.getRow();
    for(Coordinate c: region){
      if(c.getCol()-c.getRow()<min){
       min  = c.getRow()+c.getCol();
       rtn = c;
      }
    }
    return rtn;
  }
  
  
  
  
  
  
  
  
  
  
  int getMaxRow(){
    int maxRow = 0;
    for(Coordinate c : region){
      if(maxRow < c.getRow()){
        maxRow = c.getRow();
      }
    }
    return maxRow;
  }
    int getMaxCol(){
    int maxCol = 0;
    for(Coordinate c : region){
      if(maxCol < c.getCol()){
        maxCol = c.getCol();
      }
    }
    return maxCol;
  }
    int getArea(){
      return (getMaxRow()-getMinRow())*(getMaxCol()-getMinCol());
    }
    int getMinRow(){
    int minRow = 300;
    for(Coordinate c : region){
      if(minRow < c.getRow()){
        minRow = c.getRow();
      }
    }
    return minRow;
  }
    int getMinCol(){
    int minCol = 300;
    for(Coordinate c : region){
      if(minCol < c.getCol()){
        minCol = c.getCol();
      }
    }
    return minCol;
  }
}