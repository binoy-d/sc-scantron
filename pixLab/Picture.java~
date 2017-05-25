import java.lang.Math;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */





public class Picture extends SimplePicture 
{
  //region stuff
  public ArrayList<Region> regionList ;
  public Region region = new Region() ;
  //the coordinates
  public Coordinate topLeft;
  public Coordinate topRight;
  public Coordinate bottomLeft;
  public Coordinate bottomRight;
  boolean[][] isblack;
  //housekeeping
  public Picture (){   super();  }
  public Picture(String fileName){super(fileName);}
  public Picture(int height, int width){ super(width,height);}
  public Picture(Picture copyPicture){super(copyPicture);}
  public Picture(BufferedImage image){super(image);}
  public String toString(){ return "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();}
  
  public static void main(String[] args)
  {
    Picture p = new Picture("./images/test13.jpg");
    p.parseNum();
  }
  public  void parseNum(){
    Picture pic = this;
    pic = pic.transform();
   pic.isblack =  pic.blackFilter();
    pic.developRegion();
    pic.colorCorners();
    pic.drawCross(pic.findMid(),10,Color.GREEN);
    pic.drawCross(pic.findMid2(),10,Color.RED);
    pic.explore();
  }
  
  
  public Picture transform(){
    Picture newPic = new Picture(this);
    return newPic; 
  }
  public Coordinate findMid2(){
    double x1 = topLeft.getCol();
    double x3 = topRight.getCol();
    double x4 = bottomLeft.getCol();
    double x2 = bottomRight.getCol();
    
    double y1 = topLeft.getRow();
    double y3 = topRight.getRow();
    double y4 = bottomLeft.getRow();
    double y2 = bottomRight.getRow();
    
   return new Coordinate((y1+y2+y3+y4)/4,(x1+x2+x3+x4)/4); 
  }
  public boolean[][] blackFilter(){
    Pixel[][] pixels = this.getPixels2D();
    boolean[][] squares = new boolean[pixels.length][pixels[0].length];
    
    for(int i= 0; i < 16; i ++){
      for(int j= 0; j < 16; j ++){
        int red = 0;
        int green = 0;
        int blue = 0;
        //Making blocks
        for(int row = i*pixels.length/16; row < (i+1)*pixels.length/16; row ++){
          for(int col = j*pixels[0].length/16; col < (j+1)*pixels[0].length/16; col ++){
            Color c = pixels[row][col].getColor();
            red += c.getRed();
            green += c.getGreen();
            blue += c.getBlue();
            
          }
        }
        red/=(pixels.length*pixels[0].length/256);
        green/=(pixels.length*pixels[0].length/256);
        blue/=(pixels.length*pixels[0].length/256);
        
        
        Color average = new Color(red,green,blue);
        
        for(int row = i*pixels.length/16; row < (i+1)*pixels.length/16; row ++){
          for(int col = j*pixels[0].length/16; col < (j+1)*pixels[0].length/16; col ++){
            Color c = pixels[row][col].getColor();
            int t = 1;
            if(c.getRed() < average.getRed()/2 && c.getBlue()<average.getBlue()/2 && c.getGreen()<average.getGreen()/2){
              squares[row][col] = true;
              //pixels[row][col].setColor(Color.red);
            }
          }
        }
      }
      
    }
    return squares;
  }
  public void colorCorners(){
    Pixel[][] pixels = getPixels2D();
    topLeft = region.getTL();
    topRight = region.getTR();
    bottomRight = region.getBR();
    bottomLeft = region.getBL();
    for(Coordinate c : region.getRegion()){
     pixels[c.getRow()][c.getCol()].setColor(Color.BLUE); 
    }
    
    drawCross(topLeft,10,Color.RED);
    drawCross(topRight,10,Color.RED);
    drawCross(bottomLeft,10,Color.RED);
    drawCross(bottomRight,10,Color.RED);
    
    System.out.println(topLeft);
    System.out.println(topRight);
    System.out.println(bottomLeft);
    System.out.println(bottomRight);
  }
  public Coordinate findMid(){
    double x1 = topLeft.getCol();
    double x3 = topRight.getCol();
    double x4 = bottomLeft.getCol();
    double x2 = bottomRight.getCol();
    
    double y1 = topLeft.getRow();
    double y3 = topRight.getRow();
    double y4 = bottomLeft.getRow();
    double y2 = bottomRight.getRow();
    
    double m1 = (y2-y1)/(x2-x1);
    double m2 = (y4-y3)/(x4-x3);
    
    double denominator = m1-m2;
    double numerator = m1*x1-m2*x3+y3-y1;
    
    double retX = numerator/denominator;
    
    double retY = m1*(retX-x1)+y1;
    
    
    
    
    return new Coordinate((int)retY,(int)retX);
  }
    
    
    
  public void developRegion(){
    Pixel[][] pixels = getPixels2D();
    for(int i = 0;i<pixels.length;i++){
      for(int j = 0;j<pixels[0].length;j++){
        if(isblack[i][j]){
          region.add(new Coordinate(i,j)); 
        }
      }
    }
  }
  public void drawCross(Coordinate g,int size,Color h){
    int i = g.getRow();
    int j = g.getCol();
    Pixel[][] pixels = getPixels2D();
    for(int r = i-size/2;r<i+size/2;r++){
      pixels[r][j].setColor(h); 
      //pixels[r][j+1].setColor(h);
      //pixels[r][j-1].setColor(h);
    }
    for(int c = j-size/2;c<j+size/2;c++){
      pixels[i][c].setColor(h); 
      //pixels[i+1][c].setColor(h); 
      //pixels[i-1][c].setColor(h); 
    }
  }
  
} 
