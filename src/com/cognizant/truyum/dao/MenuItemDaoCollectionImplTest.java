package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.*;
import com.cognizant.truyum.util.*;
public class MenuItemDaoCollectionImplTest {
	static MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
	public void main( String args[]) {
		 
				System.out.println("Menu List Admin Printing...");
				testGetMenuItemListAdmin();
				System.out.println("Menu List Customer Printing...");
				testGetMenuListCustomer();
				System.out.println("Modified Menu and Printing to check...");
				testModifyMenuItem();
				System.out.println("Completed.");

			
	}
	public void testGetMenuItemListAdmin() {
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}
	public void testGetMenuListCustomer() {
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem item : menuItemList) {
			System.out.println(item);
		}
	}
	public void testModifyMenuItem(){
		MenuItem newMenuItem = new MenuItem(1, "Sandwich", 109.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
		menuItemDao.modifyMenuItem(newMenuItem);
		MenuItem modifiedMenuItem = menuItemDao.getMenuItem(1);
		System.out.println(modifiedMenuItem);

	
	}
}

