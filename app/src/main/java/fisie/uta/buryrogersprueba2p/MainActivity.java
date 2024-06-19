package fisie.uta.buryrogersprueba2p;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nombreET;
    private EditText apellidoET;
    private EditText dividendoET;
    private EditText divisorET;
    private EditText parEnteraET;
    private EditText residuoET;
    private EditText numInvertidoET;
    private Button mostrarBttn;
    private Button siguienteBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        nombreET = findViewById(R.id.editTextNombreAct1);
        apellidoET = findViewById(R.id.editTextApellidoAct1);
        dividendoET = findViewById(R.id.editTextDividendoAct1);
        divisorET = findViewById(R.id.editTextDivisorAct1);
        parEnteraET = findViewById(R.id.editTextParteEnteAct1);
        residuoET = findViewById(R.id.editTextResiduoAct1);
        numInvertidoET = findViewById(R.id.editTextNumInveAct1);
        siguienteBttn = findViewById(R.id.buttonsiguienteAct1);
        mostrarBttn = findViewById(R.id.buttonMostrarResAct1);

        bloquearEditText();

        siguienteBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this, ActivityDos.class);

                String obtenerNombre = nombreET.getText().toString();
                String obtenerApellido = apellidoET.getText().toString();

                intent.putExtra("NombreAct1", obtenerNombre);
                intent.putExtra("ApellidoAct1", obtenerApellido);


                startActivity(intent);
            }
        });

        mostrarBttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int dividendo = Integer.parseInt(dividendoET.getText().toString());
                int divisorInt = Integer.parseInt(divisorET.getText().toString());
                String numeroInvertido = getIntent().getStringExtra("NumeroInvertidoAct3");


                EditText editTextInvertido = findViewById(R.id.editTextNumInveAct1);
                editTextInvertido.setText(numeroInvertido);

                int numEntero = 0;
                int residuo = 0;

                if (divisorInt != 0) {
                    int signo = 1;

                    if ((dividendo < 0 && divisorInt > 0) ||
                            (dividendo > 0 && divisorInt < 0)) {
                        signo = -1;
                    }

                    dividendo = Math.abs(dividendo);
                    divisorInt = Math.abs(divisorInt);

                    while (dividendo >= divisorInt) {
                        dividendo -= divisorInt;
                        numEntero++;
                    }
                    numEntero *= signo;
                    residuo = dividendo;
                }
                parEnteraET.setText(String.valueOf(numEntero));
                residuoET.setText(String.valueOf(residuo));
            }

        });

    }

    public void bloquearEditText(){
        nombreET.setEnabled(false);
        apellidoET.setEnabled(false);
        dividendoET.setEnabled(false);
        divisorET.setEnabled(false);
        numInvertidoET.setEnabled(false);
        parEnteraET.setEnabled(false);
        residuoET.setEnabled(false);
    }


    public void MostrarDatos3(){

    }






}