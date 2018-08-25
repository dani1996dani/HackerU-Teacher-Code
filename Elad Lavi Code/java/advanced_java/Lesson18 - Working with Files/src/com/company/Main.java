package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {3,5,6,8,9,1};
        int[] arr2 = {1,2,3,4,5,7,8};
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for(int x : arr1)
            a.add(x);
        for(int x : arr2)
            b.add(x);
        List<Integer> intersection = intersect(a,b);
        for(int x : intersection)
            System.out.print(x+ " ");
        System.out.println();


    }

    private static void json() {
        Circle circle = new Circle(new Point(4,5), 6);
        JSONObject jsonCircle = new JSONObject();
        JSONObject jsonCenter = new JSONObject();
        try {
            jsonCenter.put("x", circle.getCenter().getX());
            jsonCenter.put("y", circle.getCenter().getY());
            jsonCircle.put("center", jsonCenter);
            jsonCircle.put("radius", circle.getRadius());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String s = jsonCircle.toString();
        try {
            JSONObject jsonCircle2 = new JSONObject(s);
            JSONObject jsonCenter2 = jsonCircle2.getJSONObject("center");
            int x = jsonCenter2.getInt("x");
            int y = jsonCenter2.getInt("y");
            Point center = new Point(x,y);
            Circle circle2 = new Circle(center, jsonCircle2.getInt("radius"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonCircle);
        jsonArray.put(jsonCircle);
        jsonArray.put(jsonCircle);
        jsonArray.put(jsonCircle);
        System.out.println(jsonArray.toString());
    }

    private static void workingWithByteBuffer() {
        byte[] bytes = new byte[Integer.BYTES];
        ByteBuffer.wrap(bytes).putInt(34535);
        int x = ByteBuffer.wrap(bytes).getInt();

        int z = 123;


        z = z | 1;

        if((z & 1) == 1){
            System.out.println("least significant bit is on");
        }
    }


    private static byte[] intToBytes(int x){
        byte[] bytes = new byte[Integer.BYTES];
        for (int i = Integer.BYTES-1; i >=0 ; i--) {
            bytes[i] = (byte)x;
            x = x >> 8;
        }
        return bytes;
    }

    private static int bytesToInt(byte[] bytes){
        if(bytes == null || bytes.length != Integer.BYTES)
            throw new InvalidParameterException("what the hack????");
        int x = 0;
        for (int i = 0; i < Integer.BYTES; i++) {
            x = x << Byte.SIZE;
            x = x | (bytes[i] & 0xFF);
        }
        return x;
    }

    private static void writingIntegersToFile(){
        int[] arr = {345,234,45,64,56,435,34,57,657,678,43,513,4};
        OutputStream outputStream = null;
        File file = new File("C:\\Users\\hackeru\\Desktop\\numbers.txt");
        try{
            outputStream = new FileOutputStream(file);
            /*
            for (int i = 0; i < arr.length-1; i++) {
                outputStream.write((arr[i]+",").getBytes());
            }
            if(arr.length > 0)
                outputStream.write(String.valueOf(arr[arr.length-1]).getBytes());
            */
            byte[] intBytes = new byte[4];
            for (int i = 0; i < arr.length; i++) {
                ByteBuffer.wrap(intBytes).putInt(arr[i]);
                outputStream.write(intBytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    private static void readStringsFromFile(File file){
        InputStream inputStream = null;
        List<String> names = new ArrayList<>();
        try{
            inputStream = new FileInputStream(file);
            int nameLength;
            while ((nameLength = inputStream.read()) != -1){
                byte[] nameBytes = new byte[nameLength];
                if(inputStream.read(nameBytes) != nameLength)
                    throw new RuntimeException("description of the error");
                names.add(new String(nameBytes, 0, nameLength));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void writeStringArrayToFile(String[] names, File file){
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            for(String name : names){
                byte[] nameBytes = name.getBytes();
                outputStream.write(nameBytes.length);
                outputStream.write(nameBytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writingStringsToFile() {
        /*
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream = null;
        File file = new File("C:\\Users\\hackeru\\Desktop\\MyFile1.txt");
        while (true) {
            System.out.println("please type something:");
            String input = scanner.next();
            if (input.equals("exit"))
                break;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write((input + "\r\n").getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        */
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream = null;
        File file = new File("C:\\Users\\hackeru\\Desktop\\MyFile1.txt");
            try {
                outputStream = new FileOutputStream(file);
                while (true) {
                    System.out.println("please type something:");
                    String input = scanner.next();
                    if (input.equals("exit"))
                        break;
                    outputStream.write((input + "&").getBytes());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

    }


    private static void readingLargeTextFile() {
        InputStream inputStream = null;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            File file = new File("C:\\Users\\hackeru\\Desktop\\MyFile.txt");
            if(!file.exists())
                return;
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[8];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(buffer)) != -1){
                stringBuilder.append(new String(buffer, 0, actuallyRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static void usingStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        System.out.println(stringBuilder.toString());
    }




    public static <T> List<T> intersect(List<T> a, List<T> b){
        Set<T> set = new HashSet<>(a);
        List<T> result = new ArrayList<>();
        for(T x : b){
            if(set.contains(x))
                result.add(x);
        }
        return result;

    }

    public static <T> List<T> union(List<T> a, List<T> b){
        Set<T> set = new HashSet<>();
        set.addAll(a);
        set.addAll(b);
        return new ArrayList<T>(set);
    }
}
