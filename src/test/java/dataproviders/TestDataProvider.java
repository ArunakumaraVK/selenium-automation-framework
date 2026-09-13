package dataproviders;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public final class TestDataProvider {

    private TestDataProvider() {
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        String filePath =
                System.getProperty("user.dir")
                + "/src/test/resources/testdata/LoginTestData.xlsx";

        String sheetName = "LoginData";

        Object[][] data = new Object[3][2];

        data[0][0] = ExcelUtils.getCellData(
                filePath, sheetName, 1, 0);

        data[0][1] = ExcelUtils.getCellData(
                filePath, sheetName, 1, 1);

        data[1][0] = ExcelUtils.getCellData(
                filePath, sheetName, 2, 0);

        data[1][1] = ExcelUtils.getCellData(
                filePath, sheetName, 2, 1);

        data[2][0] = ExcelUtils.getCellData(
                filePath, sheetName, 3, 0);

        data[2][1] = ExcelUtils.getCellData(
                filePath, sheetName, 3, 1);

        return data;
    }
}