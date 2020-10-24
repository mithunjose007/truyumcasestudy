package com.cognizant.truyum.dao;

import java.util.*;
import java.text.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	 static  List<MenuItem> menuItemList=new ArrayList<>();
	public MenuItemDaoCollectionImpl()  {

		if (menuItemList == null) {
			//try {
				menuItemList.add(new MenuItem(1, "Sandwich", 99.0f, true, new DateUtil().convertToDate("15/03/2017"),
						"Main Course", true));
				menuItemList.add(new MenuItem(2, "Burger", 129.0f, true, new DateUtil().convertToDate("23/12/2017"),
						"Main Course", false));
				menuItemList.add(new MenuItem(3, "Pizza", 149.0f, true, new DateUtil().convertToDate("21/08/2018"),
						"Main Course", false));
				menuItemList.add(new MenuItem(4, "French Fries", 57.0f, false, new DateUtil().convertToDate("02/07/2017"),
						"Starters", true));
				menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.0f, true, new DateUtil().convertToDate("02/11/2022"),
						"Dessert", true));
				
			//} catch (ParseException e) {

//				System.out.println("Parse exception " + e.getMessage());
//
//			}

		}

	}
	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList)
	{
		MenuItemDaoCollectionImpl.menuItemList=menuItemList;
	}//constructor2
	
	//getters and setter
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	
	public void setMenuItemList(List<MenuItem> menuItemList) {

		MenuItemDaoCollectionImpl.menuItemList = menuItemList;
	}
	
	
	//overriding 4 methods
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}////......................................
	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerItemList = new ArrayList<>();
		Date currDate = new Date();
		
		for(MenuItem item : menuItemList) {
			if(item.isActive() && currDate.after(item.getDateOfLaunch())){
				customerItemList.add(item);
			}
		}
		return customerItemList;
	}/////..................................

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menuItemModify : menuItemList) {
			if (menuItem.getId() == menuItemModify.getId()) {

				menuItemModify.setName(menuItem.getName());
				menuItemModify.setCategory(menuItem.getCategory());
				menuItemModify.setDateOfLaunch(menuItem.getDateOfLaunch());
				menuItemModify.setFreeDelivery(menuItem.isFreeDelivery());
				menuItemModify.setPrice(menuItem.getPrice());
				menuItemModify.setActive(menuItem.isActive());
			}
		}
		//menuItemList.add(menuItem);
	}
//...........................................
	

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
