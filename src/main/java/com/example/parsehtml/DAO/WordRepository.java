package com.example.parsehtml.DAO;

import com.example.parsehtml.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Integer> {

}
