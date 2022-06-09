package com.app.springdataexp.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {
    @Value("classpath:/files/SVS_USER_CREATION_64BIT_RETAILER.xlsm")
    private Resource excelFile;

    public List<ExcelRecord> parseExcel() {
        List<ExcelRecord> recordList = new ArrayList<>();
        try {
            byte[] decoded = Base64.getDecoder().decode(convertToBase64(excelFile));
            InputStream myInputStream = new ByteArrayInputStream(decoded);

            Workbook workbook = new XSSFWorkbook(myInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();
                ExcelRecord record = new ExcelRecord();
                int iterationCount = 5;
                while (cellIterator.hasNext() && iterationCount >= 0) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellTypeEnum() == CellType.BLANK) {
                        throw new Exception("blank cell");
                    }
                    if (cell.getColumnIndex() == 0) {
                        record.setUsername(NumberToTextConverter.toText(cell.getNumericCellValue()));
                    } else if (cell.getColumnIndex() == 1) {
                        record.setRetailerCodeRobi(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 2) {
                        record.setRetailerMsisdnRobi(NumberToTextConverter.toText(cell.getNumericCellValue()));
                    } else if (cell.getColumnIndex() == 3) {
                        record.setRetailerCodeAirtel(cell.getStringCellValue());
                    } else if (cell.getColumnIndex() == 4) {
                        record.setRetailerMsisdnAirtel(NumberToTextConverter.toText(cell.getNumericCellValue()));
                    }
                    iterationCount--;
                }
                recordList.add(record);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION_WHEN_PARSING_EXCEL: " + e.getMessage());
        }
        System.out.println("TOTAL_RECORD: " + recordList.size());
        return recordList;
    }

    private String convertToBase64(Resource resource) {
        String encodedData = null;
        try {
            byte[] bytes = IOUtils.toByteArray(resource.getInputStream());
            encodedData = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            System.out.println("EXCEPTION_WHEN_BASE64_CONVERSION: " + e.getMessage());
        }
        return encodedData;
    }
}