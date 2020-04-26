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
		$.each(data, function(index, value){
			
		});
	});
});



 $( function() {
    var availableTags = [
     "Madrid Barajas Adolfo Suárez"
     "Barcelona Josep Tarradellas"
     "Valencia Manises"
    ];
    $( "#aeropuertoSalida" ).autocomplete({
      source: availableTags
    });
  } );
      $( "#aeropuertoDestino" ).autocomplete({
      source: availableTags
    });
  } );