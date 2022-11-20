function enviar() {
	swal({
		title: "Esta seguro de guardar este producto?",
		text: "Asegurese que los datos sean correcto",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("Su producto ha sido guardado correctamente", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado guardar su producto");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}

function comprobar() {
	swal({
		title: "Esta seguro que desea guardar la modificacion?",
		text: "Verifique que los datos sean correctos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("El producto se ha modificado correctamente", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado la modificación");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}

function Ssesion() {
	swal({
		title: "Esta seguro que desea guardar la modificacion?",
		text: "Verifique que los datos sean correctos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("El producto se ha modificado correctamente", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado la modificación");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}

function verifi() {
	swal({
		title: "Esta seguro que desea enviar esta solicitud?",
		text: "Verifique que los datos sean correctos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("Se ha enviado la solicitud", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado la solicitud");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}


function venta() {
	swal({
		title: "Desea registrar esta venta?",
		text: "Verifique que los datos sean correctos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("Se ha registrado correctamente", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado el registro");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}

function cotizacion() {
	swal({
		title: "Seguro desea enviar la solicitud?",
		text: "Verifique que los datos sean correctos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("Se ha enviado correctamente", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado la solicitud");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}





function method() {
	swal({
		title: "Seguro desea guardar los cambios?",
		text: "Verifique que los datos sean correctos",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			swal("Guardado correcto", {
				icon: "success",
			});
		} else {
			swal("Ha cancelado la modificación");
		}
	});
}

function cancelar(){
	swal("Esta seguro?", {
		dangerMode: true,
		buttons: true,
	});
}




