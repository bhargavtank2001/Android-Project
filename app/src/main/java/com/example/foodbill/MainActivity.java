package com.example.foodbill;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView header_title,pizza_price,burger_price,cold_drink_price,bill_txt;
    CheckBox pizza,burger,cold_drink;
    Button order_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header_title = (TextView) findViewById(R.id.header_title);
        pizza_price = (TextView) findViewById(R.id.pizza_price);
        burger_price = (TextView) findViewById(R.id.burger_price);
        cold_drink_price = (TextView) findViewById(R.id.cold_drink_price);
        bill_txt = (TextView) findViewById(R.id.bill_txt);

        pizza = (CheckBox) findViewById(R.id.pizza);
        burger = (CheckBox) findViewById(R.id.burger);
        cold_drink = (CheckBox) findViewById(R.id.cold_drink);

        order_btn = (Button) findViewById(R.id.order_btn);

        order_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                int total=0;
                StringBuffer sb = new StringBuffer();

                if(pizza.isChecked())
                {
                    total+=350;
                    sb.append("\nPizza : 350/-");
                }
                if(burger.isChecked())
                {
                    total+=100;
                    sb.append("\nBurger : 100/-");
                }
                if(cold_drink.isChecked())
                {
                    total+=50;
                    sb.append("\nCold Drink : 50/-");
                }

                bill_txt.setText("\t\n\nTotal Order \n" + sb.toString() + "\n\nTotal Amount :- " + total + "/-" );
                Toast.makeText(getApplicationContext(),"Total order : \n"+sb.toString()+"\n\nTotal Amount :-"+total, LENGTH_LONG).show();

            }
        });
    }
}