import React from "react";
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
  const methodOptions = getDropdownOptions("methods");
  const periodOptions = getDropdownOptions("period");

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
          <Box sx={{ display: "flex", gap: 3, flexDirection: { xs: "column", md: "row" } }}>
            <Paper elevation={3} sx={{ flex: 1, padding: 3, borderRadius: 2 }}>
              <TextField
                id="loan-name"
                required
                fullWidth
                label="Loan Name"
              />
              <TextField
                id="loan-description"
                fullWidth
                sx={{ mt: 2 }}
                {...register("program", { required: "Loan description is required" })}
                label="Loan Description"
                multiline
                minRows={2}
                maxRows={4}
              />
              {/* Get from API */}
              <TextField
                id="loan-rate"
                required
                {...register("rate", { required: "Loan rate is required" })}
                label="Loan Rate"
                type="number"
                sx={{ mt: 2 }}
                slotProps={{
                  input: {
                    readOnly: true,
                  },
                  inputLabel: {
                    shrink: true,
                  },
                }}
              />
              <TextField
                id="loan-amount"
                required
                {...register("program", { required: "Loan amount is required" })}
                label="Loan Amount"
                type="number"
                sx={{ mt: 2, ml: 2 }}
                slotProps={{
                  inputLabel: {
                    shrink: true,
                  },
                }}
              />
              <TextField
                id="load-method"
                required
                label="Method Type"
                select
                sx={{ mt: 2, ml: 2, width: "25%" }}
                {...register("method", { required: "Method Type is required" })}
                error={!!errors.method}
                helperText={errors.method ? errors.method.message : ""}
              >
                {methodOptions.map((option) => (
                  <MenuItem key={option.key} value={option.value}>
                    {option.name}
                  </MenuItem>
                ))}
              </TextField>
              <TextField
                id="loan-period"
                required
                label="Period Type"
                select
                sx={{ mt: 2, ml: 2, width: "25%" }}
                {...register("period", { required: "Period Type is required" })}
                error={!!errors.period}
                helperText={errors.period ? errors.period.message : ""}
              >
                {periodOptions.map((option) => (
                  <MenuItem key={option.key} value={option.value}>
                    {option.name}
                  </MenuItem>
                ))}
              </TextField>
            <TextField
              label="Disbursement Date"
              type="date"
              sx={{ mt: 2, width: "25%" }}
              {...register("disbursementDate", { required: "Disbursement date is required" })}
              error={!!errors.startDate}
              helperText={errors.startDate ? errors.startDate.message : ""}
              InputLabelProps={{ shrink: true }}
            />
            <TextField
              label="Statement Date"
              type="date"
              sx={{ mt: 2, ml: 2, width: "25%" }}
              {...register("disbursementDate", { required: "Disbursement date is required" })}
              error={!!errors.startDate}
              helperText={errors.startDate ? errors.startDate.message : ""}
              InputLabelProps={{ shrink: true }}
            />
            <TextField
              label="Interest Date"
              type="date"
              sx={{ mt: 2, ml: 2, width: "25%" }}
              {...register("disbursementDate", { required: "Disbursement date is required" })}
              error={!!errors.startDate}
              helperText={errors.startDate ? errors.startDate.message : ""}
              InputLabelProps={{ shrink: true }}
            />
            <TextField
              label="Principal Date"
              type="date"
              sx={{ mt: 2, width: "25%" }}
              {...register("disbursementDate", { required: "Disbursement date is required" })}
              error={!!errors.startDate}
              helperText={errors.startDate ? errors.startDate.message : ""}
              InputLabelProps={{ shrink: true }}
            />
            <TextField
              label="Current Maturity Date"
              type="date"
              sx={{ mt: 2, ml: 2, width: "25%" }}
              {...register("disbursementDate", { required: "Disbursement date is required" })}
              error={!!errors.startDate}
              helperText={errors.startDate ? errors.startDate.message : ""}
              InputLabelProps={{ shrink: true }}
            />
            <TextField
              label="Final Maturity Date"
              type="date"
              sx={{ mt: 2, ml: 2, width: "25%" }}
              {...register("disbursementDate", { required: "Disbursement date is required" })}
              error={!!errors.startDate}
              helperText={errors.startDate ? errors.startDate.message : ""}
              InputLabelProps={{ shrink: true }}
            />
              {/* <TextField
              label="Purchase Date"
              type="date"
              sx={{
                  mt: 2,
                  ml: 2,
                  width: "25%",
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
            /> */}
            </Paper>
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
