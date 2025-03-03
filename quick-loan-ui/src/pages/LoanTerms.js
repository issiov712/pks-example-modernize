import { useState } from 'react';
import LoanTermTable from '../components/LoanTerm/LoanTermTable';
import Container from '../components/layout/Container';
import { Box, Button } from '@mui/material';
import CreateLoan from '../components/CreateLoan';

export default function LoanTerms() {
    const [openDialog, setOpenDialog] = useState(false);
    const [data, setData] = useState([]);

    const handleOpenDialog = () => setOpenDialog(true);
    const handleCloseDialog = () => setOpenDialog(false);

    const handleFormSubmit = (formData) => {
        setData([...data, formData]);
    }

    return (
        <Container>
            <Box sx={{ display: 'flex', justifyContent: 'flex-end', paddingBottom: 4 } }>
                <Button variant="contained" color="primary" onClick={handleOpenDialog} maxWidth="xl">New Loan</Button>
            </Box>
            <LoanTermTable />
            <CreateLoan open={openDialog} handleClose={handleCloseDialog} onSubmit={handleFormSubmit}  />
        </Container>
    );
} 
  