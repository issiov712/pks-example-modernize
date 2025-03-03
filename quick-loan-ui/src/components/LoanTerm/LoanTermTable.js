import * as React from 'react';
import Box from '@mui/material/Box';
import { DataGrid,GridToolbar,GridToolbarQuickFilter,GridToolbarContainer } from '@mui/x-data-grid';
import axiosInstance from '../../api/axiosIntance';
import { useEffect } from 'react';
import { useState } from 'react';
import { getColumns } from './columns';
import CustomDataGridToolbar from '../common/CustomDataGridToolBar'


export default function DataGridDemo() {
  const [rows, setRows] = useState([]);
  const [loading, setLoading] = useState(true);


 
  useEffect(() => {
    axiosInstance
      .get('/loan/')  
      .then((response) => {
        setRows(response.data);  
        setLoading(false); 
      })
      .catch((err) => {
        alert("Error: " + err.message);
        setLoading(false); 
      });
  }, []);


  const { columns, columnVisibilityModel } = getColumns();

  return (
    <Box sx={{ flex: 1, padding: 4 }}>
      <DataGrid
        rows={rows}
        columns={columns}
        initialState={{
          columns : {columnVisibilityModel},
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
          
        }}
        pageSizeOptions={[5]}
        loading={loading} // loading functionality spinning icon while waiting for data
        checkboxSelection
        disableRowSelectionOnClick
        slots={{ toolbar: CustomDataGridToolbar}} 
      />
    </Box>
  );
}
