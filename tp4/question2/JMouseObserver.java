package question2;

import java.awt.event.MouseEvent;
import java.awt.TextArea;
import java.awt.event.MouseListener;

/**
 * Décrivez votre classe JButtonObserver ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class JMouseObserver implements MouseListener { 

    private String nom;
    private TextArea contenu;
    private int X;
    private int Y;

    /**
     * Constructeur d'objets de classe JButtonObserver
     */
    public JMouseObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;

    }

    public void mouseClicked(MouseEvent e) {
    }

    /**
     * affichage d'un message dans la zone de texte ce message est de la forme
     * observateur this.nom : souris entrée en (X,Y) exemple : observateur jmo1
     * : souris entrée en (15,20)
     * 
     * @param
     */
    public void mouseEntered(MouseEvent e) {
        String message = "observateur "+ this.nom +" : souris entr�e en (" + this.X+ ","+ this.Y+ ")";
        contenu.append(message + "\n");
    }

    public void mouseExited(MouseEvent e) {
        this.X=e.getX();
        this.Y=e.getY();
    }

    public void mousePressed(MouseEvent e) {
        this.X=e.getX();
        this.Y=e.getY();
        
    }

    public void mouseReleased(MouseEvent e) {
        this.X=e.getX();
        this.Y=e.getY();
    }

}
