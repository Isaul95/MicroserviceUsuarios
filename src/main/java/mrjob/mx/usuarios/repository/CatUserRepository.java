package mrjob.mx.usuarios.repository;

import mrjob.mx.usuarios.entity.CatUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatUserRepository extends JpaRepository<CatUser, Integer> {

    CatUser findByIdUsuario(Integer id_usuario);
}
