import { useState } from "react";
import { Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle, TextField } from "@mui/material";

export default function CreateLoan({ showModal, handleShowModal }) {
    const [loanName, setLoanName] = useState('');
    const [loanAmount, setLoanAmount] = useState('');

    const handleOnSubmit = (event) => {
        event.preventDefault();
        // @TODO Add loan to the table
        console.log('Loan Name:', loanName);
        console.log('Loan Amount:', loanAmount);
        handleShowModal();
    }

    return (
        <Dialog open={showModal} onClose={handleShowModal}>
                <DialogTitle>Create New Loan Terms</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                    Please fill out the form below to add a new loan.
                    </DialogContentText>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="loanName"
                        label="Loan Name"
                        type="text"
                        fullWidth
                        variant="standard"
                        value={loanName}
                        onChange={(e) => setLoanName(e.target.value)}
                    />
                    <TextField
                        margin="dense"
                        id="loanAmount"
                        label="Loan Amount"
                        type="number"
                        fullWidth
                        variant="standard"
                        value={loanAmount}
                        onChange={(e) => setLoanAmount(e.target.value)}
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleShowModal}>Cancel</Button>
                    <Button onClick={handleOnSubmit} variant="contained" color="primary">
                        Calculate
                    </Button>
                </DialogActions>
            </Dialog>
    )
}