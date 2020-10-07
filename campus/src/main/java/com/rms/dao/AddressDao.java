package com.rms.dao;

import javax.transaction.Transactional;

import com.rms.model.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AddressDao extends CrudRepository<Address, Integer>{

}