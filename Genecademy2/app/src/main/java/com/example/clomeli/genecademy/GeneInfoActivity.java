package com.example.clomeli.genecademy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class GeneInfoActivity extends SimpleActivity {
    private static final String TAG = "MyActivity";
    ArrayList<String> firstString = new ArrayList<String>();
    ArrayList<String> fullString = new ArrayList<String>();
    ArrayList<String> pheString = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gene_info);
        Intent intent = getIntent();
        pheString.add((String) intent.getExtras().get("sc"));
        pheString.add((String) intent.getExtras().get("f"));
        pheString.add((String) intent.getExtras().get("chc"));
        pheString.add((String) intent.getExtras().get("i"));
        pheString.add((String) intent.getExtras().get("ec"));
        firstString.add("Skin Color: ");
        firstString.add("Freckles: ");
        firstString.add("Hair Color: ");
        firstString.add("Curly: ");
        firstString.add("Eye Color: ");
        for(int j = 0; j < 5; j++){
            fullString.add(firstString.get(j) + pheString.get(j));
        }
        ListView list = findListView(R.id.phenotypeList);
        SimpleList.with(this)
                .setItems(list, fullString);
        list_Listener();
    }

    public void list_Listener() {
        ListView list = findListView(R.id.phenotypeList);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int index, long id) {
                        Intent intent = new Intent(GeneInfoActivity.this, PhenotypeSpecificActivity.class);
                        intent.putExtra("phenotype", fullString.get(index));
                        intent.putExtra("array", fullString);
                        startActivity(intent);
                    }
                }
        );
    }
}
