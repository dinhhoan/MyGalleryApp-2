package com.example.mygalleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;

public class FullImageActivity extends AppCompatActivity {

    int position;
    ImageView imageView;
    String imageLink;
     ArrayList<File>myImage;

    FloatingActionButton prebuttonfab,nextbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);


        imageView=findViewById(R.id.fullImageViewId);
        prebuttonfab=findViewById(R.id.previoursfabId);
         nextbutton=findViewById(R.id.nextfabId);

        Bundle bundle= getIntent().getExtras();
        if (bundle !=null){
            myImage=(ArrayList) bundle.getParcelableArrayList("imageList");
             position=   bundle.getInt("pos",0);
            imageLink=  bundle.getString("image");

        }


        imageView.setImageURI(Uri.parse(imageLink));



        prebuttonfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                position=((position -1 )<0)? (myImage.size()-1) :(position-1);
                imageView.setImageURI(Uri.parse(myImage.get(position).toString()));


            }
        });


        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                position = ((position + 1) % myImage.size());
                imageView.setImageURI(Uri.parse(myImage.get(position).toString()));


            }
        });


    }
}
