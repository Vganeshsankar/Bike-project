package Bickservice.ZealousBickservice;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeDetailsRepositary  extends JpaRepository<BikeDetails, Integer>
{

	public Optional<BikeDetails> findAllByCusBikeno(String number);
	
	public Optional<BikeDetails> findAllByCusEmailid(String emailid);
	
} 