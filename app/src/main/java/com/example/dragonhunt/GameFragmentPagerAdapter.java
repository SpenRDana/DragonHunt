package com.example.dragonhunt;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GameFragmentPagerAdapter extends FragmentPagerAdapter {
    private int mHead;
    private int mTorso;
    private int mPants;
    public GameFragmentPagerAdapter(FragmentManager fm, int head, int torso, int pants){
        super(fm);
        mHead = head;
        mTorso = torso;
        mPants = pants;
    }
    @Override
    public Fragment getItem(int position){
        if(position == 0)
            return new Movement();
        if(position == 1)
            return Status.newInstance(mHead, mTorso, mPants);
        if(position == 2)
            return new Interaction();
        else{
            return new Bestiary();
        }
    }
    @Override
    public int getCount(){
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position){
        if(position == 0)
            return "Map";
        else if (position == 1)
            return "Status";
        else if(position == 2)
            return "Interact";
        else
            return "Bestiary";
    }
}
