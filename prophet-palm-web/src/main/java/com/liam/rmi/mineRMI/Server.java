package com.liam.rmi.mineRMI;

/**
 * Description:
 * Created by prophet on 2019/7/30 18:22
 */
public class Server {
    public static void main(String[] args) {
        QueryOrderNosSkeleton queryOrderNosSkeleton = new QueryOrderNosSkeleton(new QueryOrderNosImpl());
        queryOrderNosSkeleton.start();
    }

}
