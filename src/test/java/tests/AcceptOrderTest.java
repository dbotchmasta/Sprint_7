package tests;

import io.restassured.response.Response;
import jdk.jfr.Description;
import model.Courier;
import model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.OrderSteps;
import utils.OrderGenerator;
import utils.RandomData;

import static org.hamcrest.Matchers.equalTo;

public class AcceptOrderTest extends BaseTest {

    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    @DisplayName("Принятие заказа с валидными данными")
    @Description("Проверка принятия заказа с валидными данными")
    public void acceptOrderSuccess() {
        Courier courier = new Courier(RandomData.getRandomLogin(), RandomData.getRandomPassword(), RandomData.getRandomName());
        createAndLoginCourier(courier);
        Order order = OrderGenerator.blackOrder();
        Response createOrderResponse = orderSteps.createOrder(order);

        int track = createOrderResponse.path("track");

        Response orderResponse = orderSteps.getOrderByTrack(track);

        int orderId = orderResponse.path("order.id");

        orderSteps.acceptOrder(orderId, courierId).then().statusCode(200).body("ok", equalTo(true));
    }
}