package com.liam.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Description:
 * Created by prophet on 2019/7/30 14:44
 */
public class QueryOrderNosImpl extends UnicastRemoteObject implements QueryOrderNos {

    private static final long serialVersionUID = 1919085237435523037L;

    QueryOrderNosImpl() throws RemoteException {
    }

    @Override
    public String getOrderNos() {
        return "111101010100123151";
    }
}
