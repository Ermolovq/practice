package com.mycompany.practice;

import java.io.Serializable;

class SerializableClass implements Serializable {
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
    public float getResult() {
        return result;
    }
}
