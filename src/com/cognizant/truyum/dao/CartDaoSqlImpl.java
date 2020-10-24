package com.cognizant.truyum.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	private static PreparedStatement ps = null;
	@Override
	public void addCartItem(long userId, long menuItemId) {
     try {
			
			Connection con = ConnectionHandler.getConnection();
			
			String query = "INSERT INTO CART(CT_USER_ID, CT_MENU_ID) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Query Successful");
			}else {
				System.out.println("Query Unsuccessful");
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	@Override
		public void removeCartItem(long userId, long menuItemId) {
			
			try {
				Connection con= ConnectionHandler.getConnection();
				String query = "DELETE FROM CART WHERE CT_MENU_ID = ? AND CT_USER_ID = ?";
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setLong(1, menuItemId);
				ps.setLong(2, userId);
				
				if(ps.executeUpdate() > 0) {
					System.out.println("Query Successful");
				}else {
					System.out.println("Query Unsuccessful");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = new ArrayList<>();
		Cart cart = new Cart(menuItemList, 0);
		double total = 0;
		try {
			Connection con = ConnectionHandler.getConnection();
			
			String query = "SELECT * FROM MENUITEM WHERE ID IN (SELECT CT_MENU_ID FROM CART WHERE CT_USER_ID = ?)";
			PreparedStatement ps= con.prepareStatement(query);
			
			ps.setLong(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				float price = rs.getFloat(3);
				total += price;
				boolean active = rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemList.add(menuItem);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setMenuItemList(menuItemList);
		cart.setTotal(total);
		return menuItemList;
	}



}
