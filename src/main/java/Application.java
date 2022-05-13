import in.fb.controller.NewsFeedController;
import in.fb.controller.PostController;
import in.fb.controller.UserController;
import in.fb.dao.PostDao;
import in.fb.dao.UserDao;
import in.fb.model.NewsFeed;
import in.fb.model.User;
import in.fb.service.NewsFeedService;
import in.fb.service.PostService;
import in.fb.service.UserService;

import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        User shubham = new User("Shubham");
        User raj = new User("Raj");
        User rajesh = new User("Rajesh");
        User simran = new User("Simran");

        PostDao postDao = new PostDao();
        UserDao userDao = new UserDao();


        NewsFeedService newsFeedService = new NewsFeedService(userDao, postDao);
        PostService postService = new PostService(newsFeedService, postDao);
        UserService userService = new UserService();

        PostController postController = new PostController(postService);
        UserController userController = new UserController(userService);
        NewsFeedController newsFeedController = new NewsFeedController(newsFeedService);

        userController.followUser(shubham.getId(), simran.getId());
        userController.followUser(shubham.getId(), raj.getId());
        userController.followUser(shubham.getId(), rajesh.getId());

        userController.followUser(simran.getId(), shubham.getId());
        userController.followUser(simran.getId(), raj.getId());

        userController.followUser(raj.getId(), shubham.getId());

        postController.createPost(shubham.getId(), "Hello World");
        postController.createPost(simran.getId(), "Dr Stranger");

        newsFeedController.getNewsFeed(raj.getId())
                .forEach(post -> System.out.println(post.getDescription()));

    }
}
