package com.checkingLinks;

import jdk.nashorn.internal.ir.WhileNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckingLinksPage {

    private WebDriver driver;

    public CheckingLinksPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean CheckingPageLinks () {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        String url = "";
        List<String> brokenLinks = new ArrayList<String>();
        List<String> okLinks = new ArrayList<String>();

        HttpURLConnection httpConnection = null;
        int responseCode = 200;
        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()){
            url = it.next().getAttribute("href");
            if (url==null || url.isEmpty()){
                System.out.println(url + "url is not configure or it is empty");
                continue;
            }
            try {
                httpConnection = (HttpURLConnection)(new URL(url).openConnection());
                httpConnection.setRequestMethod("HEAD");
                httpConnection.connect();
                responseCode = httpConnection.getResponseCode();// https://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html

                if(responseCode>400){
                    System.out.println("ERROR BROKEN LINK: -- "+ url);
                    brokenLinks.add(url);
                }else {
                    System.out.println("VALID LINK: -- "+ url);
                    okLinks.add(url);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valid Links"+okLinks.size());
        System.out.println("Invalid Links"+brokenLinks.size());

        if (brokenLinks.size()>0){
            System.out.println("**** ERROR ----------------- Broken Links");
            for (int i=0; i<brokenLinks.size();i++){
                System.out.println(brokenLinks.get(i));
            }
            return false;
        }else{
            return true;
        }



    }

}
