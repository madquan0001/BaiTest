package com.example.baitest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText outputText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        AnhXa();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.SEND_SMS},12);
            }
            else {
            }
        }
        final Display display = new ProxyNumber(getApplicationContext());
        outputText.setText(display.load());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager sms = SmsManager.getDefault();
                try {
                    String[] numbers = display.load().split("\n");
                    for (int i = 0 ; i < numbers.length ; i++) {
                        sms.sendTextMessage(numbers[i], null, "gfhfghfg", null, null);
                    }
                    Toast.makeText(MainActivity.this,"Gửi thành công !", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this,"Lỗi " + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void AnhXa(){
        this.outputText = (EditText)this.findViewById(R.id.editText);
        this.button = (Button) this.findViewById(R.id.button);
    }
}
