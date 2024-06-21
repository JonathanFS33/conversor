package com.umg.a1190_22_515_examen_final;

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

    private EditText km1;
    private EditText metros1;
    private EditText metros2;
    private EditText cm1;
    private Button btn;

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
        calcular();
    }

    private void calcular() {
        km1 = findViewById(R.id.km1);
        metros1 = findViewById(R.id.metros1);

        metros2 = findViewById(R.id.metros2);
        cm1 = findViewById(R.id.cm1);

        btn = findViewById(R.id.btncalcular);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kmString = km1.getText().toString();
                int kmInt = Integer.parseInt(kmString);

                int totalMetros = kmInt*1000;

                String metrosString = Integer.toString(totalMetros);

                String metros2String = metros2.getText().toString();
                int metros2Int = Integer.parseInt(metros2String);

                int cmInt = metros2Int * 100;

                String cmString = Integer.toString(cmInt);

                metros1.setText(metrosString + " metros");
                cm1.setText(cmString + " cm");
            }
        });
    }
}