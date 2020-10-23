package com.cognizant.truyum.dao;

import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static  List<MenuItem> menuItemList;
	public MenuItemDaoCollectionImpl() {
		super();
		List<MenuItem> newlst=new ArrayList<>();
		if(menuItemList==null) {
			newlst.add(new MenuItem(1,"Burger",70.0f,true,new DateUtil().convertToDate("25/03/2017"),"Main Course", true));
			newlst.add(new MenuItem(2,"ChocolateShake",60.0f,true,new DateUtil().convertToDate("15/07/2017"),"Starter", true));
			newlst.add(new MenuItem(3,"Biriyani",100.0f,true,new DateUtil().convertToDate("05/03/2017"),"Main Course", true));
		}
		menuItemList=newlst;
	}
	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList)
	{
		MenuItemDaoCollectionImpl.menuItemList=menuItemList;
	}//constructor
	public List<MenuItem> getMenuItem() {
		// TODO Auto-generated method stub
		return menuItemList;
	}
	
	public void setMenuItemList(List<MenuItem> menuItemList) {

		MenuItemDaoCollectionImpl.menuItemList = menuItemList;
	}
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}////
	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerItemList = new ArrayList<>();
		Date currDate = new DateUtil().convertToDate("20/10/2020");
		
		for(MenuItem item : menuItemList) {
			if(item.isActive() && currDate.after(item.getDateOfLaunch())){
				customerItemList.add(item);
			}
		}
		return customerItemList;
	}/////

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem eachItem : menuItemList) {
			if (menuItem.equals(eachItem)) {
				eachItem.setId(menuItem.getId());
				eachItem.setName(menuItem.getName());
				eachItem.setPrice(menuItem.getPrice());
				eachItem.setActive(menuItem.isActive());
				eachItem.setDateOfLaunch(menuItem.getDateOfLaunch());
				eachItem.setCategory(menuItem.getCategory());
				eachItem.setFreeDelivery(menuItem.isFreeDelivery());
//				eachItem = menuItem;
				return;
			}
		}
		menuItemList.add(menuItem);
	}

	

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		return null;
	}

}
