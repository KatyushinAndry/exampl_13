package pure.main.owner.tests;

import io.qameta.allure.junit5.AllureJunit5;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pure.main.owner.config.TestDataConfig;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static pure.main.owner.helpers.AttachmentsHelper.*;
import static pure.main.owner.helpers.DriverHelper.*;

@ExtendWith({AllureJunit5.class})
public class TestBase {

    public static final TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());

    @BeforeEach
    void setup(){
        configureDriver(testDataConfig.baseUrl());
    }

    @AfterEach
    public void addAttachments(){
        closeWebDriver();
    }

}
