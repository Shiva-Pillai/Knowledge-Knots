package com.shivapillai.knowledgeknots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Branch_Names extends AppCompatActivity {

    CardView auto,cs,it,ec,ex,mech;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch__names);

        auto = (CardView) findViewById(R.id.auto_branch);
        cs = (CardView) findViewById(R.id.cs_branch);
        it = (CardView) findViewById(R.id.it_branch);
        ec = (CardView) findViewById(R.id.ec_branch);
        ex = (CardView) findViewById(R.id.ex_branch);
        mech = (CardView) findViewById(R.id.mech_branch);

        Intent val = getIntent();
        path = val.getStringExtra("Choice");

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Branch_Names.this,Semesterview.class);
                intent.putExtra("Branch",path+"Automobile/");
                intent.putExtra("Ano","Automobile");
                startActivity(intent);
            }
        });

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Branch_Names.this,Semesterview.class);
                intent.putExtra("Branch",path+"Computer Science/");
                intent.putExtra("Ano","Computer Science");
                startActivity(intent);
            }
        });

        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Branch_Names.this,Semesterview.class);
                intent.putExtra("Branch",path+"Electrical/");
                intent.putExtra("Ano","Electrical");
                startActivity(intent);
            }
        });


        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Branch_Names.this,Semesterview.class);
                intent.putExtra("Branch",path+"Electronics/");
                intent.putExtra("Ano","Electronics");
                startActivity(intent);
            }
        });


        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Branch_Names.this,Semesterview.class);
                intent.putExtra("Branch",path+"Information Technology/");
                intent.putExtra("Ano","Information Technology");
                startActivity(intent);
            }
        });


        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Branch_Names.this,Semesterview.class);
                intent.putExtra("Branch",path+"Mechanical/");
                intent.putExtra("Ano","Mechanical");
                startActivity(intent);
            }
        });

    }
}