package com.cognizant.truyum.dao;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
public class CartDaoCollectionImplTest {
	public static CartDao cartDao = new CartDaoCollectionImpl();
	public void main(String args[]){
		testAddCartItem();
		
		testGetAllCartItems();
		
		testRemoveCartItem();
	}
	
	public  void testAddCartItem(){
		cartDao.addCartItem(1, 1);
	try {
		List<MenuItem> cartItemList = cartDao.getAllCartItems(1);
		cartItemList.forEach(System.out::println);
	} catch (CartEmptyException e) {

		e.printStackTrace();
	}
}
	public  void testGetAllCartItems(){try {
		List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
		allCartItems.forEach(System.out::println);
	} catch (CartEmptyException e) {

		e.printStackTrace();
	}
	}
	public  void testRemoveCartItem(){
		cartDao.removeCartItem(1, 1);
		List<MenuItem> cartItemList;
		try {
			cartItemList = cartDao.getAllCartItems(1);
			cartItemList.forEach(System.out::println);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
