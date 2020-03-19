package com.example.projet_mobil.creationPartie;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projet_mobil.R;

/*--------------------------------------------------------
Récupère le nom du joueur et le passe au fragment affichee
--------------------------------------------------------*/

public class SaisieFragment extends Fragment implements  View.OnClickListener{
    private OnButtonClickedListener mCallback;

    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout of MainFragment
        View result=inflater.inflate(R.layout.fragment_saisie, container, false);

        // Set onClickListener to button "SHOW ME DETAILS"
        result.findViewById(R.id.fragment_main_button).setOnClickListener(this);

        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }

    // --------------
    // ACTIONS
    // --------------

    @Override
    public void onClick(View v) {
        // Spread the click to the parent activity
        mCallback.onButtonClicked(v);
    }

    // --------------
    // FRAGMENT SUPPORT
    // --------------

    // Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            // Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}
