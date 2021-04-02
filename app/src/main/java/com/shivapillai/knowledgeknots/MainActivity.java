package com.shivapillai.knowledgeknots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView notes,ques_paper,my_notes,upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notes = (CardView) findViewById(R.id.Notes);
        ques_paper = (CardView) findViewById(R.id.Question_paper);
        my_notes = (CardView) findViewById(R.id.Download_notes);
        upload = (CardView) findViewById(R.id.upload_notes);

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Branch_Names.class);
                intent.putExtra("Choice","Notes/");
                Toast.makeText(MainActivity.this,"Notes Clicked",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        ques_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Branch_Names.class);
                intent.putExtra("Choice","Ques_paper");
                Toast.makeText(MainActivity.this,"Question Papers Clicked",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Upload_Documents.class);
                Toast.makeText(MainActivity.this,"Upload Documents Clicked",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        my_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Downloaded_notes.class);
                Toast.makeText(MainActivity.this,"My Notes Clicked",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}
