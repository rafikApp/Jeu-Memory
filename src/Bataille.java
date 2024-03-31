/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ak859784
 */
public class Bataille extends Action{
    private Joueur adversaire;

    public Bataille(Joueur sc, Joueur a) {
        super(sc, "Bataille");
        this.adversaire = a;
}
    public Joueur getAdversaire() { return adversaire ; }
    public int execute(){
        int res=-1; // Déclaration est initialisation d'un entier
        Personnage c1,c2; // Déclaration de deux personnages
        LesPersonnages p1 = this.getJ().getPaquet();  // Recuperation du paquet du joueur courant
        LesPersonnages p2 = this.getAdversaire().getPaquet(); // Recuperation du paquet d'adversaire
        if(p1.getTaille()>0 && p2.getTaille()>0){  // Si la taille de chaque paquet est postive
            c1 = p1.getPerso(0);  // recuperation du premier personnage du paquet du joueur 
            c2 = p2.getPerso(0);  // recuperation du premier personnage du paquet d'adversaire
            p1.retirePerso(c1);    // suppression du premier personnage du paquet du joueur 
            p2.retirePerso(c2);  // suppression du premier personnage du paquet d'adversaire
            if(c1.getValeur()==c2.getValeur()){  // si la valeur du premier personnage du paquet du joueur égale celle du premier personnage du paquet d'adversaire
                res=0; // Affectation de 0 a la valeur de res
                // ajout de chaque personnage a son paquet précedent
                p1.ajoutePerso(c1); 
                p2.ajoutePerso(c2);
            }
            else if(c1.getValeur()>c2.getValeur()){  // si la valeur da la premier personnage du paquet du joueur est supérieur a celle du premier personnage du paquet d'adversaire
                res=1; // Affectation de 1 a la valeur de res
                // ajout des deux persnnages au paquet du joueur courant
                p1.ajoutePerso(c1); 
                p1.ajoutePerso(c2);
            }
            else if(c1.getValeur()<c2.getValeur()){   // si la valeur da la premier personnage du paquet du joueur est inférieur a celle du premier personnage du paquet d'adversaire
                res=2; // Affectation de 2 a la valeur de res
                 // ajout des deux persnnages au paquet d'adversaire
                p2.ajoutePerso(c1);
                p2.ajoutePerso(c2);
            }
        }
        if(p1.getTaille()<=0 || p2.getTaille()<=0){ // Si au moin la taille d'un des deux paquet est inférieur ou égal a 0
            String d,s=""; // déclaration de deux variable de type String, la deuxième est vide
            d= "Bataille "+this.getJ().getPseudo()+" contre "+this.getAdversaire().getPseudo(); // initialisation de la chaine de charactére d
            if(p1.getTaille()>0){  // Si la taille du paquet du joueur courant est positive
                  res=1; // Affectation de 1 a la valeur de res
                s+=" gagné \n"; // affectation d'une chaine de charactere a la variable s
            }
            else {
                res=2;  // Affectation de 2 a la valeur de res
                s+=" perdue \n"; // affectation d'une chaine de charactere a la variable s
            }        
        }
        return res; // renvoie de la valeur de res
  }
}
