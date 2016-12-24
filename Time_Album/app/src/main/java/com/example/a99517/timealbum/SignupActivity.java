package com.example.a99517.timealbum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

/**
 * Created by 99517 on 2016/12/19.
 */

public class SignupActivity extends Activity{
    EditText username,password,passwordagain;
    Button signup,cancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initView();//初始化控件
        initEvent();
    }

    private void initEvent() {
        signup.setOnClickListener(new View.OnClickListener() {//登录按钮
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText())){
                    Toast.makeText(SignupActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password.getText())){
                    Toast.makeText(SignupActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(passwordagain.getText())){
                    Toast.makeText(SignupActivity.this,"重复密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    AVUser user = new AVUser();// 新建 AVUser 对象实例
                    user.setUsername(username.getText().toString());// 设置用户名
                    user.setPassword(password.getText().toString());// 设置密码
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                                // 注册成功
                                Toast.makeText(SignupActivity.this,"恭喜你，注册成功！",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignupActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                // 失败的原因可能有多种，常见的是用户名已经存在。
                            }
                        }
                    });
                }
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        username= (EditText) findViewById(R.id.edit_signup_username);
        password= (EditText) findViewById(R.id.edit_signup_password);
        passwordagain= (EditText) findViewById(R.id.edit_signup_passwordagain);
        signup= (Button) findViewById(R.id.btn_signup_signup);
        cancle= (Button) findViewById(R.id.btn_signup_cancle);
    }
}
