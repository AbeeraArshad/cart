package com.second.cart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.index.CandidateComponentsIndex;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.second.cart.Model.Shoppingcartinfo;
import com.second.cart.Service.ShoppingcartService;

@CrossOrigin
@RestController
@RequestMapping("/api/shopping_cart")
public class ShoppingcartController {

    @Autowired
    public ShoppingcartService service;

    @PostMapping("")
    public ResponseEntity<Shoppingcartinfo> createshpList(
        @RequestBody Shoppingcartinfo shpList){
            Shoppingcartinfo cartCreated = service.create(shpList);
            return new ResponseEntity<>(cartCreated,HttpStatus.CREATED);
}
@GetMapping("/all")
public List<Shoppingcartinfo>get_items(){
   return service.get_all_items(); 
}
@GetMapping("/{id}")
public ResponseEntity<Shoppingcartinfo>get_item_by_id(@PathVariable Long id){
    Shoppingcartinfo value = service.get_item_by_id(id);
    if (value == null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Shoppingcartinfo>(value, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Shoppingcartinfo> updateShoppingInformation(@PathVariable Long id,
    @RequestBody Shoppingcartinfo shpinformation){
        Shoppingcartinfo updatedShopInformation = service.updateShoppingcartInformation(id,shpinformation);
        if(updatedShopInformation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        else{
            return new ResponseEntity<Shoppingcartinfo>(updatedShopInformation, HttpStatus.OK);
        }
    } 
@DeleteMapping("")
public ResponseEntity post_item(@PathVariable Long id){
    service.delete(id);
    return new ResponseEntity<Object>("Item Deleted Successfully",HttpStatus.OK);
}

@DeleteMapping("/delete/all")
    public void deleteItems() {
         service.deleteAllItems();
    }




}

    

