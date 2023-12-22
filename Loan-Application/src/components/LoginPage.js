import React, { useState } from 'react';
import axios from 'axios';

export function LoginPage() {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Replace 'YOUR_BACKEND_API_ENDPOINT' with your actual backend API endpoint for login
    const BASE_URL = 'http://localhost:8080/api/customers/login';

    axios.post(BASE_URL, formData)
      .then((response) => {
        // Handle the response as needed
        console.log('Login response:', response.data);
        // Optionally, you can redirect the user or perform other actions based on the response.
      })
      .catch((error) => {
        console.error('Login failed:', error);
        console.log('Response body:', error.response.data);
        window.alert('Login failed. Please check your credentials.');
      });
  };

  return (
    <div className='register-container'>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
}
