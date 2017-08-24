import java.util.ArrayList;
class Region{
  private ArrayList<Coordinate> region;
  
  public Region(){this.region = new ArrayList<Coordinate>();}
  public void add(Coordinate coord){region.add(coord);}
  public ArrayList<Coordinate> getRegion(){return region;}
  public int getSize(){return region.size(); }
  //returns the 'thickness' of a region: number of corrdinates/area they occupy
  public double getScore(){return ((double)getSize())/getArea();}
  //for combining regions
  public void addCoords(Region p){region.addAll(p.getRegion()); }
  //find top left corner
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
  //find top right corner
  public Coordinate getTR(){
    Coordinate rtn = region.get(0);
    int min  = rtn.getRow()-rtn.getCol();
    for(Coordinate c: region){
      if(c.getRow()-c.getCol()<min){
       min  = c.getRow()-c.getCol();
       rtn = c;
      }
    }
    return rtn;
  }
  //find bottom right corner
  public Coordinate getBR(){
    Coordinate rtn = region.get(0);
    int max  = rtn.getRow()+rtn.getCol();
    for(Coordinate c: region){
      if(c.getRow()+c.getCol()>max){
       max  = c.getRow()+c.getCol();
       rtn = c;
      }
    }
    return rtn;
  }
  //find bottom left corner
  public Coordinate getBL(){
    Coordinate rtn = region.get(0);
    int min  = rtn.getCol()-rtn.getRow();
    for(Coordinate c: region){
      if(c.getCol()<(getBR().getCol()-getTL().getCol())/3&&c.getCol()-c.getRow()<min){
       min  = c.getCol()-c.getRow();
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
    public String toString(){
      String ret = "{";
      for(Coordinate c: region){
        ret+=c.toString();
        ret+=",";
      }
      ret+="}";
      return ret;
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