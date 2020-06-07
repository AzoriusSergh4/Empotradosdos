$("#submitButton").click(function(){
	var origenIda = $("#origenIda").val();
	var destinoIda = $("#destinoIda").val();
	var fechaSalida = $("#fechaSalida").val();
	var fechaSalidaVuelta = $("#fechaSalidaVuelta").val();
	var url = "http://localhost:8080/vuelos/find";
	console.log(fechaSalidaVuelta);
	
	//Si el usuario ha marcado la casilla de ida y vuelta pero no ha puesto una fecha de vuelta, dará error
	if (($("#idaVuelta").prop('checked')) && (fechaSalidaVuelta == "")){
		//Vaciamos contenido de resultados antes de escribir
		$("#vuelosDisponibles").empty();
		$("#vuelosDisponibles").append("<p class='mensajeError'>No se han encontrado vuelos con esos criterios</p>");
	} 
	
	else{
	 
		$.ajax({
			dataType: "json",
			url: url,
			data: {origen: origenIda, destino: destinoIda, fechaSalida: fechaSalida, fechaSalidaVuelta: fechaSalidaVuelta}
		}).done(function(data){
			//Vaciamos contenido de resultados antes de añadir nuevos resultados
			$("#vuelosDisponibles").empty();
			//Si no hay resultados, se muestra un mensaje notificandolo
			if(data.length == 0){
				$("#vuelosDisponibles").append("<p class='mensajeError'>No se han encontrado vuelos con esos criterios</p>");
			}
			//Si hay resultados, se genera una tabla con los vuelos y su información
			else{
				$("#vuelosDisponibles").append("<table id='tablaVuelos' class='table table-striped table-bordered table-sm sd-table'><tr>"+
					 "<td> Código del vuelo </td>"+
					 "<td> Compañía </td>"+
					 "<td> Código de la compañía </td>"+
					 "<td> Fecha de salida </td>"+
					 "<td> Hora de salida </td>"+
					 "<td> Precio </td>"+
					 "<td> Duración </td>"+
					 "</tr><tbody>");
				//Si el usuario ha elegido vuelo de ida y vuelta
				if ($("#idaVuelta").prop('checked')){
					$.each(data, function(index, vuelo){
						if(vuelo.vueloVuelta != null){
							//Si tiene descuento
							if (vuelo.tieneDescuento){
								$("#tablaVuelos").append("<tr>" +
											"<td class='celda'><div>" + "<p>" + vuelo.vueloIda.codigo + "</p>" + "</div>" + "<div><p>" + vuelo.vueloVuelta.codigo + "</p>" + "</div>" + "</td>" +
											"<td class='celda'><div><a class='sd-row'>" + vuelo.vueloIda.nombreCompania + "</a>" + "</div>" + "<div>" + "<a class='sd-row'>" + vuelo.vueloVuelta.nombreCompania + "</a></div></td>" +
											"<td class='celda'><div><a class='sd-row'>" + vuelo.vueloIda.codigoCompania + "</a>" + "</div>" + "<div>" + "<a class='sd-row'>" + vuelo.vueloVuelta.codigoCompania + "</a></div></td>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.fechaSalida + "</p>" + "<p>" + vuelo.vueloVuelta.fechaSalida + "</p>" + "</td>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.horaSalida + "</p>" + "<p>" + vuelo.vueloVuelta.horaSalida + "</p>" + "</td>" +
											"<td class='celda'><p class ='descuento'>" + "¡20% de descuento!" + "</p>" + "<p>" + vuelo.precioTotal + "€<p>" + "</td>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.duracion +  " min" + "</p>" + "<p>" + vuelo.vueloVuelta.duracion + " min</p></td>" +
									"</tr>");
							
								}
								else{
									$("#tablaVuelos").append("<tr>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.codigo + "</p>" + "<p>" + vuelo.vueloVuelta.codigo + "</p>" + "</td>" +
											"<td class='celda'><div><a class='sd-row'>" + vuelo.vueloIda.nombreCompania + "</a>" + "</div>" + "<div>" + "<a class='sd-row'>" + vuelo.vueloVuelta.nombreCompania + "</a></div></td>" +
											"<td class='celda'><div><a class='sd-row'>" + vuelo.vueloIda.codigoCompania + "</a>" + "</div>" + "<div>" + "<a class='sd-row'>" + vuelo.vueloVuelta.codigoCompania + "</a></div></td>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.fechaSalida + "</p>" + "<p>" + vuelo.vueloVuelta.fechaSalida + "</p>" + "</td>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.horaSalida + "</p>" + "<p>" + vuelo.vueloVuelta.horaSalida + "</p>" + "</td>" +
											"<td class='celda'>" + "<p>" + vuelo.precioTotal + "€</p>" + "</td>" +
											"<td class='celda'>" + "<p>" + vuelo.vueloIda.duracion +  " min" + "</p>" + "<p>" + vuelo.vueloVuelta.duracion + " min</p></td>" +
									"</tr>");
								}
							}
					});
								
				}
				//Si el usuario solo ha elegido un vuelo de ida
				else {
					$.each(data, function(index, vuelo){
						$("#tablaVuelos").append("<tr>" +
								"<td class='celda'>" + vuelo.vueloIda.codigo + "</td>" +
								"<td class='celda'><a class='sd-row'>" + vuelo.vueloIda.nombreCompania + "</a></td>" +
								"<td class='celda'><a class='sd-row'>" + vuelo.vueloIda.codigoCompania + "</a></td>" +
								"<td class='celda'>" + vuelo.vueloIda.fechaSalida + "</td>" +
								"<td class='celda'>" + vuelo.vueloIda.horaSalida + "</td>" +
								"<td class='celda'>" + vuelo.vueloIda.precio + "€</td>" +
								"<td class='celda'>" + vuelo.vueloIda.duracion + " min</td>" +
						"</tr>");
					});
				
				}
			
						
			}
			
		});
		
	}
});



$( function() {
    $( "#dialog" ).dialog({
    	autoOpen: false,
    	modal: true
    });
 });


$(document.body).on("click",".sd-row", function(event){	
	var codigoONombre = event.target.text; //Devuelve el código o nombre de la compañía aérea
	var url = "http://localhost:8080/companias/compania";
	//Llamada ajax al backend para conseguir los datos de la compañía 
	$.ajax({
		dataType: "json",
		url: url,
		data: {codigoONombre: codigoONombre}
	}).done(function(data){
	//Vaciamos contenido de resultados antes de añadir nuevos resultados
		$("#texto-dialogo").empty();
	//Carga los datos en el dialog
		$("#texto-dialogo").append(
				"<p>" + "Nombre: " + data.nombre + "</p>" +
				"<p>" + "Código: " + data.codigo + "</p>" +
				"<p>" + "Teléfono: " + data.telefono + "</p>" +		
				"<p>" + "Web: " + "<a class= 'urlWeb' href=" + "\"" + data.web + "\"" + "target=" + "\"" + "_blank" + "\""  + ">" + data.web + "</a>" +"</p>" +
				"<p>" + "Valoración: " + "<div id='rateYo'></div>" + "</p>"
				);
		 $("#rateYo").rateYo({
		 	numStars: 5,
		 	readOnly: true,
    		rating: data.valoracion    		
  		});		
		$("#dialog").dialog("open");	
		
	});
});




$( function() {
		
    $( ".aeropuertosInput" ).autocomplete({
    	minLength: 0,
    	source: function( request, response ) {
    		var nombre = this.element.val();
	    	$.ajax({
	    		dataType: "json",
	    		url: "http://localhost:8080/aeropuertos/nombres",
	    		data: {nombre: nombre},
	    		success: function(data){
	    			response(data);
	    		}
	    	});
    	}
    });
});


$("#idaVuelta").change(function() {
    if(this.checked) {
        $('#content').show();
    }else{
    	$('#content').hide();
    }
});