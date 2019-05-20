package com.example.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.ImageView;


public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, Cursor c) {
        super(context, R.layout.entry_row, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int i = cursor.getColumnIndex("title");
        String title = cursor.getString(i);
        TextView titleView = view.findViewById(R.id.titleTextView);
        titleView.setText(title);

        int j = cursor.getColumnIndex("content");
        String content = cursor.getString(j);
        TextView contentView = view.findViewById(R.id.contentTextView);
        contentView.setText(content);

//        int k = cursor.getColumnIndex("mood");
//        String mood = cursor.getString(k);
//        ImageView imageMood = view.findViewById(R.id.imageView);
////        imageMood.setImageResource(mood.getDrawableId());

//        int l = cursor.getColumnIndex("timestamp");
//        int time = cursor.getInt(j);
//        TextView contentView = view.findViewById(R.id.contentTextView);
//        contentView.setText(content);


    }
}
