package in.fb.service;

import in.fb.dao.PostDao;
import in.fb.model.Post;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class PostService {

    public NewsFeedService newsFeedService;
    public PostDao postDao;

    public boolean createPost(String userId, String text) {
        String postId = UUID.randomUUID().toString();
        postDao.createPost(userId, new Post(postId, text, new Date()));

        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> newsFeedService.addPost(userId, postId));
        return true;
    }

    public boolean deletePost(String userId, String postId) {
        postDao.deletePost(userId, postId);
        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> newsFeedService.deletePost(userId, postId));
        return true;
    }
}
