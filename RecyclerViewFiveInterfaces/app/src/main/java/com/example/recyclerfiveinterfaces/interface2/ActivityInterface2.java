package com.example.recyclerfiveinterfaces.interface2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerfiveinterfaces.R;

import java.util.ArrayList;

public class ActivityInterface2 extends AppCompatActivity implements OnProductActionListener {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface2);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        products = new ArrayList<>();
        products.add(new Product("لپ‌تاپ ایسوس", "35,000,000"));
        products.add(new Product("گوشی سامسونگ", "18,500,000"));
        products.add(new Product("هدفون بلوتوثی", "1,200,000"));
        products.add(new Product("ساعت هوشمند", "2,800,000"));
        products.add(new Product("کیبورد مکانیکی", "1,950,000"));

        adapter = new ProductAdapter(products, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBuyClick(Product product) {
        Toast.makeText(this, product.title + " به سبد خرید اضافه شد", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetailsClick(Product product) {
        Toast.makeText(this, "مشخصات: " + product.title + " | قیمت: " + product.price, Toast.LENGTH_SHORT).show();
    }
}
