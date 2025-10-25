import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        // create socket to send communication to server
        Socket socket = new Socket("localhost", 8000);

        // retrieve num from terminal
        int num = Integer.parseInt(args[0]);

        // wrap the data as bytes and send to socket
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

        // wrap the data as bytes and receive from socket
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        System.out.println("Sending number:  " + num);
        toServer.writeInt(num);
        toServer.flush();
        int randomNum = fromServer.readInt();
        System.out.println("Received Random Number:  " + randomNum);
        socket.close();
    }
}