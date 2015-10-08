<%@page import="com.vo.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<sql:setDataSource
    var="mysqlDataSource"
	driver="org.gjt.mm.mysql.Driver"
	url="jdbc:mysql://localhost/test"
	user="root"
	password="root" />
	
<sql:query var="result" dataSource="${mysqlDataSource}">
	select * from test.product;
</sql:query>


<c:forEach var="row" items="${result.rows}">
	${row.product_id} ${row.product_name} <br>
</c:forEach>




