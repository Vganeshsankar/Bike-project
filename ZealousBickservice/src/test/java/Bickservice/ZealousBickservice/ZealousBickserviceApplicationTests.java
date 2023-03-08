package Bickservice.ZealousBickservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

class ZealousBickserviceApplicationTests 
{

	@MockBean
	BikeDetailsRepositary jpa;
	@Autowired
	BikeDetailsService service;
	
	@Test
	public void testcase1()
	{
		Date date= new Date(2022,10,10);
		BikeDetails bike1=new BikeDetails(1,"Tn34V5656", "Manojkumar", 9789355930L, "Manojgeetha12@gmail.com", date, null);
		
		when(jpa.findAll()).thenReturn(Stream.of(bike1).collect(Collectors.toList()));
		assertNotNull(service.MakeFetchAll());
		assertSame(date, service.MakeFetchAll().get(0).getCusDateofpurchase());
		
	}
	
	@Test
	public void testtread()
	{
		
		Date date = new Date(2020,10,10);
		Optional<BikeDetails> bike1=Optional.of(new BikeDetails(1,"Tn34V5656", "Manojkumar", 9789355930L, "Manojgeetha12@gmail.com", date, null));
	    
		Optional<BikeDetails> bike2=Optional.of(new BikeDetails(2,"Tn34V5656", "Manojkumar", 9789355930L, "Manojgeetha12@gmail.com", date, null));
		
		when(jpa.findById(1)).thenReturn(bike1);
		when(jpa.findById(2)).thenReturn(bike2);

		assertSame(bike2, service.makefetchone(2));
		assertEquals(bike1, service.makefetchone(1));

	
	
	}

	
	

	
	
	@Test
	void contextLoads() {
	}

}
