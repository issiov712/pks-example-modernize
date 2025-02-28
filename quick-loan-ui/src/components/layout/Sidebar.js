import React, { useCallback, useState } from 'react';
import { Link } from 'react-router-dom';
import { Box, List, ListItem, ListItemText, Collapse, Divider, Drawer, Toolbar, Avatar, ListItemIcon } from '@mui/material';
import ExpandLessIcon from '@mui/icons-material/ExpandLess';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import AccountBalanceIcon from '@mui/icons-material/AccountBalance';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import DashboardIcon from '@mui/icons-material/Dashboard';

export default function Sidebar() {
  const drawerWidth = 250;
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
    <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Toolbar>
          <Avatar>H</Avatar>          
        </Toolbar>
        <Divider />
        <List>
          <ListItem button component={Link} to="/dashboard">
            <ListItemIcon><DashboardIcon /></ListItemIcon>
            <ListItemText primary="Dashboard" />
          </ListItem>
          <ListItem button component={Link} to="/loan-terms">
            <ListItemIcon><AccountBalanceIcon /></ListItemIcon>
            <ListItemText primary="Loan Review" />
          </ListItem>
          <Divider />         
          <ListItem button onClick={() => toggleMenu('adminMenu')}>
            <ListItemIcon><AdminPanelSettingsIcon /></ListItemIcon>
            <ListItemText primary="Administration" />
            {expandedMenu.adminMenu ? <ExpandLessIcon /> : <ExpandMoreIcon />}
          </ListItem>
          <Collapse in={expandedMenu.adminMenu} timeout="auto" unmountOnExit>
            <List component="div" disablePadding>
              <ListItem button component={Link} to="/settings">
                <ListItemText primary="Settings" />
              </ListItem>
            </List>
          </ Collapse>
        </List>
      </Drawer>
  );
}
