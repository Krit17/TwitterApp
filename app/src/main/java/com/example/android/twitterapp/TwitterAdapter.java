package com.example.android.twitterapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Krit17 on 27-10-2017.
 */

public class TwitterAdapter extends RecyclerView.Adapter<TwitterAdapter.TweetViewHolder> {

List<Tweet> mTweetlist;
    Context mcontext;
    public TwitterAdapter(List<Tweet> tweetList){
        mTweetlist=tweetList;
    }
    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mTweetlist.size();
    }

    public static class TweetViewHolder extends RecyclerView.ViewHolder{
        ImageView ivUserAvatar;
        TextView tvUsername;
        TextView tvName;
        TextView tvBody;
        TextView tvTimeStampt;
        TextView tvRetweetCount;
        TextView tvFavoriteCount;
        ImageView ivMediaBody;

        public TweetViewHolder(View itemView) {
            super(itemView);
            ivUserAvatar=itemView.findViewById(R.id.user_avatar);
            tvUsername=itemView.findViewById(R.id.username);
            tvName=itemView.findViewById(R.id.name);
            tvBody=itemView.findViewById(R.id.body);
            tvTimeStampt=itemView.findViewById(R.id.timestamp);
            tvRetweetCount=itemView.findViewById(R.id.retweet_count);
            tvFavoriteCount=itemView.findViewById(R.id.favorite_count);
            ivMediaBody=itemView.findViewById(R.id.media_body);
        }
    }
}
