package com.example.a99517.timealbum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;

/**
 * Created by 99517 on 2016/12/19.
 */

public class LeadingActivity extends Activity{
    Button login,signup;
    AVUser currentuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AVOSCloud.initialize(this, "E74U6UKQl8kFXXVfbBucy6y9-gzGzoHsz", "KcVAsT5UIkpxrNxw1I8NFn0V");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leading);

        currentuser=AVUser.getCurrentUser();
        if (currentuser!=null){
            Intent intent=new Intent(LeadingActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        initView();//初始化Button控件
        initEvent();//点击事件
    }

    private void initEvent() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//登录
                Intent intent=new Intent(LeadingActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//注册
                Intent intent=new Intent(LeadingActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        login= (Button) findViewById(R.id.btn_leading_login);
        signup= (Button) findViewById(R.id.btn_leading_signup);
    }
}
