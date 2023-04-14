package com.springboot.httpResponse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.httpResponse.Model.Mobiles;
import com.springboot.httpResponse.Repository.MobileRepository;

@Service
public class  MobileService {
	
	@Autowired
	private  MobileRepository mobileRepository;
	
	public List<Mobiles> mobiles_List(){
		return mobileRepository.findAll();
	}
	
	public Mobiles mobileData(Long id)  {
		return mobileRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mobile not found :"+id));
				
	}
	
	public Mobiles newMobile(Mobiles mobile) {
		System.out.println(mobile);
		if(mobile.getMobileName()==null|| mobile.getModel()==null||mobile.getPrice()==null ) {
			System.out.println(mobile.toString());

			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request Body missing  :");
		}
		return mobileRepository.save(mobile);
	}
	
public void oldMobile(Long id) {
	Mobiles mobile=mobileRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mobile not found :"+id));
		 mobileRepository.delete(mobile);
	}
}
