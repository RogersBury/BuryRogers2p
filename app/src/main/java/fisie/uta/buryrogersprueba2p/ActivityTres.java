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

public class ActivityTres extends AppCompatActivity {

    private EditText nombreET;
    private EditText apellidoET;
    private EditText dividendoET;
    private EditText divisorET;
    private EditText numeroET;
    private Button cerrarBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombreET = findViewById(R.id.editTextNombreAct3);
        apellidoET = findViewById(R.id.editTextApellidoAct3);
        dividendoET = findViewById(R.id.editTextDividendoAct3);
        divisorET = findViewById(R.id.editTextDivisorAct3);
        numeroET = findViewById(R.id.editTextNumeroAct3);
        cerrarBttn = findViewById(R.id.buttonCerrarAct3);

        mostrarNombreApellidoBloaqueados();

        Intent intent = new Intent();
        String obtenerDividendo = intent.getStringExtra("Dividendo");
        String obtenerDivisor = intent.getStringExtra("Divisor");
        String obtenerNumero = intent.getStringExtra("Numero");

        dividendoET.setText(obtenerDividendo);
        divisorET.setText(obtenerDivisor);
        numeroET.setText(obtenerNumero);


        cerrarBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ActivityTres.this, ActivityDos.class);
                String obtenerNombre = nombreET.getText().toString();
                String obtenerApellido = apellidoET.getText().toString();
                String obtenerDividendo = dividendoET.getText().toString();
                String obtenerDivisor = divisorET.getText().toString();
                String obtenerNumero = numeroET.getText().toString();

                intent1.putExtra("NombreAct3", obtenerNombre);
                intent1.putExtra("ApellidoAct3", obtenerApellido);
                intent1.putExtra("DividendoAct3", obtenerDividendo);
                intent1.putExtra("DivisorAct3", obtenerDivisor);
                intent1.putExtra("NumeroInvertidoAct3", obtenerNumero);

                startActivity(intent1);
            }
        });


    }


    public void mostrarNombreApellidoBloaqueados(){
        nombreET.setEnabled(false);
        apellidoET.setEnabled(false);

        Intent intent2 = getIntent();

        String obtenerNombre = intent2.getStringExtra("NombreAct2");
        String obtenerApellido = intent2.getStringExtra("ApellidoAct2");

        nombreET.setText(obtenerNombre);
        apellidoET.setText(obtenerApellido);



    }


}