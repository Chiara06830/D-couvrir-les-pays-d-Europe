package com.example.projet_mobil.score;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.projet_mobil.R;

/*-----------------------
Gère l'affichage du score
 ----------------------*/
public class ScoreActivity extends AppCompatActivity {
    ListView lvScore;
    ListScore list = new ListScore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_score);

        //Récupération de la liste des diplomes
        list.construireListe(this);

        //Création et initialisation de l'Adapter pour les diplomes
        ScoreAdapt adapter = new ScoreAdapt(this, list);

        //Récupération du composant ListView
        lvScore = (ListView) findViewById(R.id.list_score);

        //Initialisation de la liste avec les données
        lvScore.setAdapter(adapter);

    }

    public void onClickNom(Score item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Score");

        builder.setMessage("Vous avez cliqué sur : " + item.getNom());
        builder.setPositiveButton("Oui", null);
        builder.setNegativeButton("Non", null);
        builder.show();
    }
}
