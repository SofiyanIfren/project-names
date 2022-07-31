package project.names.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.names.model.Origin;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer> {

}
