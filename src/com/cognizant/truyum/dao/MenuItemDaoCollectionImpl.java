package com.cognizant.truyum.dao;

import java.util.*;
import java.text.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static  List<MenuItem> menuItemList;
	public MenuItemDaoCollectionImpl() throws ParseException {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(000001, "Sandwich", 99.00f, true,
					DateUtil.convertToDate("15/03/2017"), "Main Course",
					true));
			menuItemList.add(new MenuItem(000002, "Burger", 129.00f, true,
					DateUtil.convertToDate("23/12/2017"), "Main Course",
					false));
			menuItemList.add(new MenuItem(000003, "Pizza", 149.00f, true,
					DateUtil.convertToDate("21/08/2018"), "Main Course",
					false));
			menuItemList.add(new MenuItem(000004, "French Fries", 200.00f,
					true, DateUtil.convertToDate("02/07/2017"),
					"Main Course", false));
			menuItemList.add( new MenuItem(000005, "Choclate Brownie", 32.00f,
					true, DateUtil.convertToDate("02/11/2022"), "Dessert",
					true));

		}

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
