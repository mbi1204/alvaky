<%@ include file="header.jsp" %>
	<%@ include file="menu.jsp" %>
	<div class="content" id="content">
		<div class="sample">
			<div class="name">${sample_name}</div>
			<div class="dsc">${sample_dsc}</div>
			<div class="clear"></div>
		</div>
		<div class="scheduler" id="scheduler">${body}</div>
	</div>
	
	<script type="text/javascript" src = "codebase/js/lib/jquery-3.1.0.js"></script>
	<script type="text/javascript" src = "codebase/js/validacion.js"></script>
	<script type="text/javascript" src = "codebase/js/reporteEjecutivo.js"></script>
	<script src="codebase/js/lib/sweetalert.min.js"></script>
</body>
</html>