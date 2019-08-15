<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<script type="text/javascript">	

</script>
</head>
<body>
<form action="<%=path%>/serv/upload/startPageImg" method="post" enctype="multipart/form-data">
请选择上传的图片或文件:
	<input type="file" name="file"/>
	<input type="submit" value="上传"/>
</form> 


<form action="<%=path%>/serv/upload/version" method="post" enctype="multipart/form-data">
请选择上传的图片或文件:
	<input type="file" name="file"/>
	<input type="submit" value="上传"/>
</form> 
</body>
</html>