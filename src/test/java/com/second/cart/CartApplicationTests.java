package com.second.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.second.cart.Repository.IShoppingcartRepository;
import com.second.cart.Service.ShoppingcartService;
import com.second.cart.Model.Shoppingcartinfo;

@SpringBootTest
 class CartApplicationTests {

	
	@Mock
	private IShoppingcartRepository iShoppingRepository;

    @InjectMocks
	private ShoppingcartService shoppingcartService;
	@Test
	void contextLoads() {
	}
	@Test
	void getAndSetID(){
    Shoppingcartinfo cut = new Shoppingcartinfo();
	Long myId = 1L;
	cut.setId(myId);
	assertEquals(myId,cut.getId());
	}
	@Test
	void getAndSetName(){
		Shoppingcartinfo cut = new Shoppingcartinfo();
		String mycartproductname = "bronze";
		cut.setName(mycartproductname);
		assertEquals(mycartproductname, cut.getName());
	}
	@Test
	void getAndSetshortDescription(){
		Shoppingcartinfo cut = new Shoppingcartinfo();
		String productImageLink = "rubby";
		cut.setImage_Link(productImageLink);
		assertEquals(productImageLink, cut.getImage_Link());
	}

	@Test
	void getAndSetprice(){
		Shoppingcartinfo cut = new Shoppingcartinfo();
		Long price = 20L;
		cut.setPrice(price);
		assertEquals(price, cut.getPrice());

	
	}

   

 }
