package tests;

import io.restassured.response.Response;
import model.Order;
import org.junit.jupiter.api.Test;
import steps.OrderSteps;
import utils.OrderGenerator;

import static org.hamcrest.Matchers.notNullValue;

public class GetOrderByTrackTest {

    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    public void getOrderByTrackSuccess() {
        Order order = OrderGenerator.blackOrder();
        Response createOrderResponse = orderSteps.createOrder(order);
        int track = createOrderResponse.path("track");
        orderSteps.getOrderByTrack(track).then().statusCode(200).body("order", notNullValue());
    }

    @Test
    public void getOrderWithTrackZeroReturnsError() {
        orderSteps.getOrderByTrack(0).then().statusCode(404);
    }

    @Test
    public void getOrderWithWrongTrackReturnsError() {
        orderSteps.getOrderByTrack(999999999).then().statusCode(404);
    }

    @Test
    public void getOrderWithoutTrackReturnsError() {
        orderSteps.getOrderWithoutTrack().then().statusCode(400);
    }
}