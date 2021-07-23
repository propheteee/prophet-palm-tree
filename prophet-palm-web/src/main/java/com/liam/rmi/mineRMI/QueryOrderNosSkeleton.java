package com.liam.rmi.mineRMI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description: QueryOrderNosSkeleton：帮助远程对象（QueryOrderNosImpl）与stub连接进行通信
 * Created by prophet on 2019/7/30 18:23
 */
public class QueryOrderNosSkeleton extends Thread {

    private QueryOrderNos queryOrderNos;

    public QueryOrderNosSkeleton(QueryOrderNos queryOrderNos) {
        this.queryOrderNos = queryOrderNos;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                Socket accept = serverSocket.accept();
                if (accept != null) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
                    try {
                        String req = (String) objectInputStream.readObject();
                        String[] request = req.split("-");
                        String method = request[0];
                        String param = request[1];
                        if (method.equals("getOrderNos")) {
                            String orderNos = queryOrderNos.getOrderNos(Integer.valueOf(param));
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                            objectOutputStream.writeObject(orderNos);
                            objectOutputStream.flush();
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();

                }
            }
        }
    }
}
