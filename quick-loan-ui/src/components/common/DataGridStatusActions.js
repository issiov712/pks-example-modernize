import { GridActionsCellItem } from '@mui/x-data-grid';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import CheckCircleIcon from '@mui/icons-material/CheckCircle'; 
import Tooltip from '@mui/material/Tooltip';
import Box from '@mui/material/Box';
import { useState } from 'react';
import CreateLoan from '../CreateEditLoan';


/**
Idea is to make this reusable for every table, 
will need some modifications to get it working with any componenet
**/
export default function CommonDataGridStatusActions({params}){
    const [openDialog, setOpenDialog] = useState(false);
    const [data, setData] = useState([]);

    const handleOpenDialog = () => setOpenDialog(true);
    const handleCloseDialog = () => setOpenDialog(false); 

    const handleFormSubmit = (formData) => {
        setData([...data, formData]);
    }
    return(
        <Box sx={{ display: 'flex', gap: 1, alignItems: 'center' }}>
        {/*Green Status Checkmark */}
        <Tooltip title="Active">
          <CheckCircleIcon sx={{ color: 'green' }} />
        </Tooltip>

        {/*Edit Button */}
        <Tooltip title="Edit">
          <GridActionsCellItem
            icon={<EditIcon color="primary" />} 
            label="Edit"
            onClick={handleOpenDialog}
          />
        </Tooltip>
        <CreateLoan open={openDialog} handleClose={handleCloseDialog} onSubmit={handleFormSubmit} id={params.id}  />
        {/*Delete Button */}
        <Tooltip title="Delete">
          <GridActionsCellItem
            icon={<DeleteIcon color="error" />} 
            label="Delete"
            onClick={() => alert(`Delete clicked for ID: ${params.row.id}`)}
          />
        </Tooltip>
      </Box>
        );
    

}