package com.springcerticom.schedluerIntranet.quality.service;

import java.util.List;

import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;

public interface PersonalQualityService {

	List<PersonalQuality> listPersonalAct();

	List<PersonalQuality> listPersonalDes();

	List<PersonalQuality> listPersonalActHoy();

	List<PersonalQuality> listPersonalDesHoy();
	
	List<PersonalQuality> listPersonalActMes(int anio, int mes);

	List<PersonalQuality> listPersonalDesMes(int anio, int mes);
	
	List<PersonalQuality> listPersonalActAnio(int anio);

	List<PersonalQuality> listPersonalDesAnio(int anio);

}
