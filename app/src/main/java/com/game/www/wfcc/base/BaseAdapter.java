package com.game.www.wfcc.base;


import android.app.Activity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Adapter基类
 * 
 * @author zhangdaweisir
 * @version 1.0
 * 
 */
public abstract class BaseAdapter extends android.widget.BaseAdapter {

	/** 数据存储集合 **/
	private List<Object> mDataList = new ArrayList<Object>();
	/** Context上下文 **/
	private Activity mContext;
	/** 每一页显示条数 **/
	private int mPerPageSize = 10;

	public int getmPerPageSize() {
		return mPerPageSize;
	}

	public void setmPerPageSize(int mPerPageSize) {
		this.mPerPageSize = mPerPageSize;
	}

	/**日志输出标志**/
	protected final String TAG = this.getClass().getSimpleName();

	public BaseAdapter() {
		this(null);
	}
	
	public BaseAdapter(Activity mContext) {
		this(mContext,10);
	}
	
	public BaseAdapter(Activity mContext,int mPerPageSize){
		this.mContext = mContext;
		this.mPerPageSize = mPerPageSize;
	}
	
	@Override
	public int getCount() {
		return mDataList.size();
	}

	@Override
	public Object getItem(int position) {
		try{
			return mDataList.get(position);
		}catch (Exception e){
			return null;
		}
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	/**
	 * 获取当前页
	 * @return 当前页
	 */
	public int getPageNo(){
		int count = (getCount() / mPerPageSize) + 1;
		if(getCount() % mPerPageSize != 0){
			count++;
		}
		count--;
		return count;
	}

	/*
	获取起始页面
		 */
	public int getBeginPageNo(){
		return 0;
	}
	/**
	 * 添加数据
	 */
	public boolean addItem(Object object){
		return mDataList.add(object);
	}
	
	/**
	 * 在指定索引位置添加数据
	 * @param location 索引
	 * @param object 数据
	 */
	public void addItem(int location,Object object){
	     mDataList.add(location, object);
	}
	
	/**
	 * 集合方式添加数据
	 * @param collection 集合
	 */
	public boolean addItem(Collection<? extends Object> collection){
		return mDataList.addAll(collection);
	}
	
	/**
	 * 在指定索引位置添加数据集合
	 * @param location 索引
	 * @param collection 数据集合
	 */
	public boolean addItem(int location,Collection<? extends Object> collection){
		return mDataList.addAll(location,collection);
	}
	
	/**
	 * 移除指定对象数据
	 * @param object 移除对象
	 * @return 是否移除成功
	 */
	public boolean removeItem(Object object){
		return mDataList.remove(object);
	}
	
	/**
	 * 移除指定索引位置对象
	 * @param location 删除对象索引位置
	 * @return 被删除的对象
	 */
	public Object removeItem(int location){
		Object obj = null;
		try {
			obj = mDataList.remove(location);
		}catch (Exception e){

		}
	    return obj;
	}
	
	/**
	 * 移除指定集合对象
	 * @param collection 待移除的集合
	 * @return 是否移除成功
	 */
	public boolean removeAll(Collection<? extends Object> collection){
		return mDataList.removeAll(collection);
	}
	
	/**
	 * 清空数据
	 */
	public void clear() {
		mDataList.clear();
	}
	
}
