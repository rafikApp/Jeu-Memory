
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class LesJoueurs {  
    private ArrayList<Joueur> lstJ;  // lstJ de type ArrayList qui sere gérer une collection de joueur 
    
    public LesJoueurs(){ // constructeur par défaut qui sere a initialiser le seul att de la classe 
        lstJ = new ArrayList<>();  
    }
    
    public Joueur getJoueur(int i){ // mzthode pour récuperer le joueur d'indice i
        return lstJ.get(i);
    }
    
    public int getIndice(Joueur j){ // methode pour retourner l'indice du jouer passer en paramétre 
        return lstJ.indexOf(j);
    }
    
    public int getNbJoueurs(){ // methode pour retourner le nombre de joueur 
        return lstJ.size();
    }
    
    public void ajouteJoueur(Joueur j){ // methode qui sere a ajouter un jouer a lstJ
        lstJ.add(j);
    }
    
    public Joueur rechJoueur(String p){ // methode qui sere a retourner le joueur dont le pseudo est passer en paramètre 
        Joueur j = new Joueur();  // création d'un joueur 
        for(int i=0;i<lstJ.size();i++)  // le parcour de la collection de joueur  
            if(lstJ.get(i).getPseudo().equals(p)) // comparer les pseudos
                    j=lstJ.get(i);    // récuperer le joueur dont le pseudo passer en paramètre 
            
        return j;    // retourner le joueur 
    }
    
   
    
    public void supprimeJoueur(Joueur j){  // methode pour supprimer le joueur passer en parametre 
        for(int i=0;i<lstJ.size();i++){
            if(lstJ.get(i).getPseudo().equals(j.getPseudo()))
                    lstJ.remove(i);   
   
        }
            
    }
    
     public void supprimeJoueurs(){
         this.lstJ.clear();
     }
    
    public LesJoueurs getGagnants()   
        {
        int max=getJoueur(0).getScore(); // initialiser max par le score du premier joueur 
        for(int i=1; i<getNbJoueurs();i++) // le parcour de la liste 
            if (getJoueur(i).getScore()>max) // si le score du joueur d'indice i est supèrieure a max 
                max=this.getJoueur(i).getScore(); // on affecte le score de ce joueur a max 
        LesJoueurs lst=new LesJoueurs(); // création d'une nouvelle liste 
        for(int i=0; i<getNbJoueurs();i++) // le parcour de la liste
            if (getJoueur(i).getScore()==max) // si le score du joueur d'indice i égale a max 
                lst.ajouteJoueur(getJoueur(i)); // on ajoute ce joueur a la liste lst 
        return lst; // retourner cette liste 
        }
    
    public String toString(){
        String s="";
        for(int i=0;i<this.lstJ.size();i++){
            s+=this.lstJ.get(i).toString();
        }
        return s;
    }
    
}
