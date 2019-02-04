package com.springcerticom.schedluerIntranet.quality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;
import com.springcerticom.schedluerIntranet.quality.service.PersonalQualityService;

@RestController
@RequestMapping("/apiQuality")
public class PersonalQualityController {

	@Autowired
	private PersonalQualityService personalQualityService; 
	
	@GetMapping("/listPersonalAct")
	public ResponseEntity<List<PersonalQuality>> listPersonalAct(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalAct(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalDes")
	public ResponseEntity<List<PersonalQuality>> listPersonalDes(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalDes(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalActHoy")
	public ResponseEntity<List<PersonalQuality>> listPersonalActHoy(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalActHoy(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalDesHoy")
	public ResponseEntity<List<PersonalQuality>> listPersonalDesHoy(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalDesHoy(),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalActMes")
	public ResponseEntity<List<PersonalQuality>> listPersonalActMes(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalActMes(2018, 11),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalDesMes")
	public ResponseEntity<List<PersonalQuality>> listPersonalDesMes(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalDesMes(2018, 11),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalActAnio")
	public ResponseEntity<List<PersonalQuality>> listPersonalActAnio(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalActAnio(2018),HttpStatus.OK);
	}
	
	@GetMapping("/listPersonalDesAnio")
	public ResponseEntity<List<PersonalQuality>> listPersonalDesAnio(){
		return new ResponseEntity<List<PersonalQuality>>(personalQualityService.listPersonalDesAnio(2018),HttpStatus.OK);
	}
	
}
