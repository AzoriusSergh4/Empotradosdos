$("#submitButton").click(function(){
	var origenIda = $("#origenIda").val();
	var destinoIda = $("#destinoIda").val();
	var fechaSalida = $("#fechaSalida").val();
	console.log(fechaSalida);
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
						"<td>" + vuelo.codigo + "</td>" +
						"<td>" + vuelo.compania.nombre + "</td>" +
						"<td>" + vuelo.fechaSalida + "</td>" +
						"<td>" + vuelo.horaSalida + "</td>" +
						"<td>" + vuelo.precio + "€</td>" +
						"<td>" + vuelo.duracion + " min</td>" +
				"</tr>");
			});		
		}
		
	});
});



$( function() {
	var aeropuertos = [];
	
	function callback(response){
		aeropuertos = response;
	}
	
	$.ajax({
		dataType: "json",
		url: "http://localhost:8080/aeropuertos/nombres",
		success: function(data){
			console.log(data);
			callback(data);
		}
	});
	
    $( ".aeropuertosInput" ).autocomplete({
    	minLength: 0,
    	source: aeropuertos
    });
});


$("#idaVuelta").change(function() {
    if(this.checked) {
        $('#content').show();
    }else{
    	$('#content').hide();
    }
});