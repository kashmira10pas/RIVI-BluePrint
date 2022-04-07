package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserstoryRepository extends CrudRepository<Userstory, Long>{
	
	void deleteById(Long id);

}
