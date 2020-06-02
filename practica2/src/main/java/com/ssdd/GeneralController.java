package com.ssdd;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssdd.aeropuerto.Aeropuerto;
import com.ssdd.aeropuerto.AeropuertoRepository;
import com.ssdd.compania.Compania;
import com.ssdd.compania.CompaniaRepository;
import com.ssdd.vuelo.Vuelo;
import com.ssdd.vuelo.VueloRepository;

@Controller
public class GeneralController {
	
	@Autowired
	AeropuertoRepository aeropuertoRepository;
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	@Autowired
	VueloRepository vueloRepository;
	
	/**
	 * Método que inicializa los datos en la base de datos
	 */
	  @PostConstruct
	    public void init() {
		  try {
		    	
	    	SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
	    
	    	//Creación de aeropuertos
	    	Aeropuerto barajas = new Aeropuerto("AAAA", "Madrid Barajas Adolfo Suárez");
	    	Aeropuerto josep = new Aeropuerto("BBBB", "Barcelona Josep Tarradellas");
	    	Aeropuerto manises = new Aeropuerto("CCCC", "Valencia Manises");
	    	Aeropuerto josemarti = new Aeropuerto("HHH", "La Habana José Martí");
	    	Aeropuerto charles = new Aeropuerto("PPP", "París Charles De Gaulle");
	    	Aeropuerto heathrow = new Aeropuerto("LLL", "Londres Heathrow");
	    	Aeropuerto kennedy = new Aeropuerto("JJJ", "Nueva York John F. Kennedy");
	    	aeropuertoRepository.save(barajas);
	    	aeropuertoRepository.save(josep);
	    	aeropuertoRepository.save(manises);
	    	aeropuertoRepository.save(josemarti);
	    	aeropuertoRepository.save(charles);
	    	aeropuertoRepository.save(heathrow);
	    	aeropuertoRepository.save(kennedy);
	    	
	    	//Creación de companias
	    	Compania iberia = new Compania("Iberia", "IB", "https://www.iberia.com/es/", "901111500", 4.5);
	    	companiaRepository.save(iberia);
	    	Compania ryanair = new Compania("Ryanair", "RY", "https://www.ryanair.com/es/es/", "918294840", 3.0);
	    	companiaRepository.save(ryanair);
	    	Compania airFrance = new Compania("Air France", "AF", "https://www.airfrance.es/", "913753335", 4.0);
	    	companiaRepository.save(airFrance);
	    	Compania vueling = new Compania("Vueling Airlines", "VY", "https://www.vueling.com/en", "902808005", 2.5);
	    	companiaRepository.save(vueling);
	    	Compania latam = new Compania("LATAM Airlines", "LA", "https://www.latam.com/es_es/", "912158094", 3.5);
	    	companiaRepository.save(latam);
	    	
	    	//Creación de vuelos
	    	
	    	//Madrid-Barcelona
	    	Vuelo v1 = new Vuelo("IB1111", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("10:00:00"), 60, 345, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), josep.getNombre());
	    	vueloRepository.save(v1);
	    	Vuelo v2 = new Vuelo("RY2222", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("15:00:00"), 60, 345, ryanair.getNombre(), ryanair.getCodigo(), barajas.getNombre(), josep.getNombre());
	    	vueloRepository.save(v2);
	    	Vuelo v3 = new Vuelo("IB3333", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("18:00:00"), 60, 445, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), josep.getNombre());
	    	vueloRepository.save(v3);
	    	Vuelo v4 = new Vuelo("IB4444", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("21:00:00"), 60, 330, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), josep.getNombre());
	    	vueloRepository.save(v4);
	    	Vuelo v5 = new Vuelo("RY5555", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("23:00:00"), 60, 245, ryanair.getNombre(), ryanair.getCodigo(), barajas.getNombre(), josep.getNombre());
	    	vueloRepository.save(v5);
	    	
	    	//Barcelona-Madrid
	    	Vuelo v6 = new Vuelo("RY6666", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("10:00:00"), 60, 145, ryanair.getNombre(), ryanair.getCodigo(), josep.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v6);
	    	Vuelo v7 = new Vuelo("RY7777", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("15:00:00"), 60, 230, ryanair.getNombre(), ryanair.getCodigo(), josep.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v7);
	    	Vuelo v8 = new Vuelo("IB8888", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("18:00:00"), 60, 545, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v8);
	    	Vuelo v9 = new Vuelo("IB9999", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("21:00:00"), 60, 345, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v9);
	    	Vuelo v10 = new Vuelo("RY1010", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("23:00:00"), 60, 245, ryanair.getNombre(), ryanair.getCodigo(), josep.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v10);
	    	
	    	
	    	//Madrid-Valencia
	    	Vuelo v11 = new Vuelo("IB1212", new Date(fecha.parse("09/06/2020").getTime()), Time.valueOf("10:00:00"), 60, 345, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), manises.getNombre());
	    	vueloRepository.save(v11);
	    	Vuelo v12 = new Vuelo("VY1313", new Date(fecha.parse("16/06/2020").getTime()), Time.valueOf("15:00:00"), 60, 245, vueling.getNombre(), vueling.getCodigo(), barajas.getNombre(), manises.getNombre());
	    	vueloRepository.save(v12);
	    	Vuelo v13 = new Vuelo("IB1414", new Date(fecha.parse("09/06/2020").getTime()), Time.valueOf("18:00:00"), 60, 445, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), manises.getNombre());
	    	vueloRepository.save(v13);
	    	Vuelo v14 = new Vuelo("IB1515", new Date(fecha.parse("16/06/2020").getTime()), Time.valueOf("21:00:00"), 60, 330, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), manises.getNombre());
	    	vueloRepository.save(v14);
	    	Vuelo v15 = new Vuelo("VY1616", new Date(fecha.parse("09/06/2020").getTime()), Time.valueOf("23:00:00"), 60, 145, vueling.getNombre(), vueling.getCodigo(), barajas.getNombre(), manises.getNombre());
	    	vueloRepository.save(v15);
	    	
	    	
	    	//Valencia-Madrid
	    	Vuelo v16 = new Vuelo("IB1717", new Date(fecha.parse("16/06/2020").getTime()), Time.valueOf("10:00:00"), 60, 345, iberia.getNombre(), iberia.getCodigo(), manises.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v16);
	    	Vuelo v17 = new Vuelo("VY1818", new Date(fecha.parse("09/06/2020").getTime()), Time.valueOf("15:00:00"), 60, 245, vueling.getNombre(), vueling.getCodigo(), manises.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v17);
	    	Vuelo v18 = new Vuelo("IB1919", new Date(fecha.parse("16/06/2020").getTime()), Time.valueOf("18:00:00"), 60, 445, iberia.getNombre(), iberia.getCodigo(), manises.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v18);
	    	Vuelo v19 = new Vuelo("VY2020", new Date(fecha.parse("09/06/2020").getTime()), Time.valueOf("21:00:00"), 60, 330, vueling.getNombre(), vueling.getCodigo(), manises.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v19);
	    	Vuelo v20 = new Vuelo("VY2121", new Date(fecha.parse("16/06/2020").getTime()), Time.valueOf("23:00:00"), 60, 145, vueling.getNombre(), vueling.getCodigo(), manises.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v20);
	    	
	    	
	    	//Madrid-París	
	    	Vuelo v21 = new Vuelo("IB2323", new Date(fecha.parse("25/08/2020").getTime()), Time.valueOf("10:00:00"), 120, 345, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), charles.getNombre());
	    	vueloRepository.save(v21);
	    	Vuelo v22 = new Vuelo("AF2424", new Date(fecha.parse("12/09/2020").getTime()), Time.valueOf("15:00:00"), 120, 245, airFrance.getNombre(), airFrance.getCodigo(), barajas.getNombre(), charles.getNombre());
	    	vueloRepository.save(v22);
	    	Vuelo v23 = new Vuelo("IB2525", new Date(fecha.parse("25/08/2020").getTime()), Time.valueOf("18:00:00"), 120, 445, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), charles.getNombre());
	    	vueloRepository.save(v23);
	    	Vuelo v24 = new Vuelo("IB2626", new Date(fecha.parse("12/09/2020").getTime()), Time.valueOf("21:00:00"), 120, 330, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), charles.getNombre());
	    	vueloRepository.save(v24);
	    	Vuelo v25 = new Vuelo("AF2727", new Date(fecha.parse("25/08/2020").getTime()), Time.valueOf("23:00:00"), 120, 145, airFrance.getNombre(), airFrance.getCodigo(), barajas.getNombre(), charles.getNombre());
	    	vueloRepository.save(v25);
	    	
	
	    	//París-Madrid
	    	Vuelo v26 = new Vuelo("IB2828", new Date(fecha.parse("12/09/2020").getTime()), Time.valueOf("10:00:00"), 120, 345, iberia.getNombre(), iberia.getCodigo(), charles.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v26);
	    	Vuelo v27 = new Vuelo("AF2929", new Date(fecha.parse("25/08/2020").getTime()), Time.valueOf("15:00:00"), 120, 245, airFrance.getNombre(), airFrance.getCodigo(), charles.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v27);
	    	Vuelo v28 = new Vuelo("IB3030", new Date(fecha.parse("12/09/2020").getTime()), Time.valueOf("18:00:00"), 120, 445, iberia.getNombre(), iberia.getCodigo(), charles.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v28);
	    	Vuelo v29 = new Vuelo("AF3131", new Date(fecha.parse("25/08/2020").getTime()), Time.valueOf("21:00:00"), 120, 190, airFrance.getNombre(), airFrance.getCodigo(), charles.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v29);
	    	Vuelo v30 = new Vuelo("AF3232", new Date(fecha.parse("12/09/2020").getTime()), Time.valueOf("23:00:00"), 120, 145, airFrance.getNombre(), airFrance.getCodigo(), charles.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v30);
	    	
	    	
	    	//Barcelona-París
	    	Vuelo v31 = new Vuelo("IB3434", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("10:00:00"), 120, 345, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), charles.getNombre());
	    	vueloRepository.save(v31);
	    	Vuelo v32 = new Vuelo("AF3535", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("15:00:00"), 120, 245, airFrance.getNombre(), airFrance.getCodigo(), josep.getNombre(), charles.getNombre());
	    	vueloRepository.save(v32);
	    	Vuelo v33 = new Vuelo("IB3636", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("18:00:00"), 120, 445, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), charles.getNombre());
	    	vueloRepository.save(v33);
	    	Vuelo v34 = new Vuelo("IB3737", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("21:00:00"), 120, 330, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), charles.getNombre());
	    	vueloRepository.save(v34);
	    	Vuelo v35 = new Vuelo("AF3838", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("23:00:00"), 120, 145, airFrance.getNombre(), airFrance.getCodigo(), josep.getNombre(), charles.getNombre());
	    	vueloRepository.save(v35);
	    	
	    	
	    	//París-Barcelona
	    	Vuelo v36 = new Vuelo("IB1111", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("10:00:00"), 120, 345, iberia.getNombre(), iberia.getCodigo(), charles.getNombre(), josep.getNombre());
	    	vueloRepository.save(v36);
	    	Vuelo v37 = new Vuelo("AF3232", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("15:00:00"), 120, 245, airFrance.getNombre(), airFrance.getCodigo(), charles.getNombre(), josep.getNombre());
	    	vueloRepository.save(v37);
	    	Vuelo v38 = new Vuelo("IB3333", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("18:00:00"), 120, 445, iberia.getNombre(), iberia.getCodigo(), charles.getNombre(), josep.getNombre());
	    	vueloRepository.save(v38);
	    	Vuelo v39 = new Vuelo("AF3232", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("21:00:00"), 120, 190, airFrance.getNombre(), airFrance.getCodigo(), charles.getNombre(), josep.getNombre());
	    	vueloRepository.save(v39);
	    	Vuelo v40 = new Vuelo("AF3232", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("23:00:00"), 120, 145, airFrance.getNombre(), airFrance.getCodigo(), charles.getNombre(), josep.getNombre());
	    	vueloRepository.save(v40);
	    	
	    	
	    	//Madrid-Londres
	    	Vuelo v41 = new Vuelo("IB3434", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("10:00:00"), 180, 345, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v41);
	    	Vuelo v42 = new Vuelo("VY3535", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("15:00:00"), 180, 245, vueling.getNombre(), vueling.getCodigo(), barajas.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v42);
	    	Vuelo v43 = new Vuelo("IB3636", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("18:00:00"), 180, 445, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v43);
	    	Vuelo v44 = new Vuelo("IB3737", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("21:00:00"), 180, 330, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v44);
	    	Vuelo v45 = new Vuelo("VY3838", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("23:00:00"), 180, 245, vueling.getNombre(), vueling.getCodigo(), barajas.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v45);
	    	
	    	
	    	//Londres-Madrid
	    	Vuelo v46 = new Vuelo("IB3939", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("10:00:00"), 180, 345, iberia.getNombre(), iberia.getCodigo(), heathrow.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v46);
	    	Vuelo v47 = new Vuelo("VY40404", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("15:00:00"), 180, 245, vueling.getNombre(), vueling.getCodigo(), heathrow.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v47);
	    	Vuelo v48 = new Vuelo("IB4141", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("18:00:00"), 180, 445, iberia.getNombre(), iberia.getCodigo(), heathrow.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v48);
	    	Vuelo v49 = new Vuelo("VY4242", new Date(fecha.parse("30/06/2020").getTime()), Time.valueOf("21:00:00"), 180, 190, vueling.getNombre(), vueling.getCodigo(), heathrow.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v49);
	    	Vuelo v50 = new Vuelo("VY4343", new Date(fecha.parse("07/07/2020").getTime()), Time.valueOf("23:00:00"), 180, 145, vueling.getNombre(), vueling.getCodigo(), heathrow.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v50);
	    	
	    	
	    	//Barcelona-Londres
	    	Vuelo v51 = new Vuelo("IB4545", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("10:00:00"), 180, 345, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v51);
	    	Vuelo v52 = new Vuelo("RY4646", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("15:00:00"), 180, 345, ryanair.getNombre(), ryanair.getCodigo(), josep.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v52);
	    	Vuelo v53 = new Vuelo("IB4747", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("18:00:00"), 180, 445, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v53);
	    	Vuelo v54 = new Vuelo("IB4848", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("21:00:00"), 180, 330, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v54);
	    	Vuelo v55 = new Vuelo("RY4949", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("23:00:00"), 180, 245, ryanair.getNombre(), ryanair.getCodigo(), josep.getNombre(), heathrow.getNombre());
	    	vueloRepository.save(v55);
	    	
	    	
	    	//Londres-Barcelona
	    	Vuelo v56 = new Vuelo("IB5050", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("10:00:00"), 180, 345, iberia.getNombre(), iberia.getCodigo(), heathrow.getNombre(), josep.getNombre());
	    	vueloRepository.save(v56);
	    	Vuelo v57 = new Vuelo("RY5151", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("15:00:00"), 180, 345, ryanair.getNombre(), ryanair.getCodigo(), heathrow.getNombre(), josep.getNombre());
	    	vueloRepository.save(v57);
	    	Vuelo v58 = new Vuelo("IB5252", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("18:00:00"), 180, 445, iberia.getNombre(), iberia.getCodigo(), heathrow.getNombre(), josep.getNombre());
	    	vueloRepository.save(v58);
	    	Vuelo v59 = new Vuelo("IB5353", new Date(fecha.parse("31/05/2020").getTime()), Time.valueOf("21:00:00"), 180, 330, iberia.getNombre(), iberia.getCodigo(), heathrow.getNombre(), josep.getNombre());
	    	vueloRepository.save(v59);
	    	Vuelo v60 = new Vuelo("RY5454", new Date(fecha.parse("07/06/2020").getTime()), Time.valueOf("23:00:00"), 180, 245, ryanair.getNombre(), ryanair.getCodigo(), heathrow.getNombre(), josep.getNombre());
	    	vueloRepository.save(v60);
	    	
	    	
	    	//Madrid-Nueva York
	    	Vuelo v61 = new Vuelo("IB5656", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("10:00:00"), 240, 545, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v61);
	    	Vuelo v62 = new Vuelo("RY5757", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("15:00:00"), 240, 445, ryanair.getNombre(), ryanair.getCodigo(), barajas.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v62);
	    	Vuelo v63 = new Vuelo("IB5858", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("18:00:00"), 240, 645, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v63);
	    	Vuelo v64 = new Vuelo("IB5959", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("21:00:00"), 240, 430, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v64);
	    	Vuelo v65 = new Vuelo("RY6060", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("23:00:00"), 240, 345, ryanair.getNombre(), ryanair.getCodigo(), barajas.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v65);
	    	
	    	
	    	//Nueva York - Madrid
	    	Vuelo v66 = new Vuelo("IB6161", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("10:00:00"), 240, 545, iberia.getNombre(), iberia.getCodigo(), kennedy.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v66);
	    	Vuelo v67 = new Vuelo("RY6262", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("15:00:00"), 240, 445, ryanair.getNombre(), ryanair.getCodigo(), kennedy.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v67);
	    	Vuelo v68 = new Vuelo("IB6363", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("18:00:00"), 240, 645, iberia.getNombre(), iberia.getCodigo(), kennedy.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v68);
	    	Vuelo v69 = new Vuelo("RY6464", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("21:00:00"), 240, 420, ryanair.getNombre(), ryanair.getCodigo(), kennedy.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v69);
	    	Vuelo v70 = new Vuelo("RY6565", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("23:00:00"), 240, 345, ryanair.getNombre(), ryanair.getCodigo(), kennedy.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v70);
	    	
	    	
	    	//Barcelona - Nueva York
	    	Vuelo v71 = new Vuelo("IB6767", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("10:00:00"), 240, 545, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v71);
	    	Vuelo v72 = new Vuelo("VY6868", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("15:00:00"), 240, 445, vueling.getNombre(), vueling.getCodigo(), josep.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v72);
	    	Vuelo v73 = new Vuelo("IB6969", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("18:00:00"), 240, 645, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v73);
	    	Vuelo v74 = new Vuelo("IB7070", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("21:00:00"), 240, 430, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v74);
	    	Vuelo v75 = new Vuelo("VY7171", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("23:00:00"), 240, 345, vueling.getNombre(), vueling.getCodigo(), josep.getNombre(), kennedy.getNombre());
	    	vueloRepository.save(v75);
	    	
	    	
	    	//Nueva York- Barcelona
	    	Vuelo v76 = new Vuelo("IB7272", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("10:00:00"), 240, 545, iberia.getNombre(), iberia.getCodigo(), kennedy.getNombre(), josep.getNombre());
	    	vueloRepository.save(v76);
	    	Vuelo v77 = new Vuelo("VY7373", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("15:00:00"), 240, 445, vueling.getNombre(), vueling.getCodigo(), kennedy.getNombre(), josep.getNombre());
	    	vueloRepository.save(v77);
	    	Vuelo v78 = new Vuelo("IB7474", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("18:00:00"), 240, 645, iberia.getNombre(), iberia.getCodigo(), kennedy.getNombre(), josep.getNombre());
	    	vueloRepository.save(v78);
	    	Vuelo v79 = new Vuelo("VY7575", new Date(fecha.parse("03/07/2020").getTime()), Time.valueOf("21:00:00"), 240, 430, vueling.getNombre(), vueling.getCodigo(), kennedy.getNombre(), josep.getNombre());
	    	vueloRepository.save(v79);
	    	Vuelo v80 = new Vuelo("VY7676", new Date(fecha.parse("10/07/2020").getTime()), Time.valueOf("23:00:00"), 240, 320, vueling.getNombre(), vueling.getCodigo(), kennedy.getNombre(), josep.getNombre());
	    	vueloRepository.save(v80);
	    	
	    	
	    	//Madrid- La Habana
	    	Vuelo v81 = new Vuelo("IB7878", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("10:00:00"), 300, 545, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v81);
	    	Vuelo v82 = new Vuelo("LA7979", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("15:00:00"), 300, 445, latam.getNombre(), latam.getCodigo(), barajas.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v82);
	    	Vuelo v83 = new Vuelo("IB8080", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("18:00:00"), 300, 745, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v83);
	    	Vuelo v84 = new Vuelo("IB8181", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("21:00:00"), 300, 430, iberia.getNombre(), iberia.getCodigo(), barajas.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v84);
	    	Vuelo v85 = new Vuelo("LA8282", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("23:00:00"), 300, 345, latam.getNombre(), latam.getCodigo(), barajas.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v85);
	    	
	    	
	    	//La Habana-Madrid
	    	Vuelo v86 = new Vuelo("IB8383", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("10:00:00"), 300, 545, iberia.getNombre(), iberia.getCodigo(), josemarti.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v86);
	    	Vuelo v87 = new Vuelo("LA8484", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("15:00:00"), 300, 445, latam.getNombre(), latam.getCodigo(), josemarti.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v87);
	    	Vuelo v88 = new Vuelo("IB8585", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("18:00:00"), 300, 745, iberia.getNombre(), iberia.getCodigo(), josemarti.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v88);
	    	Vuelo v89 = new Vuelo("LA8686", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("21:00:00"), 300, 430, latam.getNombre(), latam.getCodigo(), josemarti.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v89);
	    	Vuelo v90 = new Vuelo("LA8787", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("23:00:00"), 300, 345, latam.getNombre(), latam.getCodigo(), josemarti.getNombre(), barajas.getNombre());
	    	vueloRepository.save(v90);
	    	
	    	
	    	//Barcelona-La Habana
	    	Vuelo v91 = new Vuelo("IB8989", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("10:00:00"), 300, 545, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v91);
	    	Vuelo v92 = new Vuelo("LA9090", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("15:00:00"), 300, 445, latam.getNombre(), latam.getCodigo(), josep.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v92);
	    	Vuelo v93 = new Vuelo("IB9191", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("18:00:00"), 300, 745, iberia.getNombre(), iberia.getCodigo(), josep.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v93);
	    	Vuelo v94 = new Vuelo("LA9292", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("21:00:00"), 300, 430, latam.getNombre(), latam.getCodigo(), josep.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v94);
	    	Vuelo v95 = new Vuelo("LA9393", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("23:00:00"), 300, 345, latam.getNombre(), latam.getCodigo(), josep.getNombre(), josemarti.getNombre());
	    	vueloRepository.save(v95);
	    	
	    	
	    	//La Habana-Barcelona
	    	Vuelo v96 = new Vuelo("IB9494", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("10:00:00"), 300, 545, iberia.getNombre(), iberia.getCodigo(), josemarti.getNombre(), josep.getNombre());
	    	vueloRepository.save(v96);
	    	Vuelo v97 = new Vuelo("LA9595", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("15:00:00"), 300, 445, latam.getNombre(), latam.getCodigo(), josemarti.getNombre(), josep.getNombre());
	    	vueloRepository.save(v97);
	    	Vuelo v98 = new Vuelo("IB9696", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("18:00:00"), 300, 745, iberia.getNombre(), iberia.getCodigo(), josemarti.getNombre(), josep.getNombre());
	    	vueloRepository.save(v98);
	    	Vuelo v99 = new Vuelo("LA9797", new Date(fecha.parse("01/12/2020").getTime()), Time.valueOf("21:00:00"), 300, 430, latam.getNombre(), latam.getCodigo(), josemarti.getNombre(), josep.getNombre());
	    	vueloRepository.save(v99);
	    	Vuelo v100 = new Vuelo("LA9898", new Date(fecha.parse("08/12/2020").getTime()), Time.valueOf("23:00:00"), 300, 345, latam.getNombre(), latam.getCodigo(), josemarti.getNombre(), josep.getNombre());
	    	vueloRepository.save(v100);
	    	
	    	
		  } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	

	@GetMapping("/")
	public String getPage(Model model) {
		return "index";
	}
}
