package tests;

import io.restassured.response.Response;
import model.Courier;
import model.CourierCredentials;
import org.junit.jupiter.api.AfterEach;
import steps.CourierSteps;

public class BaseTest {
    protected Integer courierId;
    protected CourierSteps courierSteps = new CourierSteps();

    @AfterEach
    public void deleteCourier(){
        if (courierId != null){
            courierSteps.deleteCourier(courierId);
        }
    }

    protected void createAndLoginCourier(Courier courier){
        courierSteps.createCourier(courier);

        Response response = courierSteps.login(new CourierCredentials(courier.getLogin(), courier.getPassword()));
        courierId = response.path("id");
    }
}
