package designpattern;

import javax.management.RuntimeMBeanException;
import java.sql.Driver;

class Firefox {
    public static Driver getFireFoxDriver() {
        return null;
    }

    public static void generateHTML(String test) {
        System.out.println("Firefox page: " + test);
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }

    public static void generateHTML(String test) {
        System.out.println("Chrome page: " + test);
    }
}

class WebBrowserFacade {
    public static void generateReports(String explorer, String test) {
        Driver driver = null;
        switch (explorer) {
            case "Firefox":
                driver = Firefox.getFireFoxDriver();
                Firefox.generateHTML(test);
                break;
            case "Chrome":
                driver = Chrome.getChromeDriver();
                Chrome.generateHTML(test);
                break;
            default:
                throw new RuntimeException("Not supported: " + explorer);
        }
    }
}

public class Facade {
    public static void main(String[] args) {
        WebBrowserFacade.generateReports("Firefox","Hello World");
        WebBrowserFacade.generateReports("Chrome","Hello World");
    }
}