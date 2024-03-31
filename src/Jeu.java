/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RAFIK
 */
public class Jeu {
    private LesPersonnages lespers;
    private LesJoueurs lesJ;
    private PlateauJeu monP;
    private Action act;
    private int indc;

    public Jeu() {
        this.lespers = new LesPersonnages();
        this.lesJ = new LesJoueurs();
        this.monP = new PlateauJeu();
        this.act=null;
        this.indc=0;
    }

    public Jeu(LesPersonnages lespers, LesJoueurs lesJ, int nbc) {
        this.lespers = lespers;
        this.lesJ = lesJ;
        this.indc = 0;
        this.monP = new PlateauJeu(nbc);
        this.act=null;
    }

    public LesPersonnages getLespers() {
        return lespers;
    }

    public void setLespers(LesPersonnages lespers) {
        this.lespers = lespers;
    }

    public LesJoueurs getLesJ() {
        return lesJ;
    }

    public void setLesJ(LesJoueurs lesJ) {
        this.lesJ = lesJ;
    }

    public PlateauJeu getMonP() {
        return monP;
    }

    public void setMonP(PlateauJeu monP) {
        this.monP = monP;
    }

    public Action getAct() {
        return act;
    }

    public void setAct(Action act) {
        this.act = act;
    }

    public int getIndc() {
        return indc;
    }

    public void setIndc(int indc) {
        this.indc = indc;
    }
    
    public Joueur getJoueurCourant(){
        return this.lesJ.getJoueur(indc);
    }
    
    public int getIndSuivant(int ic){
        return (ic+1)%this.lesJ.getNbJoueurs();
    }
    
    public Joueur getJoueurSuivant(int j){ 
        return lesJ.getJoueur(getIndSuivant(j));
    }
    
    public void setJoueurCourant(int n){
        this.indc=n;
    }
    
    public boolean finJeu(){
        return this.monP.jeuVide();
    }
    
    public int nbPers(){
        int n = 0;
        for(int i = 0; i < lesJ.getNbJoueurs(); i++)
                if (i !=this.indc) 
                        n+=lesJ.getJoueur(i).getNbCartes();
        return n;
    }
    
    public int traiteTour(Joueur jo, int s){
        int bonus=-1;
        Personnage pers = this.lespers.getPerso(s);
        jo.ajoutePersoPaquet(pers);
        String f = pers.getFamille();
        LesPersonnages pf = this.lespers.getPersosFamille(f);
        int npf = pf.getTaille();
        LesPersonnages bj = jo.getPaquet().getPersosFamille(f);
        int nbj = bj.getTaille();
        /*System.out.println(nbj);
        System.out.println(npf);*/
        if(npf==nbj){
            if(jo.getFamillepré().equals(f)){
                bonus=0;
                this.monP.termineJeu();
            }
            else{
                if(this.nbPers()>0){
                    if(f.equals("rares") || f.equals("communs"))
                        bonus=1;
                    else if(f.equals("legendaires") || f.equals("epiques")){
                        bonus=2;
                    }
                    else 
                        bonus=3;
                }  
            }                
        }
        return bonus;
    }
    
}
