import React, { createContext, useContext, useState, useEffect } from "react";
import axiosInstance from "../api/axiosInstance"; 


const InterestRateContext = createContext();


export function InterestRateProvider({ children }) {
  const [interestRate, setInterestRate] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  
  useEffect(() => {
    const fetchInterestRate = async () => {
      try {
        const response = await axiosInstance.get("/loan/setting/interest-rate"); 
        setInterestRate(response.data.rate); 
      } catch (err) {
        console.error("Error fetching interest rate:", err);
        setError("Failed to load interest rate.");
      } finally {
        setLoading(false);
      }
    };
    fetchInterestRate();
  }, []);

  return (
    <InterestRateContext.Provider value={{ interestRate, loading, error }}>
      {children}
    </InterestRateContext.Provider>
  );
}


export function useInterestRate() {
  return useContext(InterestRateContext);
}
