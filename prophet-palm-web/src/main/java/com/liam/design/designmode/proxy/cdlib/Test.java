package com.liam.design.designmode.proxy.cdlib;

/**
 * Description:
 * Created by prophet on 2019/7/18 17:16
 */
public class Test {
    public static void main(String[] args) {
        //原理：字节码重组
        Rose proxyInstance = (Rose) new PartnerAgent().getProxyInstance(Rose.class);
        System.out.println(proxyInstance.getClass());
        //ProxyGenerator.generateProxyClass("")
        proxyInstance.findPartner();
    }
}
