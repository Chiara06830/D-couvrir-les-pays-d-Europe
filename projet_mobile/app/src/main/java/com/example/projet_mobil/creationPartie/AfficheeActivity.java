package com.example.projet_mobil.creationPartie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet_mobil.R;

public class AfficheeActivity extends AppCompatActivity {
    TextView nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debut_jeux);

        nom = (TextView) findViewById(R.id.nom_joueur);
        String pseudo = getIntent().getExtras().getParcelable("user");
        Toast toast = Toast.makeText(getApplicationContext(), pseudo, Toast.LENGTH_SHORT);
        toast.show();
        nom.setText(pseudo);
    }
}
