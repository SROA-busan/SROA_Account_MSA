package com.projects.sroa_account_msa.repository;

import com.projects.sroa_account_msa.model.EmployeeInfo;
import com.projects.sroa_account_msa.model.EngineerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerInfoRepository extends JpaRepository<EngineerInfo, Long> {


    EngineerInfo findByEmployeeInfo(EmployeeInfo employeeInfo);
}
