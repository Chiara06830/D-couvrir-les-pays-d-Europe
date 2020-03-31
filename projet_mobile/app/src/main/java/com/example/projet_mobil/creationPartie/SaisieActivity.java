package com.example.projet_mobil.creationPartie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.projet_mobil.R;
import com.example.projet_mobil.jeux.QuizzActivity;
import com.example.projet_mobil.score.Score;

/*-----------------------------------------------------------
Affiche le nom du joueur et lui prpose de commencer la partie
 ----------------------------------------------------------*/

public class SaisieActivity extends AppCompatActivity{
    Button comencer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

       if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.saisie, new SaisieFragment()).commit();
        }

       comencer = (Button) findViewById(R.id.btn_commencer);
    }

    public void commencerJeux(View v){
        Score score = new Score(0, "chiara", 0);
        Intent intent = new Intent(SaisieActivity.this, QuizzActivity.class);
        //intent.putExtra("score", (CharSequence) score);
        startActivity(intent);
    }
}
