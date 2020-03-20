package com.example.projet_mobil.score;

/*----------------------------------
Définie de quoi est composé le score
 ---------------------------------*/
public class Score {
    private int classement;
    private String nom;
    private int nbPoints;

    public Score(int img, String nom, int nbPoints){
        this.classement = img;
        this.nom = nom;
        this.nbPoints = nbPoints;
    }

    public Score(){}

    public int getClassement(){return this.classement;}
    public void setClassement(int classement){this.classement = classement;}
    public String getNom(){return this.nom;}
    public void setNom(String nom){this.nom = nom;}
    public int getNbPoints(){return this.nbPoints;}
    public void setNbPoints(int nb){this.nbPoints = nb;}

    @Override
    public String toString(){
        return classement + " : " + nom + " / " + nbPoints + "pts";
    }
}
