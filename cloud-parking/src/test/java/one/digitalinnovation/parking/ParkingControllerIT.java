package one.digitalinnovation.parking;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerIT {

    /*@LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest()
    {
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void whenfindAllThenCheckResult()
    {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void create()
    {

    }*/

}
