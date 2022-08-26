import java.io.*;
import java.util.Arrays;

/*
  Author: Krishna Lad(File Reading & Writing) & Soham(Sorting& delete)


  The ReadFile class reads the "MovieData.txt" and sorts it. It then writes to a new file called up text. Where all the sorted information is. 
*/

class ReadFile {

  private String lineCheck, line, linecheckMovieNam; //vars  
  int count = 0;
  int count1 = 0;
  private String randMovies [] = new String[5];
  private int randRatings [] = new int [5];
  private Recommending rec = new Recommending();
  private String line1, lineMovie;
  private String [] top5Rated; 
  



  public ReadFile() throws IOException
  {
    delete("SortedMovieData.txt");

    BufferedReader lineReader2 = new BufferedReader(new java.io.FileReader("txtFiles/MovieData.txt")); //linereader for 
    BufferedReader lineRead = new BufferedReader(new java.io.FileReader("txtFiles/MovieData.txt"));
    
   

    lineCheck = lineReader2.readLine();

    while (lineCheck != null) {
      count++;
      lineCheck = lineReader2.readLine();
    }


   
    String[] studentNum = new String[count];
    int[] rating = new int[count];
    String[] movieName = new String[count];

    for (int i = 0; i < count; i++) {

      line = lineRead.readLine();
      String[] bits = line.split(" ");

      studentNum[i] = bits[0];
      movieName[i] = bits[1];
      rating[i] = Integer.parseInt(bits[2]);
    }
    lineRead.close();
    lineReader2.close();
    // sorts file
    quickSort(studentNum, movieName, rating, 0, studentNum.length - 1);
    


    // writes file
    fileWriter(studentNum, movieName, rating, count);
    

    
    for (int i = 0; i < 5; i++)
    {
      int rand = (int)(1 + (Math.random()*count));
    
      randMovies[i] = (movieName[rand]);
      randRatings[i]  = (rating[rand]);
    }

    rec.data(movieName,studentNum,rating,count); 
    readMovieName(); 
    top5Rated = rec.top5Movies();
  }

  
  public void setUserThings(String [] userMovies, int userRatings[])
  {
    //makes an array of the user movies and ratings 
    String [] Movies = userMovies; 
    int [] Ratings = userRatings; 

    rec.User(Movies,Ratings); 
  }

  public void Recommend()
  {
    rec.rec(); 
  }


  public static void fileWriter(String[] studentNum, String[] Movies, int[] rating, int count) {
    try {
      PrintWriter newfile = new PrintWriter(new FileWriter("SortedMovieData.txt")
      );
      
      for (int i = 0; i < count; i++) {
        newfile.println(studentNum[i] + " " + Movies[i] + " " + rating[i]);
        
        
      }
      newfile.close();
    } catch (IOException e) {
      System.out.println("cant make a new file");
    }
  }

  private void quickSort(String[] Username, String[] Movie, int[] rating, int start, int end) {

    if (end <= start)
      return;

    int pivot = partition(Username, Movie, rating, start, end);
    quickSort(Username, Movie, rating, start, pivot - 1);
    quickSort(Username, Movie, rating, pivot + 1, end);
  }

  private int partition(String[] Username, String[] Movie, int[] rating, int start, int end) {
    int i = start - 1;

    for (int j = start; j <= end; j++) {
      if (Username[j].compareTo(Username[end]) < 0) {
        i++;
        String temp = Username[i];
        Username[i] = Username[j];
        Username[j] = temp;
        temp = Movie[i];
        Movie[i] = Movie[j];
        Movie[j] = temp;
        int temper = rating[i];
        rating[i] = rating[j];
        rating[j] = temper;
      }
    }
    i++;
    String temp = Username[i];
    Username[i] = Username[end];
    Username[end] = temp;
    temp = Movie[i];
    Movie[i] = Movie[end];
    Movie[end] = temp;
    int temper = rating[i];
    rating[i] = rating[end];
    rating[end] = temper;

    return i;
  }


  
  public void delete(String file) {
    File delete = new File(file);
    delete.delete();
  }

  public String [] getRecMovies()
  {
    String rec5 [] = Arrays.copyOf(rec.getRec5(),5);
    return rec5;
  }

  public String [] getRandomMovie()
  {
    return randMovies;
  }

  public void readMovieName() 
  {
    try {
     BufferedReader readNam = new BufferedReader(new java.io.FileReader("txtFiles/movieNam.txt"));
    BufferedReader readNam2 = new BufferedReader(new java.io.FileReader("txtFiles/movieNam.txt"));


    lineMovie = readNam.readLine();
    while (lineMovie != null) 
    {
     count1++;
     lineMovie = readNam.readLine();
     
    }
    
    String[] movieNam = new String[count1];
    for (int i = 0; i < count1; i++) 
    {
      line1 = readNam2.readLine();
      String[] Movie = line1.split(" ");
      movieNam[i] = Movie[0];
    }
      readNam.close();
      readNam2.close();
      rec.top5(movieNam,count1);
    }
    catch(Exception q)
    {
      q.printStackTrace();
    }
  }

  public String [] getTop5Rated() 
  {
    return top5Rated;
  }

    

}
