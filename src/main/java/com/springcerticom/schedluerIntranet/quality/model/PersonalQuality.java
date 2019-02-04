package com.springcerticom.schedluerIntranet.quality.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RAP_PERSONAL")
public class PersonalQuality {
	@Id
	private String cpersonal;
	
	private String apaterno;
	private String amaterno;
	private String anombres;
	private String adomicilio;
	private String isexo;
	private Date fnacimiento;
	private String ndocid;
	private Date fingresoemp;
	private String atelefono;
	private Date fcese;
	private String cestpers;
}
