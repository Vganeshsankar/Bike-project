package Bickservice.ZealousBickservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BikeDetailsService
{

	@Autowired
	BikeDetailsRepositary repo;
	
	public BikeDetails create(BikeDetails bike)
	{
		return repo.save(bike);
		
	}
	public List<BikeDetails> MakeFetchAll()
	{
		
		return repo.findAll();
	}
	public  Optional<BikeDetails> makefetchone(int id)
	{
		return repo.findById(id);
	}
	public String deletebyid(int id)
	{
		BikeDetails temp=repo.findById(id).orElse(new BikeDetails());
		repo.delete(temp);
		return temp.getCusName()+"has been deleted successfully";
				
	}
	public BikeDetails gettingexactone(int cusid)
	{
		return repo.findById(cusid).orElse(new BikeDetails());
	}
	
	public Optional<BikeDetails> exactbikeno(String number)
	{
		return repo.findAllByCusBikeno(number);
	}
	
	public Optional<BikeDetails> exactmailid(String emailid)
	{
		return repo.findAllByCusEmailid(emailid);
	}
}
