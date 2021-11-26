package com.qualitystream.testing;

import org.testng.annotations.*;
import sun.reflect.generics.tree.VoidDescriptor;

import static org.testng.Assert.*;

public class TestNGExample {

    @BeforeSuite
    public void beforeSuite(){
    }
    @BeforeTest
    public void beforeTest(){
    }
    @BeforeClass
    public void beforeClass(){
    }
    @BeforeMethod
    public void beforeMethod(){
    }
    @Test
    public void f(){
    }

    @AfterMethod
    public void afterMethod(){
    }
    @AfterClass
    public void afterClass(){
    }
    @AfterTest
    public void afterTest(){
    }
    @AfterSuite
    public void afterSuite() {
    }
}