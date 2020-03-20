package com.example.projet_mobil.jeux;

/*---------------------------------------------------
Affichage du score nom et classement en fin de partie
---------------------------------------------------*/

import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class FinActivity extends AppCompatActivity {
    public void writeJSON() {
        JSONObject object = new JSONObject();
        try {
            object.put("name", "Jack Hack");
            object.put("score", new Integer(200));
            object.put("current", new Double(152.32));
            object.put("nickname", "Hacker");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}


