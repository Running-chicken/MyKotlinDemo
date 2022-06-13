package com.example.mykotlindemo.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerClass {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6666);

            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new MyRunnable(socket)).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    static class MyRunnable implements Runnable{

        Socket socket = null;

        MyRunnable(Socket socket){
            this.socket =socket;
        }


        @Override
        public void run() {
            String line = null;
            InputStream inputStream;
            OutputStream outputStream;
            String[] strings = new String[]{"hello world","this is socket","i im zhenzhen","who are you","im cuican"};
            String str = strings[new Random().nextInt(strings.length-1)];

            try {

                inputStream = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine())!=null){
                    System.out.println("输出："+line);
                }


                outputStream = socket.getOutputStream();
                outputStream.write(str.getBytes());
                outputStream.flush();
                socket.shutdownOutput();
                outputStream.close();
                br.close();
                inputStream.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
