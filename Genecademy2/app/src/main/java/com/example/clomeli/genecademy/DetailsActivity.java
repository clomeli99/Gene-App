package com.example.clomeli.genecademy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

import stanford.androidlib.SimpleActivity;

public class DetailsActivity extends SimpleActivity {

    TextView geneName;
    ImageView chromepic;
    ImageView chromepic24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView detailsd = $(R.id.details);
        chromepic24 = $(R.id.chromepic24);
        geneName =$(R.id.geneName);
        chromepic = $(R.id.chromepic);
        Intent intent = getIntent();
        String name = (String) intent.getExtras().get("gene");
        geneName.setText(name.toUpperCase());
        name = name.toLowerCase();
        int txtid = getResources().getIdentifier(name, "raw", getPackageName());
        Scanner txtscan = new Scanner(getResources().openRawResource(txtid));
        String chromosomenum = txtscan.nextLine();
        chromosomenum = "a" + chromosomenum;
        int png24id =  getResources().getIdentifier(chromosomenum, "drawable", getPackageName());
        chromepic24.setImageResource(png24id);
        String details = txtscan.nextLine();
        details = "         " + details;
        detailsd.setText(details);
        int pngid = getResources().getIdentifier(name, "drawable", getPackageName());
        chromepic.setImageResource(pngid);
    }
}
