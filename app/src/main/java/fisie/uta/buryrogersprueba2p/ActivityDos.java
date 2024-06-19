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

public class ActivityDos extends AppCompatActivity {

    private EditText nombreET;
    private EditText apellidoET;
    private EditText dividendoET;
    private EditText divisorET;
    private EditText numeroET;
    private Button siguienteBttn;
    private Button cerrarBttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        nombreET = findViewById(R.id.editTextnombreAct2);
        apellidoET = findViewById(R.id.editTextApellidoAct2);
        dividendoET = findViewById(R.id.editTextDividendoAct2);
        divisorET = findViewById(R.id.editTextDivisorAct2);
        numeroET = findViewById(R.id.editTextNumeroAct2);
        siguienteBttn = findViewById(R.id.buttonSiguienteAct2);
        cerrarBttn = findViewById(R.id.buttonCerrarAct2);


        bloquearEditText();

        siguienteBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        ActivityDos.this, ActivityTres.class);

                String obtenerNombre = nombreET.getText().toString();
                String obtenerApellido = apellidoET.getText().toString();
                String obtenerDividendo = dividendoET.getText().toString();
                String obtenerDivisor = divisorET.getText().toString();
                String obtenerNumero = numeroET.getText().toString();

                intent.putExtra("NombreAct2", obtenerNombre);
                intent.putExtra("ApellidoAct2", obtenerApellido);
                intent.putExtra("DividendoAct2", obtenerDividendo);
                intent.putExtra("DivisorAct2", obtenerDivisor);
                intent.putExtra("NumeroAct2", obtenerNumero);

                startActivity(intent);

                mostrarValores();
            }
        });


        cerrarBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDos.this, MainActivity.class);
                String obtenerNombre = nombreET.getText().toString();
                String obtenerApellido = apellidoET.getText().toString();
                String obtenerDividendo = dividendoET.getText().toString();
                String obtenerDivisor = divisorET.getText().toString();
                String obtenerNumero = numeroET.getText().toString();


                if (!obtenerNombre.isEmpty() || !obtenerApellido.isEmpty() || !obtenerDividendo.isEmpty() ||
                        !obtenerDivisor.isEmpty() || !obtenerNumero.isEmpty()) {

                    String numeroInvertido = new StringBuilder(obtenerNumero).reverse().toString();

                    intent.putExtra("NombreAct2", obtenerNombre);
                    intent.putExtra("ApellidoAct2", obtenerApellido);
                    intent.putExtra("DividendoAct2", obtenerDividendo);
                    intent.putExtra("DivisorAct2", obtenerDivisor);
                    intent.putExtra("NumeroInvertidoAct2", numeroInvertido);

                }

                startActivity(intent);
            }
        });
    }


    public void bloquearEditText(){
        dividendoET.setEnabled(false);
        divisorET.setEnabled(false);
        numeroET.setEnabled(false);
    }


    public void mostrarValores(){
        Intent intent3 = new Intent();
        String obtenerNombre = intent3.getStringExtra("NombreAct3");
        nombreET.setText(obtenerNombre);

        String obtenerApellido = intent3.getStringExtra("ApellidoAct3");
        apellidoET.setText(obtenerApellido);

        String obtenerDividendo = intent3.getStringExtra("DividendoAct3");
        dividendoET.setText(obtenerDividendo);

        String obtenerDivisor = intent3.getStringExtra("DivisorAct3");
        divisorET.setText(obtenerDivisor);

        String obtenerNumero = intent3.getStringExtra("NumeroInvertidoAct3");
        numeroET.setText(obtenerNumero);
    }
}