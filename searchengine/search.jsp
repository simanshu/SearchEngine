<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Accio.SearchResult" %>
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
                Title
            </th>
            <th>Link</th>
        </tr>
        <%
            ArrayList<SearchResult> results=(ArrayList<SearchResult>)request.getAttribute("results");
            for(SearchResult result:results){
        %>
        <tr>
            <td><a><%out.println(result.getTitle());%></a></td>
            <td><a href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
