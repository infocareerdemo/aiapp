import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Component/Login';
import Home from './User/Home';
import Register from './User/Register';
import ForgotPassword from './User/ForgotPassword';


function App() {
  return (
  
      <BrowserRouter>
        
          <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/forgotpassword" element={<ForgotPassword />} />
          <Route path="/register" element={<Register />} />
          <Route path="/home" element={<Home />} />
          </Routes>
        
      </BrowserRouter>
  

  );
}

export default App;
