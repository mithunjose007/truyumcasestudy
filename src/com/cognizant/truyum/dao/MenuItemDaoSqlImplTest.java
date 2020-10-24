package com.cognizant.truyum.dao;
import java.util.*;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
public class MenuItemDaoSqlImplTest {
	private static MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
	public static void main(String args[]){
		System.out.println("MenuItemDaoImplTest Main method begins");
		System.out.println("Admin List of MenuItems");
		testGetMenuItemListAdmin();
		System.out.println("Customer List of Menu Items");
		testGetMenuItemListCustomer();
		System.out.println("Modifying and printing MenuItem");
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		System.out.println("Get Menu Item");
		testGetMenuItem();
	
	}
	public static void testGetMenuItemListAdmin() {
		List<MenuItem> itemAdminLists = menuItemDao.getMenuItemListAdmin();
		itemAdminLists.forEach(System.out::println);
	}
	
	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(1, "Sandwich", 109.00f, true, new DateUtil().convertToDate("02/07/2017"),
				"MainCourse", true);
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;
		menuItemDao.modifyMenuItem(menuItem);
		System.out.println("Modified MenuItem details are :"
				+ menuItemDao.getMenuItem(000002));
	}
	
	public static void testGetMenuItemListCustomer() {
		List<MenuItem> itemCustomerLists = menuItemDao.getMenuItemListCustomer();
		itemCustomerLists.forEach(System.out::println);
	}
	
	
	public static void testGetMenuItem() {
		MenuItem menuItem = menuItemDao.getMenuItem(2);
		if(menuItem == null) {
			System.out.println("The Item does not exist in our database");
			return;
		}
		System.out.println(menuItem);
	}

}
