package org.serpis.pablotr.aplicacionas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MENSAJE = "org.serpis.pablotr.aplicacionas.MENSAJE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarMensaje(View view) {
        Intent intento =  new Intent(this, MostrarMensajeActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String mensaje = editText.getText().toString();
        intento.putExtra(EXTRA_MENSAJE, mensaje);
        startActivity(intento);
    }
}
