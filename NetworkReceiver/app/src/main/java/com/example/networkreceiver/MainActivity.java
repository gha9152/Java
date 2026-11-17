package com.example.networkreceiver;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NetworkChangeReceiver.NetworkListener {

    TextView txtStatus;
    Button btnClear;
    ListView listView;
    ArrayList<String> logList;
    ArrayAdapter<String> adapter;
    NetworkChangeReceiver receiver;
    Boolean lastState = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtStatus = findViewById(R.id.txtStatus);
        btnClear = findViewById(R.id.btnClear);
        listView = findViewById(R.id.listView);

        logList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logList);
        listView.setAdapter(adapter);

        receiver = new NetworkChangeReceiver(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logList.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    @Override
    public void onNetworkChange(boolean isConnected, String networkType) {
        if (lastState != null && lastState == isConnected) {
            return;
        }
        lastState = isConnected;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());

        String logMessage;
        if (isConnected) {
            logMessage = "[وصل شد] " + networkType + "\nزمان: " + currentTime;
            txtStatus.setText("وضعیت: متصل (" + networkType + ")");
            txtStatus.setTextColor(0xFF388E3C);
        } else {
            logMessage = "[قطع شد] اینترنت قطع شد\nزمان: " + currentTime;
            txtStatus.setText("وضعیت: اینترنت قطع است");
            txtStatus.setTextColor(0xFFD32F2F);
        }

        logList.add(0, logMessage);
        adapter.notifyDataSetChanged();
    }
}
