import React, { useState } from "react";
import { DataGrid } from "@mui/x-data-grid";
import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Button,
  TextField,
  MenuItem,
  InputAdornment,
  Box,
  Paper
} from "@mui/material";
import { useForm } from "react-hook-form";

import { useDropdown } from "../context/dropDownContext"; // Import the dropdown hook

export default function CreateLoan({ open, handleClose, onSubmit }) {
  const {
    register,
    handleSubmit,
    formState: { errors },
    reset
  } = useForm();

  

  const { getDropdownOptions } = useDropdown(); // Use the dropdown context

  // Retrieve dropdown data dynamically
  const programOptions = getDropdownOptions("programs");
  const agencyOptions = getDropdownOptions("agencies");
  const categoryOptions = getDropdownOptions("categories");

  //Data For the Grid
  const columns = [
    { field: "type", headerName: "Type", width: 200 },
    { field: "loanBalance", headerName: "Loan Balances", width: 200 }
  ];

  const rows = [
    {id:1, type: "Type A", loanBalance: "-" },
    {id:2, type: "Type B", loanBalance: "-" },
    {id:3, type: "Type C", loanBalance: "-" },
    {id:4, type: "Type D", loanBalance: "-" },
    {id:5, type: "Type E", loanBalance: "-" },
    {id:6, type: "Type F", loanBalance: "-" },
    {id:7, type: "Type G", loanBalance: "-" },
    {id:8, type: "Type H", loanBalance: "-" }
  ];
  //End Grid Data

  

  const handleFormSubmit = (data) => {
    onSubmit(data); // Pass form data to parent
    reset(); // Reset the form
    handleClose(); // Close dialog
  };

  return (
    <Dialog open={open} onClose={handleClose} fullWidth maxWidth="xl">
      <DialogTitle>Add New Loan</DialogTitle>
      <form id="Loan" onSubmit={handleSubmit(handleFormSubmit)}>
      <DialogContent>
        
      {/* Two-row layout using Flexbox */}
      <Box sx={{ display: "flex", flexDirection: "column", gap: 3 }}>
              {/* First Row */}
              <Box sx={{ display: "flex", gap: 3, flexDirection: { xs: "column", md: "row" } }}>
                {/* Left Side */}
                <Paper elevation={3} sx={{ flex: 1, padding: 3, borderRadius: 2 }}>

        <TextField
            label="Program"
            select
            fullWidth
            sx={{ mt: 2 }}
            {...register("program", { required: "Program is required" })}
            error={!!errors.program}
            helperText={errors.program ? errors.program.message : ""}
          >
            {programOptions.map((option) => (
              <MenuItem key={option.key} value={option.value}>
                {option.name}
              </MenuItem>
            ))}
          </TextField>

          <TextField
            label="Borrower Code"
            select
            fullWidth
            sx={{ mt: 2 }}
            {...register("borrowerCode", { required: "Program is required" })}
            error={!!errors.program}
            helperText={errors.program ? errors.program.message : ""}
          >
            {categoryOptions.map((option) => (
              <MenuItem key={option.key} value={option.value}>
                {option.name}
              </MenuItem>
            ))}
          </TextField>

          <TextField
            label="Distributaion Date"
            type="date"
            fullWidth
            sx={{ mt: 2 }}
            {...register("distributaionDate", { required: "Start date is required" })}
            error={!!errors.startDate}
            helperText={errors.startDate ? errors.startDate.message : ""}
            InputLabelProps={{ shrink: true }}
          />

            <TextField
            label="Purchase Date"
            type="date"
            fullWidth
            sx={{
                mt: 2,
                backgroundColor: "#f0f0f0",  // Light gray background
                opacity: 0.7,                // Dimmed effect
                pointerEvents: "none",       // Prevents interaction
                borderRadius: "4px",
              }}
            {...register("purchaseDate", { required: "Start date is required" })}
            error={!!errors.startDate}
            helperText={errors.startDate ? errors.startDate.message : ""}
            InputLabelProps={{ shrink: true }}
            InputProps={{ readOnly: true }}
          />


        
        <TextField
            label="Consolidation"
            select
            fullWidth
            sx={{ mt: 2 }}
            {...register("consolidation", { required: "Program is required" })}
            error={!!errors.program}
            helperText={errors.program ? errors.program.message : ""}
          >
            {categoryOptions.map((option) => (
              <MenuItem key={option.key} value={option.value}>
                {option.name}
              </MenuItem>
            ))}
          </TextField>
        
        
          <TextField
            label="New Cash Amount ($)"
            type="number"
            fullWidth
            sx={{ mt: 2 }}
            {...register("newCashAmount", { required: "Commitment is required", valueAsNumber: true })}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
            InputProps={{
                startAdornment: <InputAdornment position="start">$</InputAdornment>,
            }}
          />

           
        <TextField
            label="FundSymbol"
            type="input"
            fullWidth
            sx={{ mt: 2 }}
            {...register("fundSymbol", { required: "Commitment is required"})}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
          />
          
          
    </Paper>


 {/* Right Side */}
 <Paper elevation={3} sx={{ flex: 1, padding: 3, borderRadius: 2 }}>
<TextField
            label="Fund Symbol/Status Date"
            type="date"
            fullWidth
            sx={{
                mt: 2,
                backgroundColor: "#f0f0f0",  // Light gray background
                opacity: 0.7,                // Dimmed effect
                pointerEvents: "none",       // Prevents interaction
                borderRadius: "4px",
              }}
            {...register("purchaseDate", { required: "Start date is required" })}
            error={!!errors.startDate}
            helperText={errors.startDate ? errors.startDate.message : ""}
            InputLabelProps={{ shrink: true }}
            InputProps={{ readOnly: true }}
          />
    <TextField
            label="Loan Id"
            type="number"
            fullWidth
            sx={{
                mt: 2,
                backgroundColor: "#f0f0f0",  // Light gray background
                opacity: 0.7,                // Dimmed effect
                pointerEvents: "none",       // Prevents interaction
                borderRadius: "4px",
              }}
            {...register("loanId", { required: "Commitment is required", valueAsNumber: true })}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
            InputProps={{ readOnly: true }}
            
          />
        <TextField
            label="Note number"
            type="number"
            fullWidth
            sx={{
                mt: 2,
                backgroundColor: "#f0f0f0",  // Light gray background
                opacity: 0.7,                // Dimmed effect
                pointerEvents: "none",       // Prevents interaction
                borderRadius: "4px",
              }}
            {...register("noteNumber", { required: "Commitment is required", valueAsNumber: true })}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
            InputProps={{ readOnly: true }}
            
          />

<TextField
            label="Face Amount"
            type="number"
            fullWidth
            sx={{
                mt: 2,
                backgroundColor: "#f0f0f0",  // Light gray background
                opacity: 0.7,                // Dimmed effect
                pointerEvents: "none",       // Prevents interaction
                borderRadius: "4px",
              }}
            {...register("faceAmount", { required: "Commitment is required", valueAsNumber: true })}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
            InputProps={{
                startAdornment: <InputAdornment position="start">$</InputAdornment>,
                readOnly: true
            }}
          />

<TextField
            label="Loan Amount ($)"
            type="number"
            fullWidth
            sx={{ mt: 2 }}
            {...register("loan Amount", { required: "Commitment is required", valueAsNumber: true })}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
            InputProps={{
                startAdornment: <InputAdornment position="start">$</InputAdornment>,
            }}
          />

        <TextField
            label="Loan Fee Initiator"
            select
            fullWidth
            sx={{ mt: 2 }}
            {...register("loanFeeInitiator", { required: "Agency is required" })}
            error={!!errors.agency}
            helperText={errors.agency ? errors.agency.message : ""}
            >
         {agencyOptions.map((option) => (
              <MenuItem key={option.key} value={option.value}>
                {option.name}
              </MenuItem>
            ))}
        </TextField>

          <TextField
            label="Loan Fee Amount"
            type="number"
            fullWidth
            sx={{ mt: 2 }}
            {...register("loan feee amount", { required: "Commitment is required", valueAsNumber: true })}
            error={!!errors.commitment}
            helperText={errors.commitment ? errors.commitment.message : ""}
            InputProps={{
                startAdornment: <InputAdornment position="start">$</InputAdornment>,
            }}
          />
         
         </Paper>
      </Box>
{/* Second Row */}
<Box sx={{ display: "flex", gap: 3, flexDirection: { xs: "column", md: "row" } }}>
                <Paper elevation={3} sx={{ flex: 1, padding: 3, borderRadius: 2 }}>
                 
                <DataGrid rows={rows} columns={columns} pageSize={5} rowsPerPageOptions={[5]} />
                </Paper>
                <Paper elevation={3} sx={{ flex: 1, padding: 3, borderRadius: 2 }}>
                  <TextField
                    label="Additional Notes"
                    multiline
                    rows={4}
                    fullWidth
                    sx={{ mb: 2 }}
                    {...register("notes")}
                  />
                </Paper>
              </Box>
            </Box>

      </DialogContent>
      </form>
      <DialogActions>
        <Button onClick={handleClose} color="secondary">
          Cancel
        </Button>
        <Button type="submit" form="commitment-form" variant="contained" color="primary">
          Submit
        </Button>
      </DialogActions>
    </Dialog>
  );
}
