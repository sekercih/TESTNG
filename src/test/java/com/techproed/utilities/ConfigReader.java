package com.techproed.utilities;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //Bu class'in amaci, configuration.properties dosyasindaki verileri(test data) okumaktir.

    //create Properties instance
    private static Properties properties;
    //FileInputStream kullanarak,bir dosya aciyoruz
    //Properties'i bu dosyaya yukluyoruz
    //Daha sonra properties dosyasini okuyacagiz.

    //baslatmak icin static blok olusturduk.
    static{
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            //System.out.println("file path bulunamadi");
            e.printStackTrace();
        }
    }
    //Okumak icin static bir metod olusturalim.
    //Bu metod kullanici anahtar kelimeyi girdiginde(key) , value return eder.
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(properties.getProperty("gecerli_username"));
    }




}