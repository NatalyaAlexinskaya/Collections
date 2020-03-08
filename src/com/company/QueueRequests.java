package com.company;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueRequests {
    private ConcurrentLinkedQueue<ClientRequest> queue = null;

    QueueRequests() {
        queue = new ConcurrentLinkedQueue<>();
        Thread addClient = new Thread(new AddClient());
        addClient.start();
        Thread nameClient = new Thread(new NameClient());
        nameClient.start();
        Thread removeClient = new Thread(new RemoveClient());
        removeClient.start();
    }

    class ClientRequest {
        private String name;
        private int phone;

        public ClientRequest(String name, int phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public int getPhone() {
            return phone;
        }
    }

    class AddClient implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                ClientRequest clientRequest = new ClientRequest("C" + i, 12345 + i);
                System.out.println("Добавляю клиента № " + i);
                queue.add(clientRequest);
            }
        }
    }

    class NameClient implements Runnable {

        @Override
        public void run() {
            for (ClientRequest client : queue) {
                System.out.println("Имя клиента " + client.getName() + " " + "Номер клиента " + client.getPhone());
            }
        }
    }

    class RemoveClient implements Runnable {
        @Override
        public void run() {
            ClientRequest clientRequest;
            while ((clientRequest = queue.poll()) != null) {
                System.out.println(clientRequest.getName() + " " + "удален");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new QueueRequests();
    }
}

//Класс ConcurrentLinkedQueue предназанчен для многопоточного исполнения.
//2й поток иногда не успевает успевает исполниться.