function validar(){
	var user = document.getElementById("usuario").value;
	var password = document.getElementById("contraseña").value;

	if(user.length < 1){
		alert("Ingrese el correo");
		return false;
	}
	else{
		if(password.length < 1){
			alert("Ingrese la contraseña")
			return false;
		}
	}

	if (user === "Julian", "julian", "julesteban2003@gmail.com" && password === "1002525126"){
		alert("Exitoso","succes")
		window.location = "/index";
	}
	else if(user === "Geraldin", "geraldin","rosasgeraldine0@gmail.com" && password === "445587"){
			alert("Exitoso","succes")

			window.location="/";
		} else if(user === "Laura", "laura","lauradsanchezv09@gmail.com" && password === "09092"){
			alert("Exitoso","succes")
			
			window.location="/index";
		}

		else{
			alert("Error de validacion")
		}


}