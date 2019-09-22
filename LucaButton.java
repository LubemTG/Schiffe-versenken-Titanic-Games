import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


class LucaButton extends JButton{
  
  private int a;
  private int b;
  
  public LucaButton(int a, int b) {
    this.a = a;
    this.b = b;  
  }
  public int getA(){
    return a;
  }
  public int getB(){
    return b;
  }
}
