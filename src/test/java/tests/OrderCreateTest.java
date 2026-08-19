package tests;

import io.qameta.allure.Description;
import model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import steps.OrderSteps;
import utils.OrderGenerator;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.notNullValue;

public class OrderCreateTest {

    private final OrderSteps orderSteps = new OrderSteps();

    static Stream<Arguments> orders() {
        return Stream.of(
                Arguments.of("BLACK", OrderGenerator.blackOrder()),
                Arguments.of("GREY", OrderGenerator.greyOrder()),
                Arguments.of("BLACK + GREY", OrderGenerator.blackAndGreyOrder()),
                Arguments.of("WITHOUT COLOR", OrderGenerator.orderWithoutColor())
        );
    }

    @ParameterizedTest(name = "Создание заказа с цветом: {0}")
    @MethodSource("orders")
    @DisplayName("Создание заказа")
    @Description("Проверка создания заказа с различными вариантами цветов")
    public void createOrderWithDifferentColors(String colorName, Order order) {

        orderSteps.createOrder(order)
                .then()
                .statusCode(201)
                .body("track", notNullValue());
    }
}