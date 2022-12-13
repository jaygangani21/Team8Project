package com.cp3.team8project;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class ConfirmationOrder extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Button confirm;
    double Longitude,Latitude;
    Geocoder geocoder;
    Intent receive;
    TextView address;
    CartDatabase cartDatabase;
    ArrayList<Address> addresses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_order);


        toolbar = findViewById(R.id.toolbarConf);
        address = findViewById(R.id.address_details);
        confirm =findViewById(R.id.confirm_button);

        confirm.setOnClickListener(this);




        cartDatabase=CartDatabase.getInstance(this);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Confirm your order");
        }


        receive = getIntent();
        Longitude = receive.getDoubleExtra("Longitude" , 31.2025);
        Latitude  = receive.getDoubleExtra("Latitude" , 30.0395);

        geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        try {
            addresses  = (ArrayList<Address>) geocoder.getFromLocation(Latitude, Longitude,1);

            if (addresses != null && addresses.size()>0)
            {
                if (addresses.get(0).getThoroughfare() != null)
                {

//                    Toast.makeText(this,addresses.get(0).getThoroughfare() , Toast.LENGTH_SHORT).show();
                    address.setText(addresses.get(0).getThoroughfare());
                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View view) {
        startActivity(new Intent(ConfirmationOrder.this, OrderConfirmed.class));
    }

    public void setLocation(View view)
    {
        Intent intent = new Intent(ConfirmationOrder.this , MapsActivity.class);
        startActivity(intent);

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
