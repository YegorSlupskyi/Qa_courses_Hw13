package org.example;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class HillelTestingCourses {
    private final WebDriver driver;
    private static final String HILLEL_COURSES_PAGE = "https://ithillel.ua/courses/testing";


    public HillelTestingCourses(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(HILLEL_COURSES_PAGE);
    }

    public List<WebElement> getAllCourses() {
        return driver.findElements(By.cssSelector(".profession-bar_title"));
    }

    public static void printWebElements(List<WebElement> webElementList) {
        for (WebElement webElement : webElementList) {
            System.out.println(webElement.getText());
        }
    }

    public List<WebElement> getAdditionalCourses() {
        List<WebElement> coursesBlocks = driver.findElements(By.cssSelector(".block-profession_group"));
        WebElement lastBlock = coursesBlocks.get(coursesBlocks.size() - 1);
        List<WebElement> additionalCoursesList = lastBlock.findElements(By.cssSelector(".profession-bar_title"));
        return additionalCoursesList;
    }

    public List<WebElement> getOpportunities() {
        return driver.findElements(By.cssSelector(".opportunity-item_title.p-l"));
    }

    public void goToCategory(String category) throws Exception {
        WebElement coursesDropdown = driver.findElement(By.cssSelector("button.site-nav-link[data-dropdown-trigger='coursesMenu']"));
        coursesDropdown.click();
        List<WebElement> categorySelectorButtons = driver.findElements(By.cssSelector(".cats-list_btn"));
        for (WebElement button : categorySelectorButtons) {
            if (Objects.equals(button.getAttribute("data-category"), category)){
                button.click();
                return;
            }
        }
        throw new Exception("There is no such button");

    }

}
