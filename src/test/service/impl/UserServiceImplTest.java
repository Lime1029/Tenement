package test.service.impl; 

import com.opensymphony.xwork2.ActionContext;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>ÆßÔÂ 8, 2019</pre> 
* @version 1.0 
*/ 
public class UserServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUserDao() 
* 
*/ 
@Test
public void testGetUserDao() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setUserDao(UserDao userDAO) 
* 
*/ 
@Test
public void testSetUserDao() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUserByTel(String telephone) 
* 
*/ 
@Test
public void testGetUserByTel() throws Exception {
//TODO: Test goes here...
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

    UserService loginService = (UserService) ctx.getBean("userService");

    loginService.getUserByTel("13697237196");
} 

/** 
* 
* Method: getAgentByTel(String telephone) 
* 
*/ 
@Test
public void testGetAgentByTel() throws Exception { 
//TODO: Test goes here...
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    UserService agent = (UserService)ctx.getBean("userService");
    agent.getAgentByTel("18810339310");
} 

/** 
* 
* Method: getAdminByTel(String telephone) 
* 
*/ 
@Test
public void testGetAdminByTel() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchMyHouse(int userId) 
* 
*/ 
@Test
public void testSearchMyHouse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchMyRentalHouse(int userId) 
* 
*/ 
@Test
public void testSearchMyRentalHouse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMyContract(int houseId) 
* 
*/ 
@Test
public void testGetMyContract() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getContractAsTenant(int houseId, int userId) 
* 
*/ 
@Test
public void testGetContractAsTenant() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMyOutstandingOrders(int userId) 
* 
*/ 
@Test
public void testGetMyOutstandingOrders() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMyPrepaidOrders(int userId) 
* 
*/ 
@Test
public void testGetMyPrepaidOrders() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: modifyOrderStatus(int orderId) 
* 
*/ 
@Test
public void testModifyOrderStatus() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findUserByUserID(int userID) 
* 
*/ 
@Test
public void testFindUserByUserID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUserByLoginName(String username) 
* 
*/ 
@Test
public void testGetUserByLoginName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(User user) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: modifyUser(User newuser) 
* 
*/ 
@Test
public void testModifyUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updatePass(Long id, String newPassword) 
* 
*/ 
@Test
public void testUpdatePass() throws Exception { 
//TODO: Test goes here... 
} 


} 
