package com.qkikakiood.a9gag_ish;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.qkikakiood.a9gag_ish.Adapters.CommentsAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class CommentActivity extends AppCompatActivity {
    public static ArrayList<String> commentsList= new ArrayList<>();

    Button btnSend;
    EditText editTxt;
    TextView comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ListView lv= (ListView) findViewById(R.id.listView2);
        CommentsAdapter adapter = new CommentsAdapter(this);
        lv.setAdapter(adapter);

        btnSend= (Button) findViewById(R.id.btn_send);
        editTxt= (EditText) findViewById(R.id.edit_txt);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentsList.add(editTxt.getText().toString());
                Intent intent= new Intent(CommentActivity.this,CommentActivity.class);
                startActivity(intent);
            }
        });


    }
}
