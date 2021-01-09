package ru.job4j.io;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        int sign = 0;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (flag) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while ((in.ready())) {
                        str = in.readLine();
                        System.out.println(str);
                        if (str.contains("?msg=Exit")) {
                            flag = false;
                        }
                        if (str.contains("?msg=Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend. \r\n".getBytes());
                        } else {
                            if (str.contains("?msg=")) {
                                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                                System.out.println(str.split("msg=")[1]);
                                out.write((str.split("msg=")[1].split(" ")[0] + "\r\n").getBytes());
                            }
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                   out.write("Hello, dear friend.".getBytes());
                }
            }
        }
    }
}