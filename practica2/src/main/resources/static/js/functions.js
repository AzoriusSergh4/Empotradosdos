$("#submitButton").click(function(){
	var origenIda = $("#origenIda").val();
	var destinoIda = $("#destinoIda").val();
	var fechaSalida = $("#fechaSalida").val();
	var url = "http://localhost:8080/vuelos/find";
	$.ajax({
		dataType: "json",
		url: url,
		data: {origen: origenIda, destino: destinoIda, fechaSalida: fechaSalida}
	}).done(function(data){
		console.log(data);
		//Vaciamos contenido de resultados antes de añadir nuevos resultados
		$("#vuelosDisponibles").empty();
		//Si no hay resultados, se muestra un mensaje notificandolo
		if(data.length == 0){
			$("#vuelosDisponibles").append("<p>No se han encontrado vuelos con esos criterios</p>");
		}
		//Si hay resultados, se genera una tabla con los vuelos y su información
		else{
			$("#vuelosDisponibles").append("<table id='tablaVuelos' class='table table-striped table-bordered table-sm sd-table'><tbody>");
			$.each(data, function(index, vuelo){
				$("#tablaVuelos").append("<tr>" +
						"<td>" + vuelo.vueloIda.codigo + "</td>" +
						"<td><a class='sd-row'>" + vuelo.vueloIda.compania.nombre + "</a></td>" +
						"<td><a class='sd-row'>" + vuelo.vueloIda.compania.codigo + "</a></td>" +
						"<td>" + vuelo.vueloIda.fechaSalida + "</td>" +
						"<td>" + vuelo.vueloIda.horaSalida + "</td>" +
						"<td>" + vuelo.vueloIda.precio + "€</td>" +
						"<td>" + vuelo.vueloIda.duracion + " min</td>" +
				"</tr>");
			});		
		}
		
	});
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
				"<p>" + "Web: " + "<a href=" + "\"" + data.web + "\"" + "target=" + "\"" + "_blank" + "\""  + ">" + data.web + "</a>" +"</p>" +
				"<p>" + "Valoración: " + "<div id=" + "\"" + "rateYo" + "\"" + "></div>" + "</p>"
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