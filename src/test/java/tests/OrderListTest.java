package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.OrderSteps;

import static org.hamcrest.Matchers.greaterThan;

public class OrderListTest {
    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    @DisplayName("Получение списка заказов")
    @Description("Проверка получения списка заказов")
    public void getOrdersListSuccess() {
        orderSteps.getOrders()
                .then()
                .statusCode(200)
                .body("orders.size()", greaterThan(0));
    }
}
