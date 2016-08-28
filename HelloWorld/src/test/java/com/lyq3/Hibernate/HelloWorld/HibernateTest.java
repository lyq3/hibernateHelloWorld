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
		//����SessionFactory����
		SessionFactory sessionFactory=null;
		//1)����Configuration���󣺶�Ӧhibernate�Ļ���������Ϣ�Ͷ����ϵӳ����Ϣ
		Configuration configuration=new Configuration().configure();//���ض��������ļ�λ��
		
		//4.0֮ǰ��������SessionFactory
		//sessionFactory=configuration.buildSessionFactory();
		
		//4.0֮��
		//1)����һ��ServiceRegistry����
		//hibernate���κ����úͷ�����Ҫ�ڸö�����ע�������Ч
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//����һ��Session����
		Session session=sessionFactory.openSession();
		//��������
		Transaction transaction=session.beginTransaction();
		//ִ�б���
		News news=new News("3434","333333",new Date(new java.util.Date().getTime()));
		session.save(news);
		//�ύ����
		transaction.commit();
		//�ر�Session
		session.close();
		//�ر�SessionFactory
		sessionFactory.close();
	}
}
