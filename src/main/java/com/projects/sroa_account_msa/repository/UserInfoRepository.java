package com.projects.sroa_account_msa.repository;

import com.projects.sroa_account_msa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    boolean existsById(String userId);

    UserInfo findById(String id);

    @Transactional
    @Modifying
    @Query("UPDATE UserInfo SET pw=?2 WHERE id=?1")
    void updatePw(String id, String pw);
}
