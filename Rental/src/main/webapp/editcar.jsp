<%@ page import="RentalMan.Car" %>
<%
  Car car = (Car) request.getAttribute("car");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Edit Car</title>
  <style>
    form {
      max-width: 400px;
      margin: auto;
      background: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }
    input, select {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 6px;
    }
    button {
      background: #2563eb;
      color: #fff;
      border: none;
      padding: 10px 15px;
      border-radius: 6px;
      cursor: pointer;
    }
    button:hover {
      background: #1d4ed8;
    }
  </style>
</head>
<body>

  <h2 style="text-align:center;">Edit Car</h2>

  <form action="updatecar" method="post">
    <input type="hidden" name="carid" value="<%= car.getCarid() %>">

    <label>Car Name:</label>
    <input type="text" name="carname" value="<%= car.getCarname() %>" required>

    <label>Car Model:</label>
    <input type="text" name="carmodel" value="<%= car.getCarmodel() %>" required>

    <label>Car Number:</label>
    <input type="number" name="carnumber" value="<%= car.getCarnumber() %>" required>

    <label>Owner Name:</label>
    <input type="text" name="ownername" value="<%= car.getOwnername() %>" required>

    <label>Status:</label>
    <select name="status">
      <option value="available" <%= "available".equals(car.getStatus()) ? "selected" : "" %>>Available</option>
      <option value="booked" <%= "booked".equals(car.getStatus()) ? "selected" : "" %>>Booked</option>
    </select>

    <button type="submit">Update Car</button>
  </form>

</body>
</html>
