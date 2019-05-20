package com.example.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }
    public void OnClick(View view) {

        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
//        ImageView imageView = findViewById(r.id)


        String editTitle = editText.getText().toString();
        String editContent = editText2.getText().toString();

        JournalEntry journalEntry = new JournalEntry(editTitle, editContent);

        EntryDatabase.getInstance(getApplicationContext()).insert(journalEntry);
        finish();
    }
}
