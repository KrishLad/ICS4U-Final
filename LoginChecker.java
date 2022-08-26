/*
  Authors: Krishna Lad & Khyle Sewpersaud

  This class looks through the "login.txt" and checks if the username exits within the database of the program.

*/


import java.io.*;

class LoginChecker{

 private String thisSpot, lineC, lineB;
 int count = 0;

  public boolean check(String info) {

    try
    {
      BufferedReader fr = new BufferedReader(new java.io.FileReader("txtFiles/login.txt"));
      
      thisSpot = fr.readLine();

      if (thisSpot.equals(info))
      {
        return true;
      }
      
      while (!thisSpot.equals(info))
      {
        thisSpot = fr.readLine();

        if (thisSpot.equals(info))
        {
          //fr.close();
          return true;
        }
      }
      //fr.close();
      return false;
    }
    catch (Exception z)
    {
      return false;
    }
  }

  public boolean dupeUserCheck(String username)
  {
    try
    { 
      BufferedReader fr2 = new BufferedReader(new java.io.FileReader("txtFiles/login.txt"));
     
      lineC = fr2.readLine(); 

      while (lineC != null)
      {
        count++;
        lineC = fr2.readLine();
      }

      fr2.close();

      BufferedReader fr3 = new BufferedReader(new java.io.FileReader("txtFiles/login.txt"));

      for (int i = 0; i < count; i++)
      {
        lineB  = fr3.readLine(); 
        String bits[] = lineB.split(" ");

        if (bits[0].equals(username))
        {
          fr3.close();
          return false;
        }
      }
      fr3.close();   

      return true;
    }catch(Exception h)
    {
      h.printStackTrace(); 
      return true; 
    }
  }


}