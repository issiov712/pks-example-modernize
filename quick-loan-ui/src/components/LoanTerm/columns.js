import { GridActionsCellItem } from '@mui/x-data-grid';
import EditIcon from '@mui/icons-material/Edit';
import CheckCircleIcon from '@mui/icons-material/CheckCircle'; 
import Tooltip from '@mui/material/Tooltip';
import LinearProgress from '@mui/material/LinearProgress';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

export const columns = [
    {
        field: 'action',
        headerName: 'Action',
        width: 75,
        sortable: false,
        filterable: false,
        renderCell: (params) => (
          <GridActionsCellItem
            icon={<EditIcon color="primary" />} // Edit Icon
            label="Edit"
            onClick={() => alert(`Edit clicked for ID: ${params.row.id}`)} 
          />
        ),},
    {
      field: 'name',
      headerName: 'Name',
      width: 150,
      editable: true,
    },
    {
      field: 'description',
      headerName: 'Description',
      width: 150,
      editable: true,
    },
    {
      field: 'rate',
      headerName: 'Rate',
      type: 'number',
      width: 60,
      editable: true,
      headerAlign: 'left', //nubers are alligned to right by default
      align: 'left', 
    },
    {
      field: 'amount',
      headerName: 'Amount',
      type: 'number',
      width: 110,
      editable: true,
      headerAlign: 'left', //nubers are alligned to right by default
      align: 'left', 
      valueFormatter: (params) => `$${params}`, //Add the $ symbol
    },
    {
        field: 'openState',
        headerName: 'Status',
        width: 60,
        sortable: false,
        filterable: false,
        renderCell: () => (
          <Tooltip title="Open">
            <CheckCircleIcon sx={{ color: 'green' }} /> 
          </Tooltip>
        ),
      },
     //demo progress bar
      {
        field: 'progress',
        headerName: 'Progress',
        width: 150, 
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
      field: 'fundsDisbursementDate', 
      headerName: 'Funds Disbursement Date',
      width: 150,
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
      width: 150,
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
      width: 180,
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
      width: 180,
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
      width: 110,
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
      width: 110,
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
      width: 110,
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
      width: 110,
      editable: true,
    },
    {
      field: 'loanPeriodType',
      headerName: 'Loan Period Type',
      width: 110,
      editable: true,
    },
  
  ];