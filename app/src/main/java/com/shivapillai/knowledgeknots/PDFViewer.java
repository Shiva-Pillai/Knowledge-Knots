package com.shivapillai.knowledgeknots;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PDFViewer extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        pdfView = findViewById(R.id.pdf);
        String path  = getIntent().getStringExtra("Path");
        Toast.makeText(getApplicationContext(),path,Toast.LENGTH_SHORT).show();
        File file = new File(path);
        pdfView.fromFile(file).load();
        pdfView.recycle();
    }
}
