import React, { useCallback, useState } from 'react';
import { Box, List, ListItem, ListItemText, Collapse, Divider } from '@mui/material';
import ExpandLessIcon from '@mui/icons-material/ExpandLess';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import { Link } from 'react-router-dom';

export default function Sidebar() {
  const [expandedMenu, setExpandedMenu] = useState({
    adminMenu: false, 
    utilMenu: false, 
    userMenu: false
  });

  const toggleMenu = useCallback((menu) => {
    setExpandedMenu((prevState) => ({
      ...prevState,
      [menu]: !prevState[menu],
    }));
  }, []);

  return (
    <Box
      component="nav"
      sx={{
        width: '240px',
        height: 'calc(100vh - 95px)',
        color: 'black',
        position: 'fixed',
        top: '95px',
        left: 0,
        display: 'flex',
        flexDirection: 'column',
        padding: 2,
        zIndex: 1200,
      }}
    >
      <Divider sx={{ backgroundColor: 'rgba(0, 0, 0, 0.1)', mb: 2 }} />
      <List>
        {/* Admin Menu */}
        <ListItem button onClick={() => toggleMenu('adminMenu')} sx={{ padding: '12px 20px', borderRadius: '8px', '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
          <ListItemText primary="Administration" />
          {expandedMenu.adminMenu ? <ExpandLessIcon /> : <ExpandMoreIcon />}
        </ListItem>
        <Collapse in={expandedMenu.adminMenu} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>
          <ListItem button component={Link} to="/program-commitment" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Program Commitment" />
            </ListItem>
            <ListItem button component={Link} to="/agency" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Agency/Agency Contact" />
            </ListItem>
            <ListItem button component={Link} to="/contractual-pricing" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Contractual Pricing Terms" />
            </ListItem>
            <ListItem button component={Link} to="/borrower-info" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Borrower Information" />
            </ListItem>
            <ListItem button component={Link} to="/borrower-commitment" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Borrower Commitment" />
            </ListItem>
            <ListItem button component={Link} to="/loan-terms" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Loan Terms" />
            </ListItem>
            <ListItem button component={Link} to="/pricing-terms" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Pricing Terms" />
            </ListItem>
            <ListItem button component={Link} to="/loan-pricing" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Select Loans for Pricing" />
            </ListItem>
            <ListItem button component={Link} to="/rate-certification" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Rate Certification" />
            </ListItem>
            <ListItem button component={Link} to="/pricing-approval" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Pricing Approval" />
            </ListItem>
            <ListItem button component={Link} to="/prepayment" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Prepayment" />
            </ListItem>
            <ListItem button component={Link} to="/maturity-extension" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Maturity Extension" />
            </ListItem>
            <ListItem button component={Link} to="/standalone-programs" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Standalone Programs" />
            </ListItem>
            <ListItem button component={Link} to="/reports" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Reports" />
            </ListItem>
            <ListItem button component={Link} to="/cohort" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Cohort/Subcohort" />
            </ListItem>
          </List>
        </Collapse>
        {/* Utilities Menu */}
        <ListItem button onClick={() => toggleMenu('utilMenu')} sx={{ padding: '12px 20px', borderRadius: '8px', '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
          <ListItemText primary="Utilities" />
          {expandedMenu.utilMenu ? <ExpandLessIcon /> : <ExpandMoreIcon />}
        </ListItem>
        <Collapse in={expandedMenu.utilMenu} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>
            <ListItem button component={Link} to="/batch-jobs" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Submit Batch Jobs" />
            </ListItem>
            <ListItem button component={Link} to="/tables" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="View Tables" />
            </ListItem>
            <ListItem button component={Link} to="/logs" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="View Logs" />
            </ListItem>
          </List>
        </Collapse>

        {/* User Access Menu */}
        <ListItem button onClick={() => toggleMenu('userMenu')} sx={{ padding: '12px 20px', borderRadius: '8px', mt: 1, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
          <ListItemText primary="User Access Control" />
          {expandedMenu.userMenu ? <ExpandLessIcon /> : <ExpandMoreIcon />}
        </ListItem>
        <Collapse in={expandedMenu.userMenu} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>
            <ListItem button component={Link} to="/password" sx={{ pl: 4, '&:hover': { backgroundColor: 'rgba(0, 0, 0, 0.05)' } }}>
              <ListItemText primary="Change Password" />
            </ListItem>
          </List>
        </Collapse>
      </List>
    </Box>
  );
}
