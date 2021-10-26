package com.projects.sroa_account_msa.repository;

import com.projects.sroa_account_msa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    boolean existsById(String userId);

    UserInfo findByuserNum(Long userNum);

    UserInfo findById(String id);

}
