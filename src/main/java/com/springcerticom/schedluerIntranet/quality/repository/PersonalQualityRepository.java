package com.springcerticom.schedluerIntranet.quality.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;

@Repository
public interface PersonalQualityRepository extends JpaRepository<PersonalQuality, String> {

	List<PersonalQuality> findByCestpers(String string);

	List<PersonalQuality> findByCestpersAndFcese(String string, Date date);

	List<PersonalQuality> findByCestpersAndFingresoemp(String string, Date date);

	@Query("SELECT p FROM PersonalQuality p where p.cestpers = :estado and YEAR(p.fingresoemp) = :anio and MONTH(p.fingresoemp) = :mes ")
	List<PersonalQuality> findByCestpersAndFingresoempYearAndFingresoempMonth(@Param("estado") String estado, @Param("anio") int anio, @Param("mes") int mes);

	@Query("SELECT p FROM PersonalQuality p where p.cestpers = :estado and YEAR(p.fcese) = :anio and MONTH(p.fcese) = :mes ")
	List<PersonalQuality> findByCestpersAndFceseYearAndFingresoempMonth(@Param("estado") String estado, @Param("anio") int anio, @Param("mes") int mes);

	@Query("SELECT p FROM PersonalQuality p where p.cestpers = :estado and YEAR(p.fcese) = :anio ")
	List<PersonalQuality> findByCestpersAndFceseYear(@Param("estado") String estado, @Param("anio") int anio);
	
}
