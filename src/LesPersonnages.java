
import java.util.ArrayList;

public class LesPersonnages{
    
    private ArrayList<Personnage> persos; //attribut perso de type arrayList qui sert a gere "personnage"

    public ArrayList<Personnage> getPersos() { //accesseur en lecure du attribut de la classe
        return persos;
    }
    
    public LesPersonnages() {
      this.persos = new ArrayList<Personnage>();// constructeur par défaut qui sert a initialiser les attributs de la classe par des valeurs prédefinies 
     }
         
     public int getTaille() { 
         return this.persos.size();  //recuperer la taille du la liste 
     }
     
    public int getScore(){ //methode qui retourne la score total de touts les persoonages 
        int sc = 0;//declaration du variabla et la initialiser par 0
        for(int i=0; i<getTaille(); i++) //parcourir la liste
           sc+=getPerso(i).getValeur(); //la somme des scores
        return sc;//retourne le score totale
    }
          
    public Personnage getPerso(int i){ //methode qui retourne personnage d'indice i donner dans les parametres
        if (i>=0 && i<this.persos.size()) //si l'indice est dans la liste
             return this.persos.get(i); //returner personnage d'indice i
        else return null; //retourner null dans le cas contraire
    }
    
    public LesPersonnages getPersosFamille(String f) //methode qui retourne une collection des personnages qui ont la meme familles qui passe en parametre
    {   LesPersonnages lp = new LesPersonnages(); //creation d'une nouvelle liste de type Lespersonnages
        for(int i=0; i<getTaille(); i++) //parcourir la liste
            if(getPerso(i).getFamille().equals(f)) //tester si le premier personnage a la meme famille qui passer en parametre
                lp.ajoutePerso(getPerso(i)); // ajouter ce personnages dans la liste 
        return lp;  //retourner la liste
    }
    
    public void retirePerso(Personnage p)// methode qui supprime le personnage qui est passer en parametre
    { 
        int i=0; //declaration et initialisation du varibale i par 0
        boolean trouve = false;  //creation du variable trouve est linitialiser par false
        while(i<getTaille() && !trouve){ //parcourir la liste et assurer que trouve est encore false
          if (getPerso(i).getNom().equals(p.getNom())){ //tester si ce personnage a le meme pseudo du personnage passer en parametre
              this.persos.remove(i);  //supprimer ce personnage de la lsite
              trouve = true; //affecter true a la variable 
          }
          else i++; // si non passer a l'autre personnage dans la liste
        }      
    }
    
   public LesPersonnages retirePersos(String f ) // methode qui retourne une collection des personnages qui ont la meme famille qui est passere en parametre 
    { LesPersonnages lcr = new LesPersonnages(); // creation d'une nouvelle collection de type les personnages 
        int i = 0;
        while(i<getTaille()){ // parcourir la liste
            if (getPerso(i).getFamille().equals(f)) { // si le personnage d'indice i a la meme famille que la famiile qui est passer en prametre
                lcr.ajoutePerso(getPerso(i)); //ajouter ce personnage dans la liste crée
                this.persos.remove(i);  //supprimer  le personnage de l'attribut dez la classe
            }
            else i++;
        }
        return lcr;// retourner la liste 
    } 
    
    /*public LesPersonnages retirePersosFamille(String f)
    { 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFamille().equals(f)) {
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }*/
    
    
     
    public void retirePersos()//methode qui efface la liste
    { 
           persos.clear();
    }
    
    public void ajoutePerso(Personnage p){ //methode qui ajout un personnage a la liste
        this.persos.add(p);
    
    }
    
    public void ajoutePersos(LesPersonnages lpr){ // methode qui ajoute les personnages d'une liste passer en parametre  a la liste persos
        for(int i=0;i<lpr.getTaille();i++)
            this.persos.add(lpr.getPerso(i));
    
    }
    
    
    
    @Override
    public String toString() { //redifinion de la methode toString
        String s = "";
        for(int i=0; i<getTaille(); i++)// parcourir la liste 
            s+="\n"+i+"- "+getPerso(i).toString(); //ajouter les informations de chaque personnage dans la variable s
       return s;// retourner s
    }
    
    
	
    public LesPersonnages(int nc) {  // constructeur standard qui sert a initialiser les attributs de la classe par des valeurs par rapport a chque valeur donner a nc
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }
    
    public ArrayList<String> getFamilles(){ // methode qui retourne une collection des familles des personnages non doubles 
        ArrayList<String> lst = new ArrayList<>(); // creation d'une nouvelle liste
        for(int j=0;j<this.persos.size();j++){ //parcourir la liste persos
            Personnage p = this.persos.get(j); //declarer un nouveau personnage en le initialiser par le personnage d'indice j dans la liste persos
            boolean trouve = false;
            for(int i=0;i<lst.size();i++) // parvourir la liste lst
                if(lst.get(i).equals(p.getFamille())) //tester si la famille deja existe dans la liste lst 
                    trouve = true; 
            if(!trouve)lst.add(p.getFamille()); // si la famille n'existe pas dan la liste lst on l'ahjoute
        }
        return lst; // retourner la liste lst
    }
}

