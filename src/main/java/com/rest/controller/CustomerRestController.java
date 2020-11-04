package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;

//RestController = Controller + ResponseBody
@RestController
public class CustomerRestController {

	@Autowired // 타입이 동일한 객체 주입
	CustomerService service; // 여기선 CustomerServiceImpl 이 주입이 됨

	// 현재는 view가 없이 json 자체를 뿌림
	// Get: http://localhost:8080/rest/customers
	@GetMapping(value = "/customers")
	public List<Customer> selectAll() {
		return service.selectAll();
	}

	@GetMapping(value = "/customers/{num}")
	public Customer selectOne(@PathVariable String num) {
		return service.selectOne(num);
	}

	// Post: .../rest/customers/
	// 클라이언트가 보내는 데이터(json) -> java
	// RequestBody: 요청이 들어오는 json 데이터를 java로 변환시켜주는 annotation
	// json이 java 스타일로 만든 객체에 담겨서 들어감
	// 만약에 java 스타일로 만든 객체에 해당하는 attribute가 없으면 그 값은 null이 들어가고
	// 나머지 값만 할당되어서 객체가 생성됨;
	@PostMapping(value = "/customers")
	public Map<String, String> insert(@RequestBody Customer c) {
		System.out.println(c);
		service.insert(c);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "삽입성공");
		return map;
	}
	@PutMapping(value = "/customers/{num}")
	public Map<String, String> update(Customer c) {
		service.update(c);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "업데이트성공");
		return map;
	}
	@DeleteMapping(value = "/customers/{num}")
	public Map<String, String> delete(@PathVariable String num) {
		service.delete(num);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "삭제성공");
		return map;
	}

}
