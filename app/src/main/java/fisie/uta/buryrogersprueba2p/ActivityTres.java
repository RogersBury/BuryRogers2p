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
                Intent intent = new Intent(ActivityTres.this, ActivityDos.class);
                String obtenerNombre = nombreET.getText().toString();
                String obtenerApellido = apellidoET.getText().toString();
                String obtenerDividendo = dividendoET.getText().toString();
                String obtenerDivisor = divisorET.getText().toString();
                String obtenerNumero = numeroET.getText().toString();

                intent.putExtra("NameAct3", obtenerNombre);
                intent.putExtra("LastNameAct3", obtenerApellido);
                intent.putExtra("DividendoAct3", obtenerDividendo);
                intent.putExtra("DivisorAct3", obtenerDivisor);
                intent.putExtra("NumeroInvertidoAct", obtenerNumero);

                startActivity(intent);
            }
        });


    }


    public void mostrarNombreApellidoBloaqueados(){
        nombreET.setEnabled(false);
        apellidoET.setEnabled(false);

        Intent intent1 = getIntent();

        String obtenerNombre = intent1.getStringExtra("Nombre");
        String obtenerApellido = intent1.getStringExtra("Apellido");

        nombreET.setText(obtenerNombre);
        apellidoET.setText(obtenerApellido);



    }


}