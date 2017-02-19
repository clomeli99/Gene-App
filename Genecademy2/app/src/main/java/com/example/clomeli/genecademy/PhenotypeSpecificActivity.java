package com.example.clomeli.genecademy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import stanford.androidlib.SimpleActivity;

public class PhenotypeSpecificActivity extends SimpleActivity {
    LinearLayout main;
    String text;
    ArrayList<String> list = new ArrayList<>();
    Button but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phenotype_specific);
        Intent intent = getIntent();
        text = (String) intent.getExtras().get("phenotype");
        list = (ArrayList<String>) intent.getExtras().get("array");
        TextView phenotype = $(R.id.phenotypeText);
        phenotype.setText(text);
        but = $(R.id.but);
        main = $(R.id.activity_phenotype_specific);
        populatelayout();
    }

    private void populatelayout() {
        switch (text){
            case"Skin Color: Brown":
                main.addView(ret_Layout("MC1R", "a lot and functional causes dark brown hair."));
                but.setVisibility(View.VISIBLE);
                break;
            case"Skin Color: Light Brown":
                but.setVisibility(View.VISIBLE);
                main.addView(ret_Layout("MC1R", "An average amount of functioning would cause light brown skin."));
                break;
            case"Skin Color: White":
                but.setVisibility(View.VISIBLE);
                main.addView(ret_Layout("MC1R", "Poorly working results in white skin in asians and europeans."));
                main.addView(ret_Layout("KITLG", "Poorly working results in white skin in asians and europeans."));
                main.addView(ret_Layout("OCA2", "Poorly working results in white skin for asians."));
                main.addView(ret_Layout("SLC2485", "Mutations in these genes cause white skin in europeans."));
                main.addView(ret_Layout("SLC45A2", "Mutations in these genes cause white skin in europeans."));
                main.addView(ret_Layout("TYR", "Mutations in these genes cause white skin in europeans."));
                main.addView(ret_Layout("ASIP", "Normal gene causes white skin."));
            break;
            case"Eye Color: Blue":
                main.addView(ret_Layout("HERC2", "CC allele causes a 72% chance of having blue eyes and a TC allele causes a 70% chance of having blue eyes."));
                break;
            case"Eye Color: Green":
                main.addView(ret_Layout("HERC2", "TT allele is a 14% chance while a CC allele is a 27% chance and TC is 37%"));
                break;
            case"Eye Color: Brown":
                main.addView(ret_Layout("HERC2", "TT allele means 85% chance of brown eyes and a TC allele causes a 56% chance of having brown eyes\n" +
                        "hair color."));
                break;
            case"Hair Color: Red":
                main.addView(ret_Layout("MC1R", "None functioning would cause red hair."));
                break;
            case"Hair Color: Blonde":
                main.addView(ret_Layout("MC1R", "Some functioning would cause blonde hair."));
                break;
            case"Hair Color: Brown":
                main.addView(ret_Layout("MC1R", "Medium amount of functioning would cause brown hair."));
                break;
            case"Hair Color: Black":
                main.addView(ret_Layout("MC1R", "Abundant amount of functioning would cause black hair."));
                break;
            case"Curly: Yes":
                main.addView(ret_Layout("TCHH,", "Gene mutation results in curly hair in european people."));
                main.addView(ret_Layout("JUP", "Gene mutation results in very curly hair."));
                main.addView(ret_Layout("DSC2", "Gene mutation results in very curly hair."));
                main.addView(ret_Layout("KANK2", "Gene mutation results in very curly hair."));
                main.addView(ret_Layout("DSP", "Gene mutation results in very curly hair"));
                break;
            case"Curly: No":
                main.addView(ret_Layout("EDAR", "Variations affect how heavy and straight Asian hair would be."));
                main.addView(ret_Layout("FGFR2", "Variations affect how heavy and straight Asian hair would be."));
                break;
            case"Freckles: Yes":
                main.addView(ret_Layout("MC1R", "1-2 out of 2 alleles are inactive."));
                break;
            case"Freckles: No":
                main.addView(ret_Layout("MC1R", "Both alleles are active."));
                break;
        }
    }

    private LinearLayout ret_Layout(String but_text, String body_text)
    {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        final Button but = new Button(this);
        but.setText(but_text);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhenotypeSpecificActivity.this, DetailsActivity.class);
                intent.putExtra("gene", but.getText());
                startActivity(intent);
            }
        });
        ll.addView(but);
        TextView txt = new TextView(this);
        txt.setText(body_text);
        ll.addView(txt);
        return  ll;
    }

    public void butClick420(View view) {
        Intent intent = new Intent(this, GenericInfoActivity.class);
        startActivity(intent);
    }
}
