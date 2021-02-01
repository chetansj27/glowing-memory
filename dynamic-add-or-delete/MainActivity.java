package com.example.skills;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView clearButton;
    AutoCompleteTextView editSkill;
    ArrayAdapter adapter;

    ArrayList<String> skills = new ArrayList<>(Arrays.asList("Android ", "java", "IOS", "SQL", "JDBC", "Web services"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);
        editSkill = findViewById(R.id.editText);
        clearButton = findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSkill.getText().clear();
            }
        });
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, skills);

        editSkill.setAdapter(adapter);

        editSkill.setThreshold(1);

        editSkill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String skillName = parent.getItemAtPosition(position).toString();
                addSkill(skillName);
                editSkill.getText().clear();
            }
        });


    }
// add
    public void addSkill(String skillName) {
        View addView = getLayoutInflater().inflate(R.layout.skills_add, null, false);
        Button skillButton = addView.findViewById(R.id.skillButton);
        ImageView crossButton = addView.findViewById(R.id.crossButton);

        skillButton.setText(skillName);
        //skills.remove(skillName);
        //adapter.notifyDataSetChanged();


        crossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeSkill(addView);
            }
        });
        linearLayout.addView(addView);

    }
    //remove

    public void removeSkill(View view) {
        linearLayout.removeView(view);
    }


}
