<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeesList</title>
</head>
<body>

	<h1>Employees List</h1>

	<table>

		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Employee Id</th>
				<th>Email</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ employees }" var="employee">
				<tr>
					<td>${employee.id }</td>
					<td>${employee.name }</td>
					<td>${employee.employeeId }</td>
					<td>${employee.email }</td>
					<td>${employee.salary }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>