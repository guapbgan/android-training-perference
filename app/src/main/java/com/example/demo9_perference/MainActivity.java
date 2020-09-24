package com.example.demo9_perference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.FileNameMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String FILENAME = "system_main.xml";
    private static final String KEY1 = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    //要有這個右上角的...才會出現
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("settings");//要有這個右上角的...才會出現
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences preferences = getSharedPreferences(FILENAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        EditText editText = findViewById(R.id.editText);
        switch (view.getId()){
            case R.id.button1:
                editor.putString(KEY1,editText.getText().toString());
                editor.apply();
                Toast.makeText(this, "preference saved", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                editText.setText(preferences.getString(KEY1, "default user"));

                break;
            case R.id.button3:
                editor.clear();
                editor.apply();//需apply才會修改內容
                Toast.makeText(this,  "setting cleared", Toast.LENGTH_LONG).show();
                break;

        }
    }
}