<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
response.setHeader("Access-Control-Max-Age", "3600");
response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

response.setHeader("Access-Control-Allow-Origin", "*");

%>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="SummorGetInfo.js"></script>
<meta charset="EUC-KR">
<title>�� ���� �˻� ����Ʈ</title>
</head>
<body>
	<h2 style="color:red" align="center">���� �˻�</h2>
	<input type="text" style="margin-left: 150px" size = 20px id="ID"><button id="btn" onclick="DisplaySummorInfo();">�˻�</button>
	<div id="show">
		
	</div>
</body>
</html>