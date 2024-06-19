package dev.netanelbcn.commonmanager.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import dev.netanelbcn.commonmanager.Controller.LogicManager_Common;
import dev.netanelbcn.commonmanager.R;
import dev.netanelbcn.commonmanager.Utilities.DataManager_common;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_left;
    private ShapeableImageView main_pic;
    private MaterialButton main_right;
    private MaterialButton main_decrease;
    private MaterialButton main_zero;
    private MaterialButton main_increase;
    private MaterialTextView main_daysBar;

    protected DataManager_common dataManagerCommon;

    private LogicManager_Common logicManagerCommon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        logicManagerCommon = new LogicManager_Common(dataManagerCommon);
        logicManagerCommon.loadData();
        refreshUI();
        attachListeners();

    }

    private void refreshUI() {
        Glide.with(this)
                .load(
                        logicManagerCommon.getPhotosURI().get(logicManagerCommon.getPosition().getPhotoIndex()))
                .placeholder(R.drawable.ic_launcher_background)
                .into(main_pic);
        main_daysBar.setText(logicManagerCommon.getPosition().getDaysNum() + "");
    }

    private void attachListeners() {
        main_left.setOnClickListener(v -> {
            logicManagerCommon.nextPhoto();
            refreshUI();
        });
        main_right.setOnClickListener(v -> {
            logicManagerCommon.previousPhoto();
            refreshUI();
        });
        main_increase.setOnClickListener(v -> {
            logicManagerCommon.increaseDays();
            refreshUI();
        });

        main_decrease.setOnClickListener(v -> {
            logicManagerCommon.decreaseDays();
            refreshUI();
        });
        main_zero.setOnClickListener(v -> {
            logicManagerCommon.zeroDays();
            refreshUI();
        });
    }

    private void findViews() {
        main_left = findViewById(R.id.main_left);
        main_pic = findViewById(R.id.main_pic);
        main_right = findViewById(R.id.main_right);
        main_decrease = findViewById(R.id.main_decrease);
        main_zero = findViewById(R.id.main_zero);
        main_increase = findViewById(R.id.main_increase);
        main_daysBar = findViewById(R.id.main_daysBar);
    }
}