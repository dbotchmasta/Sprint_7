package tests;

import model.Courier;
import org.junit.jupiter.api.Test;
import utils.RandomData;

import static org.hamcrest.Matchers.equalTo;

public class CourierCreateTest extends BaseTest{
    @Test
    public void createCourierSuccess(){
        Courier courier = new Courier(RandomData.getRandomLogin(), RandomData.getRandomPassword(), RandomData.getRandomName());
        courierSteps.createCourier(courier).then().statusCode(201).body("ok", equalTo(true));
    }
}
