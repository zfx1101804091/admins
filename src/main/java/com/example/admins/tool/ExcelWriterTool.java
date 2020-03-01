package com.example.admins.tool;

import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/2/27 0027 12:09
 */
@Component
public class ExcelWriterTool extends ExcelWriter {
    @Override
    public ExcelWriter autoSizeColumnAll() {
        int columnCount = this.getColumnCount();

        for(int i = 1; i <= columnCount; ++i) {
            this.autoSizeColumn(i);
        }

        return this;
    }
}
