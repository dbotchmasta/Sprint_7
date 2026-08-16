package utils;

import model.Order;

import java.util.List;

public class OrderGenerator {

    public static Order blackOrder() {
        return createOrder(List.of("BLACK"));
    }

    public static Order greyOrder() {
        return createOrder(List.of("GREY"));
    }

    public static Order blackAndGreyOrder() {
        return createOrder(List.of("BLACK", "GREY"));
    }

    public static Order orderWithoutColor() {
        return createOrder(List.of());
    }

    public static Order createOrder(List<String> colors) {

        return new Order(
                "Иван",
                "Иванов",
                "Москва, ул. Ленина, д. 1",
                "1",
                "+79999999999",
                5,
                "2025-01-01",
                "Тестовый заказ",
                colors
        );
    }
}