package in.fb.service;

import in.fb.dao.PostDao;
import in.fb.dao.UserDao;
import in.fb.model.Post;
import in.fb.model.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class NewsFeedService {

    UserDao userDao;
    PostDao postDao;

    public List<Post> getNewsFeed(String userId) {
        List<String> posts =  userDao.getUser(userId).getNewsFeed().getListOfPosts();

        List<Post> resp = posts.stream()
                .map(postId -> postDao.getPost(userId, postId))
                .collect(Collectors.toList());

        resp.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        return resp.subList(0, 10);
    }

    public List<Post> getNewsFeedPaginated(String userId, int page) {
        List<String> posts =  userDao.getUser(userId).getNewsFeed().getListOfPosts();

        List<Post> resp = posts.stream()
                .map(postId -> postDao.getPost(userId, postId))
                .collect(Collectors.toList());

        resp.sort((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));

        return resp.subList(page*2, page*2 + 2);
    }

    public boolean addPost(String userId, String postId) {
        User user = userDao.getUser(userId);

        for (String follower : user.getFollowers()) {
            User friend = userDao.getUser(follower);
            friend.getNewsFeed().getListOfPosts().add(postId);
        }
        return true;
    }

    public boolean deletePost(String userId, String postId) {
        User user = userDao.getUser(userId);

        for (String follower : user.getFollowers()) {
            User friend = userDao.getUser(follower);
            friend.getNewsFeed().getListOfPosts().remove(postId);
        }
        return true;
    }
}
