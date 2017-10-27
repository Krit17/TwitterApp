package com.example.android.twitterapp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.FixedTweetTimeline;
import com.twitter.sdk.android.tweetui.Timeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TwitterListTimeline;
import com.twitter.sdk.android.tweetui.UserTimeline;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends ListFragment {
    public Home_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle("Home");
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.twitter.com").addConverterFactory(GsonConverterFactory.create()).build();
        ListService service=retrofit.create(ListService.class);


         TwitterSession session=  TwitterCore.getInstance().getSessionManager().getActiveSession();
        TwitterService twitterService=new TwitterService(session);
        Call<List<Tweet>> tweets=twitterService.getListServices().statuses(100,null,null,null,null,null,null);
        tweets.enqueue(new Callback<List<Tweet>>() {
            @Override
            public void success(Result<List<Tweet>> result) {
                List<Tweet> tweetList=result.data;
                Tweet tweet=tweetList.get(0);

                final FixedTweetTimeline timeline = new FixedTweetTimeline.Builder()
                        .setTweets(result.data)
                        .build();
                final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(view.getContext())
                        .setTimeline(timeline)
                        .build();
                setListAdapter(adapter);
            }

            @Override
            public void failure(TwitterException exception) {

            }
        });


//                final UserTimeline userTimeline = new UserTimeline.Builder()
//                        .screenName(session.getUserName())
//                        .build();
//                final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(view.getContext())
//                        .setTimeline(userTimeline)
//                        .build();


        return view;
    }

}
