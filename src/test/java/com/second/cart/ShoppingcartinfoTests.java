package com.second.cart;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.cart.Controller.ShoppingcartController;
import com.second.cart.Model.Shoppingcartinfo;
import com.second.cart.Service.ShoppingcartService;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
class ShoppingcartinfoTests {

    private MockMvc mvc;

    @Mock
    private ShoppingcartService shoppingcartService;

    @InjectMocks
    private ShoppingcartController controller;
    private JacksonTester<Shoppingcartinfo> json;
	private JacksonTester<Collection<Shoppingcartinfo>> jsonList;

    @BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

    @Test
    void contextLoads() {

    }

     
     @Test
     public void canGetAllCartInfo() throws Exception {
         Shoppingcartinfo Info1 = new Shoppingcartinfo (1L, "rubby", "http://dgdgf", 12, 10L, 20L);
         Shoppingcartinfo Info2 = new Shoppingcartinfo(2L, "rubby", "http://dgdgf", 12, 10L, 20L);
         List<Shoppingcartinfo> cartInfo = new ArrayList<Shoppingcartinfo>();
         cartInfo.add(Info1);
         cartInfo.add(Info2);
         when(shoppingcartService.get_all_items()).thenReturn(cartInfo);
         mvc.perform(get("/api/shopping_cart/all")
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(content().json(jsonList.write(cartInfo).getJson()));
 
     }

     @Test
     public void getCartDetailById() throws Exception{
         Shoppingcartinfo info = new Shoppingcartinfo(1L, "rubby", "http://dgdgf", 12, 10L, 20L);
 
         when(shoppingcartService.get_item_by_id(1L)).thenReturn(info);
         mvc.perform(get("/api/shopping_cart/1")
         .contentType(MediaType.APPLICATION_JSON)
         .content(json.write(info).getJson()))
         .andExpect(status().isOk())
         .andExpect(content().json(json.write(info).getJson()));
 }
    
    @Test
    public void canCreateProductinfo() throws Exception {
     Shoppingcartinfo info1 = new Shoppingcartinfo(3L, "rubby", "http://dgdgf", 12, 10L, 20L);
     when(shoppingcartService.create(info1)).thenReturn(info1);
     mvc.perform(post("/api/shopping_cart")
             .contentType(MediaType.APPLICATION_JSON)
             .content(json.write(info1).getJson()))
             .andExpect(status().isCreated());
 
 }
    
     @Test
	public void canUpdateCandidateAcademicInfo() throws Exception {
		Shoppingcartinfo info = new Shoppingcartinfo(3L, "rubby", "http://dgdgf", 12, 10L, 20L);
		when(shoppingcartService.updateShoppingcartInformation(eq(3L), any(Shoppingcartinfo.class) )).thenReturn(info);
		mvc.perform(put("/api/shopping_cart/update/3")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(info).getJson()))
				.andExpect(status().isOk())
				.andExpect(content().json(json.write(info).getJson()));

    
 }
 
}

   

