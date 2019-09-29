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
  int[][] eA = new int [16][16];
  int[][] gA = new int [15][15];
  
  
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
                if (uboot == 1) {
                   if (u>0) {
                  int a = ((LucaButton) evt.getSource()).getA();
                  int b = ((LucaButton) evt.getSource()).getB();
                  if (w == 1) {
                    if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a-1][b+2] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a][b+2] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+1][b+2] == 0 && b+1<16) {
                      eA[a][b] = 1;
                      eA[a][b+1] = 1;
                      uboot = 0;
                      u--;
                    } // end of if
                  } // end of if
                  else {
                    if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a+2][b+1] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a+2][b] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+2][b+1] == 0 && a+1<16) {
                    eA[a][b] = 1;
                    eA[a+1][b] = 1;
                    uboot = 0;
                    u--;
                      }
                  } // end of if-else
                  vergleicheFelder();
                  
                } 
                } // end of if
            } // end of if
            if (zerstoerer == 1) {
                   if (z>0) {
                      int a = ((LucaButton) evt.getSource()).getA();
                      int b = ((LucaButton) evt.getSource()).getB();
                       if (w == 1) {
                          if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a-1][b+2] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a][b+2] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+1][b+2] == 0 && eA[a-1][b+3] == 0 && eA[a][b+3] == 0 && eA[a+1][b+3] == 0 && b+2<16) {
                             eA[a][b] = 1;
                             eA[a][b+1] = 1;
                             eA[a][b+2] = 1;
                             zerstoerer = 0;
                             z--;
                          }
                       } // end of if
                       else {
                          if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a+2][b-1] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a+2][b] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+2][b+1] == 0 && eA[a+3][b-1] == 0 && eA[a+3][b] == 0 && eA[a+3][b+1] == 0 && a+2<16) {
                             eA[a][b] = 1;
                             eA[a+1][b] = 1;
                             eA[a+2][b] = 1;
                             zerstoerer = 0;
                             z--;
                    }
                  } // end of if-else
                  vergleicheFelder();
                } 
                } // end of if
                if (kreuzer == 1) {
                   if (h>0) {
                      int a = ((LucaButton) evt.getSource()).getA();
                      int b = ((LucaButton) evt.getSource()).getB();
                          if (w == 1) {
                          if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a-1][b+2] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a][b+2] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+1][b+2] == 0 && eA[a-1][b+3] == 0 && eA[a][b+3] == 0 && eA[a+1][b+3] == 0 && eA[a-1][b+4] == 0 && eA[a][b+4] == 0 && eA[a+1][b+4] == 0  && b+3<16) {
                             eA[a][b] = 1;
                             eA[a][b+1] = 1;
                             eA[a][b+2] = 1;
                             eA[a][b+3] = 1;
                             kreuzer = 0;
                             h--;
                             }
                          } // end of if
                          else {
                          if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a+2][b-1] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a+2][b] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+2][b+1] == 0 && eA[a+3][b-1] == 0 && eA[a+3][b] == 0 && eA[a+3][b+1] == 0 && eA[a+4][b-1] == 0 && eA[a+4][b] == 0 && eA[a+4][b+1] == 0 && a+3<16) {
                             eA[a][b] = 1;
                             eA[a+1][b] = 1;
                             eA[a+2][b] = 1;
                             eA[a+3][b] = 1;
                             kreuzer = 0;
                             h--;     
                             }
                          } // end of if-else
                  vergleicheFelder(); 
                } // end of if
            } // end of if
            if (schlachtschiff == 1) {
                   if (r>0) {
                      int a = ((LucaButton) evt.getSource()).getA();
                      int b = ((LucaButton) evt.getSource()).getB();
                          if (w == 1) {
                             if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a-1][b+2] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a][b+2] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+1][b+2] == 0 && eA[a-1][b+3] == 0 && eA[a][b+3] == 0 && eA[a+1][b+3] == 0 && eA[a-1][b+4] == 0 && eA[a][b+4] == 0 && eA[a+1][b+4] == 0  && eA[a-1][b+5] == 0 && eA[a][b+5] == 0 && eA[a+1][b+5] == 0 && b+4<16) {
                             eA[a][b] = 1;
                             eA[a][b+1] = 1;
                             eA[a][b+2] = 1;
                             eA[a][b+3] = 1;
                             eA[a][b+4] = 1;
                             schlachtschiff = 0;
                             r--;
                          } // end of if
                          }
                          else {
                          if (eA[a-1][b-1] == 0 && eA[a-1][b] == 0 && eA[a-1][b+1] == 0 && eA[a+2][b-1] == 0 && eA[a][b-1] == 0 && eA[a][b] == 0 && eA[a][b+1] == 0 && eA[a+2][b] == 0 && eA[a+1][b-1] == 0 && eA[a+1][b] == 0 && eA[a+1][b+1] == 0 && eA[a+2][b+1] == 0 && eA[a+3][b-1] == 0 && eA[a+3][b] == 0 && eA[a+3][b+1] == 0 && eA[a+4][b-1] == 0 && eA[a+4][b] == 0 && eA[a+4][b+1] == 0 && eA[a+5][b-1] == 0 && eA[a+5][b] == 0 && eA[a+5][b+1] == 0 && a+4<16) {
                             eA[a][b] = 1;
                             eA[a+1][b] = 1;
                             eA[a+2][b] = 1;
                             eA[a+3][b] = 1;
                             eA[a+4][b] = 1;
                             schlachtschiff = 0;
                             r--;
                             }
                          } // end of if-else
                  vergleicheFelder(); 
                } // end of if
            } // end of if
            } // end of if 
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
    for (int b = 1; b<15; b++) {
      for (int a = 1; a<15; a++) {
        if (eA[a][b] == 1) {
          buttons[a][b].setIcon(new ImageIcon("schiff.png"));
        } // end of if
      } // end of for
    } // end of for
  }
  int r = 1;   // begrenzt Anzahl
  int schlachtschiff = 0;
  
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
          uboot = 0;
          kreuzer = 0;
          zerstoerer = 0;
          schlachtschiff = 1;
           if (r>0) {
            int r2 =r-1;          
              anzahlSchlachtschiff.setText("Noch "+r2+" Schlachtschiffe übrig.");
           }
        }
      }
    });
    cp.add(schlachtschiffButton);
  }
  
  int h = 2;     // begrenzt Anzahl
  int kreuzer = 0;
  
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
           uboot = 0;
           kreuzer = 1;
           zerstoerer = 0;
           schlachtschiff = 0;
           if (h>0) {
            int h2 = h-1;
              anzahlKreuzer.setText("Noch "+h2+" Kreuzer übrig.");
           }
        }
      }
    });
    cp.add(kreuzerButton);
  }
  
  int z = 3;         // begrenzt Anzahl
  int zerstoerer = 0;
  
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
           uboot = 0;
           kreuzer = 0;
           zerstoerer = 1;
           schlachtschiff = 0;
           if (z>0) {
              int z2 =z-1;
              anzahlZerstoerer.setText("Noch "+z2+" Zerstörer übrig.");
           }
        }
      }
    });
    cp.add(zerstoererButton);
  }
  
  int u = 4;      // begrenzt Anzahl
  int uboot = 0;
  
  public void setzteUBoot(){
    Container cp = getContentPane();
    final JTextField anzahlUBoote = new JTextField();
    anzahlUBoote.setBounds(1120, 930, 200, 40);
    anzahlUBoote.setText("Noch 4 U-Boote übrig.");
    cp.add(anzahlUBoote);
    final JButton ubootButton = new JButton();
    ubootButton.setBounds(1120, 750, 200, 120);
    ubootButton.setText("");
    ubootButton.setMargin(new Insets(2, 2, 2, 2));
    ubootButton.setIcon(new ImageIcon("uboot 2felder transparent.png"));
    ubootButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent ae) { 
        if (ae.getSource() == ubootButton){
          uboot = 1;
          kreuzer = 0;
          zerstoerer = 0;
          schlachtschiff = 0;
           if (u>0 & u!=2) {
             int u2 = u-1;         
             anzahlUBoote.setText("Noch "+u2+" U-Boote übrig.");
           }else{
            if (u>0) {
              int u2 = u-1;
                anzahlUBoote.setText("Noch "+u2+" U-Boot übrig.");  
              }
            } // end of if
        }
      }
    });
    cp.add(ubootButton);
  }
  
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
  
