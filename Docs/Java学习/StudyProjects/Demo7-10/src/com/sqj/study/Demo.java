package com.sqj.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sqj.entitys.Person;

public class Demo {

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		// TODO Auto-generated method stub
		String arr[]={"baidu","google","sina","webchat","tencent"};
		for (int i = 0; i < arr.length; i++) {
			System.out.println("----->"+arr[i]);
		}
        System.out.println("helloworld");
        Person p=new Person();
        p.set_id("410181198310016072");
        p.set_age(35);
        p.set_name("куг╖╬Э");
        System.out.println(p.toString());
        
        Class<Person> cls=Person.class;
        try {
			Person p1 =cls.newInstance();
	        p1.set_id("4101811983100160720000");
	        p1.set_age(34);
	        p1.set_name("baidu");
	        System.out.println(p1.toString());
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			Class cls1=Class.forName("com.sqj.entitys.Person");
			Constructor cs= cls1.getConstructor(String.class,String.class,int.class);//("410181198310016072","sina",30);
			try {
				
				Person p2 = (Person) cs.newInstance("410181198310016072","sina",30);
				System.out.println(p2.toString());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

