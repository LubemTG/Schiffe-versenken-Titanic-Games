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
public class GUITest extends JFrame {
  // Anfang Attribute
  
  int [][] eA = new int [13][13];
  
  int [][] gA = new int [13][13];
  
  
  private LucaButton[][] buttons = new LucaButton[14][14];
  public GUITest(String title) {
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
    for (int x=1; x <14;x++) {
      for (int y=1; y <14;y++) {
        int a = x;
        int b = y;
        LucaButton newButton = new LucaButton(a,b);
        Container cp = getContentPane();
        cp.setLayout(null);
        buttons[x][y] = newButton;
        newButton.setBounds((x*40),(y*40),40,40);
        newButton.setContentAreaFilled(true);
        newButton.setText("");
        newButton.setIcon(new ImageIcon("G:\\Info\\Schiffe versenken\\neusteVersion\\wasser.png"));
        newButton.setMargin(new Insets(2, 2, 2, 2));
        newButton.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent evt) { 
            newButton_ActionPerformed(evt);
            if (evt.getSource() == newButton){
              newButton.setIcon(new ImageIcon("G:\\Info\\Schiffe versenken\\neusteVersion\\schiff.png"));
            }
          }
        });
        cp.add(newButton);
        // Ende Komponenten
      }
    }
  }
  public void erstelleGegnerischesButtonFeld(){
    for (int x=1; x <14;x++) {
      for (int y=1; y <14;y++) {
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
        newButton.setIcon(new ImageIcon("G:\\Info\\Schiffe versenken\\neusteVersion\\nebel.png"));
        newButton.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent evt) { 
            newButton_ActionPerformed(evt);
            if (evt.getSource() == newButton){
              newButton.setIcon(new ImageIcon("G:\\Info\\Schiffe versenken\\neusteVersion\\wasser.png"));
            }
          }
        });
        cp.add(newButton);
      }
    }
  }
  
  public static void main(String[] args){
    GUITest meinGUITest= new GUITest("Schiffe versenken");
    
  }
  public void newButton_ActionPerformed(ActionEvent evt) {
    //evt.setIcon(new ImageIcon("C:\\Users\\clara\\Desktop\\achim\\wasser"));
    /*for (int s = 0; s<30; s++) {
    int a = ((LucaButton) evt.getSource()).getA();
    int b = ((LucaButton) evt.getSource()).getB();
    eA[a][b] = 1;
    if ((LucaButton) evt.getSource() == newButton){
    newButton.setIcon(new ImageIcon("C:\\Users\\clara\\Desktop\\achim\\schiff.png")); 
    }
    } // end of for */
  } 
  
  /*public void platziereSchiffe(){
  for (int s=0;s<10;s++) {
  int x = 0;
  int y = 0;
  System.out.println("x-Koordinate des Schiffes: ");
  x = scan.nextInt();
  System.out.println("y-Koordinate des Schiffes: ");
  y = scan.nextInt();
  feld [x][y] = 1 ;
  } // end of for
  }
  */
}



/* 
public void erstelleEigenesArray(){
  int [][] eigenesArray = new int [13][13];
  }
  
public void platziereSchiffe(){
  for (int s=0;s<30 ;s++ ) {
      System.out.println("x-Koordinate des Schiffes: ");
      x = scan.nextInt() ;
      System.out.println("y-Koordinate des Schiffes: ");
      y = scan.nextInt() ;
      feld [x][y] = 1 ;
    } // end of for
*/   


 


     



















