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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Jefe Adm <b class="caret"></b></a>
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
                        <a href="HomeJefeAdm.jsp"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
                    <li >
                        <a href="RegistrarSueldo.jsp"><i class="fa fa-fw fa-money"></i> Registrar sueldo profesor por curso.</a>
                    </li>
                    <li class="active">
                        <a href="CrearCurso.jsp"><i class="fa fa-fw fa-plus-square"></i> Crear curso y asignar profesor.</a>
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
                            Crear curso y asignar profesor
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-home"></i>  <a href="HomeJefeAdm.jsp">Inicio</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-plus-square"></i> Crear curso y asignar profesor.
                            </li>
                        </ol>
                    </div>
                </div>

                 <div class="row">
                    <div class="col-sm-5">
                        <h4>Crear curso</h4>
                        <form action=""  >                  
                             <div class="form-group">
                                <label>Ingrese nombre del curso:</label>
                                <input class="form-control"> 
                            </br>
                                <button type="submit" class="btn btn-primary">Crear curso</button> 
                            </div>   
                            
                        </form>
                    </div>
              
                    <div class="col-sm-7">
                        <h4>Asignar profesor</h4>
                        <form action="" >
                             <div class="form-group">
                                <label>Ingrese cÃ³digo del curso:</label>
                                <input class="form-control"> 
                            </div> 
                            <div class="form-group">
                                <label>Ingrese nombre del curso:</label>
                                <input class="form-control"> 
                            </div>    
                            <div class="form-group">
                                <label>Ingrese rut del profesor:</label>
                                <input class="form-control"> 
                            </div> 
                            <button type="submit" class="btn btn-primary">Asignar profesor</button>
                        </form>
                    </div>
                </div>

                

                

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
