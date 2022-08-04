package com.barmej.interactiveapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ;
    TextView textView ;
    Button button ;
    Random random = new Random() ;
    int count = -1 ;
    private static final String BUNDLE = "BUNDLE" ;
    String[] arrayNames ;


    int[] arrayImage = {
            R.drawable.beach ,
            R.drawable.bike ,
            R.drawable.football ,
            R.drawable.museum ,
            R.drawable.park ,
            R.drawable.restaurant ,
            R.drawable.running ,
            R.drawable.shop ,
            R.drawable.swimming ,
            R.drawable.walking ,
    } ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView) ;
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button) ;
        arrayNames = getResources().getStringArray(R.array.names) ;



    }

    public void Suggest(View view) {
        count = random.nextInt(10) ;
        showImageAndTitle();
    }

    private void showImageAndTitle () {

        imageView.setImageResource(arrayImage[count]);
        textView.setText(arrayNames[count]);
    }

    public void displayNext(View view) {
        count++ ;
        if (count > -1 && count < 10 ){
            showImageAndTitle();
        } else {
            Toast.makeText(this ,R.string.done , Toast.LENGTH_SHORT).show();
        }

    }

    public void displayPrevious(View view) {
        count-- ;
        if (count > -1 && count < 10 ) {
            showImageAndTitle();
        } else {
            Toast.makeText(this , R.string.done , Toast.LENGTH_SHORT).show();
        }

    }
}
