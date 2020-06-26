package com.example.inner_sotrage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    EditText editText;
    Button PushBtn;
    TextView checkText;
    private static final int key=0;
    HashMap<Integer, String> hashMap;
    String content;
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        content=editText.getText().toString();
        PushBtn = findViewById(R.id.PushBtn);
        checkText = findViewById(R.id.checkTxt);


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        SharedPreferences sharedPreferences=getSharedPreferences("sFile",key);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.first: {

                        PushBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(content.getBytes().length<=0){
                                    Toast.makeText(MainActivity.this, "내용을 입력 해주세요", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Hash_map(content,key);
                                    cnt++;
                                }
                            }
                        });
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
    public HashMap<Integer, String> Hash_map(String value, int hashcode){
        hashMap=new HashMap<Integer,String>();
        String receive=content;
        int hash_code=cnt;
        SharedPreferences sharedPreferences= getSharedPreferences("Sfile",MODE_PRIVATE);
        sharedPreferences.edit().putString(receive, Integer.toString(hash_code)).apply();
        hashMap.put(hash_code,receive);

        return hashMap;
    }

}

