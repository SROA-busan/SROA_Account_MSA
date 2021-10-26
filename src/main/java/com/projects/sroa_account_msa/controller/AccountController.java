package com.projects.sroa_account_msa.controller;


import com.projects.sroa_account_msa.model.UserInfo;
import com.projects.sroa_account_msa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // 사용 가능한 ID -> true, 사용 불가(중복된 아이디) -> false
    @GetMapping("account/duplicateCheck/{ID}")
    public boolean duplicateCheck(@PathVariable("ID") String id){
        return accountService.isAvailableId(id);
    }


    // 고객 회원가입
    @PostMapping("/account/customer/singup")
    public boolean userSignup(@RequestBody UserInfo userInfo) {
        return accountService.createNewUser(userInfo);
    }


    // 고객, 엔지니어 로그인
    @GetMapping("/account/login/{ID}/{PW}")
    public Integer login(@PathVariable("ID") String id, @PathVariable("PW") String pw) {
        System.out.println(id);
        System.out.println(pw);
        return accountService.login(id, pw);
    }

    //엔지니어 최초 로그인 후 정보 수정 요청
}
