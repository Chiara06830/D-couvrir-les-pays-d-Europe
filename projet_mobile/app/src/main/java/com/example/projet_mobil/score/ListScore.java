package com.example.projet_mobil.score;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/*--------------------------------------
Créer la liste de score à partir du JSON
 -------------------------------------*/
public class ListScore {
    ArrayList<Score> list;

    public ListScore(){
        this.list = new ArrayList<Score>();
    }
    public int size(){return list.size();}
    public Score get(int pos){return this.list.get(pos);}

    public void construireListe(Context context){
        try {
            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            //recuypération des scores
            for(int i=0; i<jsonArray.length(); i++)
                list.add(getScoreFromJSONObject(jsonArray.getJSONObject(i), context));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private Score getScoreFromJSONObject(JSONObject jsonObject, Context context) throws JSONException{
        String nom = jsonObject.getString("nom");
        int nbPoints = jsonObject.getInt("score");

        Score score = new Score(0, nom, nbPoints);

        return score;
    }

    private String getJSONFromAsset(Context context){
        String json = null;
        try {
            InputStream input = context.getAssets().open("score.json");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
