package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.dal.ArticlesVendusDal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.sql.Date;

import fr.eni.projetEncheres.bo.ArticlesVendusBo;


public class TestDalArticlesVendus {
	
public static void main(String[] args) throws IOException {
		
		ArticlesVendusDal article1 = new ArticlesVendusDal();
		ArticlesVendusDal article2 = new ArticlesVendusDal();
		//Articles_vendusdal article3 = new Articles_vendusdal();
		 String str="2015-03-31";  
		 Date date=Date.valueOf(str);//converting string into sql date  
//		LocalDate date = LocalDate.of(2020, Month.JANUARY, 8);
//		LocalDate date2 = LocalDate.of(2021, Month.JANUARY, 9);
		ArticlesVendusBo voiture = new ArticlesVendusBo("voiture", "petite voiture jouet", date, date, 15, 10, 3, 5);
		article1.insert(voiture);

		//Utilisateurs Adrian = new Utilisateurs("LeSauveur", "Adrian", "Lepage", "adrian@gmail.com",  "0650852530", "rue des super héros", "10000", "Gotham", "1234", 50, 0);
		//UtilisateursDal.insert(Adrian);
		
		//Utilisateurs Hubert = new Utilisateurs("HB", "Hubert", "Lebreton", "hb@hotmail.com",  "0750852515", "rue de la Bretagne", "35000", "Rennes", "4321", 50, 0);
		//UtilisateursDal.insert(Hubert);

	}

}


