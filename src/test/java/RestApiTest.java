import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestApiTest {


    @Test(priority = 1)
    public void NameAssertion() {

        List<String> names=

                given()

                        .when()
                        .get("https://jsonplaceholder.typicode.com/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().path("name")
                ;

        System.out.println("Names = " +names);
        Assert.assertTrue(names.contains("Nicholas Runolfsdottir V"));
        int index=names.indexOf("Nicholas Runolfsdottir V");
        System.out.println("index = " + index);
    }

    @Test(priority = 2)
    public void AddressAssertion(){

        Map<String,String> address=
                given()

                        .when()
                        .get("https://jsonplaceholder.typicode.com/users")

                        .then()
                        //.log().body()
                        .statusCode(200)
                        .extract().path("[7].address")
                ;
        System.out.println("Address = " + address);
        String actualAddress=address.toString();
        Assert.assertEquals(actualAddress,"{street=Ellsworth Summit, suite=Suite 729, city=Aliyaview, zipcode=45169, geo={lat=-14.3990, lng=-120.7677}}");

    }

}
