package utils;

import api.response.CommentResponse;
import api.response.PostResponse;
import api.response.UserResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Utils {

    public static String getGlobalValue(String key) throws IOException {
        // Method to fetch global property
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/global.properties");
        prop.load(fileInputStream);
        return prop.getProperty(key);
    }

    public String getUserID(UserResponse response, String userName) {
        return response.getUsers().stream().filter(x -> x.getUsername().contains(userName)).findAny().get().getId();
    }

    public List<String> getPostsOfUser(PostResponse response, String userID) {
        List<String> postID = new ArrayList<>();
        response.getPosts().stream().filter(x -> x.getUserId().contains(userID)).forEach(posts -> {
            postID.add(posts.getId());
        });
        return postID;
    }

    public List<String> getEmailIdOfUsers(CommentResponse commentResponse, List<String> postIDList) {
        List<String> listOfEmail = new ArrayList<>();
        for (String postID : postIDList) {
            commentResponse.getComments().stream().filter(x -> x.getPostId().contains(postID)).forEach(comments -> {
                listOfEmail.add(comments.getEmail());

            });
        }
        return listOfEmail;
    }

}
