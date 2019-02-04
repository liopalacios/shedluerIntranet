package com.springcerticom.schedluerIntranet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcerticom.schedluerIntranet.intranet.model.Personal;
import com.springcerticom.schedluerIntranet.intranet.repository.PersonalRepository;
import com.springcerticom.schedluerIntranet.quality.model.PersonalQuality;
import com.springcerticom.schedluerIntranet.quality.repository.PersonalQualityRepository;


@SpringBootApplication
@EnableScheduling
public class SchedluerIntranetApplication {
	/*@Component
	class Runner implements CommandLineRunner {
		private final DataSource dataSource;

		Runner(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		@Override
		public void run(String... args) throws Exception {
			Connection con = dataSource.getConnection();
			ResultSet rs = con.createStatement().executeQuery("SELECT CURRENT_TIMESTAMP");
			rs.next();
			System.out.println("TS: "+rs.getString(1));
		}
	}*/
	
	
	/*@PostConstruct
	public void addData2DB() {
		personalRepository.saveAll(Stream.of(new Personal()).collect(Collectors.toList()));
		personalQualityRepository.saveAll(Stream.of(new PersonalQuality()).collect(Collectors.toList()));
	}
	*/
	
	/*
	 * @Autowired
	private PersonalRepository personalRepository;
	
	@Autowired
	private PersonalQualityRepository personalQualityRepository;
	
	@GetMapping("/getPersonal")
	public List<Personal> getPersonal(){
		System.out.println("lista personal Intranet");
		return personalRepository.findAll();
	}
	
	@GetMapping("/getPerosnalQuality")
	public List<PersonalQuality> getPersonalQuality(){
		System.out.println("lista personal quality");
		return personalQualityRepository.findAll();
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(SchedluerIntranetApplication.class, args);
	}

}

