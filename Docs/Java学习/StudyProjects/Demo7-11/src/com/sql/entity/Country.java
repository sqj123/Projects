package com.sql.entity;

public class Country {
	private String _code;
	private String _name;
	private String _region;
	private float _surfaceArea;

	public Country() {

	}

	public String get_code() {
		return _code;
	}

	public void set_code(String _code) {
		this._code = _code;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_region() {
		return _region;
	}

	public void set_region(String _region) {
		this._region = _region;
	}

	public float get_surfaceArea() {
		return _surfaceArea;
	}

	public void set_surfaceArea(float _surfaceArea) {
		this._surfaceArea = _surfaceArea;
	}
}
