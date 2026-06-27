package com.example.registrationapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    LinearLayout containerUsers;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        containerUsers = findViewById(R.id.containerUsers);
        databaseHelper = new DatabaseHelper(this);

        loadUsers();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private void loadUsers() {
        containerUsers.removeAllViews();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String dob = cursor.getString(2);
                String email = cursor.getString(3);
                addUserCard(id, name, dob, email);
            } while (cursor.moveToNext());
        } else {
            TextView empty = new TextView(this);
            empty.setText("No registrations yet.");
            empty.setTextColor(0xFF888888);
            empty.setTextSize(16);
            empty.setGravity(Gravity.CENTER);
            empty.setPadding(0, 80, 0, 0);
            containerUsers.addView(empty);
        }

        cursor.close();
        db.close();
    }

    private void addUserCard(int id, String name, String dob, String email) {

        // Card
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(48, 48, 48, 48);
        card.setBackgroundColor(0xFFFFFFFF);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(0, 0, 0, 20);
        card.setLayoutParams(cardParams);

        // Name label
        TextView labelName = new TextView(this);
        labelName.setText("Name");
        labelName.setTextSize(12);
        labelName.setTextColor(0xFF888888);
        card.addView(labelName);

        // Name value
        TextView tvName = new TextView(this);
        tvName.setText(name);
        tvName.setTextSize(17);
        tvName.setTextColor(0xFF1A237E);
        tvName.setPadding(0, 4, 0, 20);
        card.addView(tvName);

        // Divider
        TextView div1 = new TextView(this);
        div1.setBackgroundColor(0xFFEEEEEE);
        LinearLayout.LayoutParams div1Params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 1);
        div1Params.setMargins(0, 0, 0, 20);
        div1.setLayoutParams(div1Params);
        card.addView(div1);

        // DOB label
        TextView labelDob = new TextView(this);
        labelDob.setText("Date of Birth");
        labelDob.setTextSize(12);
        labelDob.setTextColor(0xFF888888);
        card.addView(labelDob);

        // DOB value
        TextView tvDob = new TextView(this);
        tvDob.setText(dob);
        tvDob.setTextSize(17);
        tvDob.setTextColor(0xFF212121);
        tvDob.setPadding(0, 4, 0, 20);
        card.addView(tvDob);

        // Divider
        TextView div2 = new TextView(this);
        div2.setBackgroundColor(0xFFEEEEEE);
        LinearLayout.LayoutParams div2Params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 1);
        div2Params.setMargins(0, 0, 0, 20);
        div2.setLayoutParams(div2Params);
        card.addView(div2);

        // Email label
        TextView labelEmail = new TextView(this);
        labelEmail.setText("Email");
        labelEmail.setTextSize(12);
        labelEmail.setTextColor(0xFF888888);
        card.addView(labelEmail);

        // Email value
        TextView tvEmail = new TextView(this);
        tvEmail.setText(email);
        tvEmail.setTextSize(17);
        tvEmail.setTextColor(0xFF212121);
        tvEmail.setPadding(0, 4, 0, 20);
        card.addView(tvEmail);

        // Bottom row — trash icon
        LinearLayout bottomRow = new LinearLayout(this);
        bottomRow.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams bottomParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        bottomParams.setMargins(0, 8, 0, 0);
        bottomRow.setLayoutParams(bottomParams);

        TextView spacer = new TextView(this);
        spacer.setLayoutParams(new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        bottomRow.addView(spacer);

        Button btnDelete = new Button(this);
        btnDelete.setText("🗑");
        btnDelete.setTextSize(22);
        btnDelete.setTextColor(0xFFE53935);
        btnDelete.setBackgroundColor(0x00000000);
        btnDelete.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        bottomRow.addView(btnDelete);
        card.addView(bottomRow);

        btnDelete.setOnClickListener(v -> {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            db.delete("users", "id=?", new String[]{String.valueOf(id)});
            db.close();
            Toast.makeText(this, name + " removed!", Toast.LENGTH_SHORT).show();
            loadUsers();
        });

        containerUsers.addView(card);
    }
}