package com.example.projet_mobil.jeux;

/*-------------------------------------
Va creer un quiz avec un pays aléatoire
 ------------------------------------*/

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet_mobil.R;
import com.example.projet_mobil.score.Score;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizzActivity extends AppCompatActivity {
    private String TAG = QuizzActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private static String url = "https://www.junkjumper-projects.com/iut/pays.json";

    ImageView pays;
    TextView scoreActuelle;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    Score score;
    List<Pays> paysList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_pays);

        //score  = getIntent().getExtras().getParcelable("score");
        context = this.getApplicationContext();
        paysList = new ArrayList<Pays>();

        pays = (ImageView) findViewById(R.id.image_pays);
        scoreActuelle = (TextView) findViewById(R.id.score_joueur);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        new GetPays().execute();
    }

    private class GetPays extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(QuizzActivity.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        // appeler automatiquement après onPreExecute
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null) {
                try {
                    JSONArray jsonarray = new JSONArray(jsonStr);

                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject c = jsonarray.getJSONObject(i);

                        String nom = c.getString("nom");
                        String simage = c.getString("image");
                        int image = context.getResources().getIdentifier(simage, "mipmap", context.getPackageName());

                        Pays p = new Pays(image, nom);
                        System.out.println(p);
                        paysList.add(p);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Erreur JSON " + e.getMessage());

                }
            } else {
                Log.e(TAG, "Probleme connexion ");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing())
                pDialog.dismiss();

            //remplir une liste avec tout les noms de pays
            ArrayList<String> listNom = new ArrayList<String>();
            for(int i=0;i<paysList.size();i++){
                listNom.add(paysList.get(i).getNom());
            }

            //remplir une liste avec les boutons pour les melanger plus tard
            ArrayList<Button> listButton = new ArrayList<Button>();
            listButton.add(btn1);
            listButton.add(btn2);
            listButton.add(btn3);
            listButton.add(btn4);

            //récupere un pays aléatoire
            Random randPays = new Random();
            int rPays = randPays.nextInt(paysList.size());
            Pays selected = paysList.get(rPays);
            System.out.println(selected);
            pays.setImageResource(selected.getImage());

            //prendre un bouton aléatoirement pour lui donner la bonne réponse
            Random randBouton = new Random();
            int rBouton = randBouton.nextInt(listButton.size());
            Button reponse = listButton.get(rBouton);
            reponse.setText(selected.getNom());

            //remplir les autres bouton avec d'autres nom aléatoire
            listButton.remove(reponse);
            for (int i=0; i<listButton.size(); i++){
                Random rand2 = new Random();
                int r2 = rand2.nextInt(listButton.size());
                listButton.get(i).setText(listNom.get(r2));
                listNom.remove(r2);
            }
        }
    }
}
