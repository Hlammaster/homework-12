import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeForm {




    @BeforeAll
    static void beforeAll(){ browserSize= "1920x1080"; }

    @Test
    void fillFormTest(){
       open( "https://demoqa.com/automation-practice-form");
       $("#firstName").setValue("Sirius");
       $("#lastName").setValue("Black");
       $("#userEmail").setValue("gavnuk@mail.ru");




    }



}
