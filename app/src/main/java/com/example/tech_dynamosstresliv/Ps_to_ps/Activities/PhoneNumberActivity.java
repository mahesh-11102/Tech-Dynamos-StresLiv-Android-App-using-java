package com.example.tech_dynamosstresliv.Ps_to_ps.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tech_dynamosstresliv.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneNumberActivity extends AppCompatActivity {

    ActivityPhoneNumberBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.nameBox.requestFocus();

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null){
            Intent i = new Intent(PhoneNumberActivity.this, PsChatActivity.class);
            startActivity(i);
            finish();
        }

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneNumberActivity.this, OTPActivity.class);
                intent.putExtra("phoneNumber",binding.nameBox.getText().toString());
                startActivity(intent);
            }
        });
    }
}