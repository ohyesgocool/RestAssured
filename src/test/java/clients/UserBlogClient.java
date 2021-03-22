package clients;

import api.requests.UserBlogAPI;
import api.response.CommentResponse;
import api.response.PostResponse;
import api.response.UserResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Reporter;

import java.io.IOException;
import java.util.List;

public class UserBlogClient {
    UserBlogAPI getUserBlogDetails;
    Response response ;

    public UserBlogClient(){
        getUserBlogDetails = new UserBlogAPI();

    }

    public UserResponse getUserResponse (){
        response = getUserBlogDetails.getUserBlog("users");
        UserResponse userResponse =new UserResponse();
        try {
            userResponse.setUsers((List<UserResponse.Users>) new ObjectMapper().readValue(response.getBody().asString() , new TypeReference<List<UserResponse.Users>>(){
            }));
        } catch (IOException e) {
            Reporter.log("Exception in Mapping the JSON to User class ----> " + e.toString(), true);
        }
        userResponse.setHttpStatusCode(response.getStatusCode());
        return userResponse;
    }

    public PostResponse getPostResponse(){
         response = getUserBlogDetails.getUserBlog("posts");
         PostResponse postResponse = new PostResponse();

        try {
            postResponse.setPosts((List<PostResponse.Posts>) new ObjectMapper().readValue(response.getBody().asString() , new TypeReference<List<PostResponse.Posts>>(){
            }));
        } catch (IOException e) {
            Reporter.log("Exception in Mapping the JSON to User class ----> " + e.toString() , true);
        }
        postResponse.setHttpStatusCode(response.getStatusCode());
        return  postResponse;
    }

    public CommentResponse getCommentRespone(){
        response = getUserBlogDetails.getUserBlog("comments");
        CommentResponse commentResponse = new CommentResponse();

        try {
            commentResponse.setComments((List<CommentResponse.Comments>) new ObjectMapper().readValue(response.getBody().asString() , new TypeReference<List<CommentResponse.Comments>>(){
            }));
        } catch (IOException e) {
            Reporter.log("Exception in Mapping the JSON to User class ----> " + e.toString() , true);
        }
        commentResponse.setHttpStatusCode(response.getStatusCode());
        return  commentResponse;
    }
}
