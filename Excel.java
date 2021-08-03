	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.nio.file.Paths;
	import com.google.common.io.Resources;
	
	
	
	
	
public class Excel {



	/**
	 * Clase para poder leer y escribir de un archivo Excel. En nombre de entrada se
	 * almacena en la variable testDataExcelFileName Falta añadir log, captura de
	 * excepciones y la documentacion
	 */

	public class ExcelUtil extends Principal {
		// Variable de entorno
		// Main Directory of the project
		public static final String currentDir = System.getProperty("user.dir");
		public static final String resourcesDir = Paths.get(currentDir).getParent() + "\\Recursos\\src\\main\\resources\\";

		// Location of Test data excel file
		public static String testDataExcelPath = null;

		// Excel WorkBook
		private static XSSFWorkbook excelWBook;

		// Excel Sheet
		private static XSSFSheet excelWSheet;

		// Excel cell
		private static XSSFCell cell;

		// Excel row
		private static XSSFRow row;

		// Row Number
		public static int rowNumber;

		// Column Number
		public static int columnNumber;

		// Ruta excel
		static String testDataExcelFileName = "";

		// Setter and Getters of row and columns
		public static void setRowNumber(int pRowNumber) {
			rowNumber = pRowNumber;
		}

		public static int getRowNumber() {
			return rowNumber;
		}

		public static void setColumnNumber(int pColumnNumber) {
			columnNumber = pColumnNumber;
		}

		public static int getColumnNumber() {
			return columnNumber;
		}

		/**
		 * This method has two parameters: "Excel sheet name" and "entorno" It creates
		 * FileInputStream and set excel file and excel sheet to excelWBook and
		 * excelWSheet variables.
		 * 
		 * @param sheetName Name of the Tab to access
		 * @param entorno   Number that identifies the excel excelName_$entorno.xlsx
		 * @throws Exception
		 */
		public static void setExcelFileSheet(String sheetName, String entorno) throws Exception {
			// In case of variable @entorno is null
			if (entorno == null) {
				setExcelFileSheet(sheetName);
			}
			testDataExcelFileName = "generaliDatos_" + entorno + ".xlsx";
			try {
				// Open the Excel file
				FileInputStream ExcelFile = new FileInputStream(Resources.getResource(testDataExcelFileName).getPath());
				excelWBook = new XSSFWorkbook(ExcelFile);
				excelWSheet = excelWBook.getSheet(sheetName);
				System.out.println("Setted Excel to: " + testDataExcelFileName + "\nPestaña: " + sheetName);
			} catch (Exception e) {
				try {
					System.out.println("[ ERROR ] " + ": Error seteando pestaña excel");
					Reporter.log("[ ERROR ] " + ": Error seteando pestaña excel");
					throw (e);
				} catch (IOException e1) {
					System.err.println("[FATAL ERROR ]");
					Reporter.log("[FATAL ERROR ] ");
					e1.printStackTrace();
				}
			}
		}

		/**
		 * This method has two parameters: "Test data excel file name" and "Excel sheet
		 * name" It creates FileInputStream and set excel file and excel sheet to
		 * excelWBook and excelWSheet variables.
		 * 
		 * @param sheetName Name of the Tab to access
		 * @throws Exception
		 */
		public static void setExcelFileSheet(String sheetName) throws Exception {
			testDataExcelFileName = "generaliDatos_6.xlsx";
			// MAC or Windows Selection for excel path
			try {
				// Open the Excel file
				FileInputStream ExcelFile = new FileInputStream(Resources.getResource(testDataExcelFileName).getPath());
				excelWBook = new XSSFWorkbook(ExcelFile);
				excelWSheet = excelWBook.getSheet(sheetName);
				System.out.println("Setted Excel to: " + testDataExcelFileName + "\nPestaña: " + sheetName);
			} catch (Exception e) {
				try {
					System.out.println("[ ERROR ] " + ": Error seteando pestaña excel");
					Reporter.log("[ ERROR ] " + ": Error seteando pestaña excel");
					throw (e);
				} catch (IOException e1) {
					System.err.println("[FATAL ERROR ]");
					Reporter.log("[FATAL ERROR ] ");
					e1.printStackTrace();
				}
			}
		}

		/***
		 * This method reads the test data from the Excel cell. We are passing row
		 * number and column number as parameters.
		 * 
		 * @param RowNum index of the accessed row
		 * @param ColNum index of the accessed column
		 * @return The cell data of the row and column indicated.
		 * @throws Exception
		 */
		public static String getCellData(int RowNum, int ColNum) throws Exception {
			try {
				cell = excelWSheet.getRow(RowNum).getCell(ColNum);
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(cell);
				return cellData;
			} catch (Exception e) {
				System.out.println("[ ERROR ] " + ": Error al obtener celda excel: " + RowNum + "::" + ColNum);
				Reporter.log("[ ERROR ] " + ": Error al obtener celda excel: " + RowNum + "::" + ColNum);
				throw (e);
			}
		}

		/***
		 * This method takes row number as a parameter and returns the data of given row
		 * number.
		 * 
		 * @param RowNum Index of row to access.
		 * @return the data in the selected row
		 * @throws Exception
		 */
		public static XSSFRow getRowData(int RowNum) throws Exception {
			try {
				row = excelWSheet.getRow(RowNum);
				return row;
			} catch (Exception e) {
				System.out.println("[ ERROR ] " + ": Error al obtener columna excel");
				Reporter.log("[ ERROR ] " + ": Error al obtener columna excel");
				throw (e);
			}
		}

		/***
		 * This method gets excel file, row and column number and set a value to the
		 * that cell.
		 * 
		 * @param value  Value to insert in the specified row, column
		 * @param RowNum Index of row to access.
		 * @param ColNum Index of column to access.
		 * @throws Exception
		 */
		public static void setCellData(String value, int RowNum, int ColNum) throws Exception {
			try {
				row = excelWSheet.getRow(RowNum);
				cell = row.getCell(ColNum);
				if (cell == null) {
					cell = row.createCell(ColNum);
					cell.setCellValue(value);
				} else {
					cell.setCellValue(value);
				}
				System.err.println("testDataExcelFileName:" + Resources.getResource(testDataExcelFileName).getPath());
				FileOutputStream fileOut = new FileOutputStream(Resources.getResource(testDataExcelFileName).getPath());
				excelWBook.write(fileOut);
				fileOut.flush();
				fileOut.close();
			} catch (Exception e) {
				try {
					System.out.println("[ ERROR ] " + ": Error seteando celda en el excel");
					Reporter.log("[ ERROR ] " + ": Error seteando celda en el excel");
					throw new Exception(e);
				} catch (IOException e1) {
					System.err.println("[FATAL ERROR ]");
					Reporter.log("[FATAL ERROR ] ");
					e1.printStackTrace();
				}
			}
		}

		/**
		 * This method gets DateType and FieldName, row and column and returns the value
		 * from the Excel File
		 * 
		 * @param DateType  Name of the accessed row
		 * @param FieldName Name of the accessed column
		 * @return The value in the indicated cell
		 * @throws Exception
		 */
		public static String getFieldValue(String DateType, String FieldName) throws Exception {
			try {
				String Value;
				int row = 1;
				do {
					Value = getCellData(row, 0);
					row++;
				} while (!Value.equals(DateType));
				row--;
				int Column = 1;
				do {
					Value = getCellData(0, Column);
					Column++;
					if (Value.isEmpty()) {
						break;
					}
				} while (!Value.equals(FieldName));
				Column--;
				String found = getCellData(row, Column);
				return found;

			} catch (Exception e) {
				System.out.println(
						"[ ERROR ] " + ": Error obteniendo valor de celda excel: " + FieldName + " => " + DateType);
				Reporter.log("[ ERROR ] " + ": Error obteniendo valor de celda excel: " + FieldName + " => " + DateType);
				throw (e);
			}
		}

		/***
		 * This method gets Value, DateType and FieldName, row and column and write the
		 * value.
		 * 
		 * @param InsertValue Value to be inserted
		 * @param DateType    Name of the accessed row
		 * @param FieldName   Name of the accessed column
		 * @throws Exception
		 */
		public static void setFieldValue(String InsertValue, String DateType, String FieldName) throws Exception {
			int row = 1;
			try {
				String Value;
				do {
					Value = getCellData(row, 0);
					row++;
				} while (!Value.equals(DateType));
				row--;
				int Column = 1;
				do {
					Value = getCellData(0, Column);
					Column++;
				} while (!Value.equals(FieldName));
				Column--;
				setCellData(InsertValue, row, Column);
				System.err.println(InsertValue+" "+row+" "+Column);
			} catch (Exception e) {
				try {
					System.out.println("[ ERROR ] " + ": Error informando valor obtenido en excel");
					Reporter.log("[ ERROR ] " + ": Error informando valor obtenido en excel");
					throw new Exception(e);
				} catch (IOException e1) {
					System.err.println("[FATAL ERROR ] ");
					Reporter.log("[FATAL ERROR ] ");
					e1.printStackTrace();
				}
			}
		}

		public static void close() {
			try {
				if (excelWBook != null) {
					excelWBook.close();
				}
			} catch (IOException e) {
				Reporter.log("[Error al cerrar el excel ] " + e.getLocalizedMessage());
			}
		}



}
