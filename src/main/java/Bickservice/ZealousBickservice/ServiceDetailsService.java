package Bickservice.ZealousBickservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailsService 
{

	@Autowired
	ServicrDeatilsRepositary srepo;
	
	public ServiceDetails newservice (ServiceDetails service)
	{
		return srepo.save(service);
	}
	
	public List<ServiceDetails> Exactcusidwithservicedetails (BikeDetails bick)
	{
		
		return srepo.findAllByBikedetails1(bick);
	}
	
	public Optional<ServiceDetails> Exactoneservice(int jobcard)
	{
		
		return srepo.findById(jobcard);
	}
	
	public List<ServiceDetails> Exacttypeofservice(String typeofservice)
	{
		return srepo.findAllBybikeTypeofservice(typeofservice);
	}

	public List<ServiceDetails> betweendates(String d1,String d2)
	{
		return srepo.findAllBybikeDateofservice(d1, d2);
	}

}
