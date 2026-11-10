package com.example.recyclerfiveinterfaces.interface3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerfiveinterfaces.R;

import java.util.ArrayList;

public class ActivityInterface3 extends AppCompatActivity implements OnTaskStatusListener {

    RecyclerView recyclerView;
    TaskAdapter adapter;
    ArrayList<TaskItem> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface3);

        recyclerView = findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tasks = new ArrayList<>();
        tasks.add(new TaskItem("خواندن فصل ۵ کتاب اندروید", false));
        tasks.add(new TaskItem("انجام تمرینات جلسه قبل", true));
        tasks.add(new TaskItem("ارسال پروژه اینترفیس برای استاد", false));
        tasks.add(new TaskItem("نصب کتابخانه جدید", false));
        tasks.add(new TaskItem("پاسخ به ایمیل‌های دانشگاه", true));

        adapter = new TaskAdapter(tasks, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStatusChange(TaskItem task, boolean isChecked) {
        String status = isChecked ? "انجام شد" : "در انتظار انجام";
        Toast.makeText(this, task.title + " -> " + status, Toast.LENGTH_SHORT).show();
    }
}
