package com.liam.rmi.mineRMI;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Description:QueryOrderNosStub，承担着代理远程对象实现者的角色，其实就是将方法和参数传输到远程服务，获取到返回值。
 * Created by prophet on 2019/7/30 18:30
 */
public class QueryOrderNosStub implements QueryOrderNos {
    private Socket socket;

    public QueryOrderNosStub() throws IOException {

        socket = new Socket("localhost", 8888);
    }

    @Override
    public String getOrderNos(Integer dbId) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject("getOrderNos-" + dbId);
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            try {
                return (String) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
