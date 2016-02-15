<%@page import="com.alberto.fernandez.diez.webapp.Constantes"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/"><img src="img/logo.svg"
				style="width: 50px; margin-top: -7px" /></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="<%=Constantes.VIEW_INDEX%>">Inicio</a></li>
				<li><a
					href="<%=Constantes.CONTROLLER_CONSUMPTION%>?op=<%=Constantes.OP_NUEVO%>">Añadir</a></li>
				<li><a
					href="<%=Constantes.CONTROLLER_CONSUMPTION%>?op=<%=Constantes.OP_LISTAR%>">Listar</a></li>
				<li><a href="<%=Constantes.CONTROLLER_LOGOUT%>">LogOut</a></li>
			</ul>
		</div>
	</div>
</nav>
<div class="jumbotron">

