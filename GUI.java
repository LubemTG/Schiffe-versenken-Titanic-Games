import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.*;


/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 05.09.2019
  * @author
  */
public class GUI extends JFrame {
  // Anfang Attribute
  
  int i, j, k, l;
  int[][] eA = new int [15][15];
  int[][] gA = new int [15][15];
  
  int s = 0;
  
  int a = 0;
  
  int b = 0;
  
  private LucaButton[][] buttons = new LucaButton[15][15];
  
  public GUI(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    int frameWidth = 1500; 
    int frameHeight = 1000;
    setSize(frameWidth, frameHeight);
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int c = (d.width - getSize().width) / 2;
    int e = (d.height - getSize().height) / 2;
    setLocation(c, e);
    setResizable(false);
    
    erstelleEigenesButtonFeld();
    erstelleGegnerischesButtonFeld();
    setVisible(true);
  }
  
  
  
  public void erstelleEigenesButtonFeld(){
    for (int x = 1; x < 15; x++) {
      for (int y = 1; y < 15; y++) {
        int a = x;
        int b = y;
        LucaButton newButton = new LucaButton(a,b);
        Container cp = getContentPane();
        cp.setLayout(null);
        buttons[x][y] = newButton;
        newButton.setBounds((x*40),(y*40),40,40);
        newButton.setContentAreaFilled(true);
        newButton.setText("");
        newButton.setIcon(new ImageIcon("C:\\Users\\Luca\\Documents\\GitHub\\Projeksemester-Schiffe-versenken\\wasser.png"));
        newButton.setMargin(new Insets(2, 2, 2, 2));
        newButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            newButton_ActionPerformed(evt);
            if (evt.getSource() == newButton){
              if (s<30) {
                int a = ((LucaButton) evt.getSource()).getA();
                int b = ((LucaButton) evt.getSource()).getB();
                eA[a][b] = 1;
                s++;
                newButton.setIcon(new ImageIcon("C:\\Users\\Luca\\Documents\\GitHub\\Projeksemester-Schiffe-versenken\\schiff.png"));
              }
              /*if (s==30) {
              for (int b = 1; b<15; b++) {
              for (int a = 1; a<15; a++) {
              if (eA[a][b] == 1) {
              newButton.setIcon(new ImageIcon("C:\\Users\\Luca\\Documents\\GitHub\\Projeksemester-Schiffe-versenken\\schiff.png"));
              } // end of if
              } // end of for
              } // end of for               
              } // end of if
              */
            } // end of if
          }
        });
        cp.add(newButton);
        // Ende Komponenten
      }
    }
  }
  public void erstelleGegnerischesButtonFeld(){
    for (int x=1; x <15;x++) {
      for (int y=1; y <15;y++) {
        int a = x;
        int b = y;
        LucaButton newButton = new LucaButton(a,b);
        Container cp = getContentPane();
        cp.setLayout(null);
        buttons[x][y] = newButton;
        newButton.setBounds((x*40+600),(y*40),40,40);
        newButton.setContentAreaFilled(true);
        newButton.setText("");                                     
        newButton.setMargin(new Insets(2, 2, 2, 2));
        newButton.setIcon(new ImageIcon("C:\\Users\\Luca\\Documents\\GitHub\\Projeksemester-Schiffe-versenken\\nebel.png"));
        newButton.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent evt) { 
            newButton_ActionPerformed(evt);
            if (evt.getSource() == newButton){
              newButton.setIcon(new ImageIcon("C:\\Users\\Luca\\Documents\\GitHub\\Projeksemester-Schiffe-versenken\\wasser.png"));
            }
          }
        });
        cp.add(newButton);
      }
    }
  }
  /* 
  public void vergleicheFelder(){
  int g = 0;
  while (s<30) { 
  System.out.println(g);
  g++;
  } // end of while
  for (int b = 1; b<15; b++) {
  for (int a = 1; a<15; a++) {
  if (eA[a][b] == 1) {
  newButton.setIcon(new ImageIcon("C:\\Users\\Luca\\Documents\\GitHub\\Projektsemester-Schiffe-versenken\\schiff.png"));
  } // end of if
  } // end of for
  } // end of for
  }
  
  int r = ;   // begrenzt Anzahl
  
  public void setzteSchlachstschiff{
  if (get.source ) {         //angesteuerter Button
  if (waagerecht = true) { // Hebel waagerecht oder senkrecht auf waagerecht
  eA[a][b] = 1;
  eA[a+1][b]= 1;
  eA[a+2][b]= 1;
  eA[a+3][b]= 1;
  eA[a+4][b]= 1;
  r--;
  } // end of if
  else {                   // Hebel waagerecht oder senkrecht auf senkrecht
  eA[a][b]= 1;
  eA[a][b+1]= 1;
  eA[a][b+2]= 1;
  eA[a][b+3]= 1;
  eA[a][b+4]= 1;
  r--;
  } // end of if-else
  } // end of if
  }
  
  int k = ;     // begrenzt Anzahl
  
  public void setzteKreuzer{
  if (get.source ) {         //angesteuerter Button
  if (waagerecht = true) { // Hebel waagerecht oder senkrecht auf waagerecht
  eA[a][b] = 1;
  eA[a+1][b]= 1;
  eA[a+2][b]= 1;
  eA[a+3][b]= 1;
  k--;
  } // end of if
  else {                   // Hebel waagerecht oder senkrecht auf senkrecht
  eA[a][b]= 1;
  eA[a][b+1]= 1;
  eA[a][b+2]= 1;
  eA[a][b+3]= 1;
  k--;
  } // end of if-else
  } // end of if
  }
  
  int z = ;         // begrenzt Anzahl
  
  public void setzteZerstoerer{
  if (z<0) {
  if (get.source ) {         //angesteuerter Button 
  if (waagerecht = true) { // Hebel waagerecht oder senkrecht auf waagerecht
  eA[a][b] = 1;
  eA[a+1][b]= 1;
  eA[a+2][b]= 1;
  z--;
  } // end of if
  else {                 // Hebel waagerecht oder senkrecht auf senkrecht
  eA[a][b]= 1;
  eA[a][b+1]= 1;
  eA[a][b+2]= 1;
  z--;
  } // end of if-else
  } // end of if
  }
  }
  
  
  int u = 4;      // begrenzt Anzahl
  
  public void setzteUBoot{
  if (u<0) {
  if (get.source ) {         //angesteuerter Button
  if (waagerecht = true) { // Hebel waagerecht oder senkrecht auf waagerecht
  eA[a][b] = 1;
  eA[a+1][b]= 1;
  eA[a+2][b]= 1;
  u--;
  } // end of if
  else {                    // Hebel waagerecht oder senkrecht auf senkrecht
  eA[a][b]= 1;
  eA[a][b+1]= 1;
  eA[a][b+2]= 1;
  u--;
  } // end of if-else
  } // end of if
  }
  }
  */
  public static void main(String[] args){
    GUI meinGUI= new GUI("Schiffe versenken");
  }
  public void newButton_ActionPerformed(ActionEvent evt) {
  }
}
  