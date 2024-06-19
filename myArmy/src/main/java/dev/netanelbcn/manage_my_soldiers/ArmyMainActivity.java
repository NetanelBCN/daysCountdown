package dev.netanelbcn.manage_my_soldiers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dev.netanelbcn.commonmanager.View.MainActivity;

public class ArmyMainActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerCommon = new ArmyDataManager();
        super.onCreate(savedInstanceState);
    }
}