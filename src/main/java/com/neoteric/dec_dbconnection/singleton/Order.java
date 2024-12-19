package com.neoteric.dec_dbconnection.singleton;

    public class Order {
        private static Order orderInstance;

        private Order() {}

        // Setter Injection
        public static void setOrder(Order injectedOrder) {
            orderInstance = injectedOrder;
        }

        public static Order getOrder() {
            return orderInstance;
        }

        public void processOrder() {
            System.out.println("Order is being processed.");
        }

        public static void main(String[] args) {

            Order order = new Order();

            // Setter Injection
            Order.setOrder(order);


            Order orderInstance = Order.getOrder();
            orderInstance.processOrder();
        }
    }

