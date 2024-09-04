package trnpbulkvhclreqapp.view.servlet;


import adf.utils.ebiz.EbizParams;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

@WebServlet(name = "trnpbulkvhclreqServlet", urlPatterns = { "/reports/trnpbulkvhclreqServlet" })
public class trnpbulkvhclreqServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        //
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //  String link = request.getParameter("Link");
        String reportName = null;
        String linkId = null;
        Integer slocId =new Integer(0);
        if (request.getParameter("LinkId") != null) {
            if (!request.getParameter("LinkId").equalsIgnoreCase(""))
                linkId = request.getParameter("LinkId");
        }
//        System.err.println("____CldId___"+ request.getParameter("CldId"));
//      System.err.println("___SlocId___"+ request.getParameter("SlocId"));
        String cldId = request.getParameter("CldId");
    try
    {
       slocId = Integer.parseInt(request.getParameter("SlocId"));
    }
    catch (NumberFormatException nfe)
    {
       slocId=1;
      // TODO: Add catch code
      nfe.printStackTrace();
    }
//      System.err.println("___SlocId___after catch block____  "+ slocId);
//      System.err.println("__HoOrgId___"+ request.getParameter("HoOrgId"));
        String hoOrgId = request.getParameter("HoOrgId");
        String orgId = request.getParameter("OrgId");
        String docId = request.getParameter("DocId");
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/SLSDS");
            conn = ds.getConnection();            
                Object output = this.callStoredFunction(Types.VARCHAR, "SLS.SLS_INS_BULK_VR_RPT_DATA", conn, docId, linkId);  
                System.out.println("Function called to insert object -->>"+output);                
            
            System.out.println("Printing Report");
            ps = conn.prepareStatement("select distinct srvr_Loc_As_Rpt_Path from APP.App$Servr$Loc");

            rs = ps.executeQuery();
            String path = null;
             
            while (rs.next()) {
                path = rs.getString(1);
            }
            rs.close();
//            path =     "D:/DEPLOYMENT/Report/"; //comment this line
            path = path + "TRNP/";
//                      path =     "D:/DEPLOYMENT/Report/";
            
            
            if (linkId.equals("l12"))
                reportName = "Vehicle_Scheduling_Bulk";
            else if (linkId.equals("l20"))
                reportName = "Bulk_Vehicle_Delivery_Note";
            else if (linkId.equals("l23"))
            reportName = "POS_Delivery_Note";
          /**
          * Added by : Manjeet Singh
          * Modified on : 06-05-2024
          * Remarks : Below code is added for downloading GRN_Unscanned_Barcode_Dtl report.'.
          * TMS ID : 131416
          **/
                else if (linkId.equals("l24"))
                reportName = "GRN_Unscanned_Barcode_Dtl";
            
            // String reportType = null;

           
//            String TbId = null;

            StringBuilder fetchRprtNm = new StringBuilder("SELECT APP.FN_GET_ORG_LOGO_DESC(");
            fetchRprtNm.append("'");
            fetchRprtNm.append(cldId);
            fetchRprtNm.append("'");
            fetchRprtNm.append(",");
            fetchRprtNm.append(slocId);
            fetchRprtNm.append(",");
            fetchRprtNm.append("'");
            fetchRprtNm.append(orgId);
            fetchRprtNm.append("'");
            fetchRprtNm.append(") FROM DUAL");

            String logo = "";

            PreparedStatement logoPs = conn.prepareStatement(fetchRprtNm.toString());

            ResultSet logoRs = logoPs.executeQuery();

            while (logoRs.next()) {
                logo = logoRs.getString(1);
            }
            logoRs.close();
            String logoPath = logo;
            
            //System.out.println("logoPath :: "+logoPath);

            if(request.getParameter("DocId") != null)
            {
                if(!request.getParameter("DocId").equalsIgnoreCase(""))
                    docId = request.getParameter("DocId");
            }
            
//            if((request.getParameter("TbId") != null) && (!request.getParameter("TbId").toString().equalsIgnoreCase(" ")))
//                TbId = request.getParameter("TbId");
        
            Map parameters = new HashMap();
            parameters.put("CldId", cldId);
            parameters.put("SlocId", slocId);
            parameters.put("HoOrgId", hoOrgId);
            parameters.put("OrgId", orgId);
            parameters.put("DocId", docId);
            parameters.put("Org_Logo", logoPath);

            parameters.put("Path", path);
            JasperReport report = (JasperReport)JRLoader.loadObject(new File(path + reportName + ".jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
            OutputStream ouputStream = response.getOutputStream();
            JRExporter exporter = null;
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachement; filename=\"" + reportName + ".pdf\"");
            exporter = new JRPdfExporter();
            exporter.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, true);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
            
            
            try {
                exporter.exportReport();
            } catch (JRException e) {
                throw new ServletException(e);
            } finally {
                if (ouputStream != null) {
                    try {
                        ouputStream.flush();
                        ouputStream.close();
                    } catch (IOException ex) {
                        throw (ex);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
               
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Object callStoredFunction(int type, String functionName, Connection con,
                                     Object... params) throws SQLException {
        String name = "{ ?= call " + functionName + "(";
        for (byte i = 0; i < params.length; i++) {
            name += "?";
            if (i != params.length - 1)
                name += ",";
        }
        name += ")}";
        CallableStatement st = con.prepareCall(name);
        for (byte i = 1; i <= params.length; i++) {
            st.setObject(i + 1, params[i - 1]);
        }
        st.registerOutParameter(1, type);
        st.execute();
        Object val = st.getObject(1);
        st.close();
        return val;
    }
}


