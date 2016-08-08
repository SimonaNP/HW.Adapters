package com.qkikakiood.a9gag_ish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.qkikakiood.a9gag_ish.Adapters.ItemAdapter;

public class MainActivity extends Activity {

    ListView lv;

    String[] titles = {"Potato", "True story", "FML"};
    int[] imgs = {R.drawable.potato, R.drawable.truestory, R.drawable.fml};
    String[] likes = {"likes", "likes", "likes", "likes", "likes", "likes"};
    String[] comments = {"comments " + CommentActivity.commentsList.size(),"comments " + CommentActivity.commentsList.size(),
            "comments " + CommentActivity.commentsList.size(), "comments " + CommentActivity.commentsList.size(),
            "comments " + CommentActivity.commentsList.size(), "comments " + CommentActivity.commentsList.size()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView1);
        ItemAdapter adapter = new ItemAdapter(this, titles, likes, comments, imgs);
        lv.setAdapter(adapter);



    }
}