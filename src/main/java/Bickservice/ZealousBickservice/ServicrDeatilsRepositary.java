package Bickservice.ZealousBickservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicrDeatilsRepositary extends JpaRepository<ServiceDetails, Integer>
{

public List<ServiceDetails> findAllByBikedetails1(BikeDetails bike);
	
	public List<ServiceDetails> findAllBybikeTypeofservice(String typeofservice);
	
	
	@Query(value = "select * from service_details where bike_dateofservice between :startDate and :endDate",nativeQuery = true)
	public List<ServiceDetails> findAllBybikeDateofservice(String startDate,String endDate);
	

	
}
