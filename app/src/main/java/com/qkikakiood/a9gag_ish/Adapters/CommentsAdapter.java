package com.qkikakiood.a9gag_ish.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qkikakiood.a9gag_ish.CommentActivity;

import java.util.ArrayList;

public class CommentsAdapter extends BaseAdapter {
    public static final int text1=android.R.id.text1;
    Context cttxt;
    LayoutInflater myInflater;
    ArrayList<String> comments;
    Button btn_send;
    EditText edit_txt;

    public CommentsAdapter( Context c){
        comments=new ArrayList<>();
        cttxt=c;
        myInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return CommentActivity.commentsList.size();
    }

    @Override
    public Object getItem(int position) {
        return CommentActivity.commentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=myInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
        }
        final TextView comment= (TextView) convertView.findViewById(android.R.id.text1);


        comment.setText(CommentActivity.commentsList.get(position));

        return convertView;
    }

}