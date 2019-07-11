package test.service.impl; 

import com.opensymphony.xwork2.ActionContext;
import model.Agent;
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
* @since <pre>���� 11, 2019</pre> 
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
} 

/** 
* 
* Method: getAgentByTel(String telephone) 
* 
*/ 
@Test
public void testGetAgentByTel() throws Exception { 
//TODO: Test goes here... 
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

/** 
* 
* Method: getAgentByPlot(int plotId) 
* 
*/ 
@Test
public void testGetAgentByPlot() throws Exception { 
//TODO: Test goes here...
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    UserService agent = (UserService)ctx.getBean("userService");
    agent.getAgentByTel("18810339310");
} 

/** 
* 
* Method: savehouse(LandlordApplyRelease landlordApplyRelease) 
* 
*/ 
@Test
public void testSavehouse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: messageSubmit(DiscussionSection discussionSection) 
* 
*/ 
@Test
public void testMessageSubmit() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: messageSave() 
* 
*/ 
@Test
public void testMessageSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: plotSave() 
* 
*/ 
@Test
public void testPlotSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: plotGet() 
* 
*/ 
@Test
public void testPlotGet() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: houseSave(String phone) 
* 
*/ 
@Test
public void testHouseSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: confirmHouse(House house, String phone, String user_name) 
* 
*/ 
@Test
public void testConfirmHouse() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: saveAgent(Agent agent, int userId, String username) 
* 
*/ 
@Test
public void testSaveAgent() throws Exception { 
//TODO: Test goes here...
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    UserService service = (UserService)ctx.getBean("userService");
    Agent agent = (Agent)ctx.getBean("agent");
    agent.setAgentId(1000);
    agent.setName("aloha");
    agent.setPassword("111111");
    agent.setTelephone("13520280972");
    service.saveAgent(agent, 1, "Lime");
}

} 
