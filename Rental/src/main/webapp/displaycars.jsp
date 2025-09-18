<%@page import="RentalMan.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>Available Cars — Book a Car</title>
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <style>
    :root{
      --bg:#f9fafb;
      --card:#ffffff;
      --muted:#6b7280;
      --accent:#2563eb;
      --glass:#f3f4f6;
      --radius:12px;
      --max-width:1000px;
      --gap:16px;
      font-family: "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
    }

    *{box-sizing:border-box}
    body{
      margin:0;
      background:var(--bg);
      color:#111827;
      -webkit-font-smoothing:antialiased;
      padding:32px 16px;
      display:flex;
      justify-content:center;
      align-items:flex-start;
      min-height:100vh;
    }

    .container{
      width:100%;
      max-width:var(--max-width);
    }

    header{
      margin-bottom:20px;
    }
    header h1{
      margin:0 0 6px;
      font-size:24px;
      font-weight:600;
      color:#1f2937;
    }
    header p{
      margin:0;
      color:var(--muted);
      font-size:14px;
    }

    .grid{
      display:grid;
      grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
      gap:var(--gap);
    }

    .card{
      background:var(--card);
      border-radius:var(--radius);
      padding:18px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.06);
      display:flex;
      flex-direction:column;
      justify-content:space-between;
      gap:14px;
      border:1px solid #e5e7eb;
      transition:transform .2s ease, box-shadow .2s ease;
    }
    .card:hover{
      transform:translateY(-4px);
      box-shadow:0 6px 16px rgba(0,0,0,0.08);
    }

    .car-title .name{
      font-weight:600;
      font-size:18px;
      margin-bottom:2px;
      color:#111827;
    }
    .car-title .model{
      color:var(--muted);
      font-size:14px;
    }

    .meta{
      font-size:13px;
      color:var(--muted);
      display:flex;
      flex-wrap:wrap;
      gap:8px;
    }

    form{
      display:flex;
      flex-direction:column;
      gap:12px;
    }

    label{
      display:block;
      font-size:13px;
      color:#374151;
      margin-bottom:4px;
    }

    input[type="text"],
    input[type="date"],
    input[type="number"]{
      width:100%;
      padding:10px 12px;
      border-radius:8px;
      border:1px solid #d1d5db;
      background:var(--glass);
      color:#111827;
      outline:none;
      font-size:14px;
      transition:border .2s ease;
    }
    input:focus{
      border-color:var(--accent);
    }
    input[readonly]{
      background:#e5e7eb;
      cursor:not-allowed;
    }

    .row{
      display:flex;
      gap:10px;
    }
    .row .col{flex:1}

    .btn{
      display:inline-block;
      padding:10px 14px;
      border-radius:8px;
      cursor:pointer;
      font-weight:600;
      background:var(--accent);
      color:#fff;
      border:0;
      font-size:14px;
      transition:background .2s ease;
    }
    .btn:hover{
      background:#1d4ed8;
    }

    @media (max-width:420px){
      .card{padding:14px}
      header h1{font-size:20px}
    }
  </style>
</head>
<body>
  <div class="container">
    <header>
      <h1>Available Cars</h1>
      <p>Choose a car and fill in your booking details.</p>
    </header>

    <div class="grid">
      <% List<Car> cars = (List<Car>) request.getAttribute("cars");
         if (cars != null && !cars.isEmpty()) {
           for (Car c : cars) {
      %>
      <article class="card">
        <div class="car-title">
          <div class="name"><%= c.getCarname() == null ? "Unnamed Car" : c.getCarname() %></div>
          <div class="model"><%= c.getCarmodel() == null ? "Model unknown" : c.getCarmodel() %></div>
        </div>
        <div class="meta">
          <div>ID: <strong><%= c.getCarid() %></strong></div>
          <div>No: <%= c.getCarnumber() %></div>
          <div>Owner: <%= c.getOwnername() == null ? "-" : c.getOwnername() %></div>
          <div>Status: <%= c.getStatus() == null ? "available" : c.getStatus() %></div>
        </div>

        <form action="bookcar" method="post">
          <div>
            <label for="carid-<%= c.getCarid() %>">Car ID</label>
            <input type="number" id="carid-<%= c.getCarid() %>" name="carid" value="<%= c.getCarid() %>" readonly />
          </div>

          <div>
            <label for="cname-<%= c.getCarid() %>">Customer name</label>
            <input type="text" id="cname-<%= c.getCarid() %>" name="cname" placeholder="Your full name" required />
          </div>

          <div class="row">
            <div class="col">
              <label for="sdate-<%= c.getCarid() %>">Start date</label>
              <input type="date" id="sdate-<%= c.getCarid() %>" name="sdate" required />
            </div>
            <div class="col">
              <label for="ldate-<%= c.getCarid() %>">Leave date</label>
              <input type="date" id="ldate-<%= c.getCarid() %>" name="ldate" required />
            </div>
          </div>

          <button type="submit" class="btn">Book Car</button>
        </form>
      </article>
      <%     } // end for
         } else { %>
         <div style="grid-column:1/-1; text-align:center; color:var(--muted); padding:20px;">
           No cars found.
         </div>
      <% } %>
    </div>
  </div>
</body>
</html>
