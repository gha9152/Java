
package com.example.vh_n;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editNote;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editNote = findViewById(R.id.editNote);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String text = editNote.getText().toString().trim();

            if (text.isEmpty()) {
                editNote.setError("لطفاً متن نوت را وارد کنید");
                return;
            }

            Note.addNote(text);

            Toast.makeText(
                    AddNoteActivity.this,
                    "نوت با موفقیت اضافه شد",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        });
    }
}
