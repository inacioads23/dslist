/* Pacote com as Entidades*/
package com.infostore.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Configura minha classe para ela se tornar equivalente a uma tabela do DB relacional
@Table(name = "tb_game")
public class Game {
	
	//Atributos
	@Id //define "id" como chave primária no DB
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera o auto increment
	private Long id;
	private String title;
	
	@Column(name = "game_year") //definindo que no DB não será usado "year", por questão de compatibilidade do DB
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	@Column(columnDefinition = "TEXT") //Define o tipo de campo como texto no DB. O que permite textos acima de 256 caracteres
	private String shortDescription;
	
	@Column(columnDefinition = "TEXT") //Define o tipo de campo como texto no DB. O que permite textos acima de 256 caracteres
	private String longDescription;

	
	// Construtor vazio
	public Game() {
		
	}

	// Construtor com argumento
	public Game(Long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id; // o "id" após '=' refere-se ao argumento do construtor
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	//Comparar dois Games - Opção: Source-> Generate hashCode() and equals()..
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}
