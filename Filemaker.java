/*Author:Soham Gherwada
This class makes a new file and adds a new username and password when you signup
*/

import java.io.*; 

public class Filemaker {
  
  String lastLine, id, returnS, thisSpot;
  
 public Filemaker(String Username, String password) {
   try {
      PrintWriter newfile = new PrintWriter(new FileWriter("txtFiles/login.txt",true));

      PrintWriter newfile2 = new PrintWriter(new FileWriter("txtFiles/UserBase.txt",true));
      
      newfile.println(Username + " " + password);
      newfile2.println(readID() + " " + Username);
      
      newfile.close();
      newfile2.close(); 
   }
   
   catch(Exception e)
   {
     System.out.println("Problem");
   }
  }

  private String readID() 
  {
    try 
    {
      String CurrentLine; 

      BufferedReader fr = new BufferedReader(new java.io.FileReader("txtFiles/UserBase.txt"));
      
      lastLine  = ""; 

      while ((CurrentLine = fr.readLine()) != null)
      {
        lastLine = CurrentLine; 
      }

      fr.close();

      String bits []  = lastLine.split(" "); 
      
      id = bits[0]; 

      int num  = Integer.parseInt(id.substring(7,id.length()));

      num++; 

      returnS = "student" + num; 
       
      return returnS;

    }
    catch (Exception e) 
    {
      e.printStackTrace();
      return returnS; 
    }
  } 

  
}

