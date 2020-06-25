package com.example.inner_sotrage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    EditText editText;
    Button PushBtn;
    TextView checkText;
    private static final int key=0;
    HashMap<Integer, String> hashMap;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        content=editText.getText().toString();
        PushBtn = findViewById(R.id.PushBtn);
        checkText = findViewById(R.id.checkTxt);
        hashMap=new HashMap<Integer,String>();
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        SharedPreferences sharedPreferences=getSharedPreferences("sFile",key);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.first: {
                        if(content.getBytes().length<=0){
                            Toast.makeText(MainActivity.this, "내용을 입력 해주세요", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            for(int i=0;i<30;i++){
                                hashMap.put(key, content);
                                i++;
                            }
                        }

                    }
                    case R.id.second: {
                        Toast.makeText(MainActivity.this, "두번쨰 화면", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.third: {
                        Toast.makeText(MainActivity.this, "세번쨰 화면", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return false;
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences= getSharedPreferences("Sfile",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

    }
}

