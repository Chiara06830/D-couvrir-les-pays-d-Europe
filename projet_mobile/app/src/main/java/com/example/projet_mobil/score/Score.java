package com.example.projet_mobil.score;

import android.os.Parcel;
import android.os.Parcelable;

/*----------------------------------
Définie de quoi est composé le score
 ---------------------------------*/
public class Score implements Parcelable {
    private int nbTour;
    private String nom;
    private int nbPoints;

    public Score(int img, String nom, int nbPoints){
        this.nbTour = img;
        this.nom = nom;
        this.nbPoints = nbPoints;
    }

    public Score(){}

    public int getNbTour(){return this.nbTour;}
    public void setNbTour(int classement){this.nbTour = classement;}
    public String getNom(){return this.nom;}
    public void setNom(String nom){this.nom = nom;}
    public int getNbPoints(){return this.nbPoints;}
    public void setNbPoints(int nb){this.nbPoints = nb;}

    @Override
    public String toString(){
        return nom + " / " + nbPoints + "pts";
    }

    /*-------------
    Avec Parcelable
    -------------*/

    public Score(Parcel in){
        this.nbTour = in.readInt();
        this.nom = in.readString();
        this.nbPoints = in.readInt();
    }

    //METHODE
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(nbTour);
        dest.writeString(nom);
        dest.writeInt(nbPoints);
    }

    public static final Parcelable.Creator<Score> CREATOR = new Parcelable.Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel source) {
            return new Score(source);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    //GETTER
    public static Parcelable.Creator<Score> getCreator() {
        return CREATOR;
    }
}
