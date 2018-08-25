package com.example.hackeru.lesson25_passing_objects;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class Dog implements Serializable {
    private static final long SerialVersionID = 1L;

    public static final String NAME = "name";
    public static final String AGE = "age";
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Dog(byte[] bytes){
        age = ByteBuffer.wrap(bytes).getInt(0);
        name = new String(bytes, 4, bytes.length-4);
    }

    public Dog(String json){
        try {
            JSONObject jsonDog = new JSONObject(json);
            name = jsonDog.getString(NAME);
            age = jsonDog.getInt(AGE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toJSON(){
        JSONObject jsonDog = new JSONObject();
        try{
            jsonDog.put(NAME, name);
            jsonDog.put(AGE, age);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonDog.toString();
    }

    @Override
    public String toString() {
        return "I am " + name + ", and I am " + age + " years old";
    }

    public byte[] getBytes(){
        byte[] nameBytes = name.getBytes();
        byte[] bytes = new byte[4 + nameBytes.length];
        ByteBuffer.wrap(bytes).putInt(0, age);
        for (int i = 0; i < nameBytes.length; i++) {
            bytes[4+i] = nameBytes[i];
        }
        return bytes;
    }
}
