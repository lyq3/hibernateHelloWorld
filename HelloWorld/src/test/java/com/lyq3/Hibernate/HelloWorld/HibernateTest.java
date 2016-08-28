package com.lyq3.Hibernate.HelloWorld;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class HibernateTest {
	@Test
	public void test(){
		//创建SessionFactory对象
		SessionFactory sessionFactory=null;
		//1)创建Configuration对象：对应hibernate的基本配置信息和对象关系映射信息
		Configuration configuration=new Configuration().configure();//重载定义配置文件位置
		
		//4.0之前这样创建SessionFactory
		//sessionFactory=configuration.buildSessionFactory();
		
		//4.0之后
		//1)创建一个ServiceRegistry对象
		//hibernate的任何配置和服务都需要在该对象中注册才能有效
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//创建一个Session对象
		Session session=sessionFactory.openSession();
		//开启事物
		Transaction transaction=session.beginTransaction();
		//执行保存
		News news=new News("3434","333333",new Date(new java.util.Date().getTime()));
		session.save(news);
		//提交事物
		transaction.commit();
		//关闭Session
		session.close();
		//关闭SessionFactory
		sessionFactory.close();
	}
}
