import React, { useState } from 'react';


const ForgotPassword = () => {
    const [token] = useState(localStorage.getItem("token"));
    console.log("Token:" + token)
  return (
    <div className='main-container'>

        <h2>ForgotPassword Page</h2>
        
    </div>
  );
};

export default ForgotPassword;
