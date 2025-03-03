import axios from 'axios';

//We can handle auth tokens here eventually

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080', // We can pull from .env file eventually
  headers: {
    'Content-Type': 'application/json', 
  },
});

export default axiosInstance;
