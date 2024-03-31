/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class PlateauJeu {
    private int tab[][]; // declaer un tableau bidimensionnel de type int 
    private int nbp; // declarer variable nbp pour stocker nombre de personnage
    private int nblig;// declarer variable nbp pour stocker nombre de ligne
    private int nbcol;// declarer variable nbp pour stocker nombre de cologne
    
    public PlateauJeu(int n){ // constructeur standard qui sert a initialiser les attributs de la classe par des valeurs données
        this.nbp=n;
        this.nblig=(int)(Math.sqrt(nbp*2));
        this.nbcol=nbp*2/nblig;
        this.tab= new int[this.nblig][this.nbcol];
        initPlateauJeu(); //appel de la fonction initPlateau pour l'initialiser
    }
    
    public PlateauJeu(){// constructeur par défaut qui sert a initialiser les attributs de la classe par des valeurs prédefinies 
        this(4); // appel du constructeur standard
    }
    
    public int getNblig(){
        return this.nblig; //recuperer le nombre de ligne  
    }
    
    public int getNbcol(){
        return this.nbcol; // recupere le nombre de cologne
    }
    
    public int getNbp(){
        return this.nbp; //recuperer le nombre de personnage
    }
    
    public int getCase(int l,int c){
        return tab[l][c]; //recupere contenue de la case des indices passer en parametre
    }
    
    public int getNbc(){
        return this.nblig*nbcol/2; //recuperer le nombre de carte
        
    }
    
    public void initPlateauJeu(){ //initialiser le tableau
        int k=0;
        for(int i=0;i<this.nblig;i++)
            for(int j=0;j<this.nbcol;j++)
                tab[i][j]=(k++)%this.nbp;
        melange(); //apller la methode melanger
    }
    
    
    public void invalide(int l1, int c1, int l2, int c2){ //methode qui rent les cellules invalides
        tab[l1][c1] = -1;
        tab[l2][c2] = -1;
        nbp--; //decrenter le nombre de personnage
        
    }
    
    
    public void melange(){ //methode qui melanger les cases du tableau
        for(int i=1;i<=1000;i++){
            int l1 = (int)(Math.random()*nblig); 
            int l2 = (int)(Math.random()*nblig);
            int c1 = (int)(Math.random()*nbcol);
            int c2 = (int)(Math.random()*nbcol);
            int temp = tab[l1][c1];
            tab[l1][c1] = tab[l2][c2];
            tab[l2][c2] = temp;
        }
    }
    
    public void termineJeu(){ //methode qui invalide tous les cases du tableau
        for(int l=0;l<nblig;l++)
            for(int c=0;c<nbcol;c++)
                tab[l][c] = -1;
        nbp=0; //rendre le nombre de personnage 0
    }
    
    public boolean estValide(int l,int c){//methode qui test si une case est valide ou non
        if(tab[l][c]==-1)
            return false;
        else 
            return true;
    }
    
    public boolean jeuVide(){ //methode qui teste si tout les cesses du tableau son invalide ou non
        return nbp<=0;          
    }
}
