package com.tirmizee.backend.web;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.SubDistricDao;
import com.tirmizee.core.commons.LabelManager;
import com.tirmizee.core.security.AuthenticationUser;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Controller
public class WebAdminController {

//	private static Logger LOGGER = Logger.getLogger(WebAdminController.class);
	
	@Autowired
	AuthenticationUser authenUser;
	
	@Autowired
	ServletContext context; 
	
	@Autowired
	SubDistricDao subDistricDao;
	
	@Autowired
	LabelManager labelManager;
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public ModelAndView index(Locale locale,ModelAndView model){
		final String resourcePath = "admin_index_";
		model.addObject("label", labelManager.loadAll(resourcePath,locale));
		model.setViewName("pages/admin_index");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@GetMapping(value="/admin/permission")
	public ModelAndView permission(Locale locale,ModelAndView model){
		final String resourcePath = "admin_permission_";
		model.addObject("label", labelManager.loadAll(resourcePath,locale));
		model.setViewName("pages/admin_permission");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@GetMapping(value="/admin/address")
	public ModelAndView address(Locale locale,ModelAndView model){
		final String resourcePath = "admin_address_";
		model.addObject("label", labelManager.loadAll(resourcePath,locale));
		model.setViewName("pages/admin_address");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@GetMapping(value="/admin/calendar")
	public ModelAndView calendar(Locale locale,ModelAndView model){
		model.setViewName("pages/calendar");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@GetMapping(value="/admin/role")
	public ModelAndView role(Locale locale,ModelAndView model){
		final String resourcePath = "admin_address_";
		model.addObject("label", labelManager.loadAll(resourcePath,locale));
		model.setViewName("pages/admin_role");
		return model;
	}
	
	@PreAuthorize("hasAnyAuthority('AD000')")
	@GetMapping(value="/admin/report",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> report(HttpServletResponse response) throws JRException, FileNotFoundException{
		final String fileName = "UserReport.pdf";
		JRPdfExporter exporter = new JRPdfExporter();
		JasperReport jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("/report/Cherry.jrxml"));

		Map<String, Object> map = new HashMap<>();
		map.put("title", "fsadfadsfadsf");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jr, map, new JREmptyDataSource());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 
		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.exportReport();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "inline; filename=" + fileName);
		return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
	}

}
