package com.netwizsoft.spring_batch_process.repository;

import com.netwizsoft.spring_batch_process.domain.StudentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepository extends MongoRepository<StudentDetails, String> {
}
