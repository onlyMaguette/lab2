package com.example.sb_online_shop;

import org.springframework.data.repository.CrudRepository;
import com.example.sb_online_shop.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
