package client;

import io.restassured.response.Response;
import model.Courier;
import model.CourierCredentials;

public class CourierClient extends BaseClient{
    private static final String COURIER_PATH = "/api/v1/courier";

    public Response createCourier(Courier courier){
        return getSpec().body(courier).post(COURIER_PATH);
    }

    public Response login(CourierCredentials credentials){
        return getSpec().body(credentials).post(COURIER_PATH + "/login");
    }

    public Response deleteCourier(int id){
        return getSpec().delete(COURIER_PATH + "/" + id);
    }
}
