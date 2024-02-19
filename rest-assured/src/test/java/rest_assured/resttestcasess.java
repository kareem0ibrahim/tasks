package rest_assured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.empty;

public class resttestcasess {
	public class JsonPlaceholderTest {

		@Test
		public void testGetListOfUsers() 
		{
			// validate on get users list by status code
			given().when().get("https://jsonplaceholder.typicode.com/users").then().assertThat().statusCode(200); 
		}

		@Test
		public void testGetSingleUser() 
		{   
			//get user by id
			given().when().get("https://jsonplaceholder.typicode.com/users/1").then().assertThat().statusCode(200)
			.body("id", equalTo(1)); 
		}

		@Test
		public void testInvalidUserID() 
		{
			//Test with an invalid user ID that doesn't exist in the system
			given().when().get("https://jsonplaceholder.typicode.com/users/999").then().assertThat().statusCode(404);
		}


		@Test
		public void testValidateNameUsernameEmailForUser() 
		{
			//validate response body for specific user id
			given().when().get("https://jsonplaceholder.typicode.com/users/1").then().assertThat().statusCode(200)
			.body("id", equalTo(1)) // Assuming the user is 1
			.body("name", equalTo("Leanne Graham")) // Assuming the expected name is "Leanne Graham"
			.body("username", equalTo("Bret")) // Assuming the expected Username is "Bret"
			.body("email", equalTo("Sincere@april.biz")); // Assuming the expected email is "Sincere@april.biz"
		}
		@Test
		public void testGetListOfPosts() 
		{
			// validate that there are 100 post in the response
			given().when().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().statusCode(200)
			.body("size()", equalTo(100)); // Assuming there are 100 posts in the response
		}

		@Test
		public void testGetPostById() 
		{
			//get post by id
			given().when().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().statusCode(200)
			.body("id", equalTo(1)); 
		}

		@Test
		public void testInvalidPostID() 
		{
			//Test with an invalid post ID that doesn't exist in the system
			given().when().get("https://jsonplaceholder.typicode.com/posts/999").then().assertThat().statusCode(404);
		}

		@Test
		public void testValidatePostsForUser() 
		{
			//get All user post's By user id
			given().when().get("https://jsonplaceholder.typicode.com/posts?userId=1").then().assertThat().statusCode(200)
			.body("userId", everyItem(equalTo(1))); // Assuming all posts returned belong to user with ID 1
		}
		
		@Test
		public void testInvalidUserIDForPosts() 
		{
			//Test with a user ID that doesn't have any posts
		    given().when().get("https://jsonplaceholder.typicode.com/posts?userId=999")
	        .then().assertThat().statusCode(200).body("", empty());
		}

	}
}
