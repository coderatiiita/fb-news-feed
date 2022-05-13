package in.fb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class NewsFeed {
    String userId;
    String id;
    List<String> listOfPosts;

    public NewsFeed(String userId) {
        this.userId = userId;
        this.id = UUID.randomUUID().toString();
        listOfPosts = new ArrayList<>();
    }
}
