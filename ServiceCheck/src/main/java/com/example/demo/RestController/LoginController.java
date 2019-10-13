package com.example.demo.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.userDetailsModel.LoginClass;
import com.example.demo.userDetailsModel.User;

@RestController
public class LoginController {
	// @Autowired
	// private User user;

	@PostMapping("/user")
	public LoginClass UserCheck(@RequestBody User user) {
		System.out.println("bal" + user.toString());
		LoginClass lc = new LoginClass();
		String filename="C:\\Users\\guddu\\STS WorkSpace\\ServiceCheck\\src\\data.txt";
		File file=new File(filename);
		try {
			Scanner inputstream=new Scanner(file);
			while(inputstream.hasNext()) {
				String[] data= inputstream.next().split(",");
				//System.out.println(data[0]+"key");
				//System.out.println(data[1]+"value");
				if(User.hashmap.get(data[0])==null) {
					User.hashmap.put(data[0], data[1]);
				}
				//for(String name: User.hashmap.keySet())
					//System.out.println("key"+name);
				//for(String values: User.hashmap.keySet())
					//System.out.println("value"+values);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if (user != null) {
			lc.setLogin(User.hashmap.get(user.getUid())!=null && User.hashmap.get(user.getUid()).equals(user.getPassword()));
			;
		}

		return lc;
	}

	@PostMapping("/register")
	public LoginClass register(@RequestBody User user) {
		System.out.println("bal" + user.toString());
		LoginClass lc = new LoginClass();
		if (user != null && User.hashmap.get(user.getUid()) == null) {
			User.hashmap.put(user.getUid(), user.getPassword());
			lc.setLogin(true);
		}

		return lc;
	}
}
