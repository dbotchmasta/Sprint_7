package client;

import io.restassured.response.Response;
import model.Order;

public class OrderClient extends BaseClient{
    private static  final String ORDER_PATH = "/api/v1/orders";

    public Response createOrder(Order order){
        return getSpec().body(order).post(ORDER_PATH);
    }

    public Response getOrders(){
        return getSpec().get(ORDER_PATH);
    }

    public Response acceptOrder(int orderId, int courierId){
        return getSpec().queryParam("courierId", courierId).put(ORDER_PATH + "/accept/" + orderId);
    }

    public Response getOrderByTrack(int track){
        return getSpec().queryParam("t", track).get(ORDER_PATH + "/track");
    }

    public Response getOrderWithoutTrack() {
        return getSpec().get(ORDER_PATH + "/track");
    }
}
