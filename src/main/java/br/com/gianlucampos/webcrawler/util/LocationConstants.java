package br.com.gianlucampos.webcrawler.util;

public class LocationConstants {

    public final static String SEPARATOR = System.getProperty("file.separator");
    public final static String CURRENT_DIRECTORY = System.getProperty("user.dir");
    public final static String RESOURCES = CURRENT_DIRECTORY.concat("//src//main//resources//").replace("//", SEPARATOR);
    public final static String CHROME_DRIVER = RESOURCES.concat("chromedriver.exe");

}
