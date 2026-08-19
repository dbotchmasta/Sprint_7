package steps;

import client.CourierClient;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.Courier;
import model.CourierCredentials;

public class CourierSteps {
    private final CourierClient courierClient = new CourierClient();

    @Step("Создать курьера")
    public Response createCourier(Courier courier){
        return courierClient.createCourier(courier);
    }

    @Step("Логин курьера")
    public Response login(CourierCredentials credentials){
        return courierClient.login(credentials);
    }

    @Step("Удалить курьера")
    public Response deleteCourier(int id){
        return courierClient.deleteCourier(id);
    }
}
