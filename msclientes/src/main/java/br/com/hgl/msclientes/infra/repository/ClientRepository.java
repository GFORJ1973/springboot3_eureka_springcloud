package br.com.hgl.msclientes.infra.repository;

import br.com.hgl.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);

    List<Cliente> findAllByCpf(@Param("cpf") String cpf);

    List<Cliente> findAll();
}
