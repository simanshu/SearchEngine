<%@ page import="com.Accio.Historyresult" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Search Engine</h2>
<form action="Search">
    <input type="text" name="keyword"></input>
    <button type="submit">Search</button>
</form>
<form>
    <button type="submit">History</button>
</form>
    <table border="2" class="resulttable">
        <tr>
            <th>
                Keyword
            </th>
            <th>Link</th>
        </tr>
        <%
            ArrayList<Historyresult> results=(ArrayList<Historyresult>)request.getAttribute("results");
            for (Historyresult result:results){
        %>
        <tr>
            <td><%out.println(result.getKeyword());%></td>
            <td><a href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
