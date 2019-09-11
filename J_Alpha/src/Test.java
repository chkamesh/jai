
// Java code for serialization and deserialization  
// of a Java object 
import java.io.*; 

class Dem implements java.io.Serializable 
{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x; 
    public String y; 
  
    // Default constructor 
    public Dem(int x, String y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
  
} 
  
//class Demo extends Dem implements java.io.Serializable 
//{ 
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 2L;
//	public int a; 
//    public String b; 
//  
//    // Default constructor 
//    public Demo(int a, String b) 
//    { 
//    	super(1,"dem");
//        this.a = a; 
//        this.b = b; 
//    } 
//  
//} 
//  
public class Test 
{ 
    public static void main(String[] args) 
    {    
//        Demo object = new Demo(1, "geeksforgeeks"); 
        String filename = "file.ser"; 
          
        // Serialization  
//        try
//        {    
//            //Saving of object in a file 
//            FileOutputStream file = new FileOutputStream(filename); 
//            ObjectOutputStream out = new ObjectOutputStream(file); 
//              
//            // Method for serialization of object 
//            out.writeObject(object); 
//              
//            out.close(); 
//            file.close(); 
//              
//            System.out.println("Object has been serialized"); 
//  
//        } 
//          
//        catch(IOException ex) 
//        { 
//            System.out.println("IOException is caught"); 
//        } 
  
//  
        Dem object1 = null; 
  
        // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            object1 = (Dem)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
            System.out.println("a = " + object1.x); 
            System.out.println("b = " + object1.y); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
  
    } 
} 