package algorithm.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by huaxiufeng on 19/2/27.
 */
public class LC355DesignTwitter {

    static class Twitter {
        private final int FEED_LIMIT = 10;
        private static int gtime = 0;
        private Map<Integer, User> userMap = new HashMap<>();

        static class Tweet {
            public int tweetId;
            public int userId;
            public int time;

            public Tweet(int tweetId, int userId) {
                this.tweetId = tweetId;
                this.userId = userId;
                this.time = gtime++;
            }
        }

        static class User {
            public int userId;
            public LinkedList<Tweet> tweets = new LinkedList<>();
            public Set<Integer> followSet = new HashSet<>(); // 我关注了哪些人

            public User(int userId) {
                this.userId = userId;
            }

            public void follow(int followeeId) {
                if (followeeId != this.userId) {
                    followSet.add(followeeId);
                }
            }

            public void unfollow(int followeeId) {
                followSet.remove(followeeId);
            }

            public void postTweet(int tweetId) {
                tweets.addFirst(new Tweet(tweetId, this.userId));
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            registerUserIfNecessary(userId);
            User user = userMap.get(userId);
            user.postTweet(tweetId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            LinkedList<Integer> result = new LinkedList<>();
            User user = userMap.get(userId);
            if (null == user) {
                return result;
            }
            PriorityQueue<Tweet> queue = new PriorityQueue<>(FEED_LIMIT, new Comparator<Tweet>() {
                @Override
                public int compare(Tweet o1, Tweet o2) {
                    return Integer.compare(o1.time, o2.time);
                }
            });
            for (Tweet tweet : user.tweets) {
                addTweetQueue(queue, tweet);
            }
            for (int followeeId : user.followSet) {
                User followee = userMap.get(followeeId);
                if (followee == null) {
                    continue;
                }
                for (Tweet tweet : followee.tweets) {
                    addTweetQueue(queue, tweet);
                }
            }
            while (!queue.isEmpty()) {
                result.addFirst(queue.poll().tweetId);
            }
            return result;
        }

        private void addTweetQueue(PriorityQueue<Tweet> queue, Tweet tweet) {
            if (queue.size() >= FEED_LIMIT && tweet.time < queue.peek().time) {
                return;
            }
            queue.offer(tweet);
            if (queue.size() > FEED_LIMIT) {
                queue.poll();
            }
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            registerUserIfNecessary(followerId);
            registerUserIfNecessary(followeeId);
            User user = userMap.get(followerId);
            user.follow(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            User user = userMap.get(followerId);
            if (user != null) {
                user.unfollow(followeeId);
            }
        }

        private void registerUserIfNecessary(int userId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1));

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        twitter.postTweet(1, 7);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
    }
}
