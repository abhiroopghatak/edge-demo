/**
 * 
 */
package com.abhiroop.emartviewapptest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.abhiroop.emartviewapp.controller.CustomerController;
import com.abhiroop.emartviewapp.model.Customer;

/**
 * @author abhiroop.g
 *
 */
@RunWith(MockitoJUnitRunner.class)
class EmartViewAppTest {

	@Mock
	private CustomerController cc;
	
	@InjectMocks
	private RestTemplate rt;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
		Customer c = new Customer("Eric Simmons", "erics@me.com");
		c.setId(1);
		Mockito.when(rt.getForObject(cc.getEmartUserServiceUrl() + "getUser/1", Customer.class)).thenReturn(c);

		Customer cust = cc.getCustomerById(1);

		assertEquals(c, cust);
	}

	@Test
	public void testCustomerController() {
		CustomerController cc = new CustomerController();
		String result = cc.heartbeat();
		assertEquals(result, "CustomerController is Ready to server Request");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

}
