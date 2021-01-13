package ru.job4j.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean flag = true;
        String str = null;
        int value = 0;
        int sign = 0;
        try {
            try (ServerSocket server = new ServerSocket(9000)) {
                while (flag) {
                    Socket socket = server.accept();
                    try (OutputStream out = socket.getOutputStream();
                         BufferedReader in = new BufferedReader(
                                 new InputStreamReader(socket.getInputStream()))) {
                        String buf = null;
                        while ((in.ready())) {
                            buf = in.readLine();
                            System.out.println(buf);
                            if (buf.contains("?msg=Exit")) {
                                flag = false;
                                str = buf;
                            }
                            if (buf.contains("?msg=Hello")) {
                                value = 1;
                                str = buf;
                            } else {
                                if (buf.contains("?msg=")) {
                                    value = 2;
                                    str = buf;
                                }
                            }
                            if (buf.contains("?msg=")) {
                                break;
                            }
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if (value == 1) {
                                out.write("Hello, dear friend. \r\n".getBytes());
                            } else {
                                if (value == 2) {
                                    out.write((str.split("msg=")[1]
                                            .split(" ")[0] + "\r\n").getBytes());
                                }
                            }
                        }
                    }
                }
            } catch (IOException ioException) {
            LOG.error("Exception in log example", ioException);
        }
    }
}
