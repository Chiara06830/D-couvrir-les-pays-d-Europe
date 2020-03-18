package com.example.projet_mobil.jeux;

/*----------------
Définie le un pays
 ---------------*/

public class Pays {
    private int image;
    private String nom;

    public int getImage(){return this.image;}
    public void setImage(int image){this.image = image;}
    public String getNom(){return this.nom;}
    public void setNom(String nom){this.nom = nom;}

    public Pays(int image, String nom){
        this.image = image;
        this.nom = nom;
    }

    public String toString(){
        return "Image : " + image + ", " + nom;
    }
}
