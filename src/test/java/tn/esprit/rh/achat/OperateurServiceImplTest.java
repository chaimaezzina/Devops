package tn.esprit.rh.achat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
	
	@Autowired
	IOperateurService operateurService;
	
	@Mock
	OperateurRepository operateurRepository;
	
	@Test
	@Order(0)
	public void testAddOperateur() {
		List<Operateur> ops = operateurService.retrieveAllOperateurs();
		int expected=ops.size();
		Operateur o = new Operateur();
		o.setNom("test");
		o.setPrenom("tesssssst");
		o.setPassword("123456");
		o.setFactures(null);
	    Operateur savedOp= operateurService.addOperateur(o);
		assertEquals(expected+1, operateurService.retrieveAllOperateurs().size());
		assertNotNull(savedOp.getIdOperateur());
		operateurService.deleteOperateur(savedOp.getIdOperateur());
		}

	Operateur o = Operateur.builder().nom("mock1").prenom("mockitou").password("passmock").factures(null).build();
	
	
	@Test 
	public void saveOperateurTest() {
		when(operateurRepository.findAll()).thenReturn(Stream
				.of(new Operateur((long)12,"mock","mocks","123000",null),new Operateur((long)15,"mock1","mocks1","123001",null)).collect(Collectors.toList()));
				
	}

	@Test
	public void deleteOperateurTest() {
		Operateur operateur = new Operateur((long)12,"mock","mocks","123000",null);
		operateurService.deleteOperateur(operateur.getIdOperateur());
		verify(operateurRepository, times(1)).delete(operateur);
	}	






}
