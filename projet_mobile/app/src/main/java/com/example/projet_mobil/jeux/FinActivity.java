package com.example.projet_mobil.jeux;

/*---------------------------------------------------
Affichage du score nom et classement en fin de partie
---------------------------------------------------*/

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projet_mobil.MainActivity;
import com.example.projet_mobil.R;
import com.example.projet_mobil.score.Score;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FinActivity extends AppCompatActivity {
    TextView nom;
    TextView scoreFinal;

    Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_final);

        //récuperer les infos a changer
        nom = (TextView) findViewById(R.id.nom_perso);
        scoreFinal = (TextView) findViewById(R.id.score_final_joueur);

        //recuperer le score du joueur
        score  = getIntent().getExtras().getParcelable("score");

        //mettre à jour les informations en fonction du score du joueur
        nom.setText(score.getNom());
        scoreFinal.setText(Integer.toString(score.getNbPoints()));

        //ecrire le score dans un json
        writeJSON();
    }

    public void recommencer(View v){
        Intent intent = new Intent(FinActivity.this, QuizzActivity.class);
        score.setNbTour(0);
        score.setNbPoints(0);
        intent.putExtra("score", score);
        startActivity(intent);
    }

    public void retourMenu(View v){
        Intent intent = new Intent(FinActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void writeJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put("name", score.getNom());
            object.put("score", score.getNbPoints());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            // Récupération du fichier json
            JSONArray jsonArray = new JSONArray(getJSONFromAsset(this));
            System.out.println(jsonArray);
            jsonArray.put(object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //lecture du fichier en string
    private  String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("score.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}


