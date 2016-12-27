//package com.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.edi.thoth.Application;
//import com.edi.thoth.domain.ClientUsers;
//import com.edi.thoth.service.MqProducer;
//import com.edi.thoth.service.mongodb.ClientUsersRepository;
//
//@SpringBootTest(classes = Application.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserMongodbTest
//{
//
//	@Autowired
//	private ClientUsersRepository cu;
//
//	@Autowired
//	private MqProducer mq;
//
//	@Test
//	public void Test_mq() throws Exception
//	{
//		// mq.send("orTest", "a", "aa");
//	}
//
//	@Test
//	public void Test_1()
//	{
//		ClientUsers u = new ClientUsers();
//		u.setUserName("测试");
//		List<String> listip = new ArrayList<String>();
//		listip.add("10.10.12.27");
//		listip.add("124.127.41.130");
//		u.setIps(listip);
//		u.setCheckID("client-OrderAServer");
//		u.setClientFlag("测试数据");
//
//		cu.save(u);
//	}
//
//	@Test
//	public void Test_2()
//	{
//		ClientUsers c = cu.findByips("10.10.12.27");
//		System.out.println(c.getUserName());
//	}
//}
