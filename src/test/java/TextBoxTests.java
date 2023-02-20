import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {

        @BeforeAll
        static void beforeAll() {
        browserSize= "1920x1080";
    }




    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Sirius Black");
        $("[id=userEmail]").setValue("govnojop@cot.com");
        $("[id=currentAddress]").setValue("the box 2");
        $("[id=permanentAddress]").setValue("the bed");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Sirius Black"),text("govnojop@cot.com"),
                text("the box 2"),text("the bed"));


    }

}
