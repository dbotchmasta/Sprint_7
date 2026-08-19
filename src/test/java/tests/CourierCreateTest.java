package tests;

import io.qameta.allure.Description;
import model.Courier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomData;

import static org.hamcrest.Matchers.equalTo;

public class CourierCreateTest extends BaseTest{
    @Test
    @DisplayName("Создание курьера с валидными данными")
    @Description("Проверка успешного создания нового курьера")
    public void createCourierSuccess(){
        Courier courier = new Courier(RandomData.getRandomLogin(), RandomData.getRandomPassword(), RandomData.getRandomName());
        courierSteps.createCourier(courier).then().statusCode(201).body("ok", equalTo(true));
    }
}
