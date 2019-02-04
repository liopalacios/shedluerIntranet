package com.springcerticom.schedluerIntranet;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springcerticom.schedluerIntranet.intranet.service.PersonalIntranetService;
import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;
import com.springcerticom.schedluerIntranet.quality.service.PersonalQualityService;

@Component
public class taskQuality {
	@Autowired
	private PersonalQualityService personalQualityService;

	@Autowired
	private PersonalIntranetService personalIntranetService;
	
	@Scheduled(fixedRate=20000)
	public void task() {
		//List<PersonalQuality> personalQualities = personalQualityService.listPersonalDesMes(2018, 11);
		List<PersonalQuality> personalQualitiesAnio = personalQualityService.listPersonalDesAnio(2018);
		actualizarPersonalDes(personalQualitiesAnio);
		
		//System.out.println("-*-*-*-*-*-* SHEDULE *-*-*-*-*-*-*-*" + new Date());
	}

	private void actualizarPersonalDes(List<PersonalQuality> personalQualities) {
		// TODO Auto-generated method stub
		personalQualities.forEach(personalQuality -> {
			personalIntranetService.changeDes(personalQuality);
		});
	}
}
