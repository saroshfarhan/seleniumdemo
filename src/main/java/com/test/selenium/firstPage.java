package com.test.selenium;

import org.openqa.selenium.By;


public class firstPage extends abstractPage{

    //define web elements
    public By searchBar = By.name("q");

    public By searchBtn = By.name("btnK");

    public By feelingLuckyBtn = By.name("btnI");




    //methods to consume the above said web elements
    firstPage load(String url){
        loadUrl(url);
        return this;
    }

    firstPage enterSearchQuery(){
        enterInputText(searchBar, "happy face");
        return this;
    }
    
    firstPage clickSearchBtn(){
        clickButton(searchBtn);
        return this;
    }
}
