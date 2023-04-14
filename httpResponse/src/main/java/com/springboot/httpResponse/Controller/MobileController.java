package com.springboot.httpResponse.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.httpResponse.Model.ErrorResponseBody;
import com.springboot.httpResponse.Model.Metadata;
import com.springboot.httpResponse.Model.Mobiles;
import com.springboot.httpResponse.Service.MobileService;
import com.springboot.httpResponse.Service.TimeStamp;
@RestController
@RequestMapping("/mobiles")
public class MobileController {
	
	@Autowired
	private MobileService mobileService;
	
	@Autowired 
	private TimeStamp timeStamp;
	
	@GetMapping
	public ResponseEntity<Object>  mobiles_list() {
		List<Mobiles> mobiles=mobileService.mobiles_List();
		Metadata metadata=new Metadata(200,"success",null);	
		Map<String,Object> response=new HashMap<String, Object>();
		response.put("body", mobiles);
		response.put("metadata", metadata);		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> mobile(@PathVariable Long id)  {
		try {
			System.out.println(timeStamp);
			Mobiles mobile=mobileService.mobileData( id);
			Metadata metadata=new Metadata(200,"success",null);
			Map<String,Object> response=new HashMap<String, Object>();		
			response.put("body", mobile);
			response.put("metadata", metadata);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch(ResponseStatusException ex) {		
			ErrorResponseBody errorResponseBody= new ErrorResponseBody(timeStamp.timeStamp, ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/mobiles/"+id);
			return new ResponseEntity<> (errorResponseBody,ex.getStatusCode());
		}
		catch (Exception ex) {
	        Metadata metadata = new Metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("metadata", metadata);
			response.put("Error",ex.getLocalizedMessage() );
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
	}
	
	@PostMapping
	public ResponseEntity<Object> saveMobile(@RequestBody Mobiles mobile) {
		try {
			
			Mobiles newMobile=mobileService.newMobile(mobile);
			Metadata metadata=new Metadata(201,"success",null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("body", mobile);
			response.put("metadata", metadata);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}catch(ResponseStatusException ex) {
			ErrorResponseBody errorResponseBody= new ErrorResponseBody(timeStamp.timeStamp, ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/mobiles");
			return new ResponseEntity<> (errorResponseBody,ex.getStatusCode());
		}
		catch (Exception ex) {
	        Metadata metadata = new Metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("metadata", metadata);
			response.put("Error",ex.getLocalizedMessage() );
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteMobile(@PathVariable Long id) {
		try {
		mobileService.oldMobile(id);
		Metadata metadata=new Metadata(204,"success",null);
		Map<String,Object> response=new HashMap<String, Object>();
		response.put("body","[]");
		response.put("metadata", metadata);
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
		catch(ResponseStatusException ex) {		
			ErrorResponseBody errorResponseBody= new ErrorResponseBody(timeStamp.timeStamp, ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/mobiles/"+id);
			return new ResponseEntity<> (errorResponseBody,ex.getStatusCode());
		}
		catch (Exception ex) {
	        Metadata metadata = new Metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("metadata", metadata);
			response.put("Error",ex.getLocalizedMessage() );
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
