package com.example.mahmoudalzoghby.graduationproject;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmPhNumberActivity extends Activity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_ph_number);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("01026945658", null, "Allah", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}
