package com.projects.sroa_account_msa.service;


import com.projects.sroa_account_msa.model.UserInfo;


public interface AccountService {
    boolean createNewUser(UserInfo userInfo);

    Integer login(String Id, String PW);

//    boolean createNewEngineer(UserInfo userInfo, String centerName, Long empNum);

    boolean checkDuplicateEmp(Long empNum);


    boolean isAvailableId(String id);

    UserInfo findUserByID(String id);

    void changePW(UserInfo user, String newPW);
}
