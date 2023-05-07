package exercise;

import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {

    private Connection connection;
    private String ip;
    private int port;

    public TcpConnection(String ip, int port) {
        this.connection = new Disconnected(this);
        this.ip = ip;
        this.port = port;
    }

    String getCurrentState() {
        return this.connection.getCurrentState();
    }
    void connect() {
        connection = new Connected(this);
        connection.connect();
    };
    void disconnect(){
        connection = new Disconnected(this);
        connection.disconnect();
    };
    void write(String text) {
        connection.write(text);
    };

    public static void main(String[] args) {
        TcpConnection connection = new TcpConnection("33.22.11.44", 80);
        connection.connect();
        System.out.println(connection.getCurrentState());
        connection.write("one");
        connection.write("two");
        connection.disconnect();
        System.out.println(connection.getCurrentState());
    }
}
// END
