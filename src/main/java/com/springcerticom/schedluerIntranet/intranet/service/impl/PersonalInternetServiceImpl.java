package com.springcerticom.schedluerIntranet.intranet.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcerticom.schedluerIntranet.intranet.model.Personal;
import com.springcerticom.schedluerIntranet.intranet.repository.PersonalRepository;
import com.springcerticom.schedluerIntranet.intranet.service.PersonalIntranetService;
import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;

@Service
public class PersonalInternetServiceImpl implements PersonalIntranetService {

	@Autowired
	PersonalRepository personalRepository;
	
	@Override
	public List<Personal> listPersonalAct() {
		// TODO Auto-generated method stub
		return personalRepository.findByEstado(1);
	}
	
	@Override
	public List<Personal> listPersonalDes() {
		// TODO Auto-generated method stub
		return personalRepository.findByEstado(0);
	}

	@Override
	public List<Personal> listPersonalActHoy() {
		// TODO Auto-generated method stub
		return personalRepository.findByEstadoAndFingreso(1,new Date());
	}

	@Override
	public List<Personal> listPersonalDesHoy() {
		// TODO Auto-generated method stub
		return personalRepository.findByEstadoAndFcese(0,new Date());
	}

	@Override
	public void changeDes(PersonalQuality personalQuality) {
		// TODO Auto-generated method stub
		Personal personal = personalRepository.findByEstadoAndDni(1,personalQuality.getNdocid());
		if(personal != null) {
			personal.setEstado(0);
			personal.setFcese(personalQuality.getFcese());
			personal.setIdserverlogin("");
			personalRepository.save(personal);
			System.out.println("eliminado "+personal.getApaterno());
		}
		
		
	}

}
