package com.calcapp.tests;

import static com.google.common.truth.Truth.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Issue;

import com.calcapp.pages.app.CalculatorPage;
import com.frameworkium.core.ui.pages.PageFactory;
import com.frameworkium.core.ui.tests.BaseTest;

public class CalculatorAppTest extends BaseTest {

    /**
     * Example test for https://appium.s3.amazonaws.com/TestApp7.1.app.zip
     *
     * @throws Exception
     */
    @Test(description = "Test sum computation")
    @Issue("CALC-1")
    public void testIOSApp() throws Exception {

        Random rand = new Random();
        Integer a = rand.nextInt(100);
        Integer b = rand.nextInt(100);
        Integer sum = a + b;

        String result = PageFactory.newInstance(CalculatorPage.class).computeSum(a, b).then().getResult();

        assertThat(result).isEqualTo(sum.toString());
    }
}
