package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.enums.StatusPedido;
import br.com.alura.mvc.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("pedidosEntregue")
	List<Pedido> findByStatus(StatusPedido status, Pageable page);

	List<Pedido> findByStatusAndUsuario_username(StatusPedido status, String username);

	List<Pedido> findByUsuario_usernameIs(String username);
	
}
