package dev.netanelbcn.commonmanager.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import dev.netanelbcn.commonmanager.Model.Position;
import dev.netanelbcn.commonmanager.Utilities.DataManager_common;
import dev.netanelbcn.commonmanager.Utilities.SharedPreferencesManager;

public class LogicManager_Common {

    private Position position;
    private ArrayList<String> photosURI;


    public ArrayList<String> getPhotosURI() {
        return photosURI;
    }


    public LogicManager_Common(DataManager_common dataManagerCommon) {
        this.photosURI = dataManagerCommon.getPhotosURI();
        this.position=new Position();

    }


    public void nextPhoto() {
        if (getPosition().getPhotoIndex() ==getPhotosURI().size() - 1) {
            getPosition().setPhotoIndex(0);
            getPosition().setCurrentPhoto(getPhotosURI().get(0));

        } else {
            getPosition().setPhotoIndex(getPosition().getPhotoIndex() + 1);
            getPosition().setCurrentPhoto(getPhotosURI().get(getPosition().getPhotoIndex()));
        }
        saveData();

    }

    public Position convertJSONToPosition(String json) {
        return new Gson().fromJson(json, new TypeToken<Position>() {
        }.getType());
    }

    public void loadData() {
        this.position = convertJSONToPosition(SharedPreferencesManager.getInstance().getString("position", null));
        if (this.position == null) {
            this.position = new Position();
            position.setCurrentPhoto(this.photosURI.get(position.getPhotoIndex())).setDaysNum(0).setPhotoIndex(0);
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

    public void previousPhoto() {
        if (getPosition().getPhotoIndex() == 0)
            getPosition().setPhotoIndex(getPhotosURI().size() - 1);
        else
            getPosition().setPhotoIndex(getPosition().getPhotoIndex() - 1);
        saveData();

    }

    public void decreaseDays() {
        if (getPosition().getDaysNum() >0)
            getPosition().setDaysNum(getPosition().getDaysNum() - 1);
        saveData();

    }

    public void zeroDays() {

        getPosition().setDaysNum(0);
        saveData();

    }

    public void increaseDays() {
        getPosition().setDaysNum(getPosition().getDaysNum() + 1);
        saveData();
    }


}
