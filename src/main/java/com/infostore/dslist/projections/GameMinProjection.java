package com.infostore.dslist.projections;

public interface GameMinProjection {
	
	Long getId();
	String getTitle();
	//Integer getYear(); - Anterior a alteração de Alias no DB Postgresql
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
