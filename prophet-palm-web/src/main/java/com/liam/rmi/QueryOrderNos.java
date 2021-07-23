package com.liam.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Description:
 * Created by prophet on 2019/7/30 14:42
 */
public interface QueryOrderNos extends Remote {
    public String getOrderNos() throws RemoteException;
}
