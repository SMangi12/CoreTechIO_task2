package com.example.notesapp_coretechio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAddNote;
    NoteAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new NoteAdapter(this, NoteDatabase.getInstance(this).noteDao().getAllNotes());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        btnAddNote = findViewById(R.id.btnAddNote);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAddNote.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, AddNoteActivity.class));
        });
    }
}
