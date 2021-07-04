package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);
        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");
        setLayout(new GridLayout(2, 1));
        add(donnee);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new myListener());
        boutons.add(add);   add.addActionListener(new myListener());
        boutons.add(sub);   sub.addActionListener(new myListener());
        boutons.add(mul);   mul.addActionListener(new myListener());
        boutons.add(div);   div.addActionListener(new myListener());
        boutons.add(clear); clear.addActionListener(new myListener());
        add(boutons);
        boutons.setBackground(Color.red);
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    
    class myListener implements ActionListener {
    
    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
            if(o == push){
                try{
                    pile.empiler(operande());
                  }
                  catch(NumberFormatException exc){
                      donnee.setText("Il faut que le nombre soit entier");
                    }
                  catch(PilePleineException exc){
                    donnee.setText("Pile pleine!");
                }   
            }
            else if(o == add){
                try{
                    pile.empiler(pile.depiler() + pile.depiler());
                }
                catch(PilePleineException exc){
                    donnee.setText("Pile pleine!");
                }
                catch(PileVideException exc){
                    donnee.setText("Pile pleine!");
                }   
            } 
            else if(o == sub) {
                try{
                    pile.empiler(pile.depiler() - pile.depiler());
                }
                catch(PilePleineException exc){
                    donnee.setText("Pile pleine!");
                }
                catch(PileVideException exc){
                    donnee.setText("Pile pleine!");
                }   
            }
            else if(o == mul) {
                try{
                    pile.empiler(pile.depiler() * pile.depiler());
                }
                catch(PilePleineException exc){
                    donnee.setText("Pile pleine!");
                }
                catch(PileVideException exc){
                    donnee.setText("Pile pleine!");
                }   
            }
            else if(o == div) {
                try{
                    int temp1 = pile.depiler();
                    int temp2 = pile.depiler();
                    if(temp2 == 0){
                        pile.empiler(temp2);
                        pile.empiler(temp1);
                        donnee.setText("Diviser par 0 est impossible");
                    }
                    else pile.empiler(temp1/ temp2);
                }
                catch(PilePleineException exc){
                    donnee.setText("Pile pleine!");
                }
                catch(PileVideException exc){
                    donnee.setText("Pile pleine!");
                }   
            }
            else {
                while(!pile.estVide()){
                   try{
                       pile.depiler();
                    } catch(PileVideException exc){
                    }
                }
            }
        }
    }
}