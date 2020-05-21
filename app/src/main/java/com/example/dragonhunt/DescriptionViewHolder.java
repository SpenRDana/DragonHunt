package com.example.dragonhunt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DescriptionViewHolder extends RecyclerView.ViewHolder {
    private TextView mDescName;
    private TextView mDesc;
    private ImageView mImageID;
    private Description mDescription;

    public DescriptionViewHolder(View rootView){
        super(rootView);
        mDescName = rootView.findViewById(R.id.name);
        mDesc = rootView.findViewById(R.id.description);
        mImageID = rootView.findViewById((R.id.imageOfItem));
    }

    public void bindDescription(Description description){
        mDescription = description;
        mDescName.setText(mDescription.getNameOfDescription());
        mDesc.setText(mDescription.getActualDescription());
        mImageID.setImageResource(mDescription.getImageViewID());
    }
}
