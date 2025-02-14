import React, { createContext, useContext, useState, useEffect } from "react";

// Create Context
const DropdownContext = createContext();

// Mock API Function (Simulates Fetching Multiple Dropdowns)
const fetchMockDropdownData = () =>
  new Promise((resolve) => {
    setTimeout(() => {
      resolve({
        programs: [
          { key: "program_alpha", value: "alpha", name: "Program Alpha" },
          { key: "program_beta", value: "beta", name: "Program Beta" },
          { key: "program_gamma", value: "gamma", name: "Program Gamma" }
        ],
        agencies: [
          { key: "agency_x", value: "agency_x", name: "Agency X" },
          { key: "agency_y", value: "agency_y", name: "Agency Y" },
          { key: "agency_z", value: "agency_z", name: "Agency Z" }
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
  const [dropdowns, setDropdowns] = useState({ programs: [], agencies: [], categories: [] });

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
