import React, { useState } from 'react';
import './login.css'; 
import { useNavigate } from 'react-router-dom';
import { postApi } from './ApiService';

const Login = () => {
  const [mobile, setMobile] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate(); 

  const handleLogin = async () => {

    const data = {
      mobile: mobile,
      password: password
    };

    const apiUrl = "user/login";
    const headers = {
      'Content-Type': 'application/json'
    };

    try {
      const response = await postApi('POST', apiUrl, data, headers);
      console.log(response);

      if (response.token) {
        localStorage.setItem('token', response.token);
        console.log('Login successful:', response);
        navigate('/home');
      } else {
        alert('Login failed');
      }
    } catch (error) {
      console.error('Error during login:', error.message);
    }
  };

  return (
    <div className='main-container'>
      <div className='login-container'>
        <h2>Login</h2>
        <div className='input-group'>
          <label htmlFor='mobile'>Mobile Number</label>
          <input
            type='tel'
            id='mobile'
            placeholder='Enter Mobile number'
            value={mobile}
            onChange={(e) => setMobile(e.target.value)}
          />
        </div>
        <div className='input-group'>
          <label htmlFor='password'>Password</label>
          <input
            type='password'
            id='password'
            placeholder='Enter password'
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <div className='forgot-password-link'>
              <a onClick={() => navigate('/forgotpassword')}>
                Forgot Password?
              </a>
            </div>
        </div>
        <div className='input-group input '>
        <button className='login-btn' onClick={handleLogin}>Login</button>     
        </div>
        <div className='register-link'>
          <p>Don't have an account? <a onClick={() => navigate('/register')}>Register</a></p>
        </div>
      </div>
    </div>
  );
};

export default Login;
