package com.example.projet_mobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    Button jouer;
    Button score;

    Animation sortie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortie(View v){
        logo = (ImageView) findViewById(R.id.img_logo);
        sortie =  AnimationUtils.loadAnimation(MainActivity.this, R.anim.sortie);
        logo.setVisibility(View.VISIBLE);
        logo.startAnimation(sortie);
    }
}
