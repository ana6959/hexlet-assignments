package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private TcpConnection tcpConnection;
    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }
    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! already connected");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");
    }

    @Override
    public void write(String text) {
        System.out.println("added data");
    }
}
// END
