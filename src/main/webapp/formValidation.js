// formValidation.js

// Function to validate email format
function validateEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

// Function to validate phone number (10 digits)
function validatePhone(phone) {
    const phoneRegex = /^\d{10}$/;
    return phoneRegex.test(phone);
}

// Function to validate password strength
function validatePassword(password) {
    return password.length >= 6; // Ensure password is at least 6 characters
}

// General form validation function
function validateForm(form) {
    const email = form.email ? form.email.value : null;
    const phone = form.phone ? form.phone.value : null;
    const password = form.password ? form.password.value : null;

    if (email && !validateEmail(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    if (phone && !validatePhone(phone)) {
        alert("Please enter a valid 10-digit phone number.");
        return false;
    }

    if (password && !validatePassword(password)) {
        alert("Password must be at least 6 characters long.");
        return false;
    }

    return true;
}
/**
 * 
 */