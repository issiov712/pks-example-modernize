import { useState } from 'react';
import LoanTermTable from '../components/LoanTerm/LoanTermTable';
import Container from '../components/layout/Container';
import { Box, Button ,  Snackbar, Alert} from '@mui/material';
import CreateLoan from '../components/CreateEditLoan';
import { useSnackbarContext } from "../context/SnackbarContext";

export default function LoanTerms() {
    const [openDialog, setOpenDialog] = useState(false);
    const { snackbarMessage, setSnackbarMessage} = useSnackbarContext();
    const handleOpenDialog = () => setOpenDialog(true);
    const handleCloseDialog = () => setOpenDialog(false);

    return (
        <Container>
            <Box sx={{ display: 'flex', justifyContent: 'flex-end', paddingBottom: 4 } }>
                <Button variant="contained" color="primary" onClick={handleOpenDialog} maxWidth="xl">New Loan</Button>
            </Box>
            <LoanTermTable />
            <CreateLoan open={openDialog} handleClose={handleCloseDialog} onSubmit={null/*may use later*/} setSnackbarMessage={setSnackbarMessage}   />
            
            {/*Snackbar Appears on Dashboard After Submit */}
            <Snackbar
                open={!!snackbarMessage}
                autoHideDuration={3000}
                onClose={() => setSnackbarMessage("")}
                anchorOrigin={{ vertical: "bottom", horizontal: "center" }}
            >
                <Alert onClose={() => setSnackbarMessage("")} severity="success" sx={{ width: "100%" }}>
                    {snackbarMessage}
                </Alert>
            </Snackbar>
        </Container>

    );
} 
  