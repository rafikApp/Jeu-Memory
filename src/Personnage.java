
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class Personnage {
    private String famille,nom;  // des attributs qui serent a stocker la famille et le nom du personnage 
    private int valeur; // attribut qui sert a stocker la valeur du personnage 
    private Image photo; // attribut qui sert a stocker la photo du pers
    
    

    public Personnage(String famille, String nom, int valeur) {  // constructeur standard qui sert a initialiser les attributs de la classe par des valeurs données
        this.famille = famille;
        this.nom = nom;
        this.valeur = valeur;
        this.photo = new ImageIcon(getClass().getResource("/img/"+this.nom+".jpg")).getImage();
    }

    public Personnage() { // constructeur par défaut qui sert a initialiser les attributs de la classe par des valeurs prédefinies 
        this.famille = "anonyme";
        this.nom = "anonyme";
        this.valeur = 0;
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();
    }

    public String getFamille() { // accesseur de lecture de la famille 
        return famille;
    }

    public String getNom() { // accesseur de lecture du Nom
        return nom;
    }

    public int getValeur() { // accesseur de lecture de la valeur
        return valeur;
    }
    
    public Image getPhoto(){ // accesseur de lecture de la photo  
        return this.photo;
    }

    public void setFamille(String famille) { // accesseur d'écriture de la famille 
        this.famille = famille;
    }

    public void setNom(String nom) {  // accesseur d'écriture du Nom
        this.nom = nom;
    }

    public void setValeur(int valeur) {  // accesseur d'écriture de la valeur
        this.valeur = valeur;
    }
    
    public String toString(){ // redifinition de la methode toString pour afficher les informations du personnage 
        String res = this.nom+" de la famille "+this.famille+", valeur: "+this.valeur;
        return res;
        
    }
    public void setImgBouton(JButton jb){  // methode pour redimensionner une photo en se basent aux dimensions d'un bouton passer en paramètre 
        Image img = photo.getScaledInstance(jb.getWidth(),jb.getHeight(),Image.SCALE_SMOOTH); // redimensionner la photo du personnage 
        jb.setIcon(new ImageIcon(img)); // changer l'icone du bouton 
    }
    
    
    
    
    
    
    
    
}
