package com.service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class IdentifierGeneratorImpl implements IdentifierGenerator, Configurable {
	
	private static final int IDLENG = 3;
	private static final String YYMMDDHHMMSS = "yyyyMMddhhmmss";
	
	private static String getCurrentDate(){
		return new SimpleDateFormat(YYMMDDHHMMSS).format(new Date());
	}

	public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {			
		return  new StringBuilder().append("KD").append(getCurrentDate()).append(RandomStringUtils.randomNumeric(IDLENG));
	}

	public void configure(Type type, Properties params, Dialect d) throws MappingException {
		
	}
	public static void main(String[] args) {
		IdentifierGeneratorImpl pu = new IdentifierGeneratorImpl();		
		System.out.println(pu.generate(null, null));		
		/*int random = 32;
		System.out.println(RandomStringUtils.randomNumeric(random));
		System.out.println(RandomStringUtils.randomAscii(random));
		System.out.println(RandomStringUtils.randomAlphabetic(random));
		System.out.println(RandomStringUtils.randomAlphanumeric(random));*/
		
	}
}
