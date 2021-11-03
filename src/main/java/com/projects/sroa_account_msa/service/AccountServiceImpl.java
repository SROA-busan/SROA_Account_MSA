package com.projects.sroa_account_msa.service;


import com.projects.sroa_account_msa.model.EmployeeInfo;
import com.projects.sroa_account_msa.model.UserInfo;
import com.projects.sroa_account_msa.repository.EmployeeInfoRepository;
import com.projects.sroa_account_msa.repository.EngineerInfoRepository;
import com.projects.sroa_account_msa.repository.ServiceCenterRepository;
import com.projects.sroa_account_msa.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    UserInfoRepository userInfoRepository;
    EngineerInfoRepository engineerInfoRepository;
    EmployeeInfoRepository employeeInfoRepository;
    ServiceCenterRepository serviceCenterRepository;

    @Autowired
    public AccountServiceImpl(UserInfoRepository userInfoRepository,
                              EngineerInfoRepository engineerInfoRepository,
                              EmployeeInfoRepository employeeInfoRepository,
                              ServiceCenterRepository serviceCenterRepository) {
        this.userInfoRepository = userInfoRepository;
        this.engineerInfoRepository = engineerInfoRepository;
        this.employeeInfoRepository = employeeInfoRepository;
        this.serviceCenterRepository = serviceCenterRepository;
    }

    @Override
    public boolean checkDuplicateEmp(Long empNum) {
        EmployeeInfo employeeInfo = employeeInfoRepository.findByEmpNum(empNum);
        if (employeeInfo == null) {
            System.out.println("엔지니어 회원가입 : 기업에 존재하지 않는 사원번호입니다.");
            return false;
        }
        if (engineerInfoRepository.findByEmployeeInfo(employeeInfo) != null) {
            System.out.println("엔지니어 회원가입 : 이미 가입된 사원번호입니다.");
            return false;
        }
        return true;
    }



    @Override
    public boolean isAvailableId(String Id) {
        // 아이디가 이미 존재
        if (userInfoRepository.existsById(Id)) {
            System.out.println("회원가입 : 이미 존재하는 아이디");
            return false;
        }
        return true;
    }

    @Override
    //고객의 회원가입
    public boolean createNewUser(UserInfo userInfo) {
        userInfo.setCode(0);
        userInfoRepository.save(userInfo);
        System.out.println("고객 회원가입 : 회원가입 성공");
        return true;
    }



    @Override
    //고객 로그인
    public Integer login(String Id, String PW) {
        UserInfo userInfo = userInfoRepository.findById(Id);

        if (userInfo == null) {
            System.out.println("로그인 : 존재하지않는 아이디");
            return 1;
        }

        if (PW.equals(userInfo.getPw())) {
            System.out.println("로그인 : 성공");
            // 엔지니어 최초 로그인
            if(userInfo.getCode()==2 && PW.equals("00000000")){
                return 3;
            }
            return 0;
        }
        System.out.println("로그인 : 비밀번호가 틀림");
        return 2;
    }
}
