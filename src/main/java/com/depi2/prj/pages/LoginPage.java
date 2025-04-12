package com.depi2.prj.pages;

import org.openqa.selenium.By;

public class HomePage  extends BasePage {


    private String email = "hoss@home.com";
    private String name = "Depi2 Cy User";
    private String password = "ASDasd@123";
    
    private By loginTitlelocator = By.xpath("//h1[text()='DEPI-2 TODOS']");
    private By loginEmaillocator = By.xpath("//input[@data-cy='email']");
    private By loginPasswordlocator = By.xpath("//input[@data-cy='password']");
    private By loginNamelocator = By.xpath("//input[@data-cy='name']");
    private By loginButtonlocator = By.xpath("//button[text()='Login']");
    private By loginSuccesslocator = By.xpath("//span[text(),'User logged in Redirecting...']");
    private By loginErrorlocator = By.xpath("//span[@data-cy='registration-error']");
    private By loginNameErrorlocator = By.xpath("//span[text()='Name should be min 5 characters..']");
    private By loginEmailErrorlocator = By.xpath("//span[text()='Email is not valid']");

    public HomePage() {
        super();
    }
}