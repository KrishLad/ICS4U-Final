/*
  Author: Krishna Lad
  Date: January 18th 2022
  Descrption: This class's contructor takes in the usernames the person entered and retrives the userID specifced with it. The sendMovies() and sendRating()
*/
import java.io.*;
import java.util.Arrays; 

class UserRate{

  private String userID, username, movieName, rating, lineC, lineB, newRate, lineZ, lineX,lineY,lineW;
  private int count,count2,count3, count4, count5, count6, count7;  

  // Takes ur usename and retrieves your userID
  public UserRate(String username)
  {
    try{ 
      BufferedReader fr = new BufferedReader(new java.io.FileReader("txtFiles/UserBase.txt"));

      count = 0;
     
      lineC = fr.readLine(); 

      while (lineC != null)
      {
        count++;
        lineC = fr.readLine();
      }

      fr.close();

      BufferedReader fr2 = new BufferedReader(new java.io.FileReader("txtFiles/UserBase.txt"));

      for (int i = 0; i < count; i++)
      {
        lineB  = fr2.readLine(); 
        String bits[] = lineB.split(" ");

        if (bits[1].equals(username))
        {
          this.userID = bits[0];
        }
      }

      fr2.close();
    }
    
    catch(Exception h)
    {
      h.printStackTrace(); 
    }
  }

  public String[] sendMovies() throws IOException
  {
    BufferedReader fr3 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt"));

    BufferedReader fr4 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt"));

    lineZ = fr3.readLine(); 
    
    while(lineZ != null)
    {
      count2++;

      String bits2[] = lineZ.split(" ");

      if (bits2[0].equals(userID))
      {
        count4++;
      }

      lineZ = fr3.readLine();
    }

    String movieList[] = new String[count4];

    for (int i = 0; i < count2; i++)
    {
      lineX = fr4.readLine();
      String bits [] = lineX.split(" ");

      if (bits[0].equals(userID))
      {
        movieList[count6] = bits[1]; 
        count6++;
      }
    }
    fr3.close();
    fr4.close();
    return movieList;  
  } 

   public int[] sendRatings() throws IOException
  {
    BufferedReader fr5 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt"));

    BufferedReader fr6 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt"));

    lineY = fr5.readLine(); 
    
    while(lineY != null)
    {
      count3++;

      String bits3[] = lineY.split(" ");

      if (bits3[0].equals(userID))
      {
        count5++;
      }

      lineY = fr5.readLine();
    }

    int ratingList [] = new int[count5];

    for (int i = 0; i < count3; i++)
    {
    
      lineW = fr6.readLine();
      String bits [] = lineW.split(" ");

      if (bits[0].equals(userID)) 
      {
        ratingList[count7] = Integer.parseInt(bits[2]);
        count7++;
      }
    }
    fr5.close();
    fr6.close();
    return ratingList;  
  } 

  public String getUserId() 
  {
    return userID; 
  }
}