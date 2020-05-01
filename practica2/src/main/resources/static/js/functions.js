$("#submitButton").click(function(){
	var origenIda = $("#origenIda").val();
	var destinoIda = $("#destinoIda").val();
	var url = "http://localhost:8080/vuelos/find";
	$.ajax({
		dataType: "json",
		url: url,
		data: {origen: origenIda, destino: destinoIda, fechaSalida: ""}
	}).done(function(data){
		console.log(data);
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
	var aeropuertos = [
		"Madrid Barajas Adolfo Suárez",
		"Barcelona Josep Tarradellas",
		"Valencia Manises"
    ];
    $( "#origenIda" ).autocomplete({
    	minLength: 0,
    	source: aeropuertos
    });
    $( "#destinoIda" ).autocomplete({
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