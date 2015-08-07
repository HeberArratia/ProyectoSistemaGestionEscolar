<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Heber Arratia">

    <title>Gestor Educacional</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Mi CSS -->
      <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
     <link href="css/estilosindex.css" rel="stylesheet">


    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="http://fonts.googleapis.com/css?family=Raleway:100" rel="stylesheet" type="text/css">

    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <h1 class=""> <i class="fa fa-mortar-board fa-1x "></i>Sistema Gestión Escolar</h1>
    <h3>INICIA SESIÓN</h3>
    <!-- INICIO FORMULARIO -->
    <form action="LoginUsuario" class="animated fadeInUp" method="post">
        <div id="contenInput">
            <div class="form-group">
                <input name="rut" class="form-control" placeholder="Rut (sin puntos ni guión)"> 
            </div>
            
            <div class="form-group">
                <input name="pass" type="password" class="form-control" placeholder="Contraseña"> 
            </div>

        </div>
        <button type="submit" class="miBoton button text-center">INGRESAR</button> 
      
    </form>
    </br>
    <p class="animated fadeInUp">${mensajeerror}</p>
      
    <footer><i class="fa fa-code fa-1x"></i>  By Heber Arratia</footer>
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>
   

</body>

</html>
