package android.miguel.ejercicio15;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txt_nombreArchivo;
    private EditText txt_principal;
    private Button btn_grabar, btn_recuperar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombreArchivo = (EditText) findViewById(R.id.txt_nombreArchivo);
        txt_principal = (EditText) findViewById(R.id.txt_principal);

        btn_grabar = (Button) findViewById(R.id.btn_grabar);
        btn_recuperar = (Button) findViewById(R.id.btn_recuperar);

        btn_grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grabar(v);
            }
        });

        btn_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperar(v);
            }
        });

    }

    private void grabar(View v) {
        String nomarchivo = txt_nombreArchivo.getText().toString();
        String contenido = txt_principal.getText().toString();
        try {
            File tarjeta = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjeta.getAbsolutePath(), Toast.LENGTH_LONG).show();
            File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(file,true));

            osw.append(contenido + "\n");
            osw.flush();
            osw.close();
            Toast.makeText(this, "Los datos fueron grabados correctamente",
                    Toast.LENGTH_SHORT).show();
            txt_principal.setText("");
            txt_nombreArchivo.setText("");
        } catch (IOException ioe) {
            Toast.makeText(this, "No se pudo grabar " + ioe.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void recuperar(View v) {
        String nomarchivo = txt_nombreArchivo.getText().toString();
        File tarjeta = Environment.getExternalStorageDirectory();

        File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
        try {
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String todo = "";
            while (linea != null) {
                todo = todo + linea + " ";
                linea = br.readLine();
            }
            br.close();
            archivo.close();
            txt_principal.setText(todo);

        } catch (IOException e) {
            Toast.makeText(this, "No se pudo leer",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
