package com.example.quiz_1911500518_agungmaruf_spinner_ae;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerku;
    TextView textku;
    ImageView imageku;

    String[] namahewan = {"cat", "chicken", "cow", "horse", "sheep"};
    int[] gambarhewan = {R.drawable.cat, R.drawable.chicken, R.drawable.cow, R.drawable.horse, R.drawable.sheep};
    int[] suarahewan = {R.raw.cat, R.raw.chicken, R.raw.cow, R.raw.horse, R.raw.sheep};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerku = (Spinner) findViewById(R.id.spnagung);
        textku = (TextView) findViewById(R.id.textspn);
        imageku = (ImageView) findViewById(R.id.gbrspn);

        ArrayAdapter adapterhewan = new ArrayAdapter(this, android.R.layout.simple_spinner_item, namahewan);
        spinnerku.setAdapter(adapterhewan);
        spinnerku.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textku.setText(namahewan[i]);
                imageku.setImageResource(gambarhewan[i]);
                MediaPlayer suara = MediaPlayer.create(MainActivity.this, suarahewan[i]);
                suara.start();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}