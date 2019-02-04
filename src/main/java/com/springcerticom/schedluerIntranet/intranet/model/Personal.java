package com.springcerticom.schedluerIntranet.intranet.model;
import java.sql.Date;

import javax.persistence.Column;
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
@Table(name="personal")
public class Personal {
	@Id
	private int idpersonal;
	@Column(name="ape_pat")
	private String apaterno;
	@Column(name="ape_mat")
	private String amaterno;
	private String nombre;
	private String dni;
	private String telefono;
	private String email;
	private String direccion;
	private int estado;
	@Column(name="fec_ingreso")
	private Date fingreso;
	private Date fcese;
	private String idserverlogin;
}
