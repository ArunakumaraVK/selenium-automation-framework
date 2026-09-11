package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exceptions.FrameworkException;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static String getCellData(
            String filePath,
            String sheetName,
            int rowNumber,
            int columnNumber) {

        try (
            FileInputStream file =
                    new FileInputStream(filePath);

            Workbook workbook =
                    new XSSFWorkbook(file)
        ) {

            Sheet sheet =
                    workbook.getSheet(sheetName);

            Row row =
                    sheet.getRow(rowNumber);

            Cell cell =
                    row.getCell(columnNumber);

            DataFormatter formatter =
                    new DataFormatter();

            return formatter
                    .formatCellValue(cell);

        } catch (IOException e) {

            throw new FrameworkException(
                    "Unable to read Excel file",
                    e);
        }
    }
}