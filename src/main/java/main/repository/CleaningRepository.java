package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.beans.Item;

@Repository
public interface CleaningRepository extends JpaRepository<Item, Long> {	}
