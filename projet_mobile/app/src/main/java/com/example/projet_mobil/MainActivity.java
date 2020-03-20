package com.example.projet_mobil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projet_mobil.creationPartie.SaisieActivity;
import com.example.projet_mobil.score.ScoreActivity;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    Button jouer;
    Button score;

    Animation sortie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Fait sortir le logo de l'écran
    public void sortie(View v){
        logo = (ImageView) findViewById(R.id.img_logo);
        sortie =  AnimationUtils.loadAnimation(MainActivity.this, R.anim.sortie);
        logo.setVisibility(View.VISIBLE);
        logo.startAnimation(sortie);
    }

    //fait passer a l'activité de saisie de nom du joueur
    public void jouer(View v){
        Intent intent = new Intent(MainActivity.this, SaisieActivity.class);
        startActivity(intent);
    }

    //passe à l'activité de l'affichage des scores
    public void afficherScore (View v){
        Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
        startActivity(intent);
    }
}
