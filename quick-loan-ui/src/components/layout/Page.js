import { Typography } from "@mui/material";

export default function Page({ title }) {
    return (
      <Container>
        <Typography variant="h4" sx={{ fontWeight: 'bold', mb: 2 }}>
            {title}
        </Typography>
        <Typography variant="body1" sx={{ color: '#555' }}>
            Welcome to your {title} page! This page is a work in progress.
        </Typography>
      </Container>
    );
}