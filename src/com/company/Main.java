package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(OrderStatus.NOT_STARTED, 6));
        orders.add(new Order(OrderStatus.PROCESSING, 3));
        orders.add(new Order(OrderStatus.COMPLETED, 4));
        orders.add(new Order(OrderStatus.COMPLETED, 5));
        orders.add(new Order(OrderStatus.NOT_STARTED, 3));
        orders.add(new Order(OrderStatus.NOT_STARTED, 8));
        orders.add(new Order(OrderStatus.COMPLETED, 5));
        orders.add(new Order(OrderStatus.NOT_STARTED, 2));
        orders.add(new Order(OrderStatus.PROCESSING, 5));

        for (Order order : orders) {
            if (order.getStatus().equals(OrderStatus.COMPLETED) && order.getItems() == Order.filter) {
                System.out.println(order.toString());
            }
        }
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        private final OrderStatus status;
        private static final int filter = 5;
        private int items;

        public Order(OrderStatus status, int items) {
            this.status = status;
            this.items = items;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public int getItems() {
            return items;
        }
    }
}
