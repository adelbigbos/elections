package elections.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import elections.dao.service.IElectionsDao;
import elections.dao.service.ElectionsDaoFile;

@Configuration
public class Config {
	
	@Bean
	public IElectionsDao electionDao(){
		return new ElectionsDaoFile("elections-in-good.txt", "elections-out.txt", "elections-log.txt" );
	
		
	}
	

}
