import java.util.ArrayList;
class Region{
  private ArrayList<Coordinate> region;
  public Region(){
    this.region = new ArrayList<Coordinate>();
  }
  void add(Coordinate coord){
    region.add(coord);
  }
  ArrayList<Coordinate> getRegion(){
    return region;
  }
  int getSize(){
   return region.size(); 
  }
  int getMaxRow(){
    int maxRow = 0;
    for(Coordinate c : region){
      if(maxRow < c.getR()){
        maxRow = c.getR();
      }
    }
    return maxRow;
  }
    int getMaxCol(){
    int maxCol = 0;
    for(Coordinate c : region){
      if(maxCol < c.getC()){
        maxCol = c.getC();
      }
    }
    return maxCol;
  }
    int getMinRow(){
    int minRow = 300;
    for(Coordinate c : region){
      if(minRow < c.getR()){
        minRow = c.getR();
      }
    }
    return minRow;
  }
    int getMinCol(){
    int minCol = 300;
    for(Coordinate c : region){
      if(minCol < c.getC()){
        minCol = c.getC();
      }
    }
    return minCol;
  }
}