package com.example.dragonhunt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BodyPartFragment extends Fragment {
    private static final String KEY_IMAGES = "image";
    private static final String KEY_PART = "bodypart";
    private int index = 0;

    public static BodyPartFragment newInstance(int[] images, String part){
        BodyPartFragment fragment = new BodyPartFragment();
        Bundle bundle = new Bundle();
        bundle.putIntArray(KEY_IMAGES, images);
        bundle.putString(KEY_PART, part);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final int[] arrayImage = getArguments().getIntArray(KEY_IMAGES);
        final ImageView bodypart = rootView.findViewById(R.id.middle);
        bodypart.setImageResource(arrayImage[index]);

        final String body = getArguments().getString(KEY_PART);

        final ImageButton right = rootView.findViewById(R.id.right);
        final ImageButton left = rootView.findViewById(R.id.left);
        View.OnClickListener BL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.right) {
                    if (arrayImage.length - 1 <= index) {
                        index = 0;
                    } else {
                        index++;
                    }
                    bodypart.setImageResource(arrayImage[index]);
                    onCharacterCreatedListener.onCharacterCreated(arrayImage[index], body);
                }
                else {
                    if (index == 0) {
                        index = arrayImage.length - 1;
                    } else {
                        index--;
                    }
                    bodypart.setImageResource(arrayImage[index]);
                    onCharacterCreatedListener.onCharacterCreated(arrayImage[index], body);
                }
            }
        };
        right.setOnClickListener(BL);
        left.setOnClickListener(BL);

        return rootView;
    }

    public interface OnCharacterCreatedListener{
        public void onCharacterCreated(int ID, String bodyID);
    }

    OnCharacterCreatedListener onCharacterCreatedListener;

    public void setOnCharacterCreatedListener(OnCharacterCreatedListener listener){
        this.onCharacterCreatedListener = listener;
    }
}
