package in.fb.dao;

import in.fb.model.Post;

import java.util.*;

public class PostDao {

    Map<String, List<Post>> posts;

    public PostDao() {
        this.posts = new HashMap<>();
    }

    public Post getPost(String userId, String postId) {
        return posts.get(userId)
                .stream()
                .filter(post -> post.getId().equals(postId))
                .findFirst().get();
    }

    public void createPost(String userId, Post post) {
        if (!posts.containsKey(userId)) {
            posts.put(userId, new ArrayList<>());
        }
        posts.get(userId).add(post);
    }

    public void deletePost(String userId, String postId) {
        posts.get(userId).removeIf(post -> post.getId().equals(postId));
    }

}
