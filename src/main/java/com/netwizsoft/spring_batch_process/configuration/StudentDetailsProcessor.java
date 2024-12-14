package com.netwizsoft.spring_batch_process.configuration;

import com.netwizsoft.spring_batch_process.domain.StudentDetails;
import org.springframework.batch.item.ItemProcessor;

public class StudentDetailsProcessor implements ItemProcessor<StudentDetails, StudentDetails> {

    @Override
    public StudentDetails process(StudentDetails studentDetails) throws Exception {
        return studentDetails;
    }
}
