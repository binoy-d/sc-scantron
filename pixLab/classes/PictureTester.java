/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    parseNum("dark.jpg");
 
  }
  public static void parseNum(String name){
    Picture num = new Picture(name);
    num.plagerism();
    num.drawRegions();
    num.findTopLeftSquare();
    num.explore();
  }
}