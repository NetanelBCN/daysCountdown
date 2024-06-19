package dev.netanelbcn.commonmanager.Model;

import android.net.Uri;

public class Position {

   private String currentPhoto;
   private int daysNum;
   private int photoIndex;

    public int getPhotoIndex() {
        return photoIndex;
    }

    public Position setPhotoIndex(int photoIndex) {
        this.photoIndex = photoIndex;
        return this;
    }

    public Position() {
    }

    public String getCurrentPhoto() {
        return currentPhoto;
    }

    public Position setCurrentPhoto(String currentPhoto) {
        this.currentPhoto = currentPhoto;
        return this;
    }

    public int getDaysNum() {
        return daysNum;
    }

    public Position setDaysNum(int daysNum) {
        this.daysNum = daysNum;
        return this;
    }
}
