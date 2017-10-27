package com.example.android.twitterapp;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Krit17 on 26-10-2017.
 */

public interface ListService {
    @GET("/1.1/statuses/home_timeline.json")
    public Call<List<Tweet>> statuses(@Query("count") int count, @Query("since_id") Long sinceId,
                                      @Query("max_id") Long maxId,
                                      @Query("trim_user") Boolean trimUser,
                                      @Query("exclude_replies") Boolean excludeReplies,
                                      @Query("contributor_details") Boolean contributeDetails,
                                      @Query("include_entities") Boolean includeEntities);
}
