
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class Joueur {
    private String pseudo;  // pseudo du joueur 
    private String nmfamille; // famille du joueur 
    private LesPersonnages paquet; // paquet de type les personnages sere stocker les personnages gagnées par le joueur 
    private ImageIcon photo; // la photo du joueur 
 
    public String getPseudo() { // accesseur de lecture du pseudo 
        return pseudo;
    }
   public String getFamillepré(){ // accesseur de lecture de la famille 
       return this.nmfamille;
   }
    public int getScore(){ // accesseur de lecture du score
        return paquet.getScore();
    }
    public LesPersonnages getPaquet(){ // accesseur de lecture du paquet
        return this.paquet;
    }
    public ImageIcon getImage(){ // accesseur de lecture de la photo 
        return this.photo;
    }

    public void setPseudo(String pseudo) {   // accesseur d'écriture  du pseudo
        this.pseudo = pseudo;
    }

    public void setNmfamille(String nmfamille) { // accesseur d'écriture  de la famille
        this.nmfamille = nmfamille;
    }

    public void setPaquet(LesPersonnages paquet) {  // accesseur d'écriture  du paquet
        this.paquet = paquet;
    }

    public void setPhoto(ImageIcon photo) {   // accesseur d'écriture  du photo 
        this.photo = photo;
    }
    
    public Joueur(){  // constructeur par défaut qui sert a initialiser les attributs de la classe par des valeurs prédefinies 
        this.pseudo="";
        this.nmfamille="";
        paquet=new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.png"));
    }
    public Joueur(String p,String fmp){   // constructeur standard qui sert a initialiser les attributs de la classe par des valeurs données
        this.pseudo=p;
        this.nmfamille=fmp;
        paquet=new LesPersonnages();
 
    }
    public String toString(){ // redifinition de la méthode toString afin d'afficher les informations du joueur 
         String res = " \n pseudo: "+this.pseudo+" \n la famille préferée : "+this.nmfamille+" \n personnages : "+paquet.toString();
        return res;

    }
    
    public void ajoutePersoPaquet(Personnage p) { // methode qui sere ajouter un nouveau personnage au paquet du joueur 
            this.paquet.ajoutePerso(p);
    }
    
    public void initPaquetTest(){ // methode qui sere initialiser le paquet par des oersonnages afin de tester 
            ajoutePersoPaquet(new Personnage("communs", "assault-trooper", 10));
            ajoutePersoPaquet(new Personnage("communs", "commando", 20));
            ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
            /*ajoutePersoPaquet(new Personnage("communs", "burnout", 20));
            ajoutePersoPaquet(new Personnage("rares", "dazzle", 10));
            ajoutePersoPaquet(new Personnage("communs", "mozart", 20));
            ajoutePersoPaquet(new Personnage("rares", "brawler", 10));
            ajoutePersoPaquet(new Personnage("communs", "raptor", 20));
            ajoutePersoPaquet(new Personnage("rares", "raven", 10));*/    
    }
    
    public int getNbCartes(){
        return this.paquet.getTaille();
    }
    
    
    
}
