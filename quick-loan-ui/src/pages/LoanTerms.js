import { useState } from 'react';
import ProgramCommitmentTable from '../components/ProgramCommitment/ProgramCommitmentTable';
import Container from '../components/layout/Container';
import { Box, Button } from '@mui/material';
import CreateLoan from '../components/CreateLoan';

export default function LoanTerms() {
    const [openDialog, setOpenDialog] = useState(false);
  const [data, setData] = useState([]);

  const handleOpenDialog = () => setOpenDialog(true);
  const handleCloseDialog = () => setOpenDialog(false);

  const handleFormSubmit = (formData) => {
    setData([...data, formData]); // Add new commitment data
    }

    return (
        <Container>
            <Box sx={{ display: 'flex', justifyContent: 'flex-end' } }>
                <Button variant="contained" color="primary" onClick={handleOpenDialog} maxWidth="xl">New Loan</Button>
            </Box>
            <ProgramCommitmentTable />
            <CreateLoan open={openDialog} handleClose={handleCloseDialog} onSubmit={handleFormSubmit}  />
        </Container>
    );
}


  
  