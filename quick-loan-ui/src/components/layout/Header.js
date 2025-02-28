import React from 'react';
import { AppBar, Toolbar, Typography, Box } from '@mui/material';
import { ReactComponent as ReactLogo } from '../../assets/logo.svg';

export default function Header() {
    return (
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static" sx={{ background: 'linear-gradient(to right, #3b82f6, #9333ea)', boxShadow: 3 }}>
          <Toolbar sx={{ display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
            <ReactLogo style={{ width: '60px', height: '60px' }} />
            <Typography variant="h4" component="h1" sx={{ fontWeight: 'bold', color: 'white' }}>
              Welcome to FFB
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
    );
  }
  