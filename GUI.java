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
  private LucaButton[][] gegnerbuttons = new LucaButton[15][15];
  
  public GUI(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    int frameWidth = 1680; 
    int frameHeight = 1050;
    setSize(frameWidth, frameHeight);
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int c = (d.width - getSize().width) / 2;
    int e = (d.height - getSize().height) / 2;
    setLocation(c, e);
    setResizable(false);
    
    erstelleEigenesButtonFeld();
    erstelleGegnerischesButtonFeld();
    setzteSchlachtschiff();
    setzteKreuzer();
    setzteZerstoerer();
    setzteUBoot();
    ausrichtung();
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
        newButton.setIcon(new ImageIcon("Wasser-Icon.png"));
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
        gegnerbuttons[x][y] = newButton;
        newButton.setBounds((x*40+600),(y*40),40,40);
        newButton.setContentAreaFilled(true);
        newButton.setText("");                                     
        newButton.setMargin(new Insets(2, 2, 2, 2));
        newButton.setIcon(new ImageIcon("nebel.png"));
        newButton.addActionListener(new ActionListener() { 
          public void actionPerformed(ActionEvent evt) { 
            newButton_ActionPerformed(evt);
            if (evt.getSource() == newButton){
              newButton.setIcon(new ImageIcon("Wasser-Icon.png"));
            }
          }
        });
        cp.add(newButton);
      }
    }
  }
  
  public void vergleicheFelder(){
    while (s<30) {
    } // end of while
    for (int b = 1; b<15; b++) {
      for (int a = 1; a<15; a++) {
        if (eA[a][b] == 1) {
          buttons[a][b].setIcon(new ImageIcon("schiff.png"));
        } // end of if
      } // end of for
    } // end of for
  }
  int r = 1;   // begrenzt Anzahl
  
  public void setzteSchlachtschiff(){
    Container cp = getContentPane();
    final JTextField anzahlSchlachtschiff = new JTextField();
    anzahlSchlachtschiff.setBounds(50, 930, 200, 40);
    anzahlSchlachtschiff.setText("Noch "+r+" Schlachtschiff übrig.");
    cp.add(anzahlSchlachtschiff);
    final JButton schlachtschiffButton = new JButton();
    schlachtschiffButton.setBounds(50, 700, 390, 220);
    schlachtschiffButton.setText("");
    schlachtschiffButton.setMargin(new Insets(2, 2, 2, 2));
    schlachtschiffButton.setIcon(new ImageIcon("schlachtschiff 5felder transparent.png"));
    schlachtschiffButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        if (ae.getSource() == schlachtschiffButton){
           if (r>0) {          
              r--;
              anzahlSchlachtschiff.setText("Noch "+r+" Schlachtschiffe übrig.");
           }
        }
      }
    });
    cp.add(schlachtschiffButton);
  }
  /*
  if (evt.getSource() == buttons){
  if (s<30) {
  int a = ((buttons) evt.getSource()).getA();
  int b = ((buttons) evt.getSource()).getB();
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
  }
  } // end of if
  */
  
  int h = 2;     // begrenzt Anzahl
  
  public void setzteKreuzer(){
    Container cp = getContentPane();
    final JTextField anzahlKreuzer = new JTextField();
    anzahlKreuzer.setBounds(490, 930, 200, 40);
    anzahlKreuzer.setText("Noch "+h+" Kreuzer übrig.");
    cp.add(anzahlKreuzer);
    final JButton kreuzerButton = new JButton();
    kreuzerButton.setBounds(490, 710, 300, 200);
    kreuzerButton.setText("");
    kreuzerButton.setMargin(new Insets(2, 2, 2, 2));
    kreuzerButton.setIcon(new ImageIcon("kreuzer 4felder transparent.png"));
    kreuzerButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        if (ae.getSource() == kreuzerButton){
           if (h>0) {
              h--;
              anzahlKreuzer.setText("Noch "+h+" Kreuzer übrig.");
           }
        }
      }
    });
    cp.add(kreuzerButton);
  }
  /*
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
  */
  int z = 3;         // begrenzt Anzahl
  
  public void setzteZerstoerer(){
    Container cp = getContentPane();
    final JTextField anzahlZerstoerer = new JTextField();
    anzahlZerstoerer.setBounds(840, 930, 200, 40);
    anzahlZerstoerer.setText("Noch "+z+" Zerstörer übrig.");
    cp.add(anzahlZerstoerer);
    final JButton zerstoererButton = new JButton();
    zerstoererButton.setBounds(840, 730, 230, 160);
    zerstoererButton.setText("");
    zerstoererButton.setMargin(new Insets(2, 2, 2, 2));
    zerstoererButton.setIcon(new ImageIcon("zerstörer 3felder transparent.png"));
    zerstoererButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        if (ae.getSource() == zerstoererButton){
           if (z>0) {
              z--;
              anzahlZerstoerer.setText("Noch "+z+" Zerstörer übrig.");
           }
        }
      }
    });
    cp.add(zerstoererButton);
  }
  /*
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
  */
  
  int u = 4;      // begrenzt Anzahl
  
  public void setzteUBoot(){
    Container cp = getContentPane();
    final JTextField anzahlUBoote = new JTextField();
    anzahlUBoote.setBounds(1120, 930, 200, 40);
    anzahlUBoote.setText("Noch "+u+" U-Boote übrig.");
    cp.add(anzahlUBoote);
    final JButton ubootButton = new JButton();
    ubootButton.setBounds(1120, 750, 200, 120);
    ubootButton.setText("");
    ubootButton.setMargin(new Insets(2, 2, 2, 2));
    ubootButton.setIcon(new ImageIcon("uboot 2felder transparent.png"));
    ubootButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        if (ae.getSource() == ubootButton){
           if (u>0 & u!=2) {          
              u--;
              anzahlUBoote.setText("Noch "+u+" U-Boote übrig.");
           }else{
                u--;
                anzahlUBoote.setText("Noch "+u+" U-Boot übrig.");  
              }
        }
      }
    });
    cp.add(ubootButton);
  }
  /*if (u<0) {
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
  
   int w=0;
  
    
  public void ausrichtung(){
     Container cp = getContentPane();
    final JButton ausrichtungButton = new JButton();
    ausrichtungButton.setBounds(50, 630, 100, 40);
    ausrichtungButton.setText("waagerecht");
    ausrichtungButton.setMargin(new Insets(2, 2, 2, 2));
    ausrichtungButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        if (ae.getSource() == ausrichtungButton){
          
          if (w==1) {                                      //w=1  => waagerecht
            ausrichtungButton.setText("waagerecht");
            w=0;
          } // end of if
          else {
            ausrichtungButton.setText("senkrecht");
            w=1;
          } // end of if-else
        }
      }
    });
    cp.add(ausrichtungButton);
  }
    
  public static void main(String[] args){
    GUI meinGUI= new GUI("Schiffe versenken");
    meinGUI.vergleicheFelder();
  }
  public void newButton_ActionPerformed(ActionEvent evt) {
  }
}
  
