package excel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class TestClass {

    private static final Logger logger = LogManager.getLogger(TestClass.class.getName());

    public static void testPath(){
        String path = "src\\main\\resources\\data.xlsx";
        FileInputStream fis = Util.getStream(path);
        XSSFWorkbook workbook = Util.readXLSfile(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);

        // we iterate on rows
        Iterator<Row> rowIt = sheet.iterator();

        while(rowIt.hasNext()) {
            Row row = rowIt.next();

            // iterate on cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                logger.debug(cell.toString() + ";");
            }

            System.out.println();
        }

        try {
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
