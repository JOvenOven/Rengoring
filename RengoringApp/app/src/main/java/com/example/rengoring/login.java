package com.example.rengoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    Button btn_entrar;
    Button btn_crearcuenta;
    EditText ET_CORREO,ET_PASS;
    String login_correo,login_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ET_CORREO = (EditText)findViewById(R.id.edtCorreo);
        ET_PASS = (EditText)findViewById(R.id.edtPass);

        btn_crearcuenta = findViewById(R.id.btn_crearcuenta);
        btn_crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, crearcuenta.class));
                finish();
            }
        });


        btn_entrar = findViewById(R.id.btn_Entrar);
        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, Main2Activity.class));
                finish();
            }
        });


    }

    public void userLogin(View view)
    {
        login_correo = ET_CORREO.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_correo,login_pass);
    }


}
