package com.example.dragonhunt;

public class Description {
    private int mImageViewID;
    private String mNameOfDescription;
    private String mActualDescription;

    public Description(int imageViewID, String nameOfDescription, String actualDescription){
        mActualDescription = actualDescription;
        mImageViewID = imageViewID;
        mNameOfDescription = nameOfDescription;
    }
    public String getNameOfDescription(){
        return mNameOfDescription;
    }
    public void setNameOfDescription(String newName){
        mNameOfDescription = newName;
    }
    public String getActualDescription(){
        return mActualDescription;
    }
    public void setActualDescription(String newDesc){
        mActualDescription = newDesc;
    }
    public int getImageViewID(){
        return mImageViewID;
    }
    public void setmImageViewID(int newID){
        mImageViewID = newID;
    }

}
