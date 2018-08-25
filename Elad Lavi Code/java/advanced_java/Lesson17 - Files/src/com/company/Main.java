package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String path = "C:\\Users\\hackeru\\Desktop\\MyFile.txt";
        File file = new File(path);

        System.out.println(file.exists());
        System.out.println(file.isDirectory());

        /*
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write("isn't files awesome?".getBytes());
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
        */

        try{
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[2];
            int actuallyRead;
            String s = "";

            while ((actuallyRead = inputStream.read(buffer)) != -1){
                s += new String(buffer,0 ,actuallyRead);
            }
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //System.out.println("number of files on my desktop: " + fileCount(new File(path)));

    }
    public static int fileCount(File dir){
        if(!dir.isDirectory())
            throw new RuntimeException("why did you send me a file? what a stupid question is this");
        int count = 0;
        for(File f :  dir.listFiles()){
            if(f.isDirectory())
                count += fileCount(f);
            else
                count++;
        }
        return count;
    }
}
