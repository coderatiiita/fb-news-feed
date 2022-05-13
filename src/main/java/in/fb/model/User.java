package in.fb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User {
    String id;
    String name;
    NewsFeed newsFeed;
    List<String> followers;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.newsFeed = new NewsFeed(this.id);
        this.followers = new ArrayList<>();
    }
}
