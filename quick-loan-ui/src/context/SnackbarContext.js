import { createContext, useContext, useState } from "react";

const SnackbarContext = createContext();

export function SnackbarProvider({ children }) {
  const [snackbarMessage, setSnackbarMessage] = useState("");
  const [refreshTrigger, setRefreshTrigger] = useState(false);

  //Function to trigger Table refresh
  const refreshTable = () => {
    setRefreshTrigger((prev) => !prev);
  };

  return (
    <SnackbarContext.Provider value={{ snackbarMessage, setSnackbarMessage, refreshTable, refreshTrigger }}>
      {children}
    </SnackbarContext.Provider>
  );
}


export function useSnackbarContext() {
  return useContext(SnackbarContext);
}
