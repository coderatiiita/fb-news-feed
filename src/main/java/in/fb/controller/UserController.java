package in.fb.controller;

import in.fb.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserController {

    UserService userService;

    public boolean followUser(String followeeId, String followerId) {
        return userService.followUser(followeeId, followerId);
    }

    public boolean unfollowUser(String followeeId, String followerId) {
        return userService.unfollowUser(followeeId, followerId);
    }

}
