package mx.edu.utng.autentificaciongds0343;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button btnRegistro,btnIniciar,btnSalir;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistro=(Button) findViewById(R.id.btnRegistro);
        btnIniciar=(Button) findViewById(R.id.btnIniciar);
        btnSalir=(Button) findViewById(R.id.btnSalir);
        mAuth = FirebaseAuth.getInstance();
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se relaciona la otra actividad
                Intent intento = new Intent(MainActivity.this, RegistrationActivity.class);
                //Se inicia la otra Actividad
                startActivity(intento);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se relaciona la otra actividad
                Intent intento = new Intent(MainActivity.this, LoginActivity.class);
                //Se inicia la otra Actividad
                startActivity(intento);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
        }
    }
}