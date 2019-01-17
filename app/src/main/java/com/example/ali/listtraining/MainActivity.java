package com.example.ali.listtraining;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btnSelectCity, btnSelectContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectCity = (Button)findViewById(R.id.btnSelectCity);
        btnSelectContact = (Button)findViewById(R.id.btnSelectContact);

        btnSelectCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CityListActivity.class);
                startActivityForResult(i, 1);
            }
        });

        btnSelectContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ContactsActivity.class);
                startActivity(i);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) // city selection
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String city = data.getStringExtra("city");
            builder.setMessage("شهر انتخابی شما " + city + " میباشد.");
            builder.setPositiveButton("تائید", null);
            builder.setNegativeButton("تغییر شهر", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(MainActivity.this, CityListActivity.class);
                    startActivityForResult(i, 1);
                }
            });
            builder.create().show();
        }
        else if(requestCode == 2) // contact selection
        {

        }
    }
}
