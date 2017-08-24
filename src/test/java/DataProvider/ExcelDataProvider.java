
package DataProvider;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelDataProvider {
	@DataProvider(name = "DP")
	public String[][] readExcel() {
		File file = new File("D:\\workspace\\aceturtle_Project\\src\\test\\java\\testdata\\testdata.xls");
		String inputData[][] = null;
		Workbook w;

		try {
			w = Workbook.getWorkbook(file);

			// Get the first sheet
			Sheet sheet = w.getSheet("shippingpage");

			int colcount = sheet.getColumns();

			System.out.println("colomun count" + colcount);
			int rowcount = sheet.getRows();

			System.out.println("Rowcount" + rowcount);

			inputData = new String[rowcount][colcount];

			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j,i);
					inputData[i][j] = cell.getContents();
				}
			}
		} catch (BiffException e) {

		} catch (IOException e) {

			e.printStackTrace();
		}
		return inputData;
	}
}
