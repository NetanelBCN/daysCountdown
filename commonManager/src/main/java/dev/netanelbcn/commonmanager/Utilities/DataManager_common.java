package dev.netanelbcn.commonmanager.Utilities;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import dev.netanelbcn.commonmanager.Model.Position;

public class DataManager_common {

    private Position position;
    private ArrayList<String> photosURI;


    public DataManager_common setPosition(Position position) {
        this.position = position;
        return this;
    }

    public ArrayList<String> getPhotosURI() {
        return photosURI;
    }

    public DataManager_common setPhotosURI(ArrayList<String> photosURI) {
        this.photosURI = photosURI;
        return this;
    }

    public DataManager_common() {
    }


    public Position convertJSONToPosition(String json) {
        return new Gson().fromJson(json, new TypeToken<Position>() {
        }.getType());
    }

    public void loadData() {
        this.position = convertJSONToPosition(SharedPreferencesManager.getInstance().getString("position", null));
        if (this.position == null) {
            this.position = new Position();
            position.setCurrentPhoto("").setDaysNum(0).setPhotoIndex(0);
        }
    }

    public String convertPositionToJSON() {
        return new Gson().toJson(this.position);
    }

    public void saveData() {
        String json = convertPositionToJSON();
        SharedPreferencesManager.getInstance().putString("position", json);
    }


    public Position getPosition() {
        return position;
    }
}
