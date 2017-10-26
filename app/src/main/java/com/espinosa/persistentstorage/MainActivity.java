package com.espinosa.persistentstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    Button btnSaveInfo, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = (EditText) findViewById(R.id.field_username);
        etPassword = (EditText) findViewById(R.id.field_password);
        btnSaveInfo = (Button) findViewById(R.id.btn_saveInfo);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.displayText);

        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUserName.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Save in Shared Preferences", Toast.LENGTH_LONG).show();
    }

    public void loadInfo(View view) {
        String user = preferences.getString("username", "");
        String password = preferences.getString("password", "");
        tvDisplay.setText("User is " + user + " and the password is " + password);
    }


}
