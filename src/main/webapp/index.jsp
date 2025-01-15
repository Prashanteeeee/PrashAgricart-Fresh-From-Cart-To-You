<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agricart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background: linear-gradient(to bottom, #f3f4f6, #ffffff);
        }
        .hero {
            background: url('https://source.unsplash.com/1600x900/?farm,vegetables') no-repeat center center/cover;
            height: 50vh;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .hero h1 {
            font-size: 3rem;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
        }
        .feature {
            padding: 20px;
            border-radius: 10px;
            background-color: #e3f2fd;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        footer {
            background: #2d2d2d;
            color: white;
            padding: 20px 0;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="hero">
        <div>
            <h1>Welcome to Agricart</h1>
            <p>Fresh and seasonal fruits and vegetables delivered to your doorstep!</p>
            <a href="login.jsp" class="btn btn-primary btn-lg me-2">Login</a>
            <a href="user-form.jsp" class="btn btn-success btn-lg">Register</a>
        </div>
    </div>

    <div class="container mt-5">
        <h2 class="text-center mb-4">Why Choose Agricart?</h2>
        <div class="row g-4">
            <div class="col-md-4">
                <div class="feature">
                    <h5>Fresh Produce</h5>
                    <p>Get freshly harvested fruits and vegetables directly from local farmers.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="feature">
                    <h5>No Preservatives</h5>
                    <p>We ensure that all our products are free from harmful chemicals and preservatives.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="feature">
                    <h5>Support Farmers</h5>
                    <p>By shopping with us, you contribute to fair trade and better pricing for farmers.</p>
                </div>
            </div>
        </div>
    </div>

    <div class="container mt-5">
        <h2 class="text-center mb-4">Our Categories</h2>
        <div class="row text-center">
            <div class="col-md-3">
                <img src="https://source.unsplash.com/200x200/?fruit" class="img-fluid rounded-circle mb-3" alt="Fruits">
                <h5>Fruits</h5>
            </div>
            <div class="col-md-3">
                <img src="https://source.unsplash.com/200x200/?vegetables" class="img-fluid rounded-circle mb-3" alt="Vegetables">
                <h5>Vegetables</h5>
            </div>
            <div class="col-md-3">
                <img src="https://source.unsplash.com/200x200/?organic" class="img-fluid rounded-circle mb-3" alt="Organic">
                <h5>Organic</h5>
            </div>
            <div class="col-md-3">
                <img src="https://source.unsplash.com/200x200/?farmer" class="img-fluid rounded-circle mb-3" alt="Farmer Support">
                <h5>Farmer Support</h5>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 2025 Agricart | Designed with love for nature and health</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
