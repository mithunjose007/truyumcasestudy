/**
 * 
 */
package com.cognizant.truyum.dao;

import java.util.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author MITHUN JOSE
 *
 */
public class MenuItemDaoSqlImpl implements MenuItemDao {
	private static PreparedStatement ps=null;
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		
		List<MenuItem> menuItemsList = new ArrayList<>();
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENUITEM";
			 ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				boolean active = rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemsList.add(item);
			}}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return menuItemsList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		
		List<MenuItem> menuItemsList = new ArrayList<>();
		try {
		Connection con = ConnectionHandler.getConnection();
		String query = "SELECT * FROM MENUITEM WHERE ACTIVE = TRUE AND date_Of_Launch < now()";
		 ps = con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			long id = rs.getLong(1);
			String name = rs.getString(2);
			float price = rs.getFloat(3);
			boolean active = rs.getBoolean(4);
			Date dateOfLaunch = rs.getDate(5);
			String category = rs.getString(6);
			boolean freeDelivery = rs.getBoolean(7);
			MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			menuItemsList.add(item);
		}}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return menuItemsList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		try {
				Connection con = ConnectionHandler.getConnection();
				String query = "UPDATE MENUITEM SET item_name = ?, PRICE = ?, ACTIVE = ?, DATE_OF_LAUNCH = ?, CATEGORY = ?, "
						+ "FREE_DELIVERY = ? WHERE ID = ?";
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//java.sql.Date thisDate = java.sql.Date.valueOf(format.format(menuItem.getDateOfLaunch()));

				 ps = con.prepareStatement(query);
				ps.clearParameters();
				
				ps.setString(1, menuItem.getName());
				ps.setFloat(2, menuItem.getPrice());
				ps.setBoolean(3, menuItem.isActive());
				ps.setString(4, format.format(menuItem.getDateOfLaunch()));
				ps.setString(5, menuItem.getCategory());
				ps.setBoolean(6, menuItem.isFreeDelivery());
				ps.setLong(7, menuItem.getId());
				if(ps.executeUpdate() > 0) {
					System.out.println("Query Successful");
				}else {
					System.out.println("Query Unsuccessful");
				}
				//ResultSet rs=ps.executeQuery();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		MenuItem menuItem = null;
		try {
			Connection con = ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENUITEM WHERE ID =?";
			 ps = con.prepareStatement(query);
			
			ps.setLong(1, menuItemId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				boolean active = rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuItem;
	}
}
//	public void editMenuItem(MenuItem menuItem) {
//		
//	}



