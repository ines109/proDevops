package tn.esprit.spring.entreprise;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;


@SpringBootTest
public class EntrepriseServiceImplTest {
private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	
	@Autowired
	IEntrepriseService es;
	@Autowired
	EntrepriseRepository er;
	@Autowired
	DepartementRepository deptRepoistory;
	

	
	
	@Test
 	public void testAjouterEntreprise() {
		try {
			Entreprise e = new Entreprise("1", "esprit");
			int id = es.ajouterEntreprise(e);
			assertNotNull(id);
			l.info("End add Entreprise test method");
			
		}
		catch(NullPointerException npe) {
			l.error("erreur d'ajout entreprise"+ npe);
		}
		
	}
	
	@Test
	public void testAjouterDepartement() {
	
		try {
			Departement d = new Departement("Info");
			 deptRepoistory.save(d);
			 int id =d.getId();
			assertNotNull(id);
			l.info("End add Department test method");
			} catch (NullPointerException npe) {
				l.error("erreur d'ajout departement "+ npe);
			}
		}
	@Test()
	public void testGetEntrepriseById() {
		try {

		Entreprise getEntreprise = es.getEntrepriseById(1);
		assertEquals(1, getEntreprise.getId());
		l.info("End get Entreprise test method");
			}
		 catch (NullPointerException npe) {
				l.error("error get entreprise "+ npe);
			}
		}


           @Test
	   public void testgetAllDepartementsNamesByEntreprise(){
                  try {
		List<String> names= es.getAllDepartementsNamesByEntreprise(1);
		assertEquals(1, names.size());
           l.info("End getAllDepartementsNamesByEntreprise test method");
                       }
           catch (NullPointerException npe) {
				l.error("error get AllDepartementsNamesByEntreprise"+ npe);
			}
	 }
  
       
         @Test
         public void testDeleteDepartementById() {
                 try {
		es.deleteDepartementById(1);
                l.info("End DeleteDepartementById test method");
                      }
                  catch (NullPointerException npe) {
				l.error("error delete dep"+ npe);
			}
	         }
		

}
