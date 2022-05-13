package in.fb.controller;

import in.fb.model.Post;
import in.fb.service.NewsFeedService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class NewsFeedController {

    NewsFeedService newsFeedService;

    public List<Post> getNewsFeed(String userId) {
        return newsFeedService.getNewsFeed(userId);
    }

    public List<Post> getNewsFeedPaginated(String userId, int pageNumber) {
        return newsFeedService.getNewsFeedPaginated(userId, pageNumber);
    }
}
