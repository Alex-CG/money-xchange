package com.moneyxchange.app.data.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomCrudRepository<E, ID> extends CrudRepository<E, ID> {

}
