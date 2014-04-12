<html>
	<body>
		<table>
			<tr>
				<td colspan="2">图书信息</td>
			</tr>
			<tr>
				<td>图书编号</td>
				<td>${returnBook.book_id!}</td>
			</tr>
			<tr>
				<td>书名</td>
				<td>${returnBook.book_name!}</td>
			</tr>
			<tr>
				<td>作者</td>
				<td>${returnBook.book_author!}</td>
			</tr>
			<tr>
				<td>类型</td>
				<td>${returnBook.type_name!}</td>
			</tr>
			<tr>
				<td clospan="2">借阅人信息</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>${returnBook.user_num!}</td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td>${returnBook.user_realName!}</td>
			</tr>
			<tr>
				<td>借书时间</td>
				<td>${returnBook.check_startTime?string("yyyy-MM-dd")}</td>
			</tr>
			<tr>
				<td>到期时间</td>
				<td>${returnBook.check_endTime?string("yyyy-MM-dd")}</td>
			</tr>
			<tr>
				<td>是否超期</td>
				<#if returnBook.overDue==0>
					<td>否</td>
				<#else>
					<td>是</td>
				</#if>
			</tr>
			<form action="${req.contextPath}/borrow/doReturnBook" method="post">
			<td><input type="text" value="${returnBook.book_id}" name="bookId"></td>

			<tr>
				
		     	<td><input type="submit"  value="还书" id="sub"/></td>
					
		     	<td><input type="reset" value="重置" /></td>
		    </tr>
		</table>
	</body>
</html>