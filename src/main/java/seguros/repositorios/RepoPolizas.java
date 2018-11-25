package seguros.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seguros.model.Poliza;


@Repository
public interface RepoPolizas extends JpaRepository<Poliza, Long> {

}
