package com.example.logsignsc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    EditText t1, t2, t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        t1 = (EditText) findViewById(R.id.email);
        t2 = (EditText) findViewById(R.id.username);
        t3 = (EditText) findViewById(R.id.password);

        TextView redirectLogin = findViewById(R.id.redirectLogin);
        redirectLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finish this activity to return to the previous one
            }
        });
    }

    public void addRecord(View view) {
        DbManager db = new DbManager(this);
        String res = db.addRecord(t1.getText().toString(), t2.getText().toString(), t3.getText().toString());
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();

        t1.setText("");
        t2.setText("");
        t3.setText("");
    }
}