<%@page import="servicio.ServicioMensualidadProxy"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
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
    <link href="css/main.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

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

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">
                    <i class="fa fa-mortar-board fa-1x"></i>
                    Sistema Gestión Escolar</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                
                <!-- Usuario -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Director <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i>Ver perfil</a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Cerrar Sesion</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li >
                        <a href="HomeDirector.jsp"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
                    <li >
                        <a href="ObtenerMorososMatricula.jsp"><i class="fa fa-fw fa-bar-chart-o"></i> Obtener reporte estudiantes morosos en los pagos de matrícula.</a>
                    </li>
                    <li class="active">
                        <a href="ObtenerMorososMensualidad.jsp"><i class="fa fa-fw fa-bar-chart-o"></i> Obtener reporte estudiantes morosos en los pagos de mensualidad.</a>
                    </li>
                    <li>
                        <a href="ConocerPagosProfesores.jsp"><i class="fa fa-fw fa-table"></i> Conocer pagos profesores por curso y si fue realizado.</a>
                    </li>
                    <li>
                        <a href="DesactivarCurso.jsp"><i class="fa fa-fw fa-minus-circle"></i> Desactivar curso.</a>
                    </li>
                    <li>
                        <a href="BalanceIngresoGasto.jsp"><i class="fa fa-fw fa-line-chart"></i>  Obtener balance de ingreso y gasto.</a>
                    </li>
                </ul>

            </div>
            <!-- /.navbar-collapse -->

        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Estudiantes morosos pagos de mensualidad
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-home"></i>  <a href="HomeDirector.jsp">Inicio</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Obtener reporte estudiantes morosos en los pagos de mensualidad.
                            </li>
                        </ol>
                    </div>
                </div>
                
                <!-- /.row -->
				<div class="row">
                    <div class="col-lg-12">
                        <form action="ObtenerMensualidades" method="post" >
                            <label>Ingrese mes actual:</label>
                             <div class="form-inline">
                                 <input name="mes" class="form-control" required> 
                                <button type="submit" class="btn btn-primary">Obtener mensualidades</button> 
                            </div>
                        </form>
                    </div>
                </div>
              
		<% 
        	Gson gson = new Gson();
        	String json= (String)request.getAttribute("json");
        	String[][] datos;
       if (json!=null){
        	if (json.equals("Error, intente nuevamente")){ %>
        		<p>Error, intente nuevamente</p>
        <% } else {
        	datos = gson.fromJson(json, String[][].class); %>
        	
      <!-- /.row -->
				<div class="row">
                    <div class="col-lg-12">
                    <table class="table table-bordered table-hover">
                    	  <thead>
                             <tr>
                            	<th>Estudiante</th>
                                <th>Rut</th>
                                <th>Mes</th>
                                <th>Deuda</th>  
                              </tr>
                           </thead>
                    	
                   		<tbody>
                   		<%
						// Se reccore el arreglo y se muestra en cada celda c/u de los datos de un estudiante
						for(int i=0;i<datos.length;i++){ %>	
							<tr>
  								<td><%= datos[i][0] %></td>
  								<td><%= datos[i][1] %></td>
  								<td><%= datos[i][2] %></td>
  								<td><%= "$"+datos[i][3] %></td>
							</tr>
						<% } %>
                   		</tbody>
                     </table>
                    
                     </div>
                </div>   
                <!-- /.row -->
          <% } %>  
      <% } %>        
                

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

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
