package com.example.root.astronomycalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView password;
    private final String password_ = new String("fuckyoubuddy");
    Button verify_password;
    public int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button Click Listener to get password
        verify_password = (Button) findViewById(R.id.verify_);
        verify_password.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count++;
                password = (EditText) findViewById(R.id.editText);
                String temp = new String(password.getText().toString());
                // if '==' is used it checks the referenced objects are same or not .equals() checks the value
                if( (temp.equals(password_))){
                    Intent main = new Intent(MainActivity.this, choose.class);
                    startActivity(main);
                    //To close this activity after
                    finish();
                } //else Toast.makeText(MainActivity.this, "Worng password, please try again.").show();

                if(  !(password_.equals(temp)) & (count>3) ){
                    Toast.makeText(MainActivity.this,"More than 3 FALIED attempts", Toast.LENGTH_SHORT).show();
                }

                if(!(password_.equals(temp))){
                    Toast.makeText(MainActivity.this,"Wrong password, please try again.", Toast.LENGTH_SHORT).show();
                    String msg = "You entered: " + temp.toString();
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
//                if (count > 3){
//                    Toast.makeText(MainActivity.this,"Yow entered password WRONG more than 3 times", Toast.LENGTH_LONG).show();
//                    //android.os.Process.killProcess(android.os.Process.myPid());
//                }
//
        });

    }
}

