<%@ page contentType="aplication/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.engine.data.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>

<% 
	try{
		List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("listSercicesReport");
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
		String jrxmlFile = session.getServletContext().getRealPath("/reprot/servicereport.jrxml");
		InputStream input = new FileInputStream(new File(jrxmlFile));
		JasperReport jasperReport = JasperCompileManager.compileReport(input);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	} catch (Exception e){
		e.printStackTrace();
	}
%>

