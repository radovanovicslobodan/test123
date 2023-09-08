package tests.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UserRequest;
import pojo.UserResponse;

import static constants.Urls.CREATE_USER_URL;
import static constants.Urls.TOKEN;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.api.ApiUtils.createUserPayload;

public class UserTests {

    @Test
    @DisplayName("Successfully creating user")
    public void verifyCreatingUser() {
        UserRequest requestBody = createUserPayload();

        Response createdUser = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TOKEN)
                .body(requestBody)
                .when()
                .post(CREATE_USER_URL)
                .then()
                .extract()
                .response();

        String createdUserStatus = createdUser.as(UserResponse.class).getStatus();

        assertEquals(201, createdUser.statusCode());
    }

    @Test
    @DisplayName("Successfully updating user")
    public void verifyUpdatingUser() {
        UserRequest requestBody = createUserPayload();
        String status = "inactive";

        UserResponse createdUser = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TOKEN)
                .body(requestBody)
                .when()
                .post(CREATE_USER_URL)
                .then()
                .extract()
                .as(UserResponse.class);

        int createdUserId = createdUser.getId();

        requestBody.setStatus(status);

        Response updatedUserResponse = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TOKEN)
                .body(requestBody)
                .when()
                .patch(CREATE_USER_URL + createdUserId)
                .then()
                .extract()
                .response();

        String updatedUserStatus = updatedUserResponse.as(UserResponse.class).getStatus();

        assertEquals(200, updatedUserResponse.statusCode());
        assertEquals(status, updatedUserStatus);
    }

    @Test
    @DisplayName("Successfully deleting user")
    public void verifyDeletingUser() {
        UserRequest requestBody = createUserPayload();

        UserResponse createdUser = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TOKEN)
                .body(requestBody)
                .when()
                .post(CREATE_USER_URL)
                .then()
                .extract()
                .as(UserResponse.class);


        int createdUserId = createdUser.getId();

        Response deletedUserResponse = given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TOKEN)
                .when()
                .delete(CREATE_USER_URL + createdUserId)
                .then()
                .extract()
                .response();

        assertEquals(204, deletedUserResponse.statusCode());
    }
}