package main.com.leetcode.problems.problem0355;

import java.util.*;
import java.util.stream.Collectors;

public class Twitter {

  private final Map<Integer, Set<Integer>> followerIdToFolloweesIds;
  private final Map<Integer, List<Tweet>> userIdToTweets;
  private int timeStamp;

  /** Initialize your data structure here. */
  public Twitter() {
    followerIdToFolloweesIds = new HashMap<>();
    userIdToTweets = new HashMap<>();
    timeStamp = 0;
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    List<Tweet> existingTweets = userIdToTweets.getOrDefault(userId, new ArrayList<>());
    existingTweets.add(new Tweet(tweetId, timeStamp));
    userIdToTweets.put(userId, existingTweets);
    timeStamp++;
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    List<Tweet> tweets = new ArrayList<>();
    tweets.addAll(userIdToTweets.getOrDefault(userId, new ArrayList<>()));
    Set<Integer> followees = followerIdToFolloweesIds.getOrDefault(userId, new HashSet<>());
    for (int followeeId : followees) {
      tweets.addAll(userIdToTweets.getOrDefault(followeeId, new ArrayList<>()));
    }
    Collections.sort(tweets, (o1, o2) -> o1.time - o2.time);
    if (tweets.size() > 10) {
      tweets = new ArrayList<>(tweets.subList(tweets.size() - 10, tweets.size()));
    }
    Collections.reverse(tweets);
    return tweets.stream().map(tweet -> tweet.id).collect(Collectors.toList());
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if (followeeId == followerId) {
      return;
    }
    Set<Integer> followees = followerIdToFolloweesIds.getOrDefault(followerId, new HashSet<>());
    followees.add(followeeId);
    followerIdToFolloweesIds.put(followerId, followees);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    Set<Integer> followees = followerIdToFolloweesIds.getOrDefault(followerId, new HashSet<>());
    followees.remove(followeeId);
  }

  private static class Tweet {
    private int id;
    private int time;

    Tweet(int id, int time) {
      this.id = id;
      this.time = time;
    }
  }

  public static void main(String[] args) {
    Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
    twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
    twitter.getNewsFeed(1);

// User 1 follows user 2.
    twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
    twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    twitter.getNewsFeed(1);

// User 1 unfollows user 2.
    twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
    twitter.getNewsFeed(1);
  }
}
