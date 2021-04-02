package com.shivapillai.knowledgeknots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class Downloaded_notes extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Info_Downloaded_notes> info_downloaded_notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaded_notes);


        recyclerView = findViewById(R.id.recy_down_notes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        File file = Environment.getExternalStoragePublicDirectory("Knowledge Knots");

        if (file.exists())
        {
            info_downloaded_notes = new ArrayList<>();
            File[] files = file.listFiles();


            for(int i = 0; i <files.length;i++)
            {
                File fileobj = files[i];
                Info_Downloaded_notes temp = new Info_Downloaded_notes();

                temp.setName(fileobj.getName());
                temp.setPath(fileobj.getAbsolutePath());

                info_downloaded_notes.add(temp);
            }

            Adapter_for_Down_files adapter = new Adapter_for_Down_files(this,info_downloaded_notes);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
        else
        {
            Toast.makeText(Downloaded_notes.this,"No Files Downloaded Yet",Toast.LENGTH_SHORT);
        }


    }
}
