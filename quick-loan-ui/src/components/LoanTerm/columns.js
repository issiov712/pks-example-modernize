import { GridActionsCellItem } from '@mui/x-data-grid';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import CheckCircleIcon from '@mui/icons-material/CheckCircle'; 
import Tooltip from '@mui/material/Tooltip';
import LinearProgress from '@mui/material/LinearProgress';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

export const getColumns = () => {
    const columns = [
    {
            field: 'id',
            headerName: 'id',
            flex: 0.5,
            editable: false,
    },
    {
            field: 'name',
            headerName: 'Name',
            flex: 0.5,
            editable: true,
            renderCell: (params) => (
              <strong>{params.value}</strong> 
            ),
          },
    {
      field: 'description',
      headerName: 'Description',
      flex: 0.5,
      editable: true,
    },
    {
      field: 'rate',
      headerName: 'Rate',
      type: 'number',
      flex: 0.2,
      editable: true,
      headerAlign: 'left', //nubers are alligned to right by default
      align: 'left', 
    },
    {
      field: 'amount',
      headerName: 'Amount',
      type: 'number',
      flex: 0.2,
      editable: true,
      headerAlign: 'left', //nubers are alligned to right by default
      align: 'left', 
      valueFormatter: (params) => `$${params}`, //Add the $ symbol
    },
    {
      field: 'fundsDisbursementDate', 
      headerName: 'Funds Disbursement Date',
      flex: 0.2,
      type: 'date', 
      valueGetter: (params) => {
        console.log(params)
        // Transform the string date to a Date object (assuming it's a string in ISO format)
        return new Date(params);
      }
    },
    {
      field: 'firstStatementDate', 
      headerName: 'First Statement Date',
      flex: 0.2,
      type: 'date', 
      valueGetter: (params) => {
        console.log(params)
        // Transform the string date to a Date object (assuming it's a string in ISO format)
        return new Date(params);
      }
    },
    {
      field: 'firstInterestPaymentDate', 
      headerName: 'first Interest Payment Date',
      flex: 0.2,
      type: 'date', 
      valueGetter: (params) => {
        console.log(params)
        // Transform the string date to a Date object (assuming it's a string in ISO format)
        return new Date(params);
      }
    },
    {
      field: 'firstPrincipalPaymentDate', 
      headerName: 'First Principal Payment Date',
      flex: 0.2,
      type: 'date', 
      valueGetter: (params) => {
        console.log(params)
        // Transform the string date to a Date object (assuming it's a string in ISO format)
        return new Date(params);
      }
    },
    {
      field: 'currentMaturityDate', 
      headerName: 'Current Maturity Date',
      flex: 0.2,
      type: 'date', 
      valueGetter: (params) => {
        console.log(params)
        // Transform the string date to a Date object (assuming it's a string in ISO format)
        return new Date(params);
      }
    },
    {
      field: 'finalMaturityDate', 
      headerName: 'Final Maturity Date',
      flex: 0.2,
      type: 'date', 
      valueGetter: (params) => {
        console.log(params)
        // Transform the string date to a Date object (assuming it's a string in ISO format)
        return new Date(params);
      }
    },
    {
      field: 'loanMethodType',
      headerName: 'Loan Method Type',
      flex: 0.2,
      editable: true,
    },
    {
      field: 'loanPeriodType',
      headerName: 'Loan Period Type',
      flex: 0.2,
      editable: true,
    },
    //demo progress bar
    {
        field: 'progress',
        headerName: 'Progress',
        flex: 0.3,
        sortable: false,
        renderCell: (params) => {
          const progress = params.value || 75; // Default to 75% if no value in API. Can be caluculated at runtime base on calumn valuses too   
      
          return (
            <Box sx={{ 
              width: '100%', 
              height: '100%', 
              display: 'flex', 
              alignItems: 'center', 
              justifyContent: 'center' // 
            }}> 
              <Box sx={{ width: '70%', display: 'flex', alignItems: 'center' }}>
                <LinearProgress
                  variant="determinate"
                  value={progress}
                  sx={{ height: 8, borderRadius: 5, width: '100%', marginRight: 1 }}
                />
                <Typography variant="body2" sx={{ minWidth: 30, textAlign: 'center' }}>
                  {`${progress}%`}
                </Typography>
              </Box>
            </Box>
          );
        },
      },
    {
        field: 'action',
        headerName: 'Status/Action',
        flex: 0.2, 
        sortable: false,
        filterable: false,
        renderCell: (params) => (
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
                onClick={() => alert(`Edit clicked for ID: ${params.row.id}`)}
              />
            </Tooltip>
    
            {/*Delete Button */}
            <Tooltip title="Delete">
              <GridActionsCellItem
                icon={<DeleteIcon color="error" />} 
                label="Delete"
                onClick={() => alert(`Delete clicked for ID: ${params.row.id}`)}
              />
            </Tooltip>
          </Box>
        ),
      },
];
  // Define the initial hidden columns
  const columnVisibilityModel = {
    finalMaturityDate: false, 
    currentMaturityDate: false, 
    firstPrincipalPaymentDate: false,
    firstInterestPaymentDate: false,
    firstStatementDate: false,
    fundsDisbursementDate: false,
    id: false
  };

  return { columns, columnVisibilityModel };
};
