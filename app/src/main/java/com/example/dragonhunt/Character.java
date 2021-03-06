package com.example.dragonhunt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Character extends AppCompatActivity implements BodyPartFragment.OnCharacterCreatedListener{
    private int headI = R.drawable.head1;
    private int pantsI = R.drawable.pants1;
    private int torsoI = R.drawable.shirt1;

    public static final String EXTRA_HEAD = "headthing";
    public static final String EXTRA_PANTS = "pantsthing";
    public static final String EXTRA_TORSO = "torsothing";

    private int[] harray = {R.drawable.head1, R.drawable.head2, R.drawable.head3};
    private int[] sarray = {R.drawable.shirt1, R.drawable.shirt2, R.drawable.shirt3};
    private int[] parray = {R.drawable.pants1, R.drawable.pants2, R.drawable.pants3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        final BodyPartFragment head = BodyPartFragment.newInstance(harray, "head");
        BodyPartFragment torso = BodyPartFragment.newInstance(sarray, "torso");
        BodyPartFragment legs = BodyPartFragment.newInstance(parray, "pants");

        addFrag(head, R.id.head);
        addFrag(torso, R.id.torso);
        addFrag(legs, R.id.legs);

        Button finish = findViewById(R.id.finish);
        View.OnClickListener done = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(Character.this, Game.class);
                x.putExtra(EXTRA_HEAD, headI);
                x.putExtra(EXTRA_TORSO, torsoI);
                x.putExtra(EXTRA_PANTS, pantsI);
                startActivity(x);
            }
        };
        finish.setOnClickListener(done);
    }
    public void addFrag(Fragment bodyp, int id){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(id, bodyp).commit();
    }

    @Override
    public void onCharacterCreated(int ID, String bodyID) {
        if(bodyID == "head"){
             headI = ID;
        }
        else if(bodyID == "torso"){
            torsoI = ID;
        }
        else{
            pantsI = ID;
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment){
        if(fragment instanceof BodyPartFragment){
            BodyPartFragment bodyPartFragment = (BodyPartFragment) fragment;
            bodyPartFragment.setOnCharacterCreatedListener(this);
        }
    }
}
