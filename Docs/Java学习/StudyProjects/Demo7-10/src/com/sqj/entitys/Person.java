package com.sqj.entitys;

public class Person {
	private String _id;
	private String _name;
	private int _age;

	public Person() {

	}

	public Person(String id, String name, int age) {
		this._id = id;
		this._name = name;
		this._age = age;
	}

	public int get_age() {
		return _age;
	}

	public void set_age(int _age) {
		this._age = _age;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String toString() {
		return "身份证：" + this._id + "  姓名：" + this._name + "  年龄：" + this._age;

	}
}
