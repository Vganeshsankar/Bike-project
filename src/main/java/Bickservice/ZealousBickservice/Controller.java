package Bickservice.ZealousBickservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybikeproject")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller
{

	@Autowired
	
	BikeDetailsService service;
	
	@Autowired
	ServiceDetailsService sservice;
	
	@PostMapping("/createbikedetails")
	public String newbikedetails (@RequestBody BikeDetails bike)
	{
		return service.create(bike).getCusName()+"has been added successfully";
	}
	
	@PutMapping("/updatebikedetails")
	public String updatebike(@RequestBody BikeDetails bike)
	{
		BikeDetails temp=service.create(bike);
		return temp.getCusName()+"has been updated successfully";
	}
	
	@GetMapping("/exactbikenumber/{bikeno}")
	public Optional<BikeDetails> findbikeno(@PathVariable("bikeno")String bikeno)
	{
		return service.exactbikeno(bikeno);
	}
	
	@GetMapping("/listallbikedetails")
	public List<BikeDetails>  listallbikedetails()
	{
		return service.MakeFetchAll();
	}
	@GetMapping("/")
	public String smaple()
	{
		return "welcome everyone";
	}

	@GetMapping("/listonebikedetail/{id}")
	public Optional<BikeDetails> readonebikedetail(@PathVariable("id")int id)
	{
		return service.makefetchone(id);
	}
	@DeleteMapping("/deletebybikedetails/{id}")
	public String deleteabikedetail(@PathVariable("id")int id)
	{
		return service.deletebyid(id);
		
	}
	
	@PostMapping("/createnewservice")
	public String newservicedetails(@RequestBody ServiceDetails serv)
	{
		BikeDetails temp=service.gettingexactone(serv.getBikedetails1().getCusId());

		if(serv.getBikeTypeofservice()=="free")
		{
			int total=serv.getBikeNewproductcost()+(serv.getBikeNewproductcost()*18/100);
			serv.setBikeFinalamount(total);
		}
		else
		{
			int total=serv.getBikeNewproductcost()+serv.getBikeLabourcharge();//2500+900=3400
			total+=total*18/100;//3400+=(3400*18/100)
			serv.setBikeFinalamount(total);
		}
		temp.getMyservicedetails().add(serv);
		serv.setBikedetails1(temp);
		sservice.newservice(serv);
		return serv.getBikeJobcardno()+"has been service details is added";
	}
	
	@PutMapping("/updatesevicedetails")
	public String updatesevice(@RequestBody ServiceDetails serv)
	{
//		ServiceDetails temp=sservice.newservice(serv);
		
		if(serv.getBikeTypeofservice()=="free")
		{
			int total=serv.getBikeNewproductcost()+(serv.getBikeNewproductcost()*18/100);
			serv.setBikeFinalamount(total);
		}
		else
		{
			int total=serv.getBikeNewproductcost()+serv.getBikeLabourcharge();//2500+900=3400
			total+=total*18/100;//3400+=(3400*18/100)
			serv.setBikeFinalamount(total);
		}
		serv.getBikedetails1().getMyservicedetails().add(serv);
		ServiceDetails temp=sservice.newservice(serv);
		return temp.getBikeJobcardno()+"has been updated successfully";
	}
	
	@GetMapping("/exactcusidwithservicedetails/{cusid}")
	public List<ServiceDetails> gettingparticularall(@PathVariable("cusid")int cusid)
	{
		BikeDetails temp=service.gettingexactone(cusid);
		return sservice.Exactcusidwithservicedetails(temp);
	}
	
	@GetMapping("/exactoneservice/{jobcardno}")
	public Optional<ServiceDetails> findoneservice(@PathVariable("jobcardno")int jobcardno)
	{
		return sservice.Exactoneservice(jobcardno);
	}
	
	
	@GetMapping("/exacttypeofservice/{typeofservice}")
	public List<ServiceDetails> findtypeofservice(@PathVariable("typeofservice")String typeofservice)
	{
		return sservice.Exacttypeofservice(typeofservice);

	}
	@GetMapping("/betweendates/{date1}/{date2}")
	public List<ServiceDetails> Implementdates(@PathVariable("date1")String date1,@PathVariable("date2")String date2)
	{
		return sservice.betweendates(date1, date2);
	}


	@GetMapping("/exactmailid/{emailid}")
	public Optional<BikeDetails> findmailid(@PathVariable("emailid")String emailid)
	{
		return service.exactmailid(emailid);
	}
	
	
}	
