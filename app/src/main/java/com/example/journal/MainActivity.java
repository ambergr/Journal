package com.example.journal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    JournalEntry journalEntry;

    private EntryAdapter adapter;
    private EntryDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.database = EntryDatabase.getInstance(getApplicationContext());
        Cursor selectData = database.selectAll();
        this.adapter = new EntryAdapter(getApplicationContext(), selectData);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new onItemClickListener());

        ListView listView2 = findViewById(R.id.listView);
        listView2.setAdapter(adapter);
        listView2.setOnItemLongClickListener(new onItemLongClickListener());

    }


    private class onItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        // extraheert op welke entry plaatje er geklikt wordt en stuurt dit door naar detailactivity
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);

            int i = cursor.getColumnIndex("title");
            String title = cursor.getString(i);

            int j = cursor.getColumnIndex("content");
            String content = cursor.getString(j);

//            int k = cursor.getColumnIndex("mood");
//            String mood = cursor.getString(k);

            JournalEntry journalEntry = new JournalEntry(title, content);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("journalEntry", journalEntry);
            startActivity(intent);
        }

    }

    private class onItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);

            int i = cursor.getColumnIndex("_id");
            int ids = cursor.getInt(i);

            EntryDatabase.getInstance(getApplicationContext()).delete(ids);
            updateData();

            return true;
        }

    }

    private void updateData() {
        Cursor updateCurs = database.selectAll();

        adapter.swapCursor(updateCurs);

    }


    public void OnClick(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
//        intent.putExtra("JournalEntry", journalEntry);
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        updateData();

    }

}