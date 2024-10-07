package com.sandipawale.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sandipawale.admincollegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
        FloatingActionButton fab;
        private RecyclerView csDepartment,meDepartment,phyDepartment,chemistrydapartment;
        private LinearLayout csNoData,meNoData,phyNoData,chemistryNoData;
        private List list1,list2,list3,list4;
        private DatabaseReference reference,dbRef;
        private TeacherAdapter adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_update_faculty);
            chemistrydapartment=findViewById(R.id.chemistryDepartment);
            meDepartment=findViewById(R.id.meDepartment);
            csDepartment=findViewById(R.id.csDepartment);
            phyDepartment=findViewById(R.id.phyDepartment);

            chemistryNoData=findViewById(R.id.chemistryNoDepartment);
            meNoData=findViewById(R.id.meNoData);
            csNoData=findViewById(R.id.csNoData);
            phyNoData=findViewById(R.id.phyNoData);


            reference= FirebaseDatabase.getInstance().getReference().child("faculty");
            csDepartment();
            mechanicalDepartment();
            physicsDepartment();
            chemistryDepartment();
            fab = findViewById(R.id.fab);

    fab.setOnClickListener(new View.OnClickListener() {
           @Override
       public void onClick(View view) {
                 startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
           });
        }

    private void csDepartment() {
            dbRef=reference.child("Computer Science");
            dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list1=new ArrayList<>();
                    if (!snapshot.exists()){
                        csNoData.setVisibility(View.VISIBLE);
                        csDepartment.setVisibility(View.GONE);
                    }else{
                        csNoData.setVisibility(View.GONE);
                        csDepartment.setVisibility(View.VISIBLE);
                        for(DataSnapshot snapshot1:snapshot.getChildren()) {
                            TeacherData data = snapshot1.getValue(TeacherData.class);
                            list1.add(data);
                        }
                        csDepartment.setHasFixedSize(true);
                        csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                        adapter=new TeacherAdapter(list1,UpdateFaculty.this);
                        csDepartment.setAdapter(adapter);
                        }
                    }



                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void mechanicalDepartment() {
        dbRef=reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if (!snapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else{
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list2,UpdateFaculty.this);
                    meDepartment.setAdapter(adapter);
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void physicsDepartment() {
        dbRef=reference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if (!snapshot.exists()){
                    phyNoData.setVisibility(View.VISIBLE);
                    phyDepartment.setVisibility(View.GONE);
                }else{
                    phyNoData.setVisibility(View.GONE);
                    phyDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    phyDepartment.setHasFixedSize(true);
                    phyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list3,UpdateFaculty.this);
                    phyDepartment.setAdapter(adapter);
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemistryDepartment() {
        dbRef=reference.child("Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if (!snapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistrydapartment.setVisibility(View.GONE);
                }else{
                    chemistryNoData.setVisibility(View.GONE);
                    chemistrydapartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot1:snapshot.getChildren()) {
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    chemistrydapartment.setHasFixedSize(true);
                    chemistrydapartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list4,UpdateFaculty.this);
                    chemistrydapartment.setAdapter(adapter);
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}