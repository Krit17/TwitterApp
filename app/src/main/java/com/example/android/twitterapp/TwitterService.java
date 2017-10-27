package com.example.android.twitterapp;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by Krit17 on 26-10-2017.
 */

public class TwitterService extends TwitterApiClient {
    public TwitterService(TwitterSession session){
        super(session);
    }



    public ListService getListServices(){
        return getService(ListService.class);
    }
}
