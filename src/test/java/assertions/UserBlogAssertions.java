package assertions;

import api.response.CommentResponse;
import api.response.PostResponse;
import api.response.UserResponse;
import org.testng.Assert;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

public class UserBlogAssertions {

    public void assertUserResponse(UserResponse response, String userID) {

        //Validating if no null value is returned in json file
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getId());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getUsername());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getEmail());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getName());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getPhone());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getWebsite());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getAddress().getCity());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getAddress().getStreet());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getAddress().getSuite());
        Assert.assertNotNull(response.getUsers().get(Integer.parseInt(userID)).getAddress().getZipcode());
        Assert.assertEquals(response.getHttpStatusCode(), 200);
    }

    public void assertPostResponse(PostResponse response ){
        //Validating if no null value is returned in json file
        Assert.assertNotNull(response.getPosts().get(0).getTitle());
        Assert.assertNotNull(response.getPosts().get(0).getBody());
        Assert.assertNotNull(response.getPosts().get(0).getUserId());
        Assert.assertEquals(response.getHttpStatusCode() , 200);

    }

    public void assertCommentResponse(CommentResponse response ){
        //Validating if no null value is returned in json file
        Assert.assertNotNull(response.getComments().get(0).getBody());
        Assert.assertNotNull(response.getComments().get(0).getPostId());
        Assert.assertNotNull(response.getComments().get(0).getEmail());
        Assert.assertNotNull(response.getComments().get(0).getName());
        Assert.assertNotNull(response.getComments().get(0).getId());
        Assert.assertEquals(response.getHttpStatusCode() , 200);
    }


    public boolean isValidEmailAddress(List<String> listOfEmail) {
        boolean result = true;
        for (String email : listOfEmail) {
            try {
                InternetAddress emailAddress = new InternetAddress(email);
                emailAddress.validate();
            } catch (AddressException ex) {
                result = false;
            }
        }
        return result;
    }



}
