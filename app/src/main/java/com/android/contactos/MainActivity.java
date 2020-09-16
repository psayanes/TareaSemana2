package com.android.contactos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity  {

    DatePicker picker;
    Button botonok;
    Button botoncancel;
    Button botonsiguiente;
    private EditText etNombre;
    private TextView tvFechaNacimiento;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private String nombre;
    private String fechaNacimiento;
    private String telefono;
    private String email;
    private String descripcion;
    private String dateInString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();

        if (parametros == null) {
            etNombre = (EditText) findViewById(R.id.etNombreCompleto);
            String nombreCompleto = etNombre.getText().toString();

                tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
                picker=(DatePicker)findViewById(R.id.datePicker);
                etTelefono = (EditText) findViewById(R.id.etTelefonoContacto);
                etEmail = (EditText) findViewById(R.id.etEmailContacto);
                etDescripcion = (EditText) findViewById(R.id.etDescripcionContacto);
                botonok = (Button) findViewById(R.id.btnOk);
                botoncancel = (Button) findViewById(R.id.btnCancel);
                botonsiguiente = (Button) findViewById(R.id.btnSiguiente);


        } else {
            nombre = parametros.getString("nombre");
            fechaNacimiento = parametros.getString("fechaNacimiento");
            telefono = parametros.getString("telefono");
            email = parametros.getString("email");
            descripcion = parametros.getString("descripcion");
            etNombre = (EditText) findViewById(R.id.etNombreCompleto);
            String nombreCompleto = etNombre.getText().toString();

                    tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
                    picker=(DatePicker)findViewById(R.id.datePicker);

                    etTelefono = (EditText) findViewById(R.id.etTelefonoContacto);
                    etEmail = (EditText) findViewById(R.id.etEmailContacto);
                    etDescripcion = (EditText) findViewById(R.id.etDescripcionContacto);
                    botonok = (Button) findViewById(R.id.btnOk);
                    botoncancel = (Button) findViewById(R.id.btnCancel);
                    botonsiguiente = (Button) findViewById(R.id.btnSiguiente);

                    etNombre.setText(nombre);
                    tvFechaNacimiento.setText(fechaNacimiento);
                    etTelefono.setText(telefono);
                    etEmail.setText(email);
                    etDescripcion.setText(descripcion);
        }

        botoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFechaNacimiento.setText("16/09/2020");
            }
        });

        botonok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvFechaNacimiento.setText(dosDigitos(picker.getDayOfMonth())+"/"+ dosDigitos(picker.getMonth()+1)+"/"+picker.getYear());
                    fechaNacimiento = tvFechaNacimiento.getText().toString();

                }
         });


        botonsiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nombre = etNombre.getText().toString();
                telefono = etTelefono.getText().toString();
                email = etEmail.getText().toString();
                descripcion = etDescripcion.getText().toString();

                Intent intent = new Intent(MainActivity.this, ConfirmarContacto.class);
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


     //muestra los dias y meses con dos dígitos
    private String dosDigitos(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
}

