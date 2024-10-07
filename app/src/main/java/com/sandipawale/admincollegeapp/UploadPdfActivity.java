package com.sandipawale.admincollegeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class UploadPdfActivity extends AppCompatActivity {
    /*
    private CardView addPdf;
    private final int REQ = 1;
    private ImageView noticeImageView;
    private Uri pdfData;
    private EditText pdfTitle;
    private TextView pdfTextView;
    private String pdfName,title;
    private Button uploadPdfBtn;
    private DatabaseReference databasereference;
    private StorageReference storagereference;
    String downloadUrl = "";

    private ProgressDialog pd;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_pdf);/*
        databasereference = FirebaseDatabase.getInstance().getReference();
        storagereference = FirebaseStorage.getInstance().getReference();
        pd = new ProgressDialog(this);
        pdfTitle = findViewById(R.id.pdfTitle);
        uploadPdfBtn = findViewById(R.id.uploadPdfBtn);
        pdfTextView=findViewById(R.id.pdfTextView);
        addPdf = findViewById(R.id.addPdf);

        addPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        uploadPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title=pdfTitle.getText().toString();
                if (title.isEmpty()){
                    pdfTitle.setError("Empty");
                    pdfTitle.requestFocus();

                }else if(pdfData==null){
                    Toast.makeText(UploadPdfActivity.this, "Please Upload pdf", Toast.LENGTH_SHORT).show();

                }else {
                    uploadPdf();
                }
            }
        });
    }

    private void uploadPdf() {

        pd.setTitle("Please wait....");
        pd.setMessage("Uploading Pdf");
        pd.show();
        StorageReference reference= StorageReference.child("pdf/"+pdfName+"-"+System.currentTimeMillis()+".pdf");
        reference.putFile(pdfData)
                .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        Task<Uri> uriTask=task.getStorage().getDownloadUrl();
                        while (uriTask.isComplete());
                        Uri uri=uriTask.getResult();
                        uploadData(String.valueOf(uri));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(UploadPdfActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void uploadData(String valueOf) {
        String uniqueKey=databasereference.child("pdf").push().getKey();
        HashMap data =new HashMap();
        data.put("pdfTitle","");
        data.put("pdfUrl",downloadUrl);

        databasereference.child("pdf").child(uniqueKey).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task task) {
                pd.dismiss();
                Toast.makeText(UploadPdfActivity.this, "Pdf Uploaded Successfully", Toast.LENGTH_SHORT).show();
                pdfTitle.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UploadPdfActivity.this, "Failed To Upload Pdf", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void openGallery() {
        Intent intent=new Intent();
        intent.setType("pdf/docs/ppt");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select pdf file"),REQ);

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == REQ && requestCode == RESULT_OK){
              pdfData=data.getData();
              if (pdfData.toString().startsWith("content://")) {
                  try {
                      Cursor cursor = null;
                      cursor = UploadPdfActivity.this.getContentResolver().query(pdfData, null, null, null, null);
                      if (cursor != null && cursor.moveToFirst()) {
                          pdfName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                      }
                  } catch (Exception e) {
                      e.printStackTrace();
                  }

              }else if (pdfData.toString().startsWith("file://")){
                  pdfName=new File(pdfData.toString()).getName();

              }
              pdfTextView.setText(pdfName);
            }*/
        }
    }
