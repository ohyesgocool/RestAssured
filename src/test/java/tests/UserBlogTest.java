package tests;

import api.response.CommentResponse;
import api.response.PostResponse;
import api.response.UserResponse;
import assertions.UserBlogAssertions;
import clients.UserBlogClient;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.Utils;

import java.util.List;


public class UserBlogTest {

    UserBlogClient userBlogClient;
    Utils utils;
    String userID;
    UserBlogAssertions assertions;
    String userName = "Samantha";
    List<String> listOfPostId;
    List<String> listOfEmail;

    public UserBlogTest() {
        userBlogClient = new UserBlogClient();
        utils = new Utils();
        assertions = new UserBlogAssertions();
    }

    @Test
    public void searchUserTest() {

        UserResponse searchUserResponse = userBlogClient.getUserResponse();
        userID = utils.getUserID(searchUserResponse, userName);
        Reporter.log("User ID is " + userID, true);
        assertions.assertUserResponse(searchUserResponse, userID);
    }

    @Test(dependsOnMethods = "searchUserTest")
    public void validatePostsOfUserTest() {
        PostResponse postResponse = userBlogClient.getPostResponse();
        listOfPostId = utils.getPostsOfUser(postResponse, userID);
        assertions.assertPostResponse(postResponse);
        Reporter.log("Post ID made by the particular user " + listOfPostId, true);
    }

    @Test(dependsOnMethods = "validatePostsOfUserTest")
    public void validateEmailIdOfCommentedUsers() {

        CommentResponse commentResponse = userBlogClient.getCommentRespone();
        assertions.assertCommentResponse(commentResponse);
        listOfEmail = utils.getEmailIdOfUsers(commentResponse, listOfPostId);
        Reporter.log("Email ID of users who commented are " + listOfEmail, true);
        Assert.assertTrue(assertions.isValidEmailAddress(listOfEmail));

    }
}
