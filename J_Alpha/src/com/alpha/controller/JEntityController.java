package com.alpha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.db.JEntity;
import com.alpha.service.JEntityService;

@RestController
public class JEntityController {

	@Autowired
	JEntityService jEntityService;
	
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
		System.out.println("weelcome");
        return "Welcome to RestTemplate Example.";
    }
	
	@RequestMapping(value="/jentity",method=RequestMethod.GET)
	public List<JEntity> getAll(){
		System.out.println("JEntity Controller getAll");
		return jEntityService.getAll();
	}
	@RequestMapping(value="/jentity/{id}",method=RequestMethod.GET)
	public List<JEntity> getEntity(@PathVariable("id")long id){
		System.out.println("JEntity Controller getEntity");
		return jEntityService.getEntity(id);
	}
	
}
