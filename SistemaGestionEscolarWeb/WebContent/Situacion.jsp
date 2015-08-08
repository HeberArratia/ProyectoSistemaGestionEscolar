<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Heber Arratia">

    <title>Sistema Gestión</title>

    <!-- Mi CSS -->
    <link href="css/skeleton.css" rel="stylesheet">
   
    <link href="css/estilosas.css" rel="stylesheet">


    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="http://fonts.googleapis.com/css?family=Raleway:100" rel="stylesheet" type="text/css">

    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

</head>

<body>
    <h1 class=""> <i class="fa fa-mortar-board fa-1x "></i> Sistema Gestión Escolar</h1>
    <div class="panel">
        <h3>Bienvenido:</h3>
        <form action="ObtenerSituacion" method="post">
        <label>Ingrese rut estudiante:</label>
      	<input name="rut" class="u-full-width" type="text" placeholder="Sin puntos y sin dígito verificador" required>
        <input class="boton" type="submit" value="Ingresar">
        </form>
        <div class="respuesta">
        	${resultado}
        </div>
    </div>
    
    <footer><i class="fa fa-code fa-1x"></i> By Heber Arratia - Powered by Java EE</footer>

</body>

</html>
