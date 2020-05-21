package com.example.dragonhunt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Status extends Fragment {

    private static final String KEY_HEAD = "KEY_HEADB";
    private static final String KEY_TORSO = "KEY_TORSOB";
    private static final String KEY_PANTS = "KEY_PANTSB";
    int bHead;
    int bTorso;
    int bPants;
    public static Status newInstance(int head, int torso, int pants) {
        Bundle bundle = new Bundle();
        Status fragment = new Status();
        bundle.putInt(KEY_HEAD, head);
        bundle.putInt(KEY_PANTS, pants);
        bundle.putInt(KEY_TORSO, torso);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_status, container, false);

        bHead = getArguments().getInt(KEY_HEAD);
        bTorso = getArguments().getInt(KEY_TORSO);
        bPants = getArguments().getInt(KEY_PANTS);

        ImageView imageHead = rootView.findViewById(R.id.headStat);
        imageHead.setImageResource(bHead);
        ImageView imageTorso = rootView.findViewById(R.id.torsoStat);
        imageTorso.setImageResource(bTorso);
        ImageView imagePants = rootView.findViewById(R.id.pantsStat);
        imagePants.setImageResource(bPants);

        return rootView;
    }
}
