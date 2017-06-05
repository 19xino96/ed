package org.serpis.pablotr.aplicacionas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarMensajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_mensaje);

        Intent intento = getIntent();
        String mensaje = intento.getStringExtra(MainActivity.EXTRA_MENSAJE);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(mensaje);
    }
}
