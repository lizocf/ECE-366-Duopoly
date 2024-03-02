package com.baddest.swe.duopoly;

import com.baddest.swe.duopoly.jdbc_util.*;
import com.baddest.swe.duopoly.account_util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;




@SpringBootApplication
@RestController
public class DuopolyApplication {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		System.out.println("HELLO WORLD");
		return "Hello World";
	}

	@GetMapping("/getUserName/{userName}")
	public String getUserName(@PathVariable("userName") String userName) {
		System.out.println(userName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
                "duopoly", "postgres", "password");
        AccountUtil account1 = new AccountUtil();
		try {
            Connection connection = dcm.getConnection();
            AccountDAO accountDAO = new AccountDAO(connection);
            account1.setUserName(userName);
            account1 = accountDAO.findById(account1);
            System.out.println(account1);
        }
        catch(SQLException e) {
            e.printStackTrace();
		}
		return account1;
	}


	public static void main(String[] args) {
		SpringApplication.run(DuopolyApplication.class, args);
	}

}
