package com.alfar.demo.customerService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alfar.demo.customerModel.APIResponse;
import com.alfar.demo.customerModel.AccessToken;
import com.alfar.demo.customerModel.Booking;
import com.alfar.demo.customerModel.Customer;
import com.alfar.demo.customerModel.Role;
import com.alfar.demo.customerModel.Telephone;
import com.alfar.demo.customerRepository.RoleRepository;
import com.alfar.demo.customerRepository.customerRepository;

@Service
public class customerServiceImpl implements customerService {

	@Autowired
	customerRepository customerepository;

	@Autowired
	RoleRepository RoleRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${authserver.clientid}")
	private String clientID;
	
	@Value("${authserver.clintsecret}")
	private String clientSecret;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	
	
	@Bean
	public BCryptPasswordEncoder getbCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	public Customer addCustomer(Customer customer) {

		
		

		Customer addCustomer = new Customer();

		Role userRole = RoleRepo.findByName("ROLE_operator");

		addCustomer.setUsername(customer.getUsername());
		addCustomer.setAge(customer.getAge());
		addCustomer.setGender(customer.getGender());
		addCustomer.setEmail(customer.getEmail());
		addCustomer.setAddress(customer.getAddress());
		addCustomer.setTelephone(customer.getTelephone());
		addCustomer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));

		List<Role> roleList = new ArrayList<>();
		roleList.add(userRole);

		addCustomer.setEnabled(Boolean.TRUE);
		addCustomer.setAccountNonExpired(Boolean.TRUE);
		addCustomer.setCredentialsNonExpired(Boolean.TRUE);
		addCustomer.setAccountNonLocked(Boolean.TRUE);
		addCustomer.setRoles(roleList);
		
		 for(Telephone tp : addCustomer.getTelephone()) {
			  
			  tp.setCustomer(addCustomer); }
			 

		return customerepository.save(addCustomer);
	}

	@Override
	public APIResponse cutomerLogin(String username, String password) {
		Customer customer = customerepository.findByUsername(username);

		if (customer != null) {
			System.err.println("1");
			if (bCryptPasswordEncoder.matches(password, customer.getPassword())) {
				// Call and get Access Token
				//String authServerURL = "http://localhost:8282/oauth/token";
				String authServerURL = "http://oauth/oauth/token";
				String clientCredentials = clientID + ":" + clientSecret;
				String authBasicHeaderClient = "Basic "
						+ Base64.getEncoder().encodeToString(clientCredentials.getBytes());

				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.set(HttpHeaders.AUTHORIZATION, authBasicHeaderClient);
				httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

				MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
				multiValueMap.add("username", username);
				multiValueMap.add("password", password);
				multiValueMap.add("grant_type", "password");

				HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(multiValueMap, httpHeaders);

				//System.err.println("GoURL");
				ResponseEntity<AccessToken> responseEntity = restTemplate.exchange(authServerURL, HttpMethod.POST,
						httpEntity, AccessToken.class);
				
				//System.err.println("3");
				System.err.println(responseEntity);

				return new APIResponse(200, " Login Successful!", responseEntity.getBody());
			}
			//System.err.println("2");
		}
		return new APIResponse(401, "Login Failed!", new AccessToken());
	}

	@Override
	public Customer getCustomer(String customer) {
		
		return customerepository.findByUsername(customer);
	}

	@Override
	public String insertBooking(Booking booking) {
	
		HttpHeaders headers = new HttpHeaders();
	     
	      HttpEntity <Booking> entity = new HttpEntity<Booking>(booking,headers);
		
		return restTemplate.exchange("http://booking/Booking/insertBooking",HttpMethod.POST,entity,String.class).getBody();
	
		
		
		//return restTemplate.getForObject("http://booking/Booking/insertBooking",String.class);
	
	}

	@Override
	public Customer updateCustomer(Customer user, int id) {
		
		Optional<Customer> updateCustomer = customerepository.findById(id);
		
		if(updateCustomer.isPresent()) {
			
			user.setEnabled(Boolean.TRUE);
			user.setAccountNonExpired(Boolean.TRUE);
			user.setCredentialsNonExpired(Boolean.TRUE);
			user.setAccountNonLocked(Boolean.TRUE);
			
			return customerepository.save(user);
		}
		
		
		return null;
		
		
	   
		
	}

	@Override
	public List<Customer> findAllUsers() {
		
		return customerepository.findAll();
	}




	@Override
	public Booking[] findAllBookingByID(Integer customerid) {
		
	Optional<Customer> customer = customerepository.findById(customerid);
	
	if(customer.isPresent()) {
		
		
		return restTemplate.getForObject("http://Booking/Booking/findAllById/"+customerid, Booking[].class);
		
		
	}
	
	else {
		return null;
	}
		
		
	}




	@Override
	public Booking findLastRecord(Integer customerid) {
		
		Optional<Customer> customer = customerepository.findById(customerid);
		
		if(customer.isPresent()) {
			
		return	restTemplate.getForObject("http://Booking/Booking/findLastRecord/"+customerid, Booking.class);
		}
		
		else {
			
		return null;	
		}
		
		
	}

	
	
	
	
	
	
	
	
}