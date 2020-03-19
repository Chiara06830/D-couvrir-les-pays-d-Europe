package com.example.projet_mobil.creationPartie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projet_mobil.R;


/*-----------------------------------------------------------
Affiche le nom du joueur et lui prpose de commencer la partie
 ----------------------------------------------------------*/

public class SaisieActivity extends AppCompatActivity implements SaisieFragment.OnButtonClickedListener{
    EditText etNom;
    Button btnJouer;
    private SaisieFragment saisieNom;
    private AfficheeFragment debutJeux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_saisie);

        this.configureAndShowSaisieFragment();
        this.configureAndShowAfficheeFragment();
    }

    // --------------
    // CallBack
    // --------------

    @Override
    public void onButtonClicked(View view) {
        etNom = (EditText)findViewById(R.id.etNom);
        String nom = etNom.getText().toString();
        //Check if detail fragment is not created
        if (debutJeux == null){
            Intent intent = new Intent(SaisieFragment.this, AfficheeActivity.class);
            intent.putExtra("valeur", nom);
            startActivity(intent);
        }
    }

    // --------------
    // FRAGMENTS
    // --------------
    private void configureAndShowSaisieFragment(){
        saisieNom = (SaisieFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_saisie);

        if (saisieNom == null) {
            saisieNom = new SaisieFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_saisie, saisieNom)
                    .commit();
        }
    }

    private void configureAndShowAfficheeFragment(){
        debutJeux = (AfficheeFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_debut);

        if (debutJeux == null && findViewById(R.id.frame_layout_debut) != null) {
            debutJeux = new AfficheeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_debut, debutJeux)
                    .commit();
        }
    }
}
