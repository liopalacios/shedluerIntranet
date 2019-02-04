package com.springcerticom.schedluerIntranet.quality.service.impl;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;
import com.springcerticom.schedluerIntranet.quality.repository.PersonalQualityRepository;
import com.springcerticom.schedluerIntranet.quality.service.PersonalQualityService;

@Service
public class PersonalQualityServiceImpl implements PersonalQualityService{
	
	Calendar utilDate = Calendar.getInstance();
	
	private static String formato = "yyyy-MM-dd";
	
	SimpleDateFormat simpleDateFornat = new SimpleDateFormat(formato);
	
	@Autowired
	PersonalQualityRepository personalQualityRepository;
	
	@Override
	public List<PersonalQuality> listPersonalAct() {
		// TODO Auto-generated method stub
		System.out.println(simpleDateFornat.format(new Date()));
		return personalQualityRepository.findByCestpers("ACT");
	}

	@Override
	public List<PersonalQuality> listPersonalDes() {
		// TODO Auto-generated method stub
		return personalQualityRepository.findByCestpers("CES");
	}

	@Override
	public List<PersonalQuality> listPersonalActHoy() {
		// TODO Auto-generated method stub
		return personalQualityRepository.findByCestpersAndFingresoemp("ACT",new Date());
	}

	@Override
	public List<PersonalQuality> listPersonalDesHoy() {
		// TODO Auto-generated method stub
		
		return personalQualityRepository.findByCestpersAndFcese("CES",new Date());
	}

	@Override
	public List<PersonalQuality> listPersonalActMes(int anio, int mes) {
		// TODO Auto-generated method stub
		return personalQualityRepository.findByCestpersAndFingresoempYearAndFingresoempMonth("ACT",anio,mes);
	}

	@Override
	public List<PersonalQuality> listPersonalDesMes(int anio, int mes) {
		// TODO Auto-generated method stub
		return personalQualityRepository.findByCestpersAndFceseYearAndFingresoempMonth("CES",anio,mes);
	}

	@Override
	public List<PersonalQuality> listPersonalActAnio(int anio) {
		// TODO Auto-generated method stub
		return null;//personalQualityRepository.findByCestpersAndFingresoemp_Year("ACT",anio);
	}

	@Override
	public List<PersonalQuality> listPersonalDesAnio(int anio) {
		// TODO Auto-generated method stub
		return personalQualityRepository.findByCestpersAndFceseYear("CES",anio);
	}

}
