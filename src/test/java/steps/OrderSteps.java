package steps;

import client.OrderClient;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.Order;

public class OrderSteps {
    private final OrderClient orderClient = new OrderClient();

    @Step("Создать заказ")
    public Response createOrder(Order order){
        return orderClient.createOrder(order);
    }

    @Step("Получить список заказов")
    public Response getOrders(){
        return orderClient.getOrders();
    }

    @Step("Принять заказ")
    public Response acceptOrder(int orderId, int courierId){
        return orderClient.acceptOrder(orderId, courierId);
    }

    @Step("Получить заказ по трек-номеру")
    public Response getOrderByTrack(int track){
        return orderClient.getOrderByTrack(track);
    }

    @Step("Получить заказ без трек-номера")
    public Response getOrderWithoutTrack() {
        return orderClient.getOrderWithoutTrack();
    }

}
