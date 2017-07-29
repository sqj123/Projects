package com.sqj.db;

import java.util.List;

public interface ISqlHelper<T> {	
	void getDbConnect();
    public  List<T> getList();
    public  int addNew(T t);
    public boolean modify(T t);
    public boolean delete(String code);
    void close();
}
