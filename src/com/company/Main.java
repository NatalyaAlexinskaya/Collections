package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Order factory = new Order();
        List<Order> orders = new ArrayList<>();
        orders.add(factory.notStarted(3));
        orders.add(factory.completed(5));
        orders.add(factory.processing(3));
        orders.add(factory.completed(3));
        orders.add(factory.processing(2));
        orders.add(factory.completed(5));
        orders.add(factory.notStarted(4));

        orders.stream()
                .filter(order -> factory.getFilter(order, Order.filter))
                .forEach(System.out::println);
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order implements OrderFactory {
        private OrderStatus status;
        public static final int filter = 5;
        private int items;

        public Order(OrderStatus status, int items) {
            this.status = status;
            this.items = items;
        }

        public Order() {
        }

        public boolean getFilter(Order order, int filter) {
            return order.status.equals(OrderStatus.COMPLETED) && order.items == filter;
        }
    }

    public interface OrderFactory {
        default Order notStarted(int items) {
            return new Order(OrderStatus.NOT_STARTED, items);
        }

        default Order processing(int items) {
            return new Order(OrderStatus.PROCESSING, items);
        }

        default Order completed(int items) {
            return new Order(OrderStatus.COMPLETED, items);
        }
    }
}

