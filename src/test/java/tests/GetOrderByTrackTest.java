package tests;

import io.restassured.response.Response;
import io.qameta.allure.Description;
import model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.OrderSteps;
import utils.OrderGenerator;

import static org.hamcrest.Matchers.notNullValue;

public class GetOrderByTrackTest {

    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    @DisplayName("Получение заказа по трек-номеру")
    @Description("Проверка получения существующего заказа по трек-номеру")
    public void getOrderByTrackSuccess() {
        Order order = OrderGenerator.blackOrder();
        Response createOrderResponse = orderSteps.createOrder(order);
        int track = createOrderResponse.path("track");
        orderSteps.getOrderByTrack(track).then().statusCode(200).body("order", notNullValue());
    }

    @Test
    @DisplayName("Получение заказа с трек-номером равным 0")
    @Description("Проверка ошибки при запросе заказа с трек-номером равным 0")
    public void getOrderWithTrackZeroReturnsError() {
        orderSteps.getOrderByTrack(0).then().statusCode(404);
    }

    @Test
    @DisplayName("Получение заказа с несуществующим трек-номером")
    @Description("Проверка ошибки при запросе заказа с несуществующим номером трек-номером")
    public void getOrderWithWrongTrackReturnsError() {
        orderSteps.getOrderByTrack(999999999).then().statusCode(404);
    }

    @Test
    @DisplayName("Получение заказа без трек-номера")
    @Description("Проверка ошибки при запросе заказа без трек-номера")
    public void getOrderWithoutTrackReturnsError() {
        orderSteps.getOrderWithoutTrack().then().statusCode(400);
    }
}