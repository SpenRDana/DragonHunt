package com.example.dragonhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Character extends AppCompatActivity {
    private int pindex = 0;
    private int sindex = 0;
    private int hindex = 0;
    private int[] harray = {R.drawable.head1, R.drawable.head2, R.drawable.head3};
    private int[] sarray = {R.drawable.shirt1, R.drawable.shirt2, R.drawable.shirt3};
    private int[] parray = {R.drawable.pants1, R.drawable.pants2, R.drawable.pants3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        ImageButton tR = findViewById(R.id.topR);
        ImageButton tL = findViewById(R.id.topL);
        final ImageView head = findViewById(R.id.head);
        ImageButton mR = findViewById(R.id.middleR);
        ImageButton mL = findViewById(R.id.middleL);
        final ImageView shirt = findViewById(R.id.shirt);
        ImageButton bR = findViewById(R.id.bottomR);
        ImageButton bL = findViewById(R.id.bottomL);
        final ImageView pants = findViewById(R.id.pants);
        Button finish = findViewById(R.id.finish);
        View.OnClickListener BL = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.topR){
                    if(harray.length - 1 <= hindex){
                        hindex = 0;
                    }
                    else{
                        hindex++;
                    }
                    head.setImageResource(harray[hindex]);
                }
                else if(v.getId() == R.id.topL){
                    if(hindex==0){
                        hindex = harray.length-1;
                    }
                    else{
                        hindex--;
                    }
                    head.setImageResource(harray[hindex]);
                }
                else if(v.getId() == R.id.middleR){
                    if(sarray.length - 1 <= sindex){
                        sindex = 0;
                    }
                    else{
                        sindex++;
                    }
                    shirt.setImageResource(sarray[sindex]);
                }
                else if(v.getId() == R.id.middleL){
                    if(sindex==0){
                        sindex = sarray.length-1;
                    }
                    else{
                        sindex--;
                    }
                    shirt.setImageResource(sarray[sindex]);
                }
                else if(v.getId() == R.id.bottomR){
                    if(parray.length - 1 <= pindex){
                        pindex = 0;
                    }
                    else{
                        pindex++;
                    }
                    pants.setImageResource(parray[pindex]);
                }
                else if(v.getId() == R.id.bottomL){
                    if(pindex==0){
                        pindex = parray.length-1;
                    }
                    else{
                        pindex--;
                    }
                    pants.setImageResource(parray[pindex]);
                }
                else{

                }
            }
        };
        tR.setOnClickListener(BL);
        tL.setOnClickListener(BL);
        mR.setOnClickListener(BL);
        mL.setOnClickListener(BL);
        bR.setOnClickListener(BL);
        bL.setOnClickListener(BL);
        finish.setOnClickListener(BL);


    }
}
