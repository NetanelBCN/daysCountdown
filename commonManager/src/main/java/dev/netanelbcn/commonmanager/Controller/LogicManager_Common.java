package dev.netanelbcn.commonmanager.Controller;

import dev.netanelbcn.commonmanager.Utilities.DataManager_common;

public class LogicManager_Common {

    private DataManager_common dataManagerCommon;

    public LogicManager_Common(DataManager_common dataManagerCommon) {
        this.dataManagerCommon = dataManagerCommon;
    }

    public void nextPhoto() {
        if (dataManagerCommon.getPosition().getPhotoIndex() == dataManagerCommon.getPhotosURI().size() - 1)
            dataManagerCommon.getPosition().setPhotoIndex(0);
        else
            dataManagerCommon.getPosition().setPhotoIndex(dataManagerCommon.getPosition().getPhotoIndex() + 1);
        dataManagerCommon.saveData();

    }

    public void previousPhoto() {
        if (dataManagerCommon.getPosition().getPhotoIndex() == 0)
            dataManagerCommon.getPosition().setPhotoIndex(dataManagerCommon.getPhotosURI().size() - 1);
        else
            dataManagerCommon.getPosition().setPhotoIndex(dataManagerCommon.getPosition().getPhotoIndex() - 1);
        dataManagerCommon.saveData();

    }

    public void decreaseDays() {
        if (dataManagerCommon.getPosition().getDaysNum() >= 0)
            dataManagerCommon.getPosition().setDaysNum(dataManagerCommon.getPosition().getDaysNum() - 1);
        dataManagerCommon.saveData();

    }

    public void zeroDays() {

        dataManagerCommon.getPosition().setDaysNum(0);
        dataManagerCommon.saveData();

    }

    public void increaseDays() {
        dataManagerCommon.getPosition().setDaysNum(dataManagerCommon.getPosition().getDaysNum() + 1);
        dataManagerCommon.saveData();
    }


}
