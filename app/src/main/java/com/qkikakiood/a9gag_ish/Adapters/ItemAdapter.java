package com.qkikakiood.a9gag_ish.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.qkikakiood.a9gag_ish.CommentActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<String> {

    Context c;
    LayoutInflater inflater;
    int[] imgs;
    String[] titles;
    String[] likes;
    String[] comments;
    static int[] numberLikes = new int[6];


    public ItemAdapter(Context context, String[] titles, String[] likes, String[] comments, int[] imgs) {
        super(context, R.layout.model, titles);

        this.c = context;
        this.imgs = imgs;
        this.likes = likes;
        this.comments = comments;
        this.titles = titles;
        for (int i = 0; i < 6; i++) {
            numberLikes[i] = 0;
        }

    }

    public class ViewHolder {

        TextView title;
        ImageView image;
        TextView likes;
        TextView comments;
        ImageButton btnLike;
        ImageButton btnDislike;
        ImageButton btnComment;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model, null);
        }

        final ViewHolder holder = new ViewHolder();
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.image = (ImageView) convertView.findViewById(R.id.image);
        holder.likes = (TextView) convertView.findViewById(R.id.likes);
        holder.comments = (TextView) convertView.findViewById(R.id.comments);
        holder.btnLike = (ImageButton) convertView.findViewById(R.id.btn_like);
        holder.btnDislike = (ImageButton) convertView.findViewById(R.id.btn_dislike);
        holder.btnComment = (ImageButton) convertView.findViewById(R.id.btn_comment);


        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberLikes[position] = 1;
                holder.likes.setText(likes[position] + "" + numberLikes[position]);

            }
        });

        holder.btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberLikes[position] = -1;
                holder.likes.setText(likes[position] + "" + numberLikes[position]);

            }
        });

        holder.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.startActivity(new Intent(c, CommentActivity.class));

            }
        });


        holder.image.setImageResource(imgs[position]);
        holder.title.setText(titles[position]);
        holder.likes.setText(likes[position] + "" + numberLikes[position]);
        holder.comments.setText(comments[position] );

        return convertView;

    }

}