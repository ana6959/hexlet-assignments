package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {

    private TcpConnection tcpConnection;
    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }
    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error! already disconnected");
    }

    @Override
    public void write(String text) {
        System.out.println("Error! No can do, its disconnected");
    }
}
// END
