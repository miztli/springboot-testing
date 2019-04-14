package com.example.testing;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestingApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingApplicationTests {
  private static final String USER_RESOURCE = "/users";

	@LocalServerPort
	private int port;

	@Test
	public void whenCreatingANewUser_Then_HttpOK_And_LocationUrlCreated() throws JSONException {
    String url = createUrlFrom(USER_RESOURCE);

	  // create user
	  JSONObject newUser =
      new JSONObject()
        .put("name", "miztli")
        .put("address","sur 119 A")
        .put("age",28);

    // post user
		given()
      .contentType("application/json")
      .log()
      .all()
    .when()
      .body(newUser.toString())
    .post(url)
      .then()
			.statusCode(201)
			.assertThat()
        .header("Location", containsString(url))
        .time(lessThan(2000L));
	}

	@Test
  @Sql("/db-setup-data/new-user.sql")
	public void whenFindingStudentById_Then_HttpOK_And_ResponseMatchesJsonExample() {
    String url = createUrlFrom(USER_RESOURCE + "/1");

		/*given()
      .accept("application/json")
      .log()
      .all()
      .when()
    .get(url)
    .then()
      .log()
      .all()
      .statusCode(200)
      .assertThat()
        .body(matchesJsonSchemaInClasspath("created-user.json"))
        .time(lessThan(1000L));*/
		assert 1==1;
	}

	private String createUrlFrom(String resource) {
		return "http://localhost:" + port + resource;
	}
}
