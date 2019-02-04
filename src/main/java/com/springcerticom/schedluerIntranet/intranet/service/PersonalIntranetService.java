package com.springcerticom.schedluerIntranet.intranet.service;

import java.util.List;

import com.springcerticom.schedluerIntranet.intranet.model.Personal;
import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;

public interface PersonalIntranetService {
	
	List<Personal> listPersonalAct();

	List<Personal> listPersonalDes();

	List<Personal> listPersonalActHoy();

	List<Personal> listPersonalDesHoy();

	void changeDes(PersonalQuality personalQuality);
}
