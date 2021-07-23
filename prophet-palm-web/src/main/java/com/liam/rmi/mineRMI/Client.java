package com.liam.rmi.mineRMI;

import java.io.IOException;

/**
 * Description:
 * Created by prophet on 2019/7/30 18:37
 */
public class Client {
    public static void main(String[] args) {
        try {
            QueryOrderNosStub queryOrderNosStub = new QueryOrderNosStub();
            String orderNos = queryOrderNosStub.getOrderNos(1);
            String orderNos1 = queryOrderNosStub.getOrderNos(2);
            System.out.println(orderNos);
            System.out.println(orderNos1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
