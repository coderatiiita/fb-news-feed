package in.fb.controller;

import in.fb.service.PostService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostController {

    PostService postService;

    public boolean createPost(String userId, String post) {
        return postService.createPost(userId, post);
    }

    public boolean deletePost(String userId, String post) {
        return postService.deletePost(userId, post);
    }
}
