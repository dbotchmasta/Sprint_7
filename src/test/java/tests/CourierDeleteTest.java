package tests;

import io.qameta.allure.Description;
import model.Courier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomData;

import static org.hamcrest.Matchers.equalTo;

public class CourierDeleteTest extends BaseTest {

    @DisplayName("Удаление существующего курьера")
    @Description("Проверка успешного удаления курьера")
    public void deleteCourierSuccess(){
        Courier courier = new Courier(RandomData.getRandomLogin(), RandomData.getRandomPassword(), RandomData.getRandomName());
        createAndLoginCourier(courier);
        courierSteps.deleteCourier(courierId).then().statusCode(200).body("ok", equalTo(true));
        courierId = null;
    }
}
