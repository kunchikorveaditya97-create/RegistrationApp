package com.example.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDob, etEmail;
    Button btnSubmit;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDob = findViewById(R.id.etDob);
        etEmail = findViewById(R.id.etEmail);
        btnSubmit = findViewById(R.id.btnSubmit);
        databaseHelper = new DatabaseHelper(this);

        etDob.setFocusable(false);
        etDob.setClickable(true);
        etDob.setOnClickListener(v -> {
            android.app.DatePickerDialog datePicker = new android.app.DatePickerDialog(
                    MainActivity.this,
                    (view, year, month, day) ->
                            etDob.setText(day + "/" + (month + 1) + "/" + year),
                    2000, 0, 1
            );
            datePicker.show();
        });

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String dob = etDob.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (TextUtils.isEmpty(name)) {
                etName.setError("Please enter name");
                return;
            }
            if (TextUtils.isEmpty(dob)) {
                etDob.setError("Please select date of birth");
                return;
            }
            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Please enter email");
                return;
            }

            databaseHelper.insertUser(name, dob, email);
            Toast.makeText(this, "Registered successfully!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("DOB", dob);
            intent.putExtra("EMAIL", email);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}