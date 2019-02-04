package com.springcerticom.schedluerIntranet.intranet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springcerticom.schedluerIntranet.intranet.model.Personal;


public interface PersonalRepository extends JpaRepository<Personal, Long> {

	List<Personal> findByEstado(int i);

	List<Personal> findByEstadoAndFingreso(int i, Date date);

	List<Personal> findByEstadoAndFcese(int i, Date date);

	Personal findByEstadoAndDni(int i, String ndocid);

	
}
