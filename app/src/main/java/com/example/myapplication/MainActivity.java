package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName,etPhone, etAddress;
    private TextView tvVal;
    private Button btnSet, btnShow, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        btnSet = findViewById(R.id.btnSet);
        btnShow = findViewById(R.id.btnShow);
        btnClear = findViewById(R.id.btnClear);
        tvVal = findViewById(R.id.tvVal);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

    }

    private void save() {
        if (String.valueOf(etName.getText()).equals(null) || String.valueOf(etName.getText()).equals("") || String.valueOf(etPhone.getText()).equals(null) || String.valueOf(etPhone.getText()).equals("") || String.valueOf(etAddress.getText()).equals(null) || String.valueOf(etAddress.getText()).equals("")) {
            Toast.makeText(this, "Lengkapi Isian Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else {
            String name = String.valueOf(etName.getText());
            String phone = String.valueOf(etPhone.getText());
            String address = String.valueOf(etAddress.getText());

            Contact contact = new Contact(name, phone, address);
            SharePrefManager.getInstance(MainActivity.this).saveContact(contact);
        }
    }

    private void show() {
        String nameSP = SharePrefManager.getInstance(MainActivity.this).getContact().getName();
        String phoneSP = SharePrefManager.getInstance(MainActivity.this).getContact().getPhone();
        String addressSP = SharePrefManager.getInstance(MainActivity.this).getContact().getAddress();

        tvVal.setText(nameSP+" - "+phoneSP+" - "+addressSP);
    }

    private void clear(){
        SharePrefManager.getInstance(MainActivity.this).clear();
    }
}
