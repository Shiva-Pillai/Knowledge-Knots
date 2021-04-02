package com.shivapillai.knowledgeknots;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class Upload_Documents extends AppCompatActivity{
    EditText pdfname,sub_name,topics,ch_no;
    Button upload;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    Spinner sp_branch,sp_sem;
    String branch,sem,path;

    String file_name,subject_name,cp_no,top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload__documents);

        pdfname = (EditText) findViewById(R.id.et_pdf_name);
        sub_name = (EditText) findViewById(R.id.et_sub_name);
        ch_no = (EditText) findViewById(R.id.et_ch_num);
        topics = (EditText) findViewById(R.id.et_topic);
        upload = (Button) findViewById(R.id.btn_upload);

        sp_branch = (Spinner) findViewById(R.id.spinner_branch);
        sp_sem = (Spinner) findViewById(R.id.spinner_sem);


        ArrayAdapter<CharSequence> branch_adapter =  ArrayAdapter.createFromResource(this,R.array.Branch_array,android.R.layout.simple_spinner_item);
        branch_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_branch.setAdapter(branch_adapter);

        sp_branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                branch = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Upload_Documents.this,"Cannot be Empty",Toast.LENGTH_SHORT).show();
                return;
            }
        });


        ArrayAdapter<CharSequence> sem_adapter =  ArrayAdapter.createFromResource(this,R.array.Semester_array,android.R.layout.simple_spinner_item);
        sem_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp_sem.setAdapter(sem_adapter);


        sp_sem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                sem = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Upload_Documents.this,"Cannot be Empty",Toast.LENGTH_SHORT).show();
                return;
            }
        });

        //creating a refernce or objects of firebase storage and firebase database class
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectPDFfile();

            }
        });
    }

    private void selectPDFfile(){

        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Pdf file"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData()!=null){

            uploadPDFFile(data.getData());
        }
    }

    // TO put the data to the firebase storage
    private void uploadPDFFile(Uri data) {


        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading ......");
        progressDialog.show();

        //file_name,subject_name,cp_no,top

        file_name = pdfname.getText().toString();
        subject_name = sub_name.getText().toString();
        cp_no = ch_no.getText().toString();
        top = topics.getText().toString();

        path = "Notes/"+branch+"/"+sem+"/";

        StorageReference reference = storageReference.child("uploads/"+pdfname.getText().toString()+".pdf");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());

                // URL of file in firebaseStrage is saved to url
                Uri url = uri.getResult();

                // All the respective values are saved to Model class object
                //uploadPDF uploadPDF = new uploadPDF(pdfname.getText().toString(),url.toString());

                Information_of_upload_docs docs = new Information_of_upload_docs(file_name,url.toString(),subject_name,top,cp_no);

                // To store the file in Realtime Database of Firebase using setValue
                databaseReference.child(path).child(databaseReference.push().getKey()).setValue(docs);
                Toast.makeText(Upload_Documents.this,"File Uploaded",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {

                double progress =  (100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded     "+(int)progress+" %");

            }
        });


    }


}

