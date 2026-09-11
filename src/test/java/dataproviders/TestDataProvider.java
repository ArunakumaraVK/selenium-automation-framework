package dataproviders;

import org.testng.annotations.DataProvider;

public final class TestDataProvider {

    private TestDataProvider() {
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        return new Object[][] {

            {
                "wrong_user",
                "wrong_password"
            },

            {
                "standard_user",
                "wrong_password"
            },

            {
                "wrong_user",
                "secret_sauce"
            }
        };
    }
}