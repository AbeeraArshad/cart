package com.second.cart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.cart.Model.Shoppingcartinfo;
import com.second.cart.Repository.IShoppingcartRepository;

@Service
public class ShoppingcartService {

    @Autowired
    public IShoppingcartRepository shop;

    public Shoppingcartinfo create(Shoppingcartinfo cart){
        return shop.save(cart);

    }
    public Shoppingcartinfo get_item_by_id(Long id){
        return shop.findById(id).orElse(null);
    }
    public List<Shoppingcartinfo> get_all_items(){
        return shop.findAll();

        }   
         public Shoppingcartinfo updateShoppingcartInformation(Long id, Shoppingcartinfo cartInformation){
            Optional<Shoppingcartinfo> cartOptional = shop.findById(id);
            if(cartOptional.isPresent()){
                Shoppingcartinfo existingShoppingcartInformation = cartOptional.get();
                existingShoppingcartInformation.setId(cartInformation.getId());
                existingShoppingcartInformation.setName(cartInformation.getName());
                existingShoppingcartInformation.setQuantity(cartInformation.getQuantity());
                existingShoppingcartInformation.setPrice(cartInformation.getPrice());
                existingShoppingcartInformation.setTotalPrice(cartInformation.getTotalPrice());

                shop.save(existingShoppingcartInformation);
                return existingShoppingcartInformation;
            }
            else{ 
                return null;
            }

            }

          public void delete(Long id){
            shop.deleteById(id);
          }

          public void deleteAllItems() {
            shop.deleteAll();
        }

         }
    


