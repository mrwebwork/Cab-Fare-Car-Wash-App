package edu.txstate.ash140.cabfareandcarwash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CabFare extends AppCompatActivity {
   /* int txtDistance;
    double txtCab;
    String txtCabFareResult;*/

    double numberOfMiles;
    double costPerCab = 5.50;
    double costPerMile = 3.25;
    String carSelection;
    double totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_fare);
        final EditText miles = (EditText) findViewById(R.id.txtDistance);
        final Spinner group = (Spinner) findViewById(R.id.txtCab);


        Button result = (Button) findViewById(R.id.btnCabFareResult);
        result.setOnClickListener(new View.OnClickListener() {
            TextView result = (TextView) findViewById(R.id.txtCabFareResult);
            @Override
            public void onClick(View view) {
                try {
                    numberOfMiles = Double.parseDouble(miles.getText().toString());
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    carSelection = group.getSelectedItem().toString();
                    totalCost = numberOfMiles * costPerMile + costPerCab;
                    result.setText(" You chose a " + carSelection + " for a total of " + currency.format(totalCost) );
                }
                catch (Exception e) {
                    Toast.makeText(CabFare.this, " Please enter number values ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}