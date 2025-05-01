import React, { createContext, useContext, useState, useEffect } from "react";
import axiosInstance from '../api/axiosInstance'

// Create Context
const DropdownContext = createContext();


// Provider Component
export const DropdownProvider = ({ children }) => {
  const [dropdowns, setDropdowns] = useState({ methods: [], periods: []});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchDropdowns = async () => {
      try {
        //Run all API calls in parallel using Promise.all()
        const [periodRes, methodRes] = await Promise.all([
          axiosInstance.get("/loan/type/period"),
          axiosInstance.get("loan/type/method")
        ]);

        //Store results in state
        setDropdowns({
          methods: methodRes.data,
          periods: periodRes.data,
         
        });

        setLoading(false);
        
      } catch (error) {
        console.error("Error fetching dropdown data", error);
      }
    };

    fetchDropdowns();
  }, []);

  // Function to get dropdown options
  const getDropdownOptions = (key) => dropdowns[key] || [];

  return (
    <DropdownContext.Provider value={{ getDropdownOptions,loading }}>
      {children}
    </DropdownContext.Provider>
  );
};

// Custom Hook
export const useDropdown = () => useContext(DropdownContext);
