//Pacote que faz consulta ao DB
package com.infostore.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infostore.dslist.entities.Game;

// o "JpaRepository" faz toda a parte de ação do DB: INSERT, UPDATE, DELETE, QUERY
// A Java Persistence API (JPA) é uma especificação Java que define um conjunto de classes e métodos
// para mapeamento objeto-relacional (ORM)
//											<tp entidade, tp Id entidade>
public interface GameRepository extends JpaRepository<Game, Long>{

}
