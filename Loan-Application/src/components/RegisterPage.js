import React, { useState } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';
// import { useHistory } from 'react-router-dom';
export function RegisterPage(){
    const history = useHistory();
     // State variables to store form data
//let BASE_URL = 'localhost:8080/api/customers';
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    pan: '',
    phone: '',
  });

  // Handle form input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  // Handle form submission
  const handleSubmit = (e) => {
    const BASE_URL = 'http://localhost:8080/api/customers/register';
    e.preventDefault();
    axios
    .post(BASE_URL, {
      firstName: formData.firstName,
      lastName: formData.lastName,
      email: formData.email,
      password: formData.password,
      pan: formData.pan,
      phone: formData.phone,
    })
    .then((response) => {
      console.log('Server response:', response.data);
      window.alert(response.data); 
       // Redirect to the login page
       history.push('/login');
      // Handle the response as needed
      // For example, you can update state variables or display a success message
    })
    .catch((error) => {
      console.error('Error submitting form:', error);
      // Handle the error as needed
      // For example, you can update state variables or display an error message
      if (error.response) {
        // The request was made and the server responded with a status code
        // that falls out of the range of 2xx
        console.log('Server error responses:', error.response.data);
        
        // Display the error message from the backend
        window.alert(error.response.data);
      } else if (error.request) {
        // The request was made but no response was received
        console.log('No response received:', error.request);
        window.alert('No response received from the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log('Error setting up the request:', error.message);
        window.alert('Error setting up the request.');
      }
    });
};


  return (
    <div className='register-container'>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstName">First Name:</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            value={formData.firstName}
            onChange={handleInputChange}
            required
          />
        </div>
        <div>
          <label htmlFor="lastName">Last Name:</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={formData.lastName}
            onChange={handleInputChange}
            required
          />
        </div>
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
        <div>
          <label htmlFor="pan">PAN:</label>
          <input
            type="text"
            id="pan"
            name="pan"
            value={formData.pan}
            onChange={handleInputChange}
            required
          />
        </div>
        <div>
          <label htmlFor="phone">Phone:</label>
          <input
            type="tel"
            id="phone"
            name="phone"
            value={formData.phone}
            onChange={handleInputChange}
            required
          />
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
}