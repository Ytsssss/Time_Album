package com.example.a99517.timealbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVOSCloud;
import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    com.getbase.floatingactionbutton.FloatingActionButton takephoto,getphoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
     }

    private void initEvent() {
        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DeliverActivity.class);
                intent.putExtra("photo","takephoto");
                startActivity(intent);
            }
        });
        getphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DeliverActivity.class);
                intent.putExtra("photo","getphoto");
                startActivity(intent);
            }
        });
    }

    private void initView() {
        takephoto= (FloatingActionButton) findViewById(R.id.btn_main_takephoto);
        getphoto= (FloatingActionButton) findViewById(R.id.btn_main_getphoto);
    }
}
