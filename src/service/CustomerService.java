package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;


public class CustomerService {
	
	private static final CustomerService instance = new CustomerService(); // 객체를 만들어서 레퍼런스 값을 instance에 넣어준다 final이므로 고정값 
	
	private Map<String, Customer> customers; //key와 value를 가진다

	
	
	private CustomerService() { // 외부에서 객체를 만들지 못하게 private 
		customers = new HashMap<String, Customer> (); //customers에 register된 값들을 넣어줘야한다. 
		
		System.out.println("In CustomerService Constructor");
	}
	
	public static CustomerService getInstance() { // instance 값 리턴 -> 싱글턴패턴 
		return instance;
	}
	
	public void addCustomer(Customer customer) {
		
		customers.put(customer.getId(), customer);
		
	}
	public Customer findCustomer(String id) { //특정 id에 해당되는 사용자 조회 메소드
		
		if(id != null)
			return (customers.get(id.toLowerCase()));
		else 
			return null;
		
	}
	public Customer login(String id, String password) { //login 메소드 id와 password 비교 후 로그인 여부 확인 
		Customer customer = findCustomer(id);
	
		if(customer != null) {
			if( password.equals(customer.getPassword())  ) {
				System.out.println("login success");
				return customer;
			}
					
			else {
				System.out.println("login failed");
				return null;
			}
		}	
		return null;
	}
	
}
