package com.heroku.theinternet.pages.web;

import com.frameworkium.core.ui.annotations.Invisible;
import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class DynamicLoadingExamplePage extends BasePage<DynamicLoadingExamplePage> {


    @Visible
    @Name("Start button")
    @FindBy(css = "#start button")
    private Button startButton;

    @Invisible
    @Name("Hidden element")
    @FindBy(id = "finish")
    private HtmlElement dynamicElement;

    @Step("Click Start")
    public DynamicLoadingExamplePage clickStart() {
        startButton.click();
        wait.until(ExpectedConditions.visibilityOf(dynamicElement));
        return this;
    }

    @Step("Wait for the hidden element to be displayed")
    public DynamicLoadingExamplePage waitForElementToBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dynamicElement));
        return this;
    }

    public boolean isElementDisplayed() {
        return dynamicElement.isDisplayed();
    }

    public boolean isElementPresent() {
        try {
            return dynamicElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
