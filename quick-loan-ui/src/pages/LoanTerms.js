import { useState } from 'react';
import ProgramCommitmentTable from '../components/ProgramCommitment/ProgramCommitmentTable';
import Container from '../components/layout/Container';
import { Box, Button } from '@mui/material';
import CreateLoan from '../components/CreateLoan';

export default function LoanTerms() {
    const [showModal, setShowModal] = useState(false);
    
    const handleShowModal = () => {
        setShowModal(!showModal);
    }

    return (
        <Container>
            <Box sx={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button variant="contained" color="primary" onClick={handleShowModal}>Add Loan</Button>
            </Box>
            <ProgramCommitmentTable />
            <CreateLoan showModal={showModal} handleShowModal={handleShowModal} />
        </Container>
    );
}


  
  