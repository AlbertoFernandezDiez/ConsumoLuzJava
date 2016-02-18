<%@page import="com.alberto.fernandez.diez.webapp.Constantes"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" ><img src="img/logo.svg"
				style="width: 50px; margin-top: -7px" /></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="<%=Constantes.VIEW_INDEX%>"><span><i class="fa fa-home"></i></span>
						Inicio</a></li>
				<li><a
					href="<%=Constantes.CONTROLLER_CONSUMPTION%>?op=<%=Constantes.OP_NUEVO%>"><span><i
							class="fa fa-plus"></i></span> Añadir</a></li>
				<li><a
					href="<%=Constantes.CONTROLLER_CONSUMPTION%>?op=<%=Constantes.OP_LISTAR%>"><span><i
							class="fa fa-list"></i> </span> Listar</a></li>
			</ul>
			<ul class="nav navbar-nav pull-right">
				<li><a target="_blank" href="documentacion.jsp"><span><i
							class="fa fa-book"></i> </span> Documentación</a></li>
				<li><a href="<%=Constantes.CONTROLLER_LOGOUT%>"><span><i
							class="fa fa-sign-out"></i></span> LogOut</a></li>

			</ul>
		</div>
	</div>
</nav>
<div class="jumbotron">