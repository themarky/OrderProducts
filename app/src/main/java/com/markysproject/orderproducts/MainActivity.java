package com.markysproject.orderproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView quantityTv,quantityCount,priceTv,priceCount;
    Button IncrementBtn,decrementBtn,backBtn,orderBtn;

    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIt();
        decrementBtn.setEnabled(false);
        orderBtn.setEnabled(false);
        backBtn.setVisibility(View.GONE);

    }
    private void setIt(){
        quantityTv = (TextView) findViewById(R.id.quantityTv);
        quantityCount = (TextView) findViewById(R.id.quantityCount);
        priceTv = (TextView) findViewById(R.id.priceTv);
        priceCount = (TextView) findViewById(R.id.priceCount);
        IncrementBtn = (Button) findViewById(R.id.IncrementBtn);
        decrementBtn = (Button) findViewById(R.id.decrementBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        orderBtn = (Button) findViewById(R.id.orderBtn);
    }

    public void IncrementQuantity(View view){
        Increment();
    }
    public void decrementQuantity(View view){
        decrement();
    }

    public void orderNow(View view){
        ordered();
    }

    public void goBack(View view){
        setToMain();
    }

    private void Increment(){
        quantity = quantity + 1;
        orderBtn.setEnabled(true);
        decrementBtn.setEnabled(true);
        price = price + 5;
        show();
    }

    private void decrement(){
        quantity = quantity - 1;
        price = price - 5;

        if (quantity < 1 || price < 5){
            quantity = 0;
            price = 0;
            decrementBtn.setEnabled(false);
            orderBtn.setEnabled(false);
            Toast.makeText(this,"Quantity Should be greater than 1",Toast.LENGTH_SHORT).show();
        }
        show();
    }

    private void ordered(){
        if (quantity < 1 || price < 5){
            Toast.makeText(this,"Quantity Should be greater than 1",Toast.LENGTH_SHORT).show();
        }else{
            quantityTv.setVisibility(View.GONE);
            quantityCount.setVisibility(View.GONE);
            IncrementBtn.setVisibility(View.GONE);
            decrementBtn.setVisibility(View.GONE);
            orderBtn.setVisibility(View.GONE);
            backBtn.setVisibility(View.VISIBLE);
            priceTv.setText("Receipt:\n");
            priceCount.setText("Total Quantity: "+quantity+"\nPrice: $"+price+"\nThank You.");
        }
    }

    private void setToMain(){
        quantity = 0;
        price = 0;
        quantityTv.setVisibility(View.VISIBLE);
        quantityCount.setVisibility(View.VISIBLE);
        IncrementBtn.setVisibility(View.VISIBLE);
        decrementBtn.setVisibility(View.VISIBLE);
        orderBtn.setVisibility(View.VISIBLE);
        backBtn.setVisibility(View.GONE);
        decrementBtn.setEnabled(false);
        orderBtn.setEnabled(false);
        priceTv.setText("Price");
        show();
    }

    private void show(){
        quantityCount.setText(""+quantity);
        priceCount.setText("$"+price);
    }
}