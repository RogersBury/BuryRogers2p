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

                intent.putExtra("Nombre", obtenerNombre);
                intent.putExtra("Apellido", obtenerApellido);
                intent.putExtra("Dividendo", obtenerDividendo);
                intent.putExtra("Divisor", obtenerDivisor);
                intent.putExtra("Numero", obtenerNumero);

                startActivity(intent);

                mostrarValores();
            }
        });


        cerrarBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String obtenerNombre = nombreET.getText().toString();
                String obtenerApellido = apellidoET.getText().toString();
                String obtenerDividendo = dividendoET.getText().toString();
                String obtenerDivisor = divisorET.getText().toString();
                String obtenerNumero = numeroET.getText().toString();


                if (!obtenerNombre.isEmpty() || !obtenerApellido.isEmpty() || !obtenerDividendo.isEmpty() ||
                        !obtenerDivisor.isEmpty() || !obtenerNumero.isEmpty()) {
                    Intent intent = new Intent(ActivityDos.this, MainActivity.class);
                    String numeroInvertido = new StringBuilder(obtenerNumero).reverse().toString();

                    intent.putExtra("Nombre", obtenerNombre);
                    intent.putExtra("Apellido", obtenerApellido);
                    intent.putExtra("Dividendo", obtenerDividendo);
                    intent.putExtra("Divisor", obtenerDivisor);
                    intent.putExtra("NumeroInvertido", numeroInvertido);
                    startActivity(intent);
                }
            }
        });
    }


    public void bloquearEditText(){
        dividendoET.setEnabled(false);
        divisorET.setEnabled(false);
        numeroET.setEnabled(false);
    }


    public void mostrarValores(){
        Intent intent = new Intent();
        String obtenerNombre = intent.getStringExtra("NombreAct3");
        nombreET.setText(obtenerNombre);
    }
}