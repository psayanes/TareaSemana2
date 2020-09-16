package com.android.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmarContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    Button botoneditar;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String descripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("nombre");
        String fechaNacimiento = parametros.getString("fechaNacimiento");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String descripcion = parametros.getString("descripcion");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcionContacto);
        botoneditar = (Button) findViewById(R.id.btnEditarDatos);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        botoneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfirmarContacto.this, MainActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("fechaNacimiento", fechaNacimiento);
                intent.putExtra("telefono",telefono);
                intent.putExtra("email",email);
                intent.putExtra("descripcion",descripcion);
                startActivity(intent);
                finish();
            }
        });

    }
}