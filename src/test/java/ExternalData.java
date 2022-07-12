import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.Iterator;

public class ExternalData {
    public static String path = "src/test/resources/tst_Data.xlsx";
    public static XSSFWorkbook wBook;
    public static XSSFSheet sheet;

    public static void main(String args[]) throws IOException {
//        getrowCount();
//        System.out.println("\nDesired Data : ");
//        getcellData(1,0);
//        getcellData(1,1);
//        getcellData(1,2);
        wholeData();
    }

    public static void getcellData(int rowNum,int column) throws IOException {
        wBook = new XSSFWorkbook(path);
        sheet = wBook.getSheet("demo");
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(column));
        System.out.println(value);
    }

    public static void getrowCount() throws IOException {
        wBook = new XSSFWorkbook(path);
        sheet = wBook.getSheet("demo");
        int rowcount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows inside the excel sheet : "+rowcount);
    }

    public static void wholeData() throws IOException {
        wBook = new XSSFWorkbook(path);
        sheet = wBook.getSheet("demo");
        int rowcount = sheet.getPhysicalNumberOfRows();

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row r = rowIterator.next();

            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = r.cellIterator();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
            System.out.println("");
        }
    }
}
