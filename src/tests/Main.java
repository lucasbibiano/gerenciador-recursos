package tests;

import java.sql.Timestamp;
import java.util.Calendar;

import dal.concrete.mysql.ActivityDAO;
import dal.concrete.mysql.FunctionDAO;
import dal.concrete.mysql.ObjectResourceDAO;
import dal.concrete.mysql.PermissionActivitiesWithResourcesDAO;
import dal.concrete.mysql.PermissionDAO;
import dal.concrete.mysql.PlaceResourceDAO;
import dal.concrete.mysql.PlacesServicesDAO;
import dal.concrete.mysql.ReservationDAO;
import dal.concrete.mysql.ReservationObjectDAO;
import dal.concrete.mysql.RoomTypeDAO;
import dal.concrete.mysql.SectorDAO;
import dal.concrete.mysql.ServiceResourceDAO;
import dal.concrete.mysql.UserDAO;
import pojo.Activity;
import pojo.Function;
import pojo.ObjectResource;
import pojo.Permission;
import pojo.PermissionActivitiesWithResources;
import pojo.PlaceResource;
import pojo.PlacesServices;
import pojo.Reservation;
import pojo.ReservationObject;
import pojo.RoomType;
import pojo.Sector;
import pojo.ServiceResource;
import pojo.User;
import utils.Utils;

public class Main {
	public static void main(String[] args) throws Exception {
		Activity acti = new Activity();
		acti.name = "Zoar";
		
		ActivityDAO.getInstance().create(acti);
		
		/**************************************/
		
		Permission permission = new Permission();
		permission.name = "Permissão para zuar";
		permission.description = "The zuera never ends...";
		
		PermissionDAO.getInstance().create(permission);
		
		/**************************************/
		
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
		user.login = "zuera";
		user.password = Utils.MungPass("huehue");
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
		reser.placeID = PlaceResourceDAO.getInstance().getAll().get(0).id;
		
		ReservationDAO.getInstance().create(reser);
		
		/**************************************/
		
		ObjectResource object = new ObjectResource();
		object.name = "Zuador";
		object.description = "Instrumento de zuera";
		object.tombamento = "ZU3R4";
		object.allocatedAtID = PlaceResourceDAO.getInstance().getAll().get(0).id;
		
		ObjectResourceDAO.getInstance().create(object);
		
		/**************************************/
		
		ReservationObject reres = new ReservationObject();
		reres.reservationID = ReservationDAO.getInstance().getAll().get(0).id;
		reres.objectID = ObjectResourceDAO.getInstance().getAll().get(0).id;
		
		ReservationObjectDAO.getInstance().create(reres);
		
		/**************************************/
		
		ServiceResource service = new ServiceResource();
		service.name = "WiFi da zuera";
		service.description = "100Mbps de pura zuera";
		
		ServiceResourceDAO.getInstance().create(service);		
		
		/**************************************/
		
		ServiceResource service2 = new ServiceResource();
		service2.name = "zuera";
		service2.description = "hu3";
		
		ServiceResourceDAO.getInstance().create(service2);		
		
		/**************************************/
		
		PlacesServices ps = new PlacesServices();
		ps.placeID = PlaceResourceDAO.getInstance().getAll().get(0).id;
		ps.serviceID = ServiceResourceDAO.getInstance().getAll().get(0).id;
		
		PlacesServicesDAO.getInstance().create(ps);
		
		/**************************************/
		
		PlacesServices ps2 = new PlacesServices();
		ps2.placeID = PlaceResourceDAO.getInstance().getAll().get(0).id;
		ps2.serviceID = ServiceResourceDAO.getInstance().getAll().get(1).id;
		
		PlacesServicesDAO.getInstance().create(ps2);
		
		/**************************************/
		
		PermissionActivitiesWithResources pawr = new PermissionActivitiesWithResources();
		pawr.activityID = ActivityDAO.getInstance().getAll().get(0).id;
		pawr.permissionID = PermissionDAO.getInstance().getAll().get(0).id;
		pawr.resourceType = "PlaceResource";
		pawr.resourceID = PlaceResourceDAO.getInstance().getAll().get(0).id;
		
		PermissionActivitiesWithResourcesDAO.getInstance().create(pawr);
		
		PermissionActivitiesWithResourcesDAO.getInstance().loadRelationships(pawr);
		
		System.out.println(pawr.actitivity);
		System.out.println(pawr.resource);
		System.out.println(pawr.permission);
		
		/**************************************/
	}
}
