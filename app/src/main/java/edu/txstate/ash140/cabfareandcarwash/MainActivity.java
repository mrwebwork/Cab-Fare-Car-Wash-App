package edu.txstate.ash140.cabfareandcarwash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.btnCarWash);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(MainActivity.this, CarWash.class));
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, " ERROR: Please try again, thanks. ",Toast.LENGTH_LONG).show();
                }
            }
        });
        Button button = (Button) findViewById(R.id.btnCabFare);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    try {
                        startActivity(new Intent(MainActivity.this, CabFare.class));
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, " ERROR: Please try again, thanks. ",Toast.LENGTH_LONG).show();
                    }
                }
            }
          }
        );}
    }