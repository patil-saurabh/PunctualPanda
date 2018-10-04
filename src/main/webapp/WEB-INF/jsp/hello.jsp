<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body leftmargin="50" topmargin="70"> 
	
		<h1>Punctual Panda</h1>
		Let our panda help you become more productive! 
		<br>
		<hr>
		<br>
		<h4>Add New Task</h4>
		<form:form action="addTask" method="POST" modelAttribute="todoTask">
			
			Your Name: <form:input path="userName" size="20"/><br><br>
			Your Task: <form:input path="taskName" size="20"/><br><br>
			Due Date: <form:input type="date" path="dueDate" /><br><br>
			<input type="submit" value="   A d d   T a s k    "  style="width: 100px; "/>
		
		</form:form>
		<br>
		<hr>
		<br>
			<h4>Current Tasks</h4>
			<c:forEach var='task' items="${alltasks}"><br>
				<form:form action="deleteTask" method="POST" modelAttribute="todoTask">
					<form:input path="taskId" type="hidden" value="${task.taskId}"/>
					<input type="submit" value=" X "  style="width: 30px; "/>   ${task.userName} : ${task.taskName}. Due Date: ${task.dueDate}   
					
				</form:form>
			</c:forEach>
			
		 
	
	</body>
	
</html>
