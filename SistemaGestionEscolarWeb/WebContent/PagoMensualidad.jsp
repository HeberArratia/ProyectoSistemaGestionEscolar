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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Secretaria <b class="caret"></b></a>
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
                        <a href="HomeSecretaria.jsp"><i class="fa fa-fw fa-home"></i> Inicio</a>
                    </li>
                    <li >
                        <a href="PagoMatricula.jsp"><i class="fa fa-fw fa-check-square-o"></i> Registrar pago de matrÃ­cula por estudiante.</a>
                    </li>
                    <li class="active">
                        <a href="PagoMensualidad.jsp"><i class="fa fa-fw fa-check-square-o"></i> Registrar pago de mensualidad por estudiante.</a>
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
                            Pagar mensualidad de estudiante
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-home"></i>  <a href="HomeSecretaria.jsp">Inicio</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-check-square-o"></i> Registrar pago de mensualidad por estudiante.
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                 <div class="row">
                    <div class="col-lg-12">
                        <form action=""  >
                            <label>Ingrese rut del estudiante:</label>
                             <div class="form-inline">
                                <input class="form-control"> 
                                <button type="submit" class="btn btn-primary">Buscar</button> 
                            </div>
                            <p class="help-block">Sin puntos y sin dÃ­gito verificador.</p>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <form action="" >
                            <div class=" alert alert-info" role="alert">
                 <!-- Se muetra la informaciÃ³n del estudiante -->
                                <h4>InformaciÃ³n del estudiante</h4>
                                <p>Nombre: ${nombre}</p>
                                <p>Apellido: ${apellido}</p>
                                <p>Rut: ${rut}</p>
                                <p>Estado MatrÃ­cula: ${estado}</p>
                            </div>
                             <div class="form-group ancho200">
                                <label>Seleccione mes:</label>
                                <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </select>
                            </div>
                             <label for="exampleInput">Monto por curso:</label>
                                 <div class="input-group ancho200">
                                    <div class="input-group-addon">$</div>
                                    <input type="text" class="form-control" id="exampleInputAmount"
                                     placeholder="10.000" disabled>
                                 <div class="input-group-addon">.00</div>
                                </div>
                            </br>
                            <button type="submit" class="btn btn-primary">Pagar mensualidad</button>
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
