import { Box } from "@mui/material";
import Sidebar from "./Sidebar";

export default function Container({ children }) {
    return (
        <Box sx={{ display: 'flex', height: '100vh', backgroundColor: '#f0f0f0' }}>
            {/* Sidebar */}
            <Sidebar />
            {/* Main Content Container */}
            <Box sx={{ flex: 1, marginLeft: '250px', padding: 4 }}>
                {children}
            </Box>
        </Box>
    );
}