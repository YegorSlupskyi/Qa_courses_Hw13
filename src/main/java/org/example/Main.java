package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        HillelTestingCourses HillelTestingCourses = new HillelTestingCourses(driver);

        HillelTestingCourses.goToPage();
        Thread.sleep(2000);
        HillelTestingCourses.printWebElements(HillelTestingCourses.getAllCourses());

        System.out.println("____________________________________________________________");
        HillelTestingCourses.printWebElements(HillelTestingCourses.getAdditionalCourses());

        System.out.println("____________________________________________________________");
        HillelTestingCourses.printWebElements(HillelTestingCourses.getOpportunities());

        try {
            HillelTestingCourses.goToCategory("management");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(2000);
        driver.quit();
    }
}