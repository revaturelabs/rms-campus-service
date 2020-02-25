package com.rms.dao;

import com.rms.model.Address;

import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer>{

}