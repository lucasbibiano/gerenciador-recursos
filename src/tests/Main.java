package tests;

import java.sql.Timestamp;
import java.util.Calendar;

import dal.concrete.mysql.FunctionDAO;
import dal.concrete.mysql.PlaceResourceDAO;
import dal.concrete.mysql.ReservationDAO;
import dal.concrete.mysql.RoomTypeDAO;
import dal.concrete.mysql.SectorDAO;
import dal.concrete.mysql.UserDAO;
import pojo.Function;
import pojo.PlaceResource;
import pojo.Reservation;
import pojo.RoomType;
import pojo.Sector;
import pojo.User;

public class Main {
	public static void main(String[] args) throws Exception {
		Sector sector = new Sector();
		sector.name = "Setor da zuera";
		sector.description = "setor muito zuero";
		
		SectorDAO.getInstance().create(sector);
		
		/**************************************/
		
		Function function = new Function();
		function.name = "Zuador";
		function.description = "função zuera";
		
		FunctionDAO.getInstance().create(function);
		
		/**************************************/
		
		User user = new User();
		user.cpf = "1234567890";
		user.name = "Mr. zuera";
		user.email = "zuero@zuera.com";
		user.telephone = "1234567890";
		user.functionID = FunctionDAO.getInstance().getAll().get(0).id;
		user.sectorID = SectorDAO.getInstance().getAll().get(0).id;

		UserDAO.getInstance().create(user);

		/**************************************/

		RoomType roomType = new RoomType();
		roomType.name = "Zuatório";
		roomType.description = "onde a zuera rola";
		
		RoomTypeDAO.getInstance().create(roomType);
		
		/**************************************/

		PlaceResource placeRes = new PlaceResource();
		placeRes.code = "3E3";
		placeRes.capacity = 100;
		placeRes.description = "muita zuera ocorre aqui";
		placeRes.name = "Local da zuera";
		placeRes.length = 100;
		placeRes.width = 100;
		placeRes.roomTypeID = RoomTypeDAO.getInstance().getAll().get(0).id;
		
		PlaceResourceDAO.getInstance().create(placeRes);
		
		/**************************************/

		Reservation reser = new Reservation();
		reser.approved = true;
		reser.pendingApproval = false;
		reser.solicitationTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		reser.beginTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		reser.endTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		reser.userCpf = UserDAO.getInstance().getAll().get(0).cpf;
		reser.resourceType = "PlaceResource";
		reser.resourceID = PlaceResourceDAO.getInstance().getAll().get(0).id;
				
		ReservationDAO.getInstance().create(reser);
		ReservationDAO.getInstance().loadRelationships(reser);
		
		/**************************************/
	}
}
