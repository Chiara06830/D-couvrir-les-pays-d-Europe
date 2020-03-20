package com.example.projet_mobil.creationPartie;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projet_mobil.R;

/*--------------------------------------------------------
Récupère le nom du joueur et le passe au fragment affichee
--------------------------------------------------------*/

public class SaisieFragment extends Fragment{
    Fragment frag;
    FragmentTransaction fragTransaction;


    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        //TODO
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_saisie, container, false);

        final EditText nom = (EditText) rootView.findViewById(R.id.pseudo_joueur);

        nom.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) { }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int longueur = nom.getText().length();
                if (longueur != 0) {
                    String saisie = nom.getText().toString();
                    System.out.println(saisie);
                    frag = new AfficheeFragment();
                    Bundle args = new Bundle();
                    args.putString("nom", saisie);
                    frag.setArguments(args);

                    fragTransaction = getFragmentManager().beginTransaction().replace(R.id.affichage, frag);
                    fragTransaction.commit();
                }
            }
        });

        return rootView;
    }
}
