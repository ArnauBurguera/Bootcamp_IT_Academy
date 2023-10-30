package BurgueraCallesArnau.s05t01n03.model.repository;

import BurgueraCallesArnau.s05t01n03.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {
}
