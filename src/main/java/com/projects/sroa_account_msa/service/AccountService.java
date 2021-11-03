package com.projects.sroa_account_msa.service;


import com.projects.sroa_account_msa.model.UserInfo;


public interface AccountService {
    boolean createNewUser(UserInfo userInfo);

    Integer login(String Id, String PW);


    boolean isAvailableId(String id);

    void setPw(String id, String pw);
}
