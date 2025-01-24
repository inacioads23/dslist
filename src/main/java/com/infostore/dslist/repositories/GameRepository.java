//Pacote que faz consulta ao DB
package com.infostore.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infostore.dslist.entities.Game;
import com.infostore.dslist.projections.GameMinProjection;

// o "JpaRepository" faz toda a parte de ação do DB: INSERT, UPDATE, DELETE, QUERY
// A Java Persistence API (JPA) é uma especificação Java que define um conjunto de classes e métodos
// para mapeamento objeto-relacional (ORM)
//											<tp entidade, tp Id entidade>
public interface GameRepository extends JpaRepository<Game, Long>{

	//possibilita o uso de SQL nativo
	//o Postgres não aceita apóstrofo na Query. Ex.: AS 'year'
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}
