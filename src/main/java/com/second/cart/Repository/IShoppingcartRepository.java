package com.second.cart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.second.cart.Model.Shoppingcartinfo;

@Repository
public interface IShoppingcartRepository extends JpaRepository <Shoppingcartinfo, Long>{
    // public List<Shoppingcartinfo> findAll();
    // public Optional<Shoppingcartinfo> findById(Long id);
    
}
