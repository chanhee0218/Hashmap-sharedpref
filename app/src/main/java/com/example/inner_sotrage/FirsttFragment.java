package com.example.inner_sotrage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FirstFragment extends Fragment {
    EditText editText;
    Button button;
    String editString;
    //HashMap <String, String> hashMap;
    Set<String> set= new HashSet<String>();
    int key=0;
    int value=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_firstt_fragment,container,false);
        Context context=getContext();
        editText=view.findViewById(R.id.sharedEdit);
        button=view.findViewById(R.id.sharedPushBtn);
        final Intent intent=new Intent(context,MainActivity.class);
        editString=editText.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editString.getBytes().length>0){
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Note",Context.MODE_PRIVATE);
                    Editor editor=sharedPreferences.edit();
                    editor.putString(Integer.toString(key),editString);
                    set.add(editString);
                    set=sharedPreferences.getStringSet(editString,null);
                    intent.putExtra("hashsset", (Parcelable) set);
                    startActivity(intent);

                }
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
