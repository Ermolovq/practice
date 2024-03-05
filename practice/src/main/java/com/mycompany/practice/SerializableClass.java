package com.mycompany.practice;

import java.io.Serializable;

class SerializableClass implements Serializable {
    /**
     * Клас який може містити в собі число та результат дії з ним
     */
    private static final long serialVersionUID = 1L;
    
    private float num;
    private int result;

    public SerializableClass(float num, int result) {
        this.num = num;
        this.result = result;
    }
    public SerializableClass(float num){
        this.num = num;
        this.result = 0;
    }

    public float getNum() {
        return num;
    }
    public int getResult() {
        return result;
    }
    
    public void setResult(int number) {
        this.result = number;
    }
}
