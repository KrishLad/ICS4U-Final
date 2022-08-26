/*
Author: Soham Gherwada
purpose: This file is the algorithm
*/
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Recommending {
  private String[] moviesug; //suggested movie  <= user movie? 
  private String[] Student; //Student list
  private String[] movie; //original movie
  private String[] MovieNam;
  private int[] rating; //User Rating
  private int[] orgrating; // original rating
  private String top5ave[] = new String[5]; 
  private int count = 0;
  private int count1 = 0;
  private double counter = 0.0;
  //private String target, lineCheck, user;
  private String top5[] = new String[5];
  private ArrayList < String > Save = new ArrayList < String > (); //ArrayList to transfer the array of Students that matched with the user the most.

  public void User(String[] moviesug, int[] rating) {
    quickSort(rating, moviesug, 0, rating.length - 1);
    this.moviesug = moviesug;
    this.rating = rating;
  }

  public void data(String[] movie, String[] Student, int[] orgRating, int count1) {
    this.movie = movie;
    this.Student = Student;
    this.orgrating = orgRating;
    this.count1 = count1;
  }
  public void top5(String[] MovieNam, int count) {
    this.MovieNam = MovieNam;
    this.count = count;
  }

  private static void quickSort(int[] array, String[] movie, int start, int end) {

    if (end <= start)
      return; // base case

    int pivot = partition(array, movie, start, end);
    quickSort(array, movie, start, pivot - 1);
    quickSort(array, movie, pivot + 1, end);
  }

  private static int partition(int[] array, String[] movie, int start, int end) {

    int pivot = array[end];
    int i = start - 1;

    for (int j = start; j <= end; j++) {
      if (array[j] < pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        String tem = movie[i];
        movie[i] = movie[j];
        movie[j] = tem;
      }
    }
    i++;
    int temp = array[i];
    array[i] = array[end];
    array[end] = temp;
    String tem = movie[i];
    movie[i] = movie[end];
    movie[end] = tem;
    return i;
  }
  private static void quickSort2(double[] array, String[] movie, int start, int end) {

    if (end <= start)
      return; // base case

    int pivot = partition2(array, movie, start, end);
    quickSort2(array, movie, start, pivot - 1);
    quickSort2(array, movie, pivot + 1, end);
  }

  private static int partition2(double[] array, String[] movie, int start, int end) {

    double pivot = array[end];
    int i = start - 1;

    for (int j = start; j <= end; j++) {
      if (array[j] < pivot) {
        i++;
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        String tem = movie[i];
        movie[i] = movie[j];
        movie[j] = tem;
      }
    }
    i++;
    double temp = array[i];
    array[i] = array[end];
    array[end] = temp;
    String tem = movie[i];
    movie[i] = movie[end];
    movie[end] = tem;
    return i;
  }

  public void rec() {
    // step 0 = find the highest rating
    // step 1 = find the duplicate movies
    // step 2 = find the rating of the movies
    // step 3 = find the match
    top5Movies();
    int rate = rating[rating.length - 1];
    int ratelvl = rating[rating.length - 2];

    String mostlike = moviesug[rating.length - 1];
    String mostlike2 = moviesug[rating.length - 2];

    String[] coun = new String[movie.length];
    for (int i = 0; i < movie.length; i++) {
      for (int k = 0; k < movie.length; k++) {
        if (movie[i].equals(mostlike)) {
          if (movie[k].equals(mostlike2)) {
            if (orgrating[i] == rate || orgrating[i] == rate+1 || orgrating[i] == rate-1) {
              if (orgrating[k] == ratelvl || orgrating[k] == ratelvl+1|| orgrating[k] == ratelvl-1) {
                if (Student[i].equals(Student[k])) {
                  int j = 0;
                  coun[j] = Student[i];
                  Save.add(coun[j]);
                }
              }
            }
          }
        }
      }
    }
    UserRec UR = new UserRec(Save);
    top5 = Arrays.copyOf(UR.getTop5Movies(), 5);

  }

  public String[] getRec5() {
    return top5;
  }

  public String []top5Movies() { //for loop will Take the Movie 1 by one from the MovieNam.txt
    double[] Average = new double[count];
    for (int i = 0; i < count; i++) { //Forloop will take each line from the MovieData
    double a = 0;
      for (int j = 0; j < count1; j++) { //if will compare wach of the MovieNam with the line Movie Data is on
        if (MovieNam[i].equals(movie[j])) {

          counter++;
          a = a + orgrating[j];
        }
      }

      Average[i] = a / counter;
      
      
      counter = 0;
    }
    quickSort2(Average, MovieNam, 0, count - 1);

    
    int y=1; 
    for(int k = 0; k<5;k++){
      top5ave[k] = MovieNam[count - y];
      y++;
    }
    return top5ave;

  }

}