package com.example.demo9_perference;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;

public class SettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.second_setting);

    }
}
