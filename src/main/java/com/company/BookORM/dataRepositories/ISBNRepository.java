package com.company.BookORM.dataRepositories;

import com.company.BookORM.Models.ISBN;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISBNRepository extends CrudRepository<ISBN, Integer> {
}
