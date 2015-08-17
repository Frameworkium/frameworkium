package com.angularjs.pages.web;

import com.frameworkium.pages.internal.BasePage;
import com.frameworkium.pages.internal.PageFactory;
import com.frameworkium.pages.internal.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class HomePage extends BasePage<HomePage> {

    @Name("Develop navigation bar item")
    @Visible
    @FindBy(css = "ul.nav li.dropdown a.dropdown-toggle i.icon-book")
    private WebElement developDropdown;

    @Name("Developer Guide menu item")
    @FindBy(css = "li a[href='http://docs.angularjs.org/guide']")
    private WebElement developerGuideMenuItem;

    public static HomePage open() {
        return PageFactory.newInstance(HomePage.class, "https://angularjs.org/");
    }

    public DeveloperGuidePage clickDeveloperGuide() {
        developDropdown.click();
        developerGuideMenuItem.click();
        return PageFactory.newInstance(DeveloperGuidePage.class);
    }

}