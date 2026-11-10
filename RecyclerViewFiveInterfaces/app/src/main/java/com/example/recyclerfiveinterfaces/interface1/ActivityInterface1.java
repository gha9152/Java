package com.example.recyclerfiveinterfaces.interface1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerfiveinterfaces.R;

import java.util.ArrayList;

public class ActivityInterface1 extends AppCompatActivity implements OnContactClickListener {

    RecyclerView recyclerView;
    ContactAdapter adapter;
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface1);

        recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contacts = new ArrayList<>();
        contacts.add(new Contact("علی محمدی", "09121111111"));
        contacts.add(new Contact("رضا احمدی", "09122222222"));
        contacts.add(new Contact("سارا حسینی", "09123333333"));
        contacts.add(new Contact("مهدی کریمی", "09124444444"));
        contacts.add(new Contact("مریم صادقی", "09125555555"));

        adapter = new ContactAdapter(contacts, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onContactClick(Contact contact) {
        Toast.makeText(this, "تماس با: " + contact.name + " (" + contact.phone + ")", Toast.LENGTH_SHORT).show();
    }
}
