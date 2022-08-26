import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class GUI extends JFrame implements ActionListener
{
  private JPanel tPanel, cSignup, bSignup, cForYou, cForYou2, cForYou3, cRecc, cRecc2, cRecc3, cTop5, cTop52, cTop53, cRate, cHelp, bSite;

  private JLabel tLbl, userNLbl, passwordLbl, cfrmPass, accErr, fiveRandTtl, randMovieTtl1, randMovieTtl2, randMovieTtl3, randMovieTtl4, randMovieTtl5, fiveForYou,forYouTtl1, forYouTtl2, forYouTtl3, forYouTtl4, forYouTtl5, rand1Label, rand2Label, rand3Label, rand4Label, rand5Label, forYou1Label, forYou2Label, forYou3Label, forYou4Label, forYou5Label, rateTtl, movieListTtl, ratingTtl, helpTtl, top5Lbl, top5MovieTtl1, top5MovieTtl2, top5MovieTtl3, top5MovieTtl4, top5MovieTtl5, top5MoviePic1, top5MoviePic2, top5MoviePic3, top5MoviePic4, top5MoviePic5;

  private JTextArea helpArea; 

  private JButton login, signUp, ok, randRecBtn, forYouBtn, rateBtn, logoutBtn, top5, helpBtn1, ok2;

  private JTextField userNField, passwordField, cfrmPassField;

  private JComboBox movieCombo, rateCombo;

  private Image rand1, rand2, rand3, rand4, rand5, forYou1, forYou2, forYou3, forYou4, forYou5, top51, top52, top53, top54, top55;
  
  private int okCheck, count, count2;

  private String[] movieList = new String[150];

  private String[] movieReccList = new String[5];

  private LoginChecker validater;

  private Filemaker make;

  private UserRate userRater;

  private String userLoginName, newRate, lineX, lineY;

  private ReadFile j = new ReadFile();

  public GUI() throws IOException
  {
    /*------------PANELS/PANES/FRAMES------------*/
    getContentPane().setLayout(new BorderLayout());

    tPanel = new JPanel();
    tPanel.setBackground(Color.decode("#35858B"));

    cSignup = new JPanel(null);
    cSignup.setBackground(Color.decode("#4FBDBA"));

    cForYou = new JPanel();
    cForYou.setBackground(Color.decode("#4FBDBA"));
    cForYou.setLayout(new GridLayout(3, 1, 2, 2));

    cForYou2 = new JPanel();
    cForYou2.setBackground(Color.decode("#4FBDBA"));
    cForYou2.setLayout(new GridLayout(1, 5, 0, 0));

    cForYou3 = new JPanel();
    cForYou3.setBackground(Color.decode("#4FBDBA"));
    cForYou3.setLayout(new GridLayout(1, 5, 0, 0));

    cRecc = new JPanel();
    cRecc.setBackground(Color.decode("#4FBDBA"));
    cRecc.setLayout(new GridLayout(3, 1, 2, 2));

    cRecc2 = new JPanel();
    cRecc2.setBackground(Color.decode("#4FBDBA"));
    cRecc2.setLayout(new GridLayout(1, 5, 0, 0));

    cRecc3 = new JPanel();
    cRecc3.setBackground(Color.decode("#4FBDBA"));
    cRecc3.setLayout(new GridLayout(1, 5, 0, 0));

    cTop5 = new JPanel();
    cTop5.setBackground(Color.decode("#4FBDBA"));
    cTop5.setLayout(new GridLayout(3, 1, 2, 2));

    cTop52 = new JPanel();
    cTop52.setBackground(Color.decode("#4FBDBA"));
    cTop52.setLayout(new GridLayout(1, 5, 0, 0));

    cTop53 = new JPanel();
    cTop53.setBackground(Color.decode("#4FBDBA"));
    cTop53.setLayout(new GridLayout(1, 5, 0, 0));

    cRate = new JPanel(null);
    cRate.setBackground(Color.decode("#4FBDBA"));

    cHelp = new JPanel(null);
    cHelp.setBackground(Color.decode("#4FBDBA"));

    bSignup = new JPanel();
    bSignup.setBackground(Color.decode("#AEFEFF"));

    bSite = new JPanel();
    bSite.setBackground(Color.decode("#AEFEFF"));
    /*------------PANELS/PANES/FRAMES------------*/



    /*------------SIGNUP/LOGIN LABELS------------*/
    tLbl = new JLabel("K²S Movies");
    tLbl.setFont(new Font("Calibri", Font.PLAIN, 40));
    tLbl.setForeground(Color.PINK);

    userNLbl = new JLabel("Login");
    userNLbl.setFont(new Font("Calibri", Font.BOLD, 24));
    userNLbl.setForeground(Color.WHITE);

    passwordLbl = new JLabel("Password");
    passwordLbl.setFont(new Font("Calibri", Font.BOLD, 24));
    passwordLbl.setForeground(Color.WHITE);

    cfrmPass = new JLabel("Confirm Password");
    cfrmPass.setFont(new Font("Calibri", Font.BOLD, 24));
    cfrmPass.setForeground(Color.WHITE);

    accErr = new JLabel();
    accErr.setFont(new Font("Calibri", Font.BOLD, 20));
    accErr.setForeground(Color.BLACK);

    userNField = new JTextField();
    userNField.setFont(new Font("Calibri", Font.PLAIN, 20));

    passwordField = new JTextField();
    passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));

    cfrmPassField = new JTextField();
    cfrmPassField.setFont(new Font("Calibri", Font.PLAIN, 20));

    login = new JButton("Login");
    login.addActionListener(this);
    login.setFont(new Font("Calibri", Font.PLAIN, 25));
    login.setBackground(Color.decode("#6867AC"));

    signUp = new JButton("Sign Up");
    signUp.addActionListener(this);
    signUp.setFont(new Font("Calibri", Font.PLAIN, 25));
    signUp.setBackground(Color.decode("#FF6363"));

    ok = new JButton("Enter");
    ok.addActionListener(this);
    ok.setFont(new Font("Calibri", Font.PLAIN, 25));
    /*------------SIGNUP/LOGIN LABELS------------*/

    /*------------SIGNUP/LOGIN ADDING TO PANEL------------*/
    tPanel.add(tLbl); 
    cSignup.add(userNLbl);
    cSignup.add(userNField);
    cSignup.add(passwordLbl);
    cSignup.add(passwordField);
    cSignup.add(ok);
    cSignup.add(accErr);
    cSignup.add(cfrmPass);
    cSignup.add(cfrmPassField);
    bSignup.add(login);
    bSignup.add(signUp);
    /*------------SIGNUP/LOGIN ADDING TO PANEL------------*/



    /*------------SITE FOOTER LABELS------------*/
    randRecBtn = new JButton("Random Recomendations");
    randRecBtn.addActionListener(this);
    randRecBtn.setFont(new Font("Calibri", Font.PLAIN, 15));

    forYouBtn = new JButton("For You");
    forYouBtn.addActionListener(this);
    forYouBtn.setFont(new Font("Calibri", Font.PLAIN, 15));

    rateBtn = new JButton("Rate");
    rateBtn.addActionListener(this);
    rateBtn.setFont(new Font("Calibri", Font.PLAIN, 15));

    logoutBtn = new JButton("Logout");
    logoutBtn.addActionListener(this);
    logoutBtn.setFont(new Font("Calibri", Font.PLAIN, 15));

    helpBtn1 = new JButton("Help");
    helpBtn1.addActionListener(this);
    helpBtn1.setFont(new Font("Calibri", Font.PLAIN, 15));

    top5 = new JButton("Top 5 Movies");
    top5.addActionListener(this);
    top5.setFont(new Font("Calibri", Font.PLAIN, 15));
    /*------------SITE FOOTER LABELS------------*/

    /*------------SITE FOOTER ADDING TO PANEL------------*/
    bSite.add(forYouBtn);
    bSite.add(top5);
    bSite.add(randRecBtn);
    bSite.add(rateBtn);
    bSite.add(helpBtn1);
    bSite.add(logoutBtn);
    /*------------SITE FOOTER ADDING TO PANEL------------*/



    /*------------RECOMMENDATION LABELS------------*/
    String randomMovies [] = Arrays.copyOf(j.getRandomMovie(),5);

    fiveRandTtl = new JLabel("5 Random Movies");
    fiveRandTtl.setFont(new Font("Calibri", Font.BOLD, 40));
    fiveRandTtl.setForeground(Color.decode("#EF2F88"));
    fiveRandTtl.setHorizontalAlignment(JLabel.CENTER);

    randMovieTtl1 = new JLabel();
    randMovieTtl1.setFont(new Font("Calibri", Font.BOLD, 10));
    randMovieTtl1.setForeground(Color.WHITE);
    randMovieTtl1.setHorizontalAlignment(JLabel.CENTER);
    randMovieTtl1.setVerticalAlignment(JLabel.NORTH);

    randMovieTtl2 = new JLabel();
    randMovieTtl2.setFont(new Font("Calibri", Font.BOLD, 10));
    randMovieTtl2.setForeground(Color.WHITE);
    randMovieTtl2.setHorizontalAlignment(JLabel.CENTER);
    randMovieTtl2.setVerticalAlignment(JLabel.NORTH);

    randMovieTtl3 = new JLabel();
    randMovieTtl3.setFont(new Font("Calibri", Font.BOLD, 10));
    randMovieTtl3.setForeground(Color.WHITE);
    randMovieTtl3.setHorizontalAlignment(JLabel.CENTER);
    randMovieTtl3.setVerticalAlignment(JLabel.NORTH);

    randMovieTtl4 = new JLabel();
    randMovieTtl4.setFont(new Font("Calibri", Font.BOLD, 10));
    randMovieTtl4.setForeground(Color.WHITE);
    randMovieTtl4.setHorizontalAlignment(JLabel.CENTER);
    randMovieTtl4.setVerticalAlignment(JLabel.NORTH);

    randMovieTtl5 = new JLabel();
    randMovieTtl5.setFont(new Font("Calibri", Font.BOLD, 10));
    randMovieTtl5.setForeground(Color.WHITE);
    randMovieTtl5.setHorizontalAlignment(JLabel.CENTER);
    randMovieTtl5.setVerticalAlignment(JLabel.NORTH);

    imgCheckRandom(randomMovies[0],randomMovies[1],randomMovies[2],randomMovies[3],randomMovies[4]);

    rand1Label = new JLabel(new ImageIcon(rand1));

    rand2Label = new JLabel(new ImageIcon(rand2));

    rand3Label = new JLabel(new ImageIcon(rand3));

    rand4Label = new JLabel(new ImageIcon(rand4));

    rand5Label = new JLabel(new ImageIcon(rand5));
    /*------------RANDOM RECOMMENDATION LABELS------------*/

    /*------------RANDOM RECOMMENDATION ADDING TO PANEL------------*/
    cRecc2.add(rand1Label);
    cRecc2.add(rand2Label);
    cRecc2.add(rand3Label);
    cRecc2.add(rand4Label);
    cRecc2.add(rand5Label);

    cRecc3.add(randMovieTtl1);
    cRecc3.add(randMovieTtl2);
    cRecc3.add(randMovieTtl3);
    cRecc3.add(randMovieTtl4);
    cRecc3.add(randMovieTtl5);

    cRecc.add(fiveRandTtl);
    cRecc.add(cRecc2);
    cRecc.add(cRecc3);
    /*------------RECOMMENDATION ADDING TO PANEL------------*/



    /*------------FOR YOU LABELS------------*/

    fiveForYou = new JLabel("Movies Based On Your Taste");
    fiveForYou.setFont(new Font("Calibri", Font.BOLD, 40));
    fiveForYou.setForeground(Color.decode("#EF2F88"));
    fiveForYou.setHorizontalAlignment(JLabel.CENTER);

    forYouTtl1 = new JLabel();
    forYouTtl1.setFont(new Font("Calibri", Font.BOLD, 10));
    forYouTtl1.setForeground(Color.WHITE);
    forYouTtl1.setHorizontalAlignment(JLabel.CENTER);
    forYouTtl1.setVerticalAlignment(JLabel.NORTH);

    forYouTtl2 = new JLabel();
    forYouTtl2.setFont(new Font("Calibri", Font.BOLD, 10));
    forYouTtl2.setForeground(Color.WHITE);
    forYouTtl2.setHorizontalAlignment(JLabel.CENTER);
    forYouTtl2.setVerticalAlignment(JLabel.NORTH);

    forYouTtl3 = new JLabel();
    forYouTtl3.setFont(new Font("Calibri", Font.BOLD, 10));
    forYouTtl3.setForeground(Color.WHITE);
    forYouTtl3.setHorizontalAlignment(JLabel.CENTER);
    forYouTtl3.setVerticalAlignment(JLabel.NORTH);

    forYouTtl4 = new JLabel();
    forYouTtl4.setFont(new Font("Calibri", Font.BOLD, 10));
    forYouTtl4.setForeground(Color.WHITE);
    forYouTtl4.setHorizontalAlignment(JLabel.CENTER);
    forYouTtl4.setVerticalAlignment(JLabel.NORTH);

    forYouTtl5 = new JLabel();
    forYouTtl5.setFont(new Font("Calibri", Font.BOLD, 10));
    forYouTtl5.setForeground(Color.WHITE);
    forYouTtl5.setHorizontalAlignment(JLabel.CENTER);
    forYouTtl5.setVerticalAlignment(JLabel.NORTH);
    /*------------FOR YOU LABELS------------*/

    /*------------FOR YOU ADDING TO PANEL------------*/
    cForYou3.add(forYouTtl1);
    cForYou3.add(forYouTtl2);
    cForYou3.add(forYouTtl3);
    cForYou3.add(forYouTtl4);
    cForYou3.add(forYouTtl5);

    cForYou.add(fiveForYou);
    cForYou.add(cForYou2);
    cForYou.add(cForYou3);
    /*------------FOR YOU ADDING TO PANEL------------*/
    

    
    /*------------TOP 5 LABELS------------*/
    top5Lbl = new JLabel("Top 5 Movies");
    top5Lbl.setFont(new Font("Calibri", Font.BOLD, 40));
    top5Lbl.setForeground(Color.decode("#EF2F88"));
    top5Lbl.setHorizontalAlignment(JLabel.CENTER);

    top5MovieTtl1 = new JLabel();
    top5MovieTtl1.setFont(new Font("Calibri", Font.BOLD, 10));
    top5MovieTtl1.setForeground(Color.WHITE);
    top5MovieTtl1.setHorizontalAlignment(JLabel.CENTER);
    top5MovieTtl1.setVerticalAlignment(JLabel.NORTH);

    top5MovieTtl2 = new JLabel();
    top5MovieTtl2.setFont(new Font("Calibri", Font.BOLD, 10));
    top5MovieTtl2.setForeground(Color.WHITE);
    top5MovieTtl2.setHorizontalAlignment(JLabel.CENTER);
    top5MovieTtl2.setVerticalAlignment(JLabel.NORTH);

    top5MovieTtl3 = new JLabel();
    top5MovieTtl3.setFont(new Font("Calibri", Font.BOLD, 10));
    top5MovieTtl3.setForeground(Color.WHITE);
    top5MovieTtl3.setHorizontalAlignment(JLabel.CENTER);
    top5MovieTtl3.setVerticalAlignment(JLabel.NORTH);

    top5MovieTtl4 = new JLabel();
    top5MovieTtl4.setFont(new Font("Calibri", Font.BOLD, 10));
    top5MovieTtl4.setForeground(Color.WHITE);
    top5MovieTtl4.setHorizontalAlignment(JLabel.CENTER);
    top5MovieTtl4.setVerticalAlignment(JLabel.NORTH);

    top5MovieTtl5 = new JLabel();
    top5MovieTtl5.setFont(new Font("Calibri", Font.BOLD, 10));
    top5MovieTtl5.setForeground(Color.WHITE);
    top5MovieTtl5.setHorizontalAlignment(JLabel.CENTER);
    top5MovieTtl5.setVerticalAlignment(JLabel.NORTH);

    String [] top5Rated = j.getTop5Rated(); 
    
    top5PicMaker(top5Rated[0],top5Rated[1],top5Rated[2],top5Rated[3],top5Rated[4]);

    top5MoviePic1 = new JLabel(new ImageIcon(top51));

    top5MoviePic2 = new JLabel(new ImageIcon(top52));

    top5MoviePic3 = new JLabel(new ImageIcon(top53));

    top5MoviePic4 = new JLabel(new ImageIcon(top54));

    top5MoviePic5 = new JLabel(new ImageIcon(top55));
    /*------------TOP 5 LABELS------------*/

    /*------------TOP 5 ADDING TO PANEL------------*/
    cTop52.add(top5MoviePic1);
    cTop52.add(top5MoviePic2);
    cTop52.add(top5MoviePic3);
    cTop52.add(top5MoviePic4);
    cTop52.add(top5MoviePic5);

    cTop53.add(top5MovieTtl1);
    cTop53.add(top5MovieTtl2);
    cTop53.add(top5MovieTtl3);
    cTop53.add(top5MovieTtl4);
    cTop53.add(top5MovieTtl5);

    cTop5.add(top5Lbl);
    cTop5.add(cTop52);
    cTop5.add(cTop53);
    /*------------TOP 5 TO PANEL------------*/



    /*------------RATE LABELS------------*/
    rateTtl = new JLabel("Rate A Movie");
    rateTtl.setFont(new Font("Calibri", Font.BOLD, 40));
    rateTtl.setForeground(Color.decode("#EF2F88"));

    movieListTtl = new JLabel("Our Movies");
    movieListTtl.setFont(new Font("Calibri", Font.BOLD, 24));
    movieListTtl.setForeground(Color.WHITE);

    ratingTtl = new JLabel("Rate");
    ratingTtl.setFont(new Font("Calibri", Font.BOLD, 24));
    ratingTtl.setForeground(Color.WHITE);

    ok2 = new JButton("Enter");
    ok2.addActionListener(this);
    ok2.setFont(new Font("Calibri", Font.PLAIN, 30));
    
    movieArrMaker();

    movieCombo = new JComboBox(movieList);

    String[] rateList = {"1 - Awful", "2 - Horrible", "3 - Very Bad", "4 - Not Good", "5 - Decent", "6 - Fine", "7 - Good", "8 - Great", "9 - Amazing", "10 - Perfection"};

    rateCombo = new JComboBox(rateList);


    /*------------RATE LABELS------------*/

    /*------------RATE ADDING TO PANEL------------*/ 
    rateTtl.setBounds(220, 50, 500, 50);
    movieListTtl.setBounds(135, 150, 250, 50);
    movieCombo.setBounds(115, 200, 200, 50);
    ratingTtl.setBounds(485, 150, 150, 50);
    rateCombo.setBounds(415, 200, 200, 50);
    ok2.setBounds(285, 300, 150, 50);

    cRate.add(rateTtl);
    cRate.add(movieListTtl);
    cRate.add(ratingTtl);
    cRate.add(movieCombo);
    cRate.add(rateCombo);
    cRate.add(ok2);
    /*------------RATE ADDING TO PANEL------------*/



    /*------------HELP LABELS------------*/
    helpTtl = new JLabel("Help Page");
    helpTtl.setFont(new Font("Calibri", Font.BOLD, 40));
    helpTtl.setForeground(Color.decode("#EF2F88"));

    helpArea = new JTextArea();
    helpArea.setFont(new Font("Calibri", Font.BOLD, 13));
    helpArea.setLineWrap(true);
    helpArea.setText(
      "For You Page - On this page you must rate at least 2 movies before being able to    access this page. Once you have rated 2 moveis, this page will recommend you some movies based on the other user's rated movies." + "\n\n" + "Top 5 Page - This page displays the top 5 highest rated movies on the website by averaging out all of the ratings" + "\n\n" + "5 Random Recomdenations - This page generates 5 randoms movies for the user" +  "\n\n" + "Rate - This page allows the user to rate movies and based on those ratings are recommended movies throught the For You page" + "\n\n"
      );
    helpArea.setBackground(Color.decode("#fff"));
    //#32d1b4
    /*------------HELP LABELS------------*/

    /*------------HELP ADDING TO PANEL------------*/
    helpTtl.setBounds(255, 30, 500, 50);
    helpArea.setBounds(40, 100, 650, 500);

    cHelp.add(helpTtl);
    cHelp.add(helpArea);
    /*------------HELP ADDING TO PANEL------------*/



    /*------------ADDING BACKERS TO PANE------------*/
    getContentPane().add(tPanel, BorderLayout.NORTH);
    getContentPane().add(bSignup, BorderLayout.SOUTH);
    /*------------ADDING BACKERS TO PANE------------*/
  }

  public void actionPerformed (ActionEvent e) 
  {
    userRater = new UserRate(userLoginName); 
    
    if (e.getSource() == login)
    {
      try 
      {
        okCheck = 1;

        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
        getContentPane().add(cSignup, BorderLayout.CENTER);
        getContentPane().add(tPanel, BorderLayout.NORTH);
        getContentPane().add(bSignup, BorderLayout.SOUTH);

        userNLbl.setText("Login");
        passwordLbl.setText("Password");
        ok.setText("Enter");
        userNLbl.setBounds(205, 120, 150, 25);
        userNField.setBounds(405, 120, 150, 25);
        passwordLbl.setBounds(205, 220, 150, 25);
        passwordField.setBounds(405, 220, 150, 25);
        ok.setBounds(290, 300, 150, 35);
        cfrmPass.setVisible(false);
        cfrmPassField.setVisible(false);
        clearFields();
      }
      catch (Exception p)
      {
        System.out.println("Login Menu Could Not Load");
      }
    }


    else if (e.getSource() == signUp)
    {
      okCheck = 2;

      getContentPane().removeAll();
      getContentPane().revalidate();
      getContentPane().repaint();
      getContentPane().add(cSignup, BorderLayout.CENTER);
      getContentPane().add(tPanel, BorderLayout.NORTH);
      getContentPane().add(bSignup, BorderLayout.SOUTH);


      userNLbl.setText("New Login");
      passwordLbl.setText("New Password");
      ok.setText("Join");
      userNLbl.setBounds(160, 70, 150, 25);
      userNField.setBounds(440, 70, 150, 25);
      passwordLbl.setBounds(160, 170, 200, 25);
      passwordField.setBounds(440, 170, 150, 25);
      cfrmPass.setBounds(160, 270, 260, 25);
      cfrmPassField.setBounds(440, 270, 150, 25);
      ok.setBounds(300, 345, 150, 35);
      cfrmPass.setVisible(true);
      cfrmPassField.setVisible(true);
      clearFields();
    }

    else if (e.getSource() == ok)
    {
      validater = new LoginChecker(); 
      if (okCheck == 1)
      {
        if (validater.check((userNField.getText() + " " + passwordField.getText())))
        {
          userLoginName = userNField.getText();
          getContentPane().removeAll();
          getContentPane().revalidate();
          getContentPane().repaint();
          getContentPane().add(cRecc, BorderLayout.CENTER);
          getContentPane().add(tPanel, BorderLayout.NORTH);
          getContentPane().add(bSite, BorderLayout.SOUTH);
        }

        else {
          accErr.setText("Invalid Login, Consider Signing Up");
          accErr.setBounds(175, 350, 500, 25);
        }

      }

      else 
      {
        if (validater.dupeUserCheck(userNField.getText()))
        {
          try
          {
            if (passwordField.getText().equals(cfrmPassField.getText()))
            {
              make = new Filemaker(userNField.getText(), passwordField.getText());
              accErr.setText("Welcome, Now Login!");
              accErr.setBounds(245, 395, 500, 25);
            }

            else 
            {
              accErr.setText("Passwords Do Not Match");
              accErr.setBounds(230, 395, 500, 25);
            }
          }

          catch(Exception i)
          {
            accErr.setText("Error, Could Not Make Account");
            accErr.setBounds(215, 395, 500, 25);
          }
        }

        else
        {
          accErr.setText("This Username Is Already Taken");
          accErr.setBounds(205, 395, 500, 25);
        }   
      }
    }

    else if (e.getSource() == helpBtn1) 
    {
      getContentPane().removeAll();
      getContentPane().revalidate();
      getContentPane().repaint();
      getContentPane().add(cHelp, BorderLayout.CENTER);
      getContentPane().add(tPanel, BorderLayout.NORTH);
      getContentPane().add(bSite, BorderLayout.SOUTH);
    }

    else if (e.getSource() == randRecBtn)
    {
      getContentPane().removeAll();
      getContentPane().revalidate();
      getContentPane().repaint();
      getContentPane().add(cRecc, BorderLayout.CENTER);
      getContentPane().add(tPanel, BorderLayout.NORTH);
      getContentPane().add(bSite, BorderLayout.SOUTH);
    }

    else if (e.getSource() == rateBtn)
    {
      getContentPane().removeAll();
      getContentPane().revalidate();
      getContentPane().repaint();
      getContentPane().add(cRate, BorderLayout.CENTER);
      getContentPane().add(tPanel, BorderLayout.NORTH);
      getContentPane().add(bSite, BorderLayout.SOUTH);
    }

    else if (e.getSource() == forYouBtn)
    {
      try 
      { 
        getContentPane().removeAll();
        getContentPane().revalidate();
        getContentPane().repaint();
        getContentPane().add(cForYou, BorderLayout.CENTER);
        getContentPane().add(tPanel, BorderLayout.NORTH);
        getContentPane().add(bSite, BorderLayout.SOUTH);

        if (checkForTwoRatings(userRater.getUserId()))
        {

          fiveForYou.setFont(new Font("Calibri", Font.BOLD, 40));
          fiveForYou.setText("Movies Based On Your Taste");
          
          //sets arrays with usermovies and userratings
          String [] userMovies = userRater.sendMovies(); 
          int userRatings [] = userRater.sendRatings(); 

          j.setUserThings(userMovies,userRatings); //sets the arrays above to be used in the recommending algorithim 

          j.Recommend(); //calls the recommending algorithim

          String rec5Movies [] = j.getRecMovies(); //gets the movies outputted from the algorithim

          cForYou2.removeAll();

          forYouImages(rec5Movies[0],rec5Movies[1],rec5Movies[2],rec5Movies[3],rec5Movies[4]);

          forYou1Label = new JLabel(new ImageIcon(forYou1));

          forYou2Label = new JLabel(new ImageIcon(forYou2));

          forYou3Label = new JLabel(new ImageIcon(forYou3));

          forYou4Label = new JLabel(new ImageIcon(forYou4));

          forYou5Label = new JLabel(new ImageIcon(forYou5));

          cForYou2.add(forYou1Label);
          cForYou2.add(forYou2Label);
          cForYou2.add(forYou3Label);
          cForYou2.add(forYou4Label);
          cForYou2.add(forYou5Label);
        }

        else
        {
          fiveForYou.setFont(new Font("Calibri", Font.BOLD, 20));
          fiveForYou.setText("Please Rate At Least 2 Movies To Access This Page");
        }


      }
      catch(Exception q)
      {
        q.printStackTrace();
      }
    }    

    else if (e.getSource() == top5)
    {
      getContentPane().removeAll();
      getContentPane().revalidate();
      getContentPane().repaint();
      getContentPane().add(cTop5, BorderLayout.CENTER);
      getContentPane().add(tPanel, BorderLayout.NORTH);
      getContentPane().add(bSite, BorderLayout.SOUTH);
    }

    else if (e.getSource() == logoutBtn)
    {
      getContentPane().removeAll();
      getContentPane().revalidate();
      getContentPane().repaint();
      getContentPane().add(cSignup, BorderLayout.CENTER);
      getContentPane().add(tPanel, BorderLayout.NORTH);
      getContentPane().add(bSignup, BorderLayout.SOUTH);
    }

    else if (e.getSource() == ok2)
    {
      try
      {
        String under1 = ((String)movieCombo.getSelectedItem()).replace(" ", "_");
        sendRating(under1, (String)rateCombo.getSelectedItem());
    
      
      }
      catch(Exception q)
      {
        q.printStackTrace();
      }
    
    }
  }

  public void clearFields() 
  {
    userNField.setText("");
    passwordField.setText("");
    cfrmPassField.setText("");
    accErr.setText("");
  }

  public void paint(Graphics g)
  {
    g.drawImage(rand1, 0, 0, null);
    g.drawImage(rand2, 0, 0, null);
    g.drawImage(rand3, 0, 0, null);
    g.drawImage(rand4, 0, 0, null);
    g.drawImage(rand5, 0, 0, null);
    g.drawImage(forYou1, 0, 0, null);
    g.drawImage(forYou2, 0, 0, null);
    g.drawImage(forYou3, 0, 0, null);
    g.drawImage(forYou4, 0, 0, null);
    g.drawImage(forYou5, 0, 0, null);
  }

  public void movieArrMaker()
  {
    try { 
      BufferedReader lineRead = new BufferedReader(new java.io.FileReader("txtFiles/spacedMovies.txt"));
    
      for(int i = 0; i < 150; i++)
      {
        String line = lineRead.readLine();
        movieList[i] = line;
      }

      lineRead.close();
    }
    catch(Exception h)
    {
      h.printStackTrace();
    }
  }

  public void imgCheckRandom(String film1, String film2, String film3, String film4, String film5)
  { 
    //method gets the movies from the Random movies and displays the correct imgaes based on the title of the movie
    rand1 = new ImageIcon("movieImages/" + film1.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    rand2 = new ImageIcon("movieImages/" + film2.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    rand3 = new ImageIcon("movieImages/" + film3.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);
    
    rand4 = new ImageIcon("movieImages/" + film4.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);  

    rand5 = new ImageIcon("movieImages/" + film5.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);  

    randMovieTtl1.setText(film1.replace("_"," ").toUpperCase());
    randMovieTtl2.setText(film2.replace("_"," ").toUpperCase());
    randMovieTtl3.setText(film3.replace("_"," ").toUpperCase());
    randMovieTtl4.setText(film4.replace("_"," ").toUpperCase());
    randMovieTtl5.setText(film5.replace("_"," ").toUpperCase());
  }

  public void forYouImages(String film1, String film2, String film3, String film4, String film5)
  {
    //method gets the movies from the Recommended movies and displays the correct imgaes based on the title of the movie
    forYou1 = new ImageIcon("movieImages/" + film1.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    forYou2 = new ImageIcon("movieImages/" + film2.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    forYou3 = new ImageIcon("movieImages/" + film3.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    forYou4 = new ImageIcon("movieImages/" + film4.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    forYou5 = new ImageIcon("movieImages/" + film5.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    forYouTtl1.setText(film1.replace("_", " ").toUpperCase());
    forYouTtl2.setText(film2.replace("_", " ").toUpperCase());
    forYouTtl3.setText(film3.replace("_", " ").toUpperCase());
    forYouTtl4.setText(film4.replace("_", " ").toUpperCase());
    forYouTtl5.setText(film5.replace("_", " ").toUpperCase());
  }

  public void top5PicMaker(String film1, String film2, String film3, String film4, String film5)
  { 
    //method gets the movies from the Recommended  and displays the correct imgaes based on the title of the movie
    top51 = new ImageIcon("movieImages/" + film1.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    top52 = new ImageIcon("movieImages/" + film2.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);

    top53 = new ImageIcon("movieImages/" + film3.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);
    
    top54 = new ImageIcon("movieImages/" + film4.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);  

    top55 = new ImageIcon("movieImages/" + film5.toLowerCase() + ".jpg").getImage().getScaledInstance(102, 150,Image.SCALE_SMOOTH);  

    top5MovieTtl1.setText(film1.replace("_"," ").toUpperCase());
    top5MovieTtl2.setText(film2.replace("_"," ").toUpperCase());
    top5MovieTtl3.setText(film3.replace("_"," ").toUpperCase());
    top5MovieTtl4.setText(film4.replace("_"," ").toUpperCase());
    top5MovieTtl5.setText(film5.replace("_"," ").toUpperCase());
  }

  public void sendRating(String movieTitle, String rating)
  {

    String in; 
    
    try
    {
      if (rating.substring(0, 2).equals("10"))
      {
        newRate = "5";
      }
      else
      {
        rating = rating.substring(0, 1);
      }

      switch(rating)
      {
        case "1": 
        newRate = "-5";
        break;
        case "2": 
        newRate = "-4";
        break; 
        case "3":
        newRate = "-3";
        break;
        case "4": 
        newRate = "-2";
        break;
        case "5": 
        newRate = "-1";
        break;
        case "6": 
        newRate = "1";
        break; 
        case "7":
        newRate = "2";
        break;
        case "8": 
        newRate = "3";
        break; 
        case "9":
        newRate = "4";
        break;
      }

      in = userRater.getUserId() + " " + movieTitle + " " + newRate;


      if (isInUserRatings(userRater.getUserId(), movieTitle) == true)
      {
        replaceDupeRating(userRater.getUserId(), movieTitle, newRate);
      }

      else 
      {
        PrintWriter newfile5 = new PrintWriter (new FileWriter("txtFiles/UserRatings.txt",true));
     
        newfile5.println(in);

        newfile5.close();
      }
      
    } 
    catch (IOException e)
    {
      System.out.println("Could Not Write New Rating");
    }
  }

  public boolean isInUserRatings(String userID, String movie)
  {
    try
    {
      BufferedReader readRatings = new BufferedReader(new java.io.FileReader ("txtFiles/UserRatings.txt"));
      
      String read = readRatings.readLine();

      String bits2[] = read.split(" ");

      if(bits2[0].equals(userID) && bits2[1].equals(movie))
      {
        return true;
      }
       
      while (read != null)
      { 
          String bits3[] = read.split(" ");

          if(bits3[0].equals(userID) && bits3[1].equals(movie))
          {
            return true;
          }
          
          read = readRatings.readLine();
       } 
    return false; 

    }
    catch(Exception e)
    {
      e.printStackTrace();  
      return false; 
    } 
  }



  public void replaceDupeRating(String userID, String movie, String rating)
  {
    try 
    {
      LinkedList<String> userRatingsLL = new LinkedList<String>();

      BufferedReader fr2 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt"));

      BufferedReader fr3 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt")); 

      String lineCount = fr2.readLine();

      int count2 = 0;

      int indexOfDupe = 0;

      while(lineCount != null)
      {
        count2++;
        lineCount = fr2.readLine();
      }

      for (int i = 0; i < count2; i++)
      {
        String spotCheck = fr3.readLine();

        userRatingsLL.add(spotCheck);

        String bits4[] = spotCheck.split(" ");

        if (bits4[0].equals(userID) && bits4[1].equals(movie))
        {
          indexOfDupe = i;
        }
      }

      fr2.close();
      fr3.close();

      userRatingsLL.remove(indexOfDupe); 

      userRatingsLL.add(userRater.getUserId() + " " + movie + " " + rating);
      
      PrintWriter writer = new PrintWriter("txtFiles/UserRatings.txt");
      writer.print("");
      writer.close();

      PrintWriter fr6 = new PrintWriter (new FileWriter("txtFiles/UserRatings.txt",true));

      ListIterator<String> Info = userRatingsLL.listIterator(); 
     
      while(Info.hasNext())
      {
        fr6.println(Info.next());
      }

      fr6.close();
    }
    
    catch (Exception w)
    {
      w.printStackTrace();
    }
  }

  public boolean checkForTwoRatings(String userID)
  {
    try 
    { 
      BufferedReader fr4 = new BufferedReader(new java.io.FileReader("txtFiles/UserRatings.txt"));

      String thisLine2 = fr4.readLine();

      int countOfRatings = 0;

      while (thisLine2 != null)
      {
        String [] bits5 = thisLine2.split(" ");

        if (bits5[0].equals(userID))
        {
          countOfRatings++;
        } 

        thisLine2 = fr4.readLine();
      }

      fr4.close();

      if (countOfRatings >= 2)
      {
        return true;
      }

      else
      {
        return false;
      }
    }
    catch(Exception ko)
    {
      ko.printStackTrace();
      return false;
    }
  }

} //end of program