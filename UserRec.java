/*
  Author: Krishna Lad
  Date: January 13th 2022
  
  Description: This class takes an ArrayList from "Recommending.java" and selects a random user from list. Then using that random user it locates their top 5 most liked movies and stores it in an array. it then returns. 

 
*/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

class UserRec {
    private int counter, count; //two count variables for differetn arrays 
    private String checkLines, lines,user; //line checker for the for line chekcer
    private String[] top5 = new String[5]; //array to store top 5 movies

    UserRec(ArrayList < String > userList) { //main contructor

        try {
          user = selectRandomUser(userList); //selects random user from the arraylist
          lookThroughMovies(user); //looks through movies and sets top 5
        } catch (Exception e) {
          e.printStackTrace();
        }


    }

    private String selectRandomUser(ArrayList < String > userList) { //method takes in arraylist and randomly selcts user from list
      String user;
      int dex = 0; //index of the user 
      for (int i = 0; i < userList.size(); i++) //loops through array
        {
          dex = (int)(Math.random() * userList.size()); //picks random index
        }

      user = userList.get(dex); //selcts user based on the random index

      return user;

    }

    private void lookThroughMovies(String user) { //method look through the movie data and look for the user then selcts their 
        try {
            //two line readers
            BufferedReader lineReader = new BufferedReader(new java.io.FileReader("txtFiles/MovieData.txt"));
            BufferedReader lineReader2 = new BufferedReader(new java.io.FileReader("txtFiles/MovieData.txt"));


            //this one checks the lines of the whole moviedata
            checkLines = lineReader.readLine();

            while (checkLines != null) //scan until the line is blank
            {
                checkLines = lineReader.readLine();
                counter++; //size of the first array
            }

            //first arrays store all the studetn numbers, movies, and scores
            String[] StudentNum = new String[counter];
            String[] MovieName = new String[counter];
            int[] Score = new int[counter];


            for (int i = 0; i < counter; i++) //loop that does that
            {
                lines = lineReader2.readLine();
                String[] bits = lines.split(" ");


                if (bits[0].equals(user)) //if the student in texfile = user
                {
                    count++;
                } //size of the second arrays

                StudentNum[i] = bits[0];
                MovieName[i] = bits[1];
                Score[i] = Integer.parseInt(bits[2]);
            }

            //second arrays store the values of the movies, scores, and StudentNum of the traget studetn 
            String[] targetStudentNum = new String[count]; // <= need for sorting 
            String[] targetMovieName = new String[count];
            int[] targetScore = new int[count];

            int y = 0; //variable that increases per iteration
            for (int j = 0; j < counter; j++) {
                if (StudentNum[j].equals(user)) { //if the student number in MovieData is the student number of the person selcetd then fill the target student arrays
                    targetStudentNum[y] = StudentNum[j];
                    targetMovieName[y] = MovieName[j];
                    targetScore[y] = Score[j];
                    y++; 
                }
            }

            quickSort(targetStudentNum, targetMovieName, targetScore, 0, count - 1); //sorts it
            
            fillTop5(targetMovieName, targetMovieName.length - 1); //fills an array


          
        } catch (Exception e) {
                e.printStackTrace();
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
        int count = 0;
        int i = start - 1;
        int piviot = rating[end];

        for (int j = start; j <= end; j++) {
            if (rating[j] < piviot) {
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


    private void fillTop5(String[] Movies, int size) { //fills the array we are going to send out
        for (int i = 0; i < 5; i++) {
            top5[i] = Movies[size - i];
        }
    }


    public String[] getTop5Movies() {
      return top5; //getter that sends out the top5 Recommended movies
    }
    
}