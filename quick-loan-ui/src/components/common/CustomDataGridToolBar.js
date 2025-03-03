import React from 'react';
import Box from '@mui/material/Box';
import { GridToolbarContainer, GridToolbar, GridToolbarQuickFilter } from '@mui/x-data-grid';

//Custom toolbar used for our data grid throught the application
const CustomDataGridToolbar = () => {
  return (
    <GridToolbarContainer>
      <Box sx={{ flex: 1, display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: 1 }}>
        <GridToolbarQuickFilter /> {/* Quick Search Bar */}
        <GridToolbar /> {/* Full Toolbar (Filters, Export, Density) */}
      </Box>
    </GridToolbarContainer>
  );
};

export default CustomDataGridToolbar;
