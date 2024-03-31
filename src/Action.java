/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ak859784
 */

public abstract class Action {
    private Joueur j;
    private String descriptif;
    private String deroulement;
    
    public Action(){
        this.j=null;
        this.deroulement="";
        this.descriptif="";
    }
    public Action(Joueur jc,String des){
        this.j=jc;
        this.descriptif=des;
        this.deroulement="";
    }

    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDeroulement() {
        return deroulement;
    }

    public void setDeroulement(String deroulement) {
        this.deroulement = deroulement;
    }
    public String toString(){
        String res="";
        res+="Action effectué par "+this.j.getPseudo()+"\n";
        res+="Descriptif: "+this.descriptif+"\n";
        res+="Déroulement :"+this.deroulement+"\n";
        return res;
    }
    public abstract int execute();
    
}
