package com.shivapillai.knowledgeknots;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_server_files extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    List<Information_of_upload_docs> uploadPDFS;

    String path,branch_sem;
    TextView branch_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_server_files);


        Intent intent = getIntent();

        branch_name = (TextView)findViewById(R.id.branch_sem);
        branch_sem = intent.getStringExtra("Branch_sem");
        path = intent.getStringExtra("Sem");

        branch_name.setText(branch_sem);


        recyclerView = findViewById(R.id.recycler_view_server_files);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);



        //////////////////////////////////////////////////////

        uploadPDFS = new ArrayList<>();

        // Function to view all the files in ListView present in database
        viewAllfiles();

        // Function to download the file on clicking

    }

    private void viewAllfiles() {

        databaseReference = FirebaseDatabase.getInstance().getReference(path);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren())
                {
                    Information_of_upload_docs uploadPDF = postSnapshot.getValue(com.shivapillai.knowledgeknots.Information_of_upload_docs.class);
                    uploadPDFS.add(uploadPDF);
                }

                // To Fetch the Names of PDF Files that are stored in array of objects uploadPDFS

                String[] upload = new String[uploadPDFS.size()];

                // Now looping to store the names of files in upload array

                for (int i=0;i<upload.length;i++)
                {
                    upload[i] = uploadPDFS.get(i).getFile_name();
                }

                MyAdapter adapter = new MyAdapter(uploadPDFS);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"Nothing to Display",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
