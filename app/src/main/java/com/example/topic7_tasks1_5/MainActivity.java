package com.example.topic7_tasks1_5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String SpinnerLabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.textoEditable);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_DONE){
                    Log.d("consola", "Se va a llamar");
                    Uri number = Uri.parse("tel:"+editText.getText().toString());
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                    startActivity(callIntent);
                }
                return false;
            }
        });

        //Creamos el spinner y seteamos el listener
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void mostrar(View v){
        EditText texto = (EditText) findViewById(R.id.textoEditable);

        if (texto != null) {
            Log.d("consola", "hola");
            Toast.makeText(this, texto.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarTextoSpinner(View v){
        EditText texto = (EditText) findViewById(R.id.textoEditableSpinner);
        TextView cajaTexto = (TextView) findViewById(R.id.telefono);
        cajaTexto.setText(texto.getText().toString() + " - " + SpinnerLabel);

        if (texto != null) {
            Log.d("consola", "hola");
            Toast.makeText(this, texto.getText().toString() + " - " + SpinnerLabel, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SpinnerLabel = adapterView.getItemAtPosition(i).toString();
        mostrarTextoSpinner(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d("Consola", "Nada seleccionado ");
    }

    public void mostrarDateDialog(View v) {
        DateDialog newFragment = new DateDialog();
        newFragment.show(getSupportFragmentManager(), "Date dialog");
    }

    public void recogerFecha(int year, int month, int day) {
        String mes = Integer.toString(month + 1);
        String dia = Integer.toString(day);
        String año = Integer.toString(year);
        // Assign the concatenated strings to dateMessage.
        String dateMessage = (dia + "-" + mes + "-" + año);
        Toast.makeText(this, "FECHA: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void mostrarTimeDialog(View view) {
        TimePicker newFragment = new TimePicker();
        newFragment.show(getSupportFragmentManager(), "Time Picker");
    }

    public void recogerHora(int hora, int minuto) {
        // Convert time elements into strings.
        String hora_texto = Integer.toString(hora);
        String minuto_texto = Integer.toString(minuto);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hora_texto + ":" + minuto_texto);
        Toast.makeText(this, "HORA " + timeMessage, Toast.LENGTH_SHORT).show();
    }
}