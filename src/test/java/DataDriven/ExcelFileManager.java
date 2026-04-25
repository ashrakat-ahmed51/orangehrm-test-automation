package DataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelFileManager {
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelFileManager(String filePath){
        try{
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(0);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void goToSheetName(String sheetName){
        sheet = workbook.getSheet(sheetName);
    }

    public String getSpecificCellData(int row, int col){
        return new DataFormatter().formatCellValue(sheet.getRow(row).getCell(col));
    }

    public int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount(){
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getSpecificCellFormula(int row, int col){
        Cell cell = sheet.getRow(row).getCell(row);
        if(cell != null && cell.getCellType() == CellType.FORMULA)
            return cell.getCellFormula();
        return "There is no Formula";
    }

    public List<String> getHeaders(){
        List<String> headers = new ArrayList<>();
        for(int i = 0; i < getColumnCount(); i++)
            headers.add(getSpecificCellData(0, i));
        return headers;
    }

    public Map<String, List<String>> getColumnData(){
        Map<String, List<String>> data = new LinkedHashMap<>();
        List<List<String>> rows = getRows();
        List<String> headers = getHeaders();
        for(int i = 0; i < getRowCount(); i++){
            List<String> columnData = new ArrayList<>();
            for(List<String> row: rows)
                columnData.add(row.get(i));
            data.put(headers.get(i), columnData);
        }
        return data;
    }

    public List<List<String>> getRows(){
        List<List<String>> rows = new ArrayList<>();
        for(int i = 1; i < getRowCount(); i++){
            List<String> rowData = getSpecificRow(i);
            rows.add(rowData);
        }
        return rows;
    }

    public List<String> getSpecificRow(int row){
        List<String> rowData = new ArrayList<>();
        for(int j = 0; j < getColumnCount(); j++)
            rowData.add(getSpecificCellData(row, j));
        return rowData;
    }

    public void closeExcelFile(){
        try{
            if(workbook!=null)
                workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
