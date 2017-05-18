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

  public Picture (){   super();  }

  public Picture(String fileName){super(fileName);}
  
  public Picture(int height, int width){ super(width,height);}
  
  public Picture(Picture copyPicture){super(copyPicture);}

  public Picture(BufferedImage image){super(image);}

  public String toString(){ return "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();}
  
  public static void main(String[] args)
  {
    Picture p = new Picture("./images/dark.jpg");
    p.parseNum();
  }
  public  void parseNum(){
    Picture pic = this;
    pic.explore();
  }
  
  
  public Picture transform(){
   return newPic; 
  }
  
  
  
  //STUFF WE WILL NOT USE BUT DONT WANT TO GET RID OF
/*
  public Pixel[][] plagerism(){
    Pixel[][] pixels = this.getPixels2D();
    boolean[][] squares = new boolean[pixels.length][pixels[0].length];
    boolean[][] graphite = new boolean[pixels.length][pixels[0].length]; 
    for(int i= 0; i < 16; i ++){
      for(int j= 0; j < 16; j ++){
        int red = 0;
        int green = 0;
        int blue = 0;
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
            if(c.getRed() < (int)(((double)(average.getRed()))/255*100) && c.getGreen() < (int)(((double)(average.getGreen()))/255*100) && c.getBlue() < (int)(((double)(average.getBlue()))/255*100)){
              squares[row][col] = true;
            }else if(c.getRed()<average.getRed()-40&&c.getBlue()<average.getBlue()-40&&c.getGreen()<average.getGreen()-40){
              pixels[row][col].setColor(Color.RED);
              graphite[row][col] = true;
            }
          }
        }
      }
    }
    ArrayList<Region> regionList = new ArrayList<Region>();
    for(int row = 0; row < pixels.length; row ++){
      for(int col = 0; col < pixels[0].length; col ++){
        if(squares[row][col]){
          
          regionList.add(new Region());
          
          developRegion(squares,regionList.get(regionList.size()-1),row,col);
          if(regionList.get(regionList.size()-1).getSize()<20)
            regionList.remove(regionList.size()-1);
        }
      }
    }
    for(int i = regionList.size()-1; i >= 0; i--){
      if(regionList.get(i).getSize() > (regionList.get(i).getMaxRow()-regionList.get(i).getMinRow())*(regionList.get(i).getMaxCol()-regionList.get(i).getMinCol())/1000){
        regionList.remove(i);
      }
    }
    for(Region reg: regionList){
      Color c = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
      for(Coordinate coord : reg.getRegion()){
        pixels[coord.getR()][coord.getC()].setColor(c);
      }
    }
    System.out.println("number of regions is "+regionList.size());
    return pixels;
  }
  //recursive method for creating a region
  public void developRegion(boolean[][] squares, Region region,int r,int c){
    if(squares[r][c]){
      squares[r][c] = false;
      region.add(new Coordinate(r,c));
      if(r < squares.length && r > 0 && c < squares[0].length && c > 0){
        developRegion(squares,region,r+1,c);
        developRegion(squares,region,r,c+1);
        developRegion(squares,region,r-1,c);
        developRegion(squares,region,r,c-1);
      }
    }
  }
  */
} 