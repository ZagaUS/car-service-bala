package com.zaga;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import com.zaga.entity.CarEnum;
import com.zaga.entity.CarServiceDetails;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CarServiceDetailsTest {

    @Test
    public void testgetCarDetails() {
        RestAssured.baseURI = "http://localhost:5405";
        String requestPayLoad = "{\"carNumber\":\"123456\",\"customerName\":\"bala\"}";

        given()
                .body(requestPayLoad)
                .when().get("/v1/car-management/view-car_details")
                .then()
                .statusCode(200);

    }

    @Test
    public void testCreateCarDetails() {
        RestAssured.baseURI = "http://localhost:5405";
        // String requestPayLoad =
        // "{\"carNumber\":\"123456\",\"customerName\":\"bala\",\"serviceStatus\":\"START_SERVICING\",\"deliveryAvailableStatus\":\"true\",\"deliveredStatus\":\"true\",}";
        // String[] payLoad =
        // {"carNumber":"123456","customerName":"bala","serviceStatus":"START_SERVICING","deliveryAvailableStatus":"true","deliveredStatus":"true",};

        CarServiceDetails details = new CarServiceDetails();
        details.setCarNumber("555666");
        details.setCustomerName("alab");
        details.setDeliveredStatus(false);
        details.setDeliveryAvailableStatus(false);
        details.setServiceStatus(CarEnum.START_SERVICING);

        given()
                .contentType(ContentType.JSON)
                .body(details)
                .when().post("/v1/car-management/create-car_details")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUpdateDetails() {
        CarServiceDetails details = new CarServiceDetails();
        details.setCarNumber("555666");
        details.setCustomerName("alab");
        details.setServiceStatus(CarEnum.COMPLETED);

        given()
                .contentType(ContentType.JSON)
                .queryParam("carNumber", details.getCarNumber())
                .queryParam("customerName", details.getCustomerName())
                .queryParam("serviceStatus", details.getServiceStatus())
                .when().put("/v1/car-management/modify-car-details")
                .then()
                .statusCode(201);
        // .body(is(details));

    }

    @Test
    public void testDeleteDetails() {
        // CarServiceDetails details = new CarServiceDetails();
        // details.setDeliveredStatus(true);

        given()
                .contentType(ContentType.JSON)
                .queryParam("deliveredStatus", true)
                .when().delete("/v1/car-management/delete-car-details")
                .then()
                .statusCode(204);

    }

}