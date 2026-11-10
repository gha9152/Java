package com.example.recyclerfiveinterfaces.interface5;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerfiveinterfaces.R;

import java.util.ArrayList;

public class ActivityInterface5 extends AppCompatActivity implements OnMessageActionListener {

    RecyclerView recyclerView;
    ChatAdapter adapter;
    ArrayList<ChatMessage> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface5);

        recyclerView = findViewById(R.id.recyclerView5);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        messages = new ArrayList<>();
        messages.add(new ChatMessage("علی", "سلام، فایل پروژه رو دیدی؟", "10:30"));
        messages.add(new ChatMessage("رضا", "سلام آره، کدهای بخش اینترفیس اوکیه.", "10:32"));
        messages.add(new ChatMessage("سارا", "کلاس فردا حضوری برگزار میشه؟", "11:15"));
        messages.add(new ChatMessage("مهدی", "بله، ساعت ۸ صبح کلاس داریم.", "11:20"));
        messages.add(new ChatMessage("مریم", "ممنون از همگی.", "11:45"));

        adapter = new ChatAdapter(messages, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onReplyClick(ChatMessage chat) {
        Toast.makeText(this, "پاسخ به " + chat.sender + ": " + chat.message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShareClick(ChatMessage chat) {
        Toast.makeText(this, "اشتراک‌گذاری پیام: " + chat.message, Toast.LENGTH_SHORT).show();
    }
}
