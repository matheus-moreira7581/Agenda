<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.Agenda"%>
<!DOCTYPEhtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agenda</title>
</head>
<body>
	<%
		Agenda agenda = (Agenda) request.getAttribute("agenda");
	%>
	Id:
	<%=agenda.getId_cliente()%><br>
	<!-- ${agenda.id} -->
	Nome:
	<%=agenda.getNome()%><br>
	<!-- ${agenda.nome} -->
	Endereço:
	<%=agenda.getEndereco()%><br>
	<!-- ${agenda.endereco} -->
	Telefone:
	<%=agenda.getTel()%><br>
	<!-- ${agenda.tel} -->
</body>
</html>