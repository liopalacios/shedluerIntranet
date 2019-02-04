package com.springcerticom.schedluerIntranet.intranet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcerticom.schedluerIntranet.intranet.model.Personal;
import com.springcerticom.schedluerIntranet.intranet.service.PersonalIntranetService;

@RestController
@RequestMapping("/api")
public class PersonalIntranetController {
	
	@Autowired
	private PersonalIntranetService personalIntranetService; 
	
	@GetMapping("/listPersonnalAct")
	public ResponseEntity<List<Personal>> listPersonalAct(){
		return new ResponseEntity<List<Personal>>(personalIntranetService.listPersonalAct(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonnalDes")
	public ResponseEntity<List<Personal>> listPersonalDes(){
		return new ResponseEntity<List<Personal>>(personalIntranetService.listPersonalDes(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonnalActHoy")
	public ResponseEntity<List<Personal>> listPersonalActHoy(){
		return new ResponseEntity<List<Personal>>(personalIntranetService.listPersonalActHoy(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonnalDesHoy")
	public ResponseEntity<List<Personal>> listPersonalDesHoy(){
		return new ResponseEntity<List<Personal>>(personalIntranetService.listPersonalDesHoy(),HttpStatus.OK);
	}
	
	
	
}
