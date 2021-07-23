package com.liam.design.designmode.prototype;

import java.io.*;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2019/7/19 16:28
 */
public class Car implements Cloneable, Serializable {
    private static final long serialVersionUID = -823073782435743135L;
    private String name;
    private List<String> compositions;


    //浅复制
    public Object clone() throws CloneNotSupportedException {
        //除了八大基本类型和String，其他的引用类型都是浅复制，调用clone方法时引用不会变
        return super.clone();
    }

    //深复制
    public Object deepClone1() {
        ByteArrayOutputStream byteOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ByteArrayInputStream byteInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            //先将对象写到流再读出来可以重构对象
            byteOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteOutputStream);
            objectOutputStream.writeObject(this);
            byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteOutputStream != null) {
                    byteOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (byteInputStream != null) {
                    byteInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCompositions() {
        return compositions;
    }

    public void setCompositions(List<String> compositions) {
        this.compositions = compositions;
    }

    public Object deepClone2() throws CloneNotSupportedException {
        Car car = (Car)super.clone();
        return car.getCompositions();
    }
}
