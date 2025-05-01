import React from 'react';
import { Route } from 'react-router-dom';
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Page from './components/layout/Page';
import LoanTerms from './pages/LoanTerms';
import { DropdownProvider } from './context/dropDownContext';
import { SnackbarProvider } from "./context/SnackbarContext"; 
import { InterestRateProvider } from './context/IntrestRateContext';

const routes = [
  { path: '/', element: <Login /> },
  { path: '/login', element: <Login /> },
  { path: '/dashboard', element: <Dashboard /> },
  { path: '/settings', element: <Page title="Settings" /> },
  // Admin Routes
  { path: '/program-commitment', element: <Page title="Program Commitment" /> },
  { path: '/agency', element: <Page title="Agency/Agency Contract" /> },
  { path: '/contractual-pricing', element: <Page title="Contractual Pricing" /> },
  { path: '/borrower-info', element: <Page title="Borrower Information" /> },
  { path: '/borrower-commitment', element: <Page title="Borrower Commitment" /> },
  
  { path: '/loan-terms', element:(<SnackbarProvider> 
                                  <InterestRateProvider>
                                  <DropdownProvider> 
                                      <LoanTerms /> 
                                  </DropdownProvider>
                                  </InterestRateProvider> 
                                  </SnackbarProvider>
                                   ) },
  { path: '/pricing-terms', element: <Page title="Pricing Terms" /> },
  { path: '/loan-pricing', element: <Page title="Loan Pricing" /> },
  { path: '/rate-certification', element: <Page title="Rate Certification" /> },
  { path: '/pricing-approval', element: <Page title="Pricing Approval" /> },
  { path: '/prepayment', element: <Page title="Prepayment" /> },
  { path: '/maturity-extension', element: <Page title="Maturity Extension" /> },
  { path: '/standalone-programs', element: <Page title="Standalone Programs" /> },
  { path: '/reports', element: <Page title="Reports" /> },
  { path: '/cohort', element: <Page title="Cohort/Subcohort" /> },
  
  // Util Routes
  { path: '/batch-jobs', element: <Page title="Submit Batch Jobs" /> },
  { path: '/tables', element: <Page title="Tables" /> },
  { path: '/logs', element: <Page title="Logs" /> },
  // User Routes
  { path: '/password', element: <Page title="Change Password" /> },
];

const RouteComponents = routes.map(({ path, element }, key) => (
  <Route key={key} path={path} element={element} />
));

export default RouteComponents;