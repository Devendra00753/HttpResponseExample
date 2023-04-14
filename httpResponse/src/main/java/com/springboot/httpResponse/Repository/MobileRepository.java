package com.springboot.httpResponse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.httpResponse.Model.Mobiles;

public interface MobileRepository extends JpaRepository<Mobiles,Long> {
	
	
}
