package com.example.projet_mobil.creationPartie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projet_mobil.R;

import java.util.ArrayList;

/*-----------------------------------------------
Créer le fragement qui affichera le DebutActivity
-----------------------------------------------*/

public class AfficheeFragment extends Fragment {
    TextView tvNom;
    View rootView;
    private String nom;
    Button commencer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //récupération de la valeur de la table
        Bundle b = getArguments();
        if(b!=null)
        {
            nom = getArguments().getString("nom");
        }
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_debut, null);

        tvNom = (TextView) rootView.findViewById(R.id.nom_joueur);
        System.out.println(nom);
        tvNom.setText(nom);

        return rootView;
    }


}
