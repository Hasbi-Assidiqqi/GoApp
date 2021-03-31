package com.mha.goapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mha.goapp.R;

public class LoginActivity extends AppCompatActivity {
    // deklarasi variabel
    EditText edtUsername, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // mengidentifikasi berdasarkan id
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        // jika btnLogin di klik maka akan melakukan aksi
        btnLogin.setOnClickListener(v -> {
            // mengubah mengambil EditText dan mengubahnya menjadi string
            String usernameLogin = edtUsername.getText().toString().trim();
            String passwordLogin = edtPassword.getText().toString().trim();

            if (usernameLogin.isEmpty() && passwordLogin.isEmpty()) {
                edtUsername.setError("Tidak boleh kosong");
                edtPassword.setError("Tidak boleh kosong");
            } else if (usernameLogin.isEmpty()) {
                edtUsername.setError("Tidak boleh kosong");
            } else if (passwordLogin.isEmpty()) {
                edtPassword.setError("Tidak boleh kosong");
            } else {
                // jika username dan password tidak kosong lalu passwordnya admin 123, maka login berhasil
                 if (passwordLogin.equals("admin123")) {
                    loginSucces();
                } else {
                    //jika password bukan admin123 maka akan muncul pemberitahuan Password salah
                    Toast.makeText(LoginActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginSucces() {
        // mengambil data pada EditText username kemudian dimasukkan kedalam variabel userLogin
        String userLogin = edtUsername.getText().toString();

        // pindah activity dengan membawa data berupa variabel userLogin
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("USERNAME", userLogin);
        startActivity(intent);

    }
}