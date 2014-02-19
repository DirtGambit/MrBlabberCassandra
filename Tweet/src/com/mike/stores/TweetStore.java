package com.mike.stores;

public class TweetStore {
    String Tweet;
    String Handle;
    
    public String getTweet(){
   	 return Tweet;
    }
    public String getUser(){
   	 return Handle;
    }
    
    public void setTweet(String Tweet){
   	 this.Tweet=Tweet;
    }
    public void setUser(String User){
   	 this.Handle=User;
    }
    
}
