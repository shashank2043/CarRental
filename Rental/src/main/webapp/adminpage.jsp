<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="RentalMan.Car"%>
<%@page import="java.util.List"%>
<%@page import="RentalMan.Booking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Manage Bookings</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background: #f5f7fa;
	margin: 0;
	padding: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 30px;
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: #fff;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	overflow: hidden;
}

th, td {
	padding: 12px 15px;
	border-bottom: 1px solid #eee;
	text-align: left;
}

th {
	background: #2563eb;
	color: white;
	font-weight: 600;
}

tr:hover {
	background: #f9fafb;
}

.btn-delete {
	background: #ef4444;
	color: #fff;
	border: none;
	padding: 6px 12px;
	border-radius: 6px;
	cursor: pointer;
	font-size: 14px;
	transition: background 0.3s ease;
}

.btn-delete:hover {
	background: #dc2626;
}

.empty {
	text-align: center;
	padding: 20px;
	color: #666;
}

.back-btn {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 16px;
	background: #2563eb;
	color: #fff;
	border-radius: 8px;
	text-decoration: none;
	font-weight: 600;
}

.back-btn:hover {
	background: #1d4ed8;
}
</style>

<script>
    function confirmDelete(bookingId) {
      if (confirm("Are you sure you want to delete this booking?")) {
        window.location.href = "deletebooking?id=" + bookingId;
      }
    }
  </script>
</head>
<body>

	<h1>Cars</h1>


	<%
    List<Car> cars = (List<Car>) request.getAttribute("cars");
    if (cars != null && !cars.isEmpty()) {
  %>
	<table>
		<thead>
			<tr>
				<th>Car ID</th>
				<th>Car Name</th>
				<th>Car Model</th>
				<th>Car Number</th>
				<th>Owner Name</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for (Car c : cars) { %>
			<tr>
				<td><%= c.getCarid() %></td>
				<td><%= c.getCarname() %></td>
				<td><%= c.getCarmodel() %></td>
				<td><%= c.getCarnumber() %></td>
				<td><%= c.getOwnername() %></td>
				<td><%= c.getStatus() %></td>
				<td><a href="editcar?id=<%= c.getCarid() %>"
					style="background: #f59e0b; color: #fff; padding: 6px 12px; border-radius: 6px; text-decoration: none;">
						Edit </a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<% } else { %>
	<div class="empty">No cars found.</div>
	<% } %>

	<h1>Manage Bookings</h1>

	<%
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
    if (bookings != null && !bookings.isEmpty()) {
  %>
	<table>
		<thead>
			<tr>
				<th>Booking ID</th>
				<th>Customer Name</th>
				<th>Start Date</th>
				<th>Leave Date</th>
				<th>Car ID</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for (Booking b : bookings) { %>
			<tr>
				<td><%= b.getBookingid() %></td>
				<td><%= b.getCname() %></td>
				<td><%= b.getSdate() %></td>
				<td><%= b.getLdate() %></td>
				<td><%= b.getCarid() %></td>
				<td>
					<button class="btn-delete"
						onclick="confirmDelete(<%= b.getBookingid() %>)">Delete</button>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<% } else { %>
	<div class="empty">No bookings found.</div>
	<% } %>

	<div style="text-align: center;">
		<a href="index.html" class="back-btn">⬅ Back to Home</a>
	</div>

</body>
</html>
