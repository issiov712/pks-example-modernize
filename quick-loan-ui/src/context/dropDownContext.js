import React, { createContext, useContext, useState, useEffect } from "react";

// Create Context
const DropdownContext = createContext();

// Mock API Function (Simulates Fetching Multiple Dropdowns)
const fetchMockDropdownData = () =>
  new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        methods: [
          { key: "sl", value: "SL", name: "Simple Level Payment Amortization" },
          { key: "sp", value: "SP", name: "Level Principal Payment Amortization" },
        ],
        period: [
          { key: "monthly", value: "M", name: "Monthly" },
          { key: "quarterly", value: "Q", name: "Quarterly" },
        ],
        categories: [
          { key: "category_finance", value: "finance", name: "Finance" },
          { key: "category_health", value: "health", name: "Health" },
          { key: "category_education", value: "education", name: "Education" }
        ]
      });
    }, 1000); // Simulate a 1-second API delay
  });

// Provider Component
export const DropdownProvider = ({ children }) => {
  const [dropdowns, setDropdowns] = useState({ methods: [], period: [], categories: [] });

  useEffect(() => {
    const fetchDropdowns = async () => {
      try {
        const data = await fetchMockDropdownData();
        setDropdowns(data);
      } catch (error) {
        console.error("Error fetching dropdown data", error);
      }
    };

    fetchDropdowns();
  }, []);

  // Function to get dropdown options
  const getDropdownOptions = (key) => dropdowns[key] || [];

  return (
    <DropdownContext.Provider value={{ getDropdownOptions }}>
      {children}
    </DropdownContext.Provider>
  );
};

// Custom Hook
export const useDropdown = () => useContext(DropdownContext);
