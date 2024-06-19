package dev.netanelbcn.managemyteam;

import android.os.Bundle;
import dev.netanelbcn.commonmanager.View.MainActivity;

public class KidMainActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerCommon = new KidDataManager();
        super.onCreate(savedInstanceState);


    }
}