package in.fb.dao;

import in.fb.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    List<User> users;

    public UserDao() {
        this.users = new ArrayList<>();
    }

    public User getUser(String userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst().get();
    }
}
