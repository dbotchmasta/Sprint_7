package tests;

import org.junit.jupiter.api.Test;
import steps.OrderSteps;

import static org.hamcrest.Matchers.notNullValue;

public class OrderListTest {
    private final OrderSteps orderSteps = new OrderSteps();

    @Test
    public void getOrdersListSuccess(){
        orderSteps.getOrders().then().statusCode(200).body("orders", notNullValue());
    }
}
