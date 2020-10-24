package com.cognizant.truyum.dao;
import java.util.*;
import java.text.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
public class MenuItemDaoCollectionImplTest  {
	//static MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
	public static void  main( String args[]) throws ParseException {
		 
				System.out.println("Menu List Admin Printing...");
				testGetMenuItemListAdmin();
				System.out.println("Menu List Customer Printing...");
				testGetMenuListCustomer();
				System.out.println("Modified Menu and Printing to check...");
				testModifyMenuItem();
				System.out.println("Completed.");

			
	}
	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl=new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDaoCollectionImpl.getMenuItemListAdmin();

		for (MenuItem item : menuItemList) {
			System.out.println(item.toString());
		}
	}
	public  static void testGetMenuListCustomer() throws ParseException {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItems = menuItemDaoCollectionImpl
				.getMenuItemListCustomer();

		for (MenuItem menuItem : menuItems) {

			System.out.println(menuItem.toString());

		}

	}
	public static void testModifyMenuItem() throws ParseException{
		MenuItem newMenuItem = new MenuItem(1, "Sandwich", 109.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		menuItemDao.modifyMenuItem(newMenuItem);
		System.out.println("Modified MenuItem details are :"
				+ menuItemDao.getMenuItem(000002));

	
	}
}

