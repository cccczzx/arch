package com.zhangzixiang.bridge.filter;

import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.zhangzixiang.bridge.util.CellStyleUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class CustomRowWriterHandler implements RowWriteHandler {

    private CellStyle firstCellStyle;

    /**
     * 列号
     */
    private int count = 0;

    @Override
    public void beforeRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer integer, Boolean aBoolean) {
        Cell cell = row.createCell(0);
        if (firstCellStyle == null) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            firstCellStyle = CellStyleUtil.firstCellStyle(workbook);
        }
        cell.setCellStyle(firstCellStyle);
        //设置列宽  0列   10个字符宽度
        writeSheetHolder.getSheet().setColumnWidth(0, 10 * 256);
        if (row.getRowNum() == 0) {
            cell.setCellValue("序号");
            return;
        }
        cell.setCellValue(++count);
    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer integer, Boolean aBoolean) {

    }

}
