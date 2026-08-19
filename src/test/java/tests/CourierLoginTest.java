package tests;

import io.qameta.allure.Description;
import model.Courier;
import model.CourierCredentials;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomData;

import static org.hamcrest.Matchers.notNullValue;

public class CourierLoginTest extends BaseTest{

    @Test
    @DisplayName("Авторизация существующего курьера")
    @Description("Проверка успешного логина курьера")
    public void loginCourierSuccess(){
        Courier courier = new Courier(RandomData.getRandomLogin(), RandomData.getRandomPassword(), RandomData.getRandomName());
        createAndLoginCourier(courier);
        courierSteps.login(new CourierCredentials(courier.getLogin(), courier.getPassword())).then().statusCode(200).body("id", notNullValue());
    }
}
