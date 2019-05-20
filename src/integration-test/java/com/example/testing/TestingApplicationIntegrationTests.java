package com.example.testing;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestingApplication.class)
@TestExecutionListeners({
  DependencyInjectionTestExecutionListener.class,
  DbUnitTestExecutionListener.class
})
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class TestingApplicationIntegrationTests {
  //private static final String USER_RESOURCE = "/users";

	//@LocalServerPort
	//private int port;

  //@Autowired
  //private IUserService iUserService;




	/*@Test
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
	}*/

	/*@Test
  @Sql("/db-setup-data/new-user.sql")
	public void whenFindingStudentById_Then_HttpOK_And_ResponseMatchesJsonExample() {
    /*String url = createUrlFrom(USER_RESOURCE + "/1");

		given()
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
        .time(lessThan(1000L));
		assert 1==1;
	}*/

	/*private String createUrlFrom(String resource) {
		return "http://localhost:" + port + resource;
	}*/
}
