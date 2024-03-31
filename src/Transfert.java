/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RAFIK
 */
public class Transfert extends Action {
        private Joueur cible;
        private String fp; //famille de la carte sélectionnée
        private LesPersonnages cartesTransferees; // cartes transférées
        
        
        public LesPersonnages getCartesTransferees() {
                return cartesTransferees;
        }
        
        public Joueur getJoueurCible(){
                return this.cible;
        } 
        public Transfert(Joueur sc, Joueur c, String f) {
                super(sc, "Transfert de cartes");
                this.cible = c;
                this.fp=f;
                this.cartesTransferees= new LesPersonnages();
        }
        
        @Override
        public int execute() { 
                int res; // déclaration d'un entier
                if(this.fp!=null){ // si l'attribut fp existe (référence une instance)
                    this.cartesTransferees = this.cible.getPaquet().getPersosFamille(fp);  // récuperation de tous les personnages du paquet de la cible ayant la meme famille
                    this.getJ().getPaquet().ajoutePersos(this.cartesTransferees);  // Ajout de ces personnages au paquet du joueur courant
                    this.setDeroulement(this.getJ().getPseudo()+" a pris la famille de cartes "+this.fp+" de "+this.cible.getPseudo()); // Changer la chaine de charactere de l'attribut deroulement
                }
                if(this.cartesTransferees.getTaille()==0)  // si la taille de l'attribut cartesTransferees est nul 
                    res=0; // Affectation de 0 a la valeur de res
                else // si non 
                    res=this.cartesTransferees.getTaille(); // Affectation de sa taille a la valeur de res
                
                return res; // renvoie de la valeur de la variable res
        }

}
