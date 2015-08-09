// Almacenamos las funcionalidades en variables
//Requerimos el framework express / requerimos la funcionalidad express
var express = require('express');
// Requerimos la funcionalidad SOAP
var soap = require('soap');

//Requerimos a bodyParser para filtrar respuestas de formulario
//Filtraremos los parametros que vengan de formulario
var bodyParser = require('body-parser');

//Guardamos express en la variable app
var app = express();

//Comunicamos que el engine de las vistas es Jade
app.set("view engine","jade");

//Le diremos a express que vamos a utilizar bodyParser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

//Carpeta donde guardar recursos de la aplicacion (imgs,css,js...s)
app.use(express.static("public"));

//Recibimos peticiones en la url "/" via GET
//Cuando se cumple que el usuario ingresa a esta url ejecutamos la funcion anonima
app.get("/",function(req,res){
    //Direccionamos a bienvenido.jsp
    res.render("bienvenido");
});

//Recibimos peticiones en la url "/mostrar" via POST
//Cuando se cumple que el usuario ingresa a esta url ejecutamos la funcion anonima
app.post("/mostrar",function(req,res){
  //Obtenemos el rut
 var rut = req.body.rut;
 console.log(rut);
 // Asignamos a la variable "url" la direccion del servicio wsdl
 var url = 'http://localhost:8080/SistemaGestionEscolarServicio/services/ServicioEstudiante?wsdl';
 // Definimos el parametro a enviar al servicio en formato JSON
 var args = {numero: rut};
 	// Creamos el cliente que consume el servicio
 	soap.createClient(url, function(err, client) {
 	//Requerimos la funcion y enviamos los parametros
      client.obtenerSituacionEstudiante(args, function(err, result) {
      	if(err){console.log("Error en el servicio");}
      	//Imprimimos el resultado que devolvio el servicio
        console.log(result);
        resultado = result.obtenerSituacionEstudianteReturn;
        console.log("es? " + resultado);
        // Enviamos los datos a mostrar.jade
        res.render("mostrarSituacion",{situaciones: result.obtenerSituacionEstudianteReturn}); // (No añadimos formato puesto que ya lo indicamos)
      });
  });
	
});

//Creamos el puerto para acceder al servidor
app.listen(7070);

