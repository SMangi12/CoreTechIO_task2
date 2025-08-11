package com.example.notesapp_coretechio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddNoteActivity extends AppCompatActivity {

    EditText etTitle, etDescription;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String description = etDescription.getText().toString().trim();

            if (!title.isEmpty() && !description.isEmpty()) {
                NoteDatabase.getInstance(this).noteDao().insert(new Note(title, description));
                finish(); // Go back to HomeActivity
            }
        });
    }
}
