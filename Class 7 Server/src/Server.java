import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server at:  " + new Date());

        //  Start Server
        ServerSocket serverSocket = new ServerSocket(8000);

        // Run the server infinitely, the socket would be alive forever
        while (true) {
            // Wait for Client Connection
            Socket socket = serverSocket.accept();

            // retrieve the ip address of the client
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("Got client request from:  " + inetAddress.getHostAddress());

            //  Set up the In/Out Streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            // Receive radius from the client
            int max = inputFromClient.readInt();

            // calculate random number from 0 to one less than max
            int randomNum = (int) (Math.random() * max);

            // Track Progress
            System.out.println("Got number:  " + max);
            System.out.printf("Random number from 0 to %d: %d%n", max, randomNum);

            // Send result back to client
            outputToClient.writeInt(randomNum);
            outputToClient.flush();

            //  Stop everything
            socket.close();
            System.out.println("Stopping server at:  " + new Date());
            System.out.println();
        }
    }
}