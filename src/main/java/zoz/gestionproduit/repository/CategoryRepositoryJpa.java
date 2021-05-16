package zoz.gestionproduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.gestionproduit.model.Category;

public interface CategoryRepositoryJpa extends JpaRepository<Category, Long> {

}
