package com.example.chengd.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1, editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.url);
        editText2 = (EditText) findViewById(R.id.phone);
        textView = (TextView) findViewById(R.id.textview1);
    }

    //显示跳转
    public void componentname(View view) {
        ComponentName componentName = new ComponentName(this, IntentDemo2.class);
        Intent i1 = new Intent();
        i1.setComponent(componentName);
        startActivity(i1);
    }

    //隐式跳转
    public void intentfilter(View view) {
        String action = "cn.edu.gdmec.kissme";
        Intent i2 = new Intent();
        i2.setAction(action);
        startActivity(i2);
    }

    //打开网页
    public void view(View view) {
        Intent i3 = new Intent();
        i3.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(editText1.getText().toString());
        i3.setData(uri);
        startActivity(i3);
    }

    //拨号
    public void dial(View view) {
        Intent i4 = new Intent();
        Uri uri = Uri.parse("tel:" + editText2.getText().toString());
        i4.setData(uri);
        startActivity(i4);
    }

    //带数据跳转到IntentDemo2
    public void startactivityforresult(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("value", editText1.getText().toString());
        Intent intent = new Intent(MainActivity.this, IntentDemo2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10:
                Bundle bundle = data.getExtras();
                textView.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
