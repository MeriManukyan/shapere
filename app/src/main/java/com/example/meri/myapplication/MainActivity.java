package com.example.meri.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText editText;
EditText editText1;
SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    final  String key="key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        Button b=findViewById(R.id.button);
        editText1=findViewById(R.id.editText2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editText.getText().toString()).equals(loadText())){
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);}
            }
        });
        Button b1=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
            }
        });
    }
    void saveText() {
        sPref = getSharedPreferences("key",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT,editText1.getText().toString());
        ed.commit();

    }

    String  loadText() {
        sPref = getSharedPreferences("key",MODE_PRIVATE);
        return sPref.getString(SAVED_TEXT, "12345");
    }
}

