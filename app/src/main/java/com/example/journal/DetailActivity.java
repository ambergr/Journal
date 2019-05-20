package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    JournalEntry journalEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        journalEntry = (JournalEntry) intent.getSerializableExtra("journalEntry");

        String content = journalEntry.getContent();
        String title = journalEntry.getTitle();

        TextView textView = findViewById(R.id.titleDetail);
        textView.setText(title);

        TextView textView2= findViewById(R.id.contentDetail);
        textView2.setText(content);
    }
}
