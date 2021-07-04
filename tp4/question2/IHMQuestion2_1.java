package question2;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);
 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); 
        
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();
        
        JButtonObserver jbo1 = new JButtonObserver("jbo1",this.contenu);
        JButtonObserver jbo2 = new JButtonObserver("jbo2",this.contenu);
        JButtonObserver jbo3 = new JButtonObserver("jbo3",this.contenu);
        
        boutonA.addActionListener(jbo3);
        boutonA.addActionListener(jbo2);
        boutonA.addActionListener(jbo1);
        
        
        boutonB.addActionListener(jbo2);
        boutonB.addActionListener(jbo1);
        
        boutonC.addActionListener(jbo1);

      
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
