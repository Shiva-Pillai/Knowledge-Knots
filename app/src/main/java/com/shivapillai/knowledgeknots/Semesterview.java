package com.shivapillai.knowledgeknots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Semesterview extends AppCompatActivity {

    CardView one,two,three,four,five,six,seven,eight;
    String path,branch_sem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesterview);

        Intent intent = getIntent();

        path = intent.getStringExtra("Branch");
        branch_sem = intent.getStringExtra("Ano");


        one = (CardView) findViewById(R.id.Ist);
        two = (CardView) findViewById(R.id.IInd);
        three = (CardView) findViewById(R.id.IIIrd);
        four = (CardView) findViewById(R.id.IVth);
        five = (CardView) findViewById(R.id.Vth);
        six = (CardView) findViewById(R.id.VIth);
        seven = (CardView) findViewById(R.id.VIIth);
        eight = (CardView) findViewById(R.id.VIIIth);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"Ist/");
                intent.putExtra("Branch_sem",branch_sem + " Ist");
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"IInd/");
                intent.putExtra("Branch_sem",branch_sem + " IInd");
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"IIIrd/");
                intent.putExtra("Branch_sem",branch_sem + " IIIrd");
                startActivity(intent);
            }
        });


        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"IVth/");
                intent.putExtra("Branch_sem",branch_sem + " IVth");
                startActivity(intent);
            }
        });


        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"Vth/");
                intent.putExtra("Branch_sem",branch_sem + " Vth");
                startActivity(intent);
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"VIth/");
                intent.putExtra("Branch_sem",branch_sem + " VIth");
                startActivity(intent);
            }
        });


        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"VIth/");
                intent.putExtra("Branch_sem",branch_sem + " VIIth");
                startActivity(intent);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Semesterview.this,View_server_files.class);
                intent.putExtra("Sem",path+"VIth/");
                intent.putExtra("Branch_sem",branch_sem + " VIIIth");
                startActivity(intent);
            }
        });
    }
}
