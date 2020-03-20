package com.example.projet_mobil.creationPartie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projet_mobil.R;

/*-----------------------------------------------
Créer le fragement qui affichera le DebutActivity
-----------------------------------------------*/

public class AfficheeFragment extends Fragment {
    TextView tvNom;
    View result;
    private String nom;

    public AfficheeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle b = getArguments();

        if(b!=null) {
            nom = String.valueOf(getArguments());
        }
        //afficherTable(table);
        result=inflater.inflate(R.layout.fragment_debut, container, false);
        //tvNom = (ListView) result.findViewById(R.id.tvNom);
        tvNom.setText(nom);

        return result;
    }
}
