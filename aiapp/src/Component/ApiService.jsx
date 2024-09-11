import axios from "axios";
const BaseUrl = "http://localhost:7001/api/v1/"
export const getApi = async (method, url, params, headers = null) => {
    const token = localStorage.getItem('authToken');  

  if (token) {
    headers['Authorization'] = `Bearer ${token}`;  
  }
    try {
        const response = await axios({
            method: method,
            url: BaseUrl + url,
            params: params,
            headers: headers,
        });
        return response.data;

    } catch (error) {
        console.error('API Error:', error.message);
        throw error;
    }
};

export const postApi = async (method, url, data, headers) => {
    try {

        const response = await axios({
            method: method,
            url: BaseUrl + url,
            data: data,
            headers: headers,
        });
        return response.data;

    } catch (error) {
        console.error('API Error:', error.message);
        throw error;
    }
};