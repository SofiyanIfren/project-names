package project.names.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.names.model.Name;

@Repository
public interface NameRepository extends JpaRepository<Name, Integer> {
}
