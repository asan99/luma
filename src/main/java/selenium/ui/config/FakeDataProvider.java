package selenium.ui.config;


import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import selenium.ui.models.CustomerAccountForm;


public class FakeDataProvider {

    Faker faker = new Faker();


    // Qwerty!2345 password from Luma

    @Step("generate new customer account")
    public CustomerAccountForm generateCustomerAccount() {

        String password = faker.internet().password(8, 16, true, true, true);

        return CustomerAccountForm.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .emailAddress(faker.internet().emailAddress())
                .password(password)
                .confirmPassword(password)
                .build();
    }

}
