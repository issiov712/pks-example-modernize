import './assets/styles/App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from'./pages/Login'
import Dashboard from'./pages/Dashboard'
import ProgramCommitmentList from './pages/ProgramCommitnetList';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';

function App() {
  return (
    
    <Router>
      <Header/>
    <Routes>
      <Route path="/" element={<Login/>} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/login" element={<Login/>} />
      <Route path="/loan-terms" element={<ProgramCommitmentList/>} />
    </Routes>
    <Footer/>
  </Router>
   
  );
}

export default App;
