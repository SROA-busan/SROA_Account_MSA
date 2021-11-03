package com.projects.sroa_account_msa.repository;

import com.projects.sroa_account_msa.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {

}
