package com.example.clomeli.genecademy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class SearchActivity extends SimpleActivity {


    ArrayList<String> geneArray= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        createArrayList();
        listListener();
    }

    private void listListener() {
        ListView list = findListView(R.id.geneList);
        SimpleList.with(this)
                .setItems(list, geneArray);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int index, long id) {

                        Intent intent = new Intent(SearchActivity.this, DetailsActivity.class);
                        String gene = geneArray.get(index);
                        intent.putExtra("gene",gene);
                        startActivity(intent);
                    }
                }
        );
    }

    private void createArrayList() {
        try {
            int txtid = getResources().getIdentifier("genes", "raw", getPackageName());
            Scanner list_Scan = new Scanner(getResources().openRawResource(txtid));
            while (list_Scan.hasNextLine()) {
                String line = list_Scan.nextLine();
                        geneArray.add(line);
                Log.d("dfd", geneArray.toString());
                    }
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchBut(View view) {
        EditText editText = $(R.id.editText);
        String gene = editText.getText().toString();
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("gene", gene);
        startActivity(intent);
    }

    public void randBut(View view) {
        Random randy = new Random();
        int position = randy.nextInt(geneArray.size() - 1);
        String gene = geneArray.get(position);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("gene", gene);
        startActivity(intent);
    }
}
