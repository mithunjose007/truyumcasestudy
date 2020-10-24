package com.cognizant.truyum.dao;

import java.util.*;
import java.text.*;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static  Map<Long, Cart> userCarts;
	public CartDaoCollectionImpl() {
		super();
		if(userCarts==null) {
			userCarts=new HashMap<Long,Cart>();
		}
	}// getters and setters
	public Map<Long,Cart> getUserCarts(){
		return userCarts;
	}
	public void setUserCarts(Map<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}
	
	@ Override
	public void addCartItem(long userId, long menuItemId)  {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem item =menuItemDao.getMenuItem(menuItemId);
        if(userCarts.containsKey(userId)) {
        	List<MenuItem> menuItemList  = userCarts.get(userId).getMenuItemList();
        	menuItemList.add(item);
        	userCarts.get(userId).setMenuItemList(menuItemList);
        }else {
        	List<MenuItem> newUserMenuList=new ArrayList<>();
        	newUserMenuList.add(item);
        	Cart cart =new Cart(newUserMenuList);
        	userCarts.put(userId,cart);
        }
	}

	
	@Override
	public void removeCartItem(long userId, long menuitemid) {
		Cart cart = userCarts.get(userId);
		ListIterator<MenuItem> iterator = cart.getMenuItemList().listIterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == menuitemid) {
				iterator.remove();}
			}
		}

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		Cart cart=userCarts.get(userId);
		List<MenuItem> allCartItems=cart.getMenuItemList();
		if(allCartItems.isEmpty()) {
			
		throw new CartEmptyException ();
		}
		else {
			double total=0;
			for(MenuItem item:allCartItems) {
				total+=item.getPrice();
			}
			cart.setTotal(total);
		}
		return allCartItems;
	}

}
