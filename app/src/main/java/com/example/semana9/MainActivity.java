package com.example.semana9;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    EditText sms, llamar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= findViewById(R.id.btnllamar);
        Button button1 =findViewById(R.id.btnsms);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText input = findViewById(R.id.llamar);

                String value=String.valueOf(input.getText());




                Intent intent = new  Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", value, null));
                startActivity(intent);

            }
        });


if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)!= getPackageManager().PERMISSION_GRANTED)
    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText in=findViewById(R.id.sms);
                String val=String.valueOf(in.getText());
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(llamar.getText().toString(), null,sms.getText().toString(),null,null);
                Toast.makeText(MainActivity.this, "mensj enviado", Toast.LENGTH_LONG).show();



            }
        });

    }
}