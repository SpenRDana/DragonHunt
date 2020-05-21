package com.example.dragonhunt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        int head = intent.getIntExtra(Character.EXTRA_HEAD, 0);
        int torso = intent.getIntExtra(Character.EXTRA_TORSO, 0);
        int pants = intent.getIntExtra(Character.EXTRA_PANTS, 0);

        ViewPager viewPager = findViewById(R.id.viewPager);
        GameFragmentPagerAdapter adapter = new GameFragmentPagerAdapter(getSupportFragmentManager(), head, torso, pants);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

}
