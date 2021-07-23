package com.liam.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Description:
 * Created by prophet on 2019/7/30 14:14
 */
public class Client {
    public static void main(String[] args) {
        try {
            QueryOrderNos queryOrderNos = (QueryOrderNos) Naming.lookup("rmi://localhost:8888/queryOrderNos");
            System.out.println(queryOrderNos.getOrderNos());
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
