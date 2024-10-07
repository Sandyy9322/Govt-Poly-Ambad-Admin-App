package com.sandipawale.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sandipawale.admincollegeapp.faculty.AddTeacher;
import com.sandipawale.admincollegeapp.faculty.UpdateFaculty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView uploadNotice,addGalleryImage,addEbook,addFaculty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice=findViewById(R.id.addNotice);
        addGalleryImage=findViewById(R.id.addGalleryImage);
        addEbook=findViewById(R.id.addEbook);
        addFaculty=findViewById(R.id.addFaculty);



        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        addFaculty.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.addNotice:
                Intent intent=new Intent(MainActivity.this,UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage:
                Intent intent2=new Intent(MainActivity.this,UploadImage.class);
                startActivity(intent2);
                break;
            case R.id.addEbook:
                Intent intent3=new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent3);
                break;
            case R.id.addFaculty:
                Intent intent45 =new Intent(MainActivity.this,UpdateFaculty.class);
                startActivity(intent45);
                break;
        }
        }
}