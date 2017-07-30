<%@attribute name="extraScripts" fragment="true" %>
<%@attribute name="extraStyles" fragment="true" %>
<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content=""/>
<meta name="author" content="Roberto Fonseca Alves - roberto@rhfactor.com.br">
<link rel="icon" type="image/png" href="<c:url value='/images/favicon.png' />">

<title> Escolha o seu | MyBurger </title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/7.0.0/normalize.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<jsp:invoke fragment="extraStyles"/>
<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->

</head>
<body role="document">
	<header>
		<nav class="navbar navbar-default navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">My Burger</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="${linkTo[PublicController].index()}">Home</a></li>
						<li><a href="${linkTo[PublicController].youChoose()}"><fmt:message key='choose.yours' /></a></li>
						<li><a href="${linkTo[PublicController].cart()}"><fmt:message key='cart' /></a></li>
						<li class="dropdown">
					</ul>
					<ul class="nav navbar-nav navbar-right">
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>
	</header>
	<div class="container">
	
		<%-- Se tiver erros exibir aqui --%>
		<c:if test="${fn:length(errors) gt 0}">
			<c:forEach items="${errors}" var="error">
				<p>${error.category} - ${error.message}</p>
			</c:forEach>
		</c:if>
		
		<%-- se tiver sucesso exibir mensagem --%>
		<c:if test="${success != null}">
			<p>${success}</p>
		</c:if>
		
		<jsp:doBody />
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.3.0/mustache.min.js"></script>
	<jsp:invoke fragment="extraScripts" />
</body>
</html>