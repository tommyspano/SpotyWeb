<%@ page import="java.util.*" %>
<%
    List<Map<String, String>> results = (List<Map<String, String>>) request.getAttribute("results");
%>

<ul>
<% for (int i = 0; i < results.size(); i++) {
    Map<String, String> song = results.get(i); %>
    <li><%= i %>) <%= song.get("name") %> - <%= song.get("artist") %></li>
<% } %>
</ul>

<form action="comment" method="post">
    <label>Indice della canzone:</label>
    <input type="number" name="index" required><br>
    <label>Commento:</label>
    <textarea name="comment" required></textarea><br>
    <label>Nome utente:</label>
    <input type="text" name="username" required><br>
    <input type="submit" value="Carica commento"><br>
</form>