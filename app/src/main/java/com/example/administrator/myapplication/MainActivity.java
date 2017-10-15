package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.administrator.myapplication.R.id.btn1;
import static com.example.administrator.myapplication.R.id.btn2;
import static com.example.administrator.myapplication.R.id.inputID;
import static com.example.administrator.myapplication.R.id.inputLayout;
import static com.example.administrator.myapplication.R.id.inputLayout2;
import static com.example.administrator.myapplication.R.id.inputPW;
import static com.example.administrator.myapplication.R.id.layout;
import static com.example.administrator.myapplication.R.id.radioBtnID1;
import static com.example.administrator.myapplication.R.id.radioBtnID2;
import static com.example.administrator.myapplication.R.id.radioGrID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);        //创建dialog
        createDialog(alertDialog);

        ImageView mimage = (ImageView)findViewById(R.id.imageSysu);
        mimage.setOnClickListener(new View.OnClickListener() {          //image点击监听器
            @Override
            public void onClick(View view) {       //点击后 显示dialog
                alertDialog.show();
            }
        });

        RadioGroup mRadioGroup = (RadioGroup)findViewById(radioGrID);
        checkedChange(mRadioGroup);

        Button button1 = (Button)findViewById(btn1);
        btn1_Clicked(button1);
        Button button2 = (Button)findViewById(btn2);
        btn2_Clicked(button2);



    }

    void createDialog(AlertDialog.Builder alertDialog) {
        alertDialog.setTitle("上传头像");
        final String[] Items = {"拍摄", "从相册选择"};
        alertDialog.setItems(Items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "你选择了[" + Items[which] + "]",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "你选择了[取消]", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.create();
    }

    void checkedChange(RadioGroup mRadioGroup) {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton btn1 = (RadioButton)findViewById(radioBtnID1);
                RadioButton btn2 = (RadioButton)findViewById(radioBtnID2);
                String mess = "你选择了";
                if (btn1.isChecked()) {
                    mess += "学生";
                } else {
                    mess += "教职工";
                }
                // coordinatorLayout无法使用

                Snackbar.make(findViewById(layout), mess, Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setDuration(3000)
                        .show();
            }
        });
    }

    void btn1_Clicked(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editId = (EditText)findViewById(inputID);
                EditText editPw = (EditText)findViewById(inputPW);
                TextInputLayout layId = (TextInputLayout)findViewById(inputLayout);
                layId.setErrorEnabled(true);
                TextInputLayout layPw = (TextInputLayout)findViewById(inputLayout2);
                layPw.setErrorEnabled(true);
                if (editId.getText().toString().equals("")) {
                    layId.setError("学号不能为空");
                    return;
                }
                layId.setErrorEnabled(false);
                if (editPw.getText().toString().equals("")) {
                    layPw.setError("密码不能为空");
                    return;
                }

                layPw.setErrorEnabled(false);
                String message = null;

                if (editId.getText().toString().equals("123456") &&
                        editPw.getText().toString().equals("6666")) {
                    message = "登录成功";
                } else {
                    message = "学号或密码错误";
                }
                Snackbar.make(findViewById(layout), message, Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setDuration(3000)
                        .show();
            }
        });

    }
    void btn2_Clicked(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton btn1 = (RadioButton)findViewById(radioBtnID1);
                String message = null;
                if (btn1.isChecked()) {
                    message = "学生注册功能尚未启用";
                } else {
                    message = "教职工注册功能尚未启用";
                }
                Snackbar.make(findViewById(layout), message, Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setDuration(3000)
                        .show();
            }
        });
    }
}
