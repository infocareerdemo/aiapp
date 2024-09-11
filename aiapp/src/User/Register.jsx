import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { postApi } from '../Component/ApiService'; 

const Register = () => {
    const [name, setName] = useState('');
    const [mobile, setMobile] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const navigate = useNavigate(); 


    const handleRegister = async () =>{
        const data = {
            name :name,
            mobile: mobile,
            password: password,
            emailId :email,
            role:{
             roleId:2
            }
          };
      
          const apiUrl = "user/save";
          const headers = {
            'Content-Type': 'application/json'
          };
      
          try {
            const response = await postApi('POST', apiUrl, data, headers);
            console.log(response);    
            if (response) {
              navigate("/")
            } else {
              alert('Register failed');
            }
          } catch (error) {
            console.error('Error during Register:', error.message);
          }

    }
    
  return (
    <div className='main-container'>
      <div className='login-container'>
        <h2>Register</h2>

   
        <div className='input-group'>
          <label htmlFor='name'>Name</label>
          <input
            type='tel'
            id='name'
            placeholder='Enter the name '
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>

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
        </div>


        <div className='input-group'>
          <label htmlFor='email'>Email</label>
          <input
            type='tel'
            id='email'
            placeholder='Enter email '
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>

        <div className='input-group input '>
        <button className='login-btn' onClick={handleRegister}>Register</button>
        </div>
            
      </div>
    </div>
  );
};

export default Register;
