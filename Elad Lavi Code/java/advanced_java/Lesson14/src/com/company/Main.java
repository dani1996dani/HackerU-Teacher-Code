package com.company;

public class Main {

    public static final int INK_JET = 567;

    public static void main(String[] args) {
	    //What is Enum ?
        City city = City.HAIFA;

        Person person = new Person("Elad", "Lavi", City.KFAR_SABA);
        person.setCity(City.BEER_SHEVA);

        switch (city){
            case HAIFA:

                break;
            case TVERIA:

                break;
            case RAANANA:

                break;
            case TEL_AVIV:

                break;
            case JERUSALEM:

                break;
            case KFAR_SABA:

                break;
            case RAMAT_GAN:

                break;
            case BEER_SHEVA:

                break;

        }
        //int printerType = INK_JET;
        PrinterType myPrinterType = PrinterType.INK_JET;
        System.out.println(myPrinterType.getCapacity());
        PrinterType[] printerTypes = PrinterType.values();
        for(PrinterType p : printerTypes){
            System.out.println(p.name());
        }
        PrinterType yourPrinterType = PrinterType.valueOf("INK_JET");
        if(yourPrinterType == PrinterType.LASER){
            System.out.println("your printer type is LASER");
        }
    }
}
