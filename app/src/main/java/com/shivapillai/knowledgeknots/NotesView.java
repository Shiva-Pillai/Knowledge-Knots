package com.shivapillai.knowledgeknots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NotesView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        Intent intent = getIntent();
        String path = intent.getStringExtra("Sem");

        TextView p = findViewById(R.id.path);
        p.setText(path);
    }
}
