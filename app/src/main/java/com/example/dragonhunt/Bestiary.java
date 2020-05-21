package com.example.dragonhunt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Bestiary extends Fragment {

    private RecyclerView mRecyclerView;
    private DescriptionAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bestiary, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.descRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList<Description> descriptions = new ArrayList<>();
        descriptions.add(new Description(R.drawable.skeleton, "Skeleton", "Skeletons are the reanimated bones of once-living creatures and are a type of derived undead. \nATK: 20 | DEF: 5 | SPD: 7"));
        descriptions.add(new Description(R.drawable.zombie, "Zombie", "Undead zombies move with a jerky, uneven gait. They are clad in the moldering apparel and stink. \nATK: 10 | DEF: 2 | SPD: 2"));
        descriptions.add(new Description(R.drawable.shark, "Shark", "Sharks surround the fallen lands. They are the primal predator of these seas, always ready to bite. \nATK: 25 | DEF: 4 | SPD: 14"));
        descriptions.add(new Description(R.drawable.fairy, "Fairy", "Pure fairies that have fallen to the corruption of these lands. They poison you with their magic.  \nATK: 25 | DEF: 5 | SPD: 10"));
        descriptions.add(new Description(R.drawable.bandit, "Bandit", "A human that has fallen beneath the law. They are foolish beings that may have a unkind, tragic past. \nATK: 9 | DEF: 10 | SPD: 4"));
        descriptions.add(new Description(R.drawable.troll, "Troll", "Stay away from these creatures. They are not something a mere mortal can take down alone. \nATK: 40 | DEF: 54 | SPD: 1"));
        descriptions.add(new Description(R.drawable.ghost, "Ghost", "Ghosts represent a fallen soul. Some come in spite of the living world while others try to help. \nATK: 20 | DEF: 0 | SPD: 5"));
        descriptions.add(new Description(R.drawable.dragon, "Vainqueur the Dragon", "The absolute pinnacle of all species on this plane of existence. Get ready for the fight of your life! \nATK: 204 | DEF: 104 | SPD: 400"));
        mAdapter = new DescriptionAdapter(descriptions);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }
}
