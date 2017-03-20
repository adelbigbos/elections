package elections.dao.junit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.AssertDelegateTarget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import elections.dao.config.Config;
import elections.dao.entities.ElectionsException;
import elections.dao.entities.ListeElectorale;
import elections.dao.service.ElectionsDaoFile;
import elections.dao.service.IElectionsDao;
import junit.framework.TestCase;



//@Sprin
//@SpringApplicationConfuguration (classes = {Config.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class, loader=AnnotationConfigContextLoader.class)
public class JUnitTestsElectionsDaoFile extends TestCase {
	
	
	/**
	 * instance d'accès à la couche [dao]
	 */
	
	@Autowired	
	private IElectionsDao electionsDaoFile;

	@Test
	public void testElectionsDaoFile() {
		
		assertEquals("elections-in-good.txt", electionsDaoFile.getInFileName());
		
				
	}
	
	@Test
	public void testLectureDataElections() {
		//vérifier le nombre de siège
		assertTrue(electionsDaoFile.getNbSiegesAPourvoir() != 0);
		System.out.println("Nombre de siège à pouvoir: "+electionsDaoFile.getNbSiegesAPourvoir());
		//vérifier seuil electorale
		assertTrue(electionsDaoFile.getNbSiegesAPourvoir() != 0);
		System.out.println("Seuil électorale: "+electionsDaoFile.getSeuilElectoral());
		//vérifier les liste electorales
		assertTrue(electionsDaoFile.getListesElectorales().size() > 0);
		for (int i = 0; i < electionsDaoFile.getListesElectorales().size(); i++) {
			System.out.println(electionsDaoFile.getListesElectorales().get(i).toString());
		}	
		
	}

	@Test
	public void testEcritureResultatsElections(){
		List<ListeElectorale> electionElectorales = new ArrayList<ListeElectorale>();
		
		ListeElectorale listElectorale1 = new ListeElectorale();
		listElectorale1.setId(1);
		listElectorale1.setNom("A");
		listElectorale1.setSieges(23);
		listElectorale1.setVoix(3987);
		listElectorale1.setElimine(false);
		
		ListeElectorale listElectorale2 = new ListeElectorale();
		listElectorale2.setId(2);
		listElectorale2.setNom("B");
		listElectorale2.setSieges(11);
		listElectorale2.setVoix(1987);
		listElectorale2.setElimine(false);
		
		ListeElectorale listElectorale3 = new ListeElectorale();
		listElectorale3.setId(3);
		listElectorale3.setNom("C");
		listElectorale3.setSieges(0);
		listElectorale3.setVoix(32);
		listElectorale3.setElimine(true);
		
		electionElectorales.add(listElectorale1);
		electionElectorales.add(listElectorale2);
		electionElectorales.add(listElectorale3);
		
		electionsDaoFile.setListesElectorales(electionElectorales);
		
		assertTrue(electionElectorales.equals(electionsDaoFile.getListesElectorales()));
	}
	}


