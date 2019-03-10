package com.gzeinnumer.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.read)
    TextView read;
    @BindView(R.id.editNama)
    EditText editNama;

    String fileName = "myFile";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                saveData();
                break;
            case R.id.btn2:
                readData();
                break;
        }
    }

    private void saveData() {
        String strName = editNama.getText().toString();
        SharedPreferences shared = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("name", strName);
        editor.commit();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    private void readData() {
        SharedPreferences shared = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String defaultValue = "default";
        name = shared.getString("name",defaultValue);
        read.setText(name);
        Toast.makeText(this, "Readed", Toast.LENGTH_SHORT).show();
    }
}
