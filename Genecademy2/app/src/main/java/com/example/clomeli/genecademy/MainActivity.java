package com.example.clomeli.genecademy;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleDialog;

public class MainActivity extends SimpleActivity {
    private static final String TAG = "MyActivity";

    ImageView whiteSkin, lightBrownSkin, brownSkin;
    ImageView whiteNose,lightBrownNose, brownNose;
    ImageView whiteFreckledNose, lightBrownFreckledNose, brownFreckledNose;
    ImageView blackHair, brownHair, blondeHair, redHair;
    ImageView curlyBlackHair, curlyBrownHair, curlyBlondeHair, curlyRedHair;
    ImageView brownEyes, greenEyes, blueEyes;

//    ImageView whiteSkinCX, lightBrownSkinCX, brownSkinCX;
//    ImageView yesfreckles, nofreckles;
//    ImageView blackHairCX, brownHairCX, blondeHairCX, redHairCX;
//    ImageView straightCX, curlyCX;
//    ImageView brownEyesCX, greenEyesCX, blueEyesCX;

    LinearLayout main;
    LinearLayout ll;

    HashMap<ImageView,String> stringMap = new HashMap<ImageView,String>();

    int hasFreckles = 0;
    int currentSkin = 0;
    int isCurly = 0;
    int currentHairColor= 0;
    int eyecolor = 0;

    ArrayList<ImageView> skinArray = new ArrayList<ImageView>();
    ArrayList<ImageView> noseArray = new ArrayList<ImageView>();
    ArrayList<ImageView> freckledNoseArray = new ArrayList<ImageView>();
    ArrayList<ImageView> haircolorArray = new ArrayList<ImageView>();
    ArrayList<ImageView> hairtypeArray = new ArrayList<ImageView>();
    ArrayList<ImageView> eyeArray = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = $(R.id.activity_main);
        ll = new LinearLayout(this);
        retrievefaceImageViews();
        retrieveCXImageViews();
        addViewsToList();
        createStringMap();
        skinSpinner();
        frecklesSpinner();
        hairColorSpinner();
        hairTypeSpinner();
        eyeSpinner();
    }

    private void retrieveCXImageViews() {
//        whiteSkinCX = $(R.id.whiteskin);
//        lightBrownSkinCX = $(R.id.lightbrownskin);
//        brownSkinCX = $(R.id.brownskin);
//        nofreckles = $(R.id.nofreckles);
//        yesfreckles = $(R.id.yesfreckles);
//        blackHairCX = $(R.id.blackhair);
//        brownHairCX = $(R.id.brownhair);
//        blondeHairCX = $(R.id.blondehair);
//        redHairCX = $(R.id.redhair);
//        straightCX = $(R.id.isstraight);
//        curlyCX = $(R.id.iscurly);
//        brownEyesCX = $(R.id.browneyesCX);
//        greenEyesCX = $(R.id.greeneyesCX);
//        blueEyesCX = $(R.id.blueeyesCX);
    }

    private void addPictures() {
        ll.removeAllViews();
        ll.setOrientation(LinearLayout.VERTICAL);
        TextView txt= new TextView(this);
        txt.setText("Skin Color Genes: ");
        ll.addView(txt);
        switch(currentSkin) {
            case 0:
                ll.addView(ret_Layout("MC1R"));
                ll.addView(ret_Layout("KITLG"));
                ll.addView(ret_Layout("OCA2"));
                ll.addView(ret_Layout("SLC2485"));
                ll.addView(ret_Layout("SLC45A2"));
                ll.addView(ret_Layout("TYR"));
                ll.addView(ret_Layout("ASIP"));
                break;
            case 1:
                ll.addView(ret_Layout("MC1R"));
            break;
            case 2:
                ll.addView(ret_Layout("MC1R"));
                break;
        }
        TextView txt2= new TextView(this);
        txt2.setText("Freckle Genes: ");
        ll.addView(txt2);
        ll.addView(ret_Layout("MC1R"));

        TextView txt3= new TextView(this);
        txt3.setText("Hair Color Gene: ");
        ll.addView(txt3);
        ll.addView(ret_Layout("MC1R"));

        TextView txt1= new TextView(this);
        txt1.setText("Hair Type Gene: ");
        ll.addView(txt1);
        if(isCurly == 1){
            ll.addView(ret_Layout("TCHH"));
            ll.addView(ret_Layout("JUP"));
            ll.addView(ret_Layout("DSC2"));
            ll.addView(ret_Layout("KANK2"));
            ll.addView(ret_Layout("DSP"));
        }else{
            ll.addView(ret_Layout("EDAR"));
            ll.addView(ret_Layout("FGFR2"));
        }
        TextView txt4= new TextView(this);
        txt4.setText("Eye Color Gene: ");
        ll.addView(txt4);
        ll.addView(ret_Layout("MC1R"));

        if(ll.getParent() == null){
            main.addView(ll);
        }
    }

    private ImageView ret_Layout(String gene){
        ImageView img = new ImageView(this);
        gene = gene.toLowerCase();
        gene += "cropped";
        int pngid = getResources().getIdentifier(gene, "drawable", getPackageName());
        img.setImageResource(pngid);
        return img;
    }


    private void createStringMap() {
        stringMap.put(whiteSkin, "White");
        stringMap.put(lightBrownSkin, "Light Brown");
        stringMap.put(brownSkin, "Brown");
        stringMap.put(whiteNose, "White");
        stringMap.put(lightBrownNose, "Light Brown");
        stringMap.put(brownNose, "Brown");
        stringMap.put(whiteFreckledNose, "White Freckled");
        stringMap.put(lightBrownFreckledNose, "Light Brown Freckled");
        stringMap.put(brownFreckledNose, "Brown Freckled");
        stringMap.put(blackHair, "Black");
        stringMap.put(brownHair, "Brown");
        stringMap.put(blondeHair, "Blonde");
        stringMap.put(redHair, "Red");
        stringMap.put(curlyBlackHair, "Curly Black");
        stringMap.put(curlyBrownHair, "Curly Brown");
        stringMap.put(curlyBlondeHair, "Curly Blonde");
        stringMap.put(curlyRedHair, "Curly Red");
        stringMap.put(brownEyes, "Brown");
        stringMap.put(greenEyes, "Green");
        stringMap.put(blueEyes, "Blue");
    }

    private void retrievefaceImageViews(){
        whiteSkin = $(R.id.whiteSkin);
        lightBrownSkin = $(R.id.lightBrownSkin);
        brownSkin = $(R.id.brownSkin);
        whiteNose = $(R.id.whiteNose);
        lightBrownNose = $(R.id.lightBrownNose);
        brownNose = $(R.id.brownNose);
        whiteFreckledNose = $(R.id.whiteFreckledNose);
        lightBrownFreckledNose = $(R.id.lightFreckledBrownNose);
        brownFreckledNose = $(R.id.brownFreckledNose);
        blackHair = $(R.id.blackHair);
        brownHair = $(R.id.brownHair);
        blondeHair = $(R.id.blondeHair);
        redHair = $(R.id.redHair);
        curlyBlackHair = $(R.id.curlyblackHair);
        curlyBrownHair = $(R.id.curlybrownHair);
        curlyBlondeHair = $(R.id.curlyblondeHair);
        curlyRedHair = $(R.id.curlyredHair);
        brownEyes = $(R.id.browneyes);
        greenEyes = $(R.id.greeneyes);
        blueEyes = $(R.id.blueeyes);
    }

    private void addViewsToList(){
        skinArray.add(whiteSkin);
        skinArray.add(lightBrownSkin);
        skinArray.add(brownSkin);
        noseArray.add(whiteNose);
        noseArray.add(lightBrownNose);
        noseArray.add(brownNose);
        freckledNoseArray.add(whiteFreckledNose);
        freckledNoseArray.add(lightBrownFreckledNose);
        freckledNoseArray.add(brownFreckledNose);
        haircolorArray.add(blackHair);
        haircolorArray.add(brownHair);
        haircolorArray.add(blondeHair);
        haircolorArray.add(redHair);
        hairtypeArray.add(curlyBlackHair);
        hairtypeArray.add(curlyBrownHair);
        hairtypeArray.add(curlyBlondeHair);
        hairtypeArray.add(curlyRedHair);
        eyeArray.add(brownEyes);
        eyeArray.add(greenEyes);
        eyeArray.add(blueEyes);
    }

    private void eyeSpinner() {
        Spinner eyespinner = $(R.id.eyespinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.eye_array,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eyespinner.setAdapter(arrayAdapter);
        eyespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < 3; j++){
                    ImageView eyeview = eyeArray.get(j);
                    eyeview.setVisibility(View.INVISIBLE);
                }
                eyecolor = i;
                ImageView selectedEye = eyeArray.get(i);
                selectedEye.setVisibility(View.VISIBLE);
                addPictures();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void hairColorSpinner() {
        Spinner hairspinner = $(R.id.hairspinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.hair_color_array,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairspinner.setAdapter(arrayAdapter);
        hairspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < 4; j++){
                    ImageView hairview = haircolorArray.get(j);
                    hairview.setVisibility(View.INVISIBLE);
                    ImageView typeview = hairtypeArray.get(j);
                    typeview.setVisibility(View.INVISIBLE);
                }
                currentHairColor = i;
                if(isCurly == 0){
                    ImageView selectedHair = haircolorArray.get(currentHairColor);
                    selectedHair.setVisibility(View.VISIBLE);
                }else{
                    ImageView selectedHair = hairtypeArray.get(currentHairColor);
                    selectedHair.setVisibility(View.VISIBLE);
                }
                addPictures();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void hairTypeSpinner(){
        Spinner hairtypespinner = $(R.id.hairtypespinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.hair_type_array,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hairtypespinner.setAdapter(arrayAdapter);
        hairtypespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < 4; j++){
                    ImageView colorview = haircolorArray.get(j);
                    colorview.setVisibility(View.INVISIBLE);
                    ImageView typeview = hairtypeArray.get(j);
                    typeview.setVisibility(View.INVISIBLE);
                }
                if(i == 1){
                    isCurly = 1;
                    ImageView selectedhair = hairtypeArray.get(currentHairColor);
                    selectedhair.setVisibility(View.VISIBLE);
                }else{
                    isCurly = 0;
                    ImageView selectedhair = haircolorArray.get(currentHairColor);
                    selectedhair.setVisibility(View.VISIBLE);
                }
                addPictures();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void frecklesSpinner() {
        Spinner frecklesspinner = $(R.id.frecklesspinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.freckles_array,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frecklesspinner.setAdapter(arrayAdapter);
        frecklesspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < 3; j++){
                    ImageView noseview = noseArray.get(j);
                    noseview.setVisibility(View.INVISIBLE);
                    ImageView frecklednoseview = freckledNoseArray.get(j);
                    frecklednoseview.setVisibility(View.INVISIBLE);
                }
                if(i == 1){
                    hasFreckles = 1;
                    ImageView selectedNose = freckledNoseArray.get(currentSkin);
                    selectedNose.setVisibility(View.VISIBLE);
                }else{
                    hasFreckles = 0;
                    ImageView selectedNose = noseArray.get(currentSkin);
                    selectedNose.setVisibility(View.VISIBLE);
                }
                addPictures();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void skinSpinner() {
        Spinner skinspinner = $(R.id.skinspinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.skin_array,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        skinspinner.setAdapter(arrayAdapter);
        skinspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < 3; j++){
                    ImageView noseview = noseArray.get(j);
                    noseview.setVisibility(View.INVISIBLE);
                    ImageView frecklednoseview = freckledNoseArray.get(j);
                    frecklednoseview.setVisibility(View.INVISIBLE);
                    ImageView imageview = skinArray.get(j);
                    imageview.setVisibility(View.INVISIBLE);
                }
                currentSkin = i;
                if(hasFreckles == 1){
                    ImageView selectedNose = freckledNoseArray.get(currentSkin);
                    selectedNose.setVisibility(View.VISIBLE);
                }else{
                    ImageView selectedNose = noseArray.get(currentSkin);
                    selectedNose.setVisibility(View.VISIBLE);
                }
                ImageView selectedSkin = skinArray.get(i);
                selectedSkin.setVisibility(View.VISIBLE);
                addPictures();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void button_clicked(View view) {
        Intent intent = new Intent(this, GeneInfoActivity.class);
        String cs = stringMap.get(skinArray.get(currentSkin));
        String chc = stringMap.get(haircolorArray.get(currentHairColor));
        String ec = stringMap.get(eyeArray.get(eyecolor));

        intent.putExtra("chc",chc);
        intent.putExtra("sc", cs);
        intent.putExtra("ec", ec);
        if(hasFreckles==1) {
            intent.putExtra("f", "Yes");
        }else{
            intent.putExtra("f", "No");
        }
        if(isCurly==1) {
            intent.putExtra("i", "Yes");
        }
        else{
            intent.putExtra("i", "No");
        }
        startActivity(intent);
    }

    public void button_clicked2(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
//        SimpleDialog.with(this)
//                .showInputDialog("Type name of gene: ", "Submit");
    }


    @Override
    public void onInputDialogClose(AlertDialog dialog, String input) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("gene", input);
        startActivity(intent);
    }
}
