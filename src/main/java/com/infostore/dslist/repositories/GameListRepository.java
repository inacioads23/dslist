//Pacote que faz consulta ao DB
package com.infostore.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infostore.dslist.entities.GameList;

// o "JpaRepository" faz toda a parte de ação do DB: INSERT, UPDATE, DELETE, QUERY
// A Java Persistence API (JPA) é uma especificação Java que define um conjunto de classes e métodos
// para mapeamento objeto-relacional (ORM)
//											<tp entidade, tp Id entidade>
public interface GameListRepository extends JpaRepository<GameList, Long>{
	// atualiza posição após puxar o item de lugar
	@Modifying // para Update, Insert, Delete
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
