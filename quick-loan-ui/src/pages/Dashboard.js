import React from 'react';
import Container from '../components/layout/Container';
import { Typography } from '@mui/material';

export default function Dashboard() {
  return (
    <Container>
      <Typography variant="h4" sx={{ fontWeight: 'bold', mb: 2 }}>
        Dashboard
      </Typography>
      <Typography variant="body1" sx={{ color: '#555' }}>
        Welcome to your dashboard! Here you can manage your data and settings.
      </Typography>
    </Container>
  );
}
