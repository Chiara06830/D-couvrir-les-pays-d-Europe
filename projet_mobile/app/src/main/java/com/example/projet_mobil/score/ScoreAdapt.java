package com.example.projet_mobil.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projet_mobil.R;

import java.util.ArrayList;

public class ScoreAdapt extends BaseAdapter {
    private ListScore list;
    private Context mcontext;
    private LayoutInflater mInflater;

    public ScoreAdapt(Context context, ListScore list){
        this.list = list;
        this.mcontext = context;
        this.mInflater = LayoutInflater.from(mcontext);
    }

    public int getCount() {
        return list.size();
    }
    public Object getItem(int position) { return list.get(position); }
    public long getItemId(int position) { return position; }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML ""
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.score, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView pseudo = (TextView) layoutItem.findViewById(R.id.tv_pseudo);
        TextView nbPoints = (TextView) layoutItem.findViewById(R.id.tv_nbPoints);

        //(3) : Renseignement des valeurs;
        pseudo.setText(list.get(position).getNom());
        nbPoints.setText(Integer.toString(list.get(position).getNbPoints()));

        pseudo.setTag(position);
        nbPoints.setTag(position);

        pseudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
                sendListener(list.get(position), position);
            }
        });

        //On retourne l'item créé.
        return layoutItem;
    }

    //abonnement pour click sur le nom...
    private ArrayList<ScoreAdapterListener> mListListener = new ArrayList<ScoreAdapterListener>();
    public void addListener(ScoreAdapterListener aListener) {
        mListListener.add(aListener);
    }
    private void sendListener(Score item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }

    // Interface pour écouter les évènements sur le nom du Score
    public interface ScoreAdapterListener {
        public void onClickNom(Score item, int position);
    }
}
