package com.example.a210.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageView;
    TextView username;
    TextView phone;
    TextView location;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        imageView = (ImageView) findViewById(R.id.img1);
        TextView username = (TextView) findViewById(R.id.username);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView location = (TextView) findViewById(R.id.location);

        Intent it = getIntent();
        int imageNumber = it.getIntExtra(("image"),0);
        if(imageNumber == 0){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.p1));
        }else if(imageNumber == 1){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.p2));
        }else if(imageNumber == 2){
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.p3));
        }
        username.setText(it.getStringExtra("title"));
        phone.setText(it.getStringExtra("desc"));
        location.setText(it.getStringExtra("location"));

    }
}
