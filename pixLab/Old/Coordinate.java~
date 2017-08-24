import java.awt.Color;
class Coordinate{
  private int r,c;
  public Coordinate(int r,int c){
    this.r = r;
    this.c = c;
  }
  public Coordinate(double r,double c){
    this.r = (int)r;
    this.c = (int)c;
  }
  int getRow(){
    return r;
  }
  int getCol(){
    return c;
  }
  public String toString(){
   return "("+r+","+c+")"; 
  }
  public void setPixelColor(Picture p, Color t){
    Pixel[][] pixels = p.getPixels2D();
    pixels[r][c].setColor(t);
  }
}