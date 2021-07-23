package com.liam.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Description:
 * Created by prophet on 2019/7/30 14:13
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 本地主机上的远程对象注册表Registry的实例,端口8888
            LocateRegistry.createRegistry(8888);
            // 创建一个远程对象
            QueryOrderNos queryOrderNos = new QueryOrderNosImpl();
            // 把远程对象注册到RMI注册服务器上
            Naming.bind("rmi://localhost:8888/queryOrderNos", queryOrderNos);
            System.out.println("server start success");
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
