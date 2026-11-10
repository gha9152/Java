package com.example.recyclerfiveinterfaces.interface4;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerfiveinterfaces.R;

import java.util.ArrayList;

public class ActivityInterface4 extends AppCompatActivity implements OnNoteDeleteListener {

    RecyclerView recyclerView;
    NoteAdapter adapter;
    ArrayList<NoteItem> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface4);

        recyclerView = findViewById(R.id.recyclerView4);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notes = new ArrayList<>();
        notes.add(new NoteItem("جلسه با استاد", "فردا ساعت ۱۰ صبح در دانشکده"));
        notes.add(new NoteItem("خرید کتاب", "خرید کتاب ساختمان داده و الگوریتم"));
        notes.add(new NoteItem("تحویل پروژه اندروید", "کدها باید تا آخر هفته ارسال شوند"));
        notes.add(new NoteItem("ورزش", "تمرین بدنسازی عصر ساعت ۶"));
        notes.add(new NoteItem("تماس با پشتیبانی", "پیگیری سفارش اینترنتی"));

        adapter = new NoteAdapter(notes, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNoteDelete(int position, NoteItem note) {
        notes.remove(position);
        adapter.notifyItemRemoved(position);
        Toast.makeText(this, "یادداشت '" + note.title + "' حذف شد", Toast.LENGTH_SHORT).show();
    }
}
