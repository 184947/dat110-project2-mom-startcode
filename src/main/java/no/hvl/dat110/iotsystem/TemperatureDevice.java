package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

    private static final int COUNT = 10;

    public static void main(String[] args) {

        // simulated / virtual temperature sensor
        TemperatureSensor sn = new TemperatureSensor();

        System.out.println("Temperature device started");

        Client client = new Client("sensor", "localhost", 8080);

        client.connect();

        for (int i = 0; i < COUNT; i++) {
            int temp = sn.read();
            System.out.println("READING: " + temp);
            client.publish("temperature", Integer.toString(temp));
        }

        client.disconnect();

        System.out.println("Temperature device stopping ... ");
    }
}