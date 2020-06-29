package com.example.inner_sotrage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class RecyclerView extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList <String> arrayList;
    HashSet<String> hashSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        Intent hashintent=getIntent();
        arrayList= (ArrayList<String>) intent.getSerializableExtra("hashset");
        hashSet= (HashSet<String>) hashintent.getSerializableExtra("arrset");
        recyclerViewAdapter=new RecyclerViewAdapter(arrayList,hashSet);

        if(arrayList.size()!=0){
            Toast.makeText(recyclerView, "값이 저장되지 않았습니다. ", Toast.LENGTH_SHORT).show();
        }else{

        }

        super.onCreate(savedInstanceState);

    }



}
