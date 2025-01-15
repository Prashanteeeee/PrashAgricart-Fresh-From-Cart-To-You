<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Agricart</title>
    
    <!-- Importing Bootstrap from CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <style>
        body {
            background-color: #f8f9fa;
        }
        .hero {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            background: url('your-background-image.jpg') no-repeat center center/cover;
        }
        .hero-text {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
        }
        .btn-primary {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-primary:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Agricart</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="shop.jsp">Shop</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">About</a>
                    </li>
                    <li class="nav-item">
                        <!-- Logout button -->
                        <a class="nav-link btn btn-danger text-gray" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    

    <!-- Hero Section -->
    <div class="hero">
        <div class="hero-text">
            <h1 class="display-4 fw-bold">Welcome to Agricart</h1>
            <p class="lead">Fresh, seasonal, and preservative-free fruits and vegetables delivered straight to your doorstep.</p>
            <div class="mt-4">
                <a href="shop.jsp" class="btn btn-primary btn-lg me-2">Shop Now</a>
                <a href="about.jsp" class="btn btn-outline-secondary btn-lg">Learn More</a>
            </div>
        </div>
    </div>

    <!-- Features Section -->
    <div class="container my-5">
        <div class="row text-center">
            <div class="col-md-4">
                <div class="p-4">
                    <i class="bi bi-basket2-fill" style="font-size: 3rem; color: #28a745;"></i>
                    <h5 class="mt-3">Fresh Produce</h5>
                    <p>Enjoy the best quality fruits and vegetables sourced directly from farmers.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-4">
                    <i class="bi bi-wallet-fill" style="font-size: 3rem; color: #28a745;"></i>
                    <h5 class="mt-3">Affordable Prices</h5>
                    <p>Get the best prices without compromising on quality.</p>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-4">
                    <i class="bi bi-truck" style="font-size: 3rem; color: #28a745;"></i>
                    <h5 class="mt-3">Fast Delivery</h5>
                    <p>Quick and efficient delivery to your doorstep.</p>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
