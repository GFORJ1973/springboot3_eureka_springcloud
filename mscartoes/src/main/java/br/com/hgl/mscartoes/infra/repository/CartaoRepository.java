package br.com.hgl.mscartoes.infra.repository;

import br.com.hgl.mscartoes.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
   List<Cartao> findByRendaLessThanEqual(BigDecimal renda);

}
