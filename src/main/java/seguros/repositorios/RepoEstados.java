package seguros.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seguros.model.Estado;

@Repository
public interface RepoEstados extends JpaRepository<Estado, Long> {

}
