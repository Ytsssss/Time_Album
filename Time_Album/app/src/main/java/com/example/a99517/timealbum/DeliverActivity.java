package com.example.a99517.timealbum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by 99517 on 2016/12/20.
 */

public class DeliverActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        Intent intent=getIntent();
        String a= intent.getStringExtra("photo");
        Toast.makeText(DeliverActivity.this,a,Toast.LENGTH_SHORT).show();
    }
}
