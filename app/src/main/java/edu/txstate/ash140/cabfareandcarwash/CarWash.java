package edu.txstate.ash140.cabfareandcarwash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class CarWash extends AppCompatActivity {

    double exteriorWash = 10.5;
    double specialWash = 15;
    double totalCost;
    int numberOfWashes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wash);

        final RadioButton exterior = (RadioButton) findViewById(R.id.radioBtnExterior);
        final RadioButton service = (RadioButton) findViewById(R.id.radioBtnService);
        TextView washes = (TextView) findViewById(R.id.txtNumOfWashes);
        Button calc = (Button) findViewById(R.id.btnCarWashCalc);

        calc.setOnClickListener(new View.OnClickListener() {
            TextView total = (TextView) findViewById(R.id.txtTotalCarWashes);

            @Override
            public void onClick(View view) {
                try {
                    numberOfWashes = Integer.parseInt(washes.getText().toString());
                    DecimalFormat currency = new DecimalFormat("$###,###.##");

                    // if statement for exterior radio btn
                    if (exterior.isChecked()){
                        totalCost = numberOfWashes * exteriorWash;
                    }

                    // if statement for special wash radio btn
                    if (service.isChecked()){
                        totalCost =  numberOfWashes * specialWash;
                    }

                    // if statement for car wash vs car washes text
                    if(numberOfWashes <= 1)
                    {
                        total.setText(" You placed an order for " + numberOfWashes + " Car Wash " + "for a Total of " + currency.format(totalCost));
                    }else{
                        // the "x amt" is where the variable will go when we cast it off
                        // the "y amt " is where will display the total price
                        total.setText(" You placed an order for " + numberOfWashes + " Car Washes " + "for a Total of " + currency.format(totalCost));
                    }
                } catch (Exception e) {
                    Toast.makeText(CarWash.this, " Please enter number values ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}