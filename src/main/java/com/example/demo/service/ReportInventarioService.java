package com.example.demo.service;

import com.example.demo.common.JasperReportManager;
import com.example.demo.enums.TipoReporteEnum;
import com.example.demo.DTO.ReportInventarioDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
@Service
public class ReportInventarioService {
    @Autowired
    private JasperReportManager reportManager;

    @Autowired
    private DataSource dataSource;

    public ReportInventarioDTO obtenerReporteInventario(Map<String, Object> params)
            throws JRException, IOException, SQLException {
        String fileName = "report_inventario";
        ReportInventarioDTO dto = new ReportInventarioDTO();
        String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
        dto.setFileName(fileName+extension);

        ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
                dataSource.getConnection());

        byte[] bs = stream.toByteArray();;
        dto.setStream(new ByteArrayInputStream(bs));
        dto.setLength(bs.length);

        return dto;
    }
}
