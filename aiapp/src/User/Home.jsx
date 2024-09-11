import React, { useState } from 'react';


const Home = () => {
    const [token] = useState(localStorage.getItem("token"));
    console.log("Token:" + token)
  return (
    <div className='main-container'>

        <h2>Home Page</h2>
        
    </div>
  );
};

export default Home;
