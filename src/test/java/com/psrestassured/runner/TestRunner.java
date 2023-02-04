package com.psrestassured.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/psrestassured/features", glue = {"com.psrestassured.testscripts"},
        plugin ={"html:target/cucumber-reports/cucumber-html.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests {
}
