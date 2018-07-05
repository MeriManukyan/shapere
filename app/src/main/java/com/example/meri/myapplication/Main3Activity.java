package com.example.meri.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    EditText editText,editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText=findViewById(R.id.editText3);
        editText1=findViewById(R.id.editText2);
        Button b=findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editText1.getText().toString()).equals(loadText())){
                saveText();
                finish();
                }
            }
        });

    }
    void saveText() {
        sPref = getSharedPreferences("key",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, editText.getText().toString());
        ed.commit();
    }

    String loadText() {
        sPref = getSharedPreferences("key",MODE_PRIVATE);
        return sPref.getString(SAVED_TEXT,"12345");
    }
}
