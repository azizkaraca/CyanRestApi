import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.config.RedirectConfig.redirectConfig;


public class HTTPStatusCodes {

    int code;

    @Test(priority = 1)
    public void code200assertion() {

        code =
                given()

                        .pathParam("code", "200")
                        .log().uri()

                        .when()
                        .get("http://the-internet.herokuapp.com/status_codes/{code}")

                        .then()
                        .log().status()
                        .statusCode(200)
                        .extract().statusCode();

        System.out.println("code = " + code);
    }

    @Test(priority = 2)
    public void Code301assertion() {

        code =
                given()

                        .pathParam("code", "301")
                        .log().uri()
                        .config(RestAssured.config().redirect(redirectConfig().followRedirects(false)))

                        .when()
                        .get("http://the-internet.herokuapp.com/status_codes/{code}")

                        .then()
                        .log().status()
                        .statusCode(301)
                        .extract().statusCode();

        System.out.println("code = " + code);
    }

    @Test(priority = 3)
    public void Code404assertion() {

        code =
                given()

                        .pathParam("code", "404")
                        .log().uri()

                        .when()
                        .get("http://the-internet.herokuapp.com/status_codes/{code}")

                        .then()
                        .log().status()
                        .statusCode(404)
                        .extract().statusCode();

        System.out.println("code = " + code);
    }

    @Test(priority = 4)
    public void Code500assertion() {

        code =
                given()

                        .pathParam("code", "500")
                        .log().uri()

                        .when()
                        .get("http://the-internet.herokuapp.com/status_codes/{code}")

                        .then()
                        .statusCode(500)
                        .extract().statusCode();

        System.out.println("code = " + code);
    }

}
