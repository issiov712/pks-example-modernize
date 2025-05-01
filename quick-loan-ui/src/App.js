import './assets/styles/App.css';
import { BrowserRouter as Router, Routes } from 'react-router-dom';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import RouteComponents from './routes';

function App() {
  return (
    
    <Router>
      <Header/>
      <Routes>
        {RouteComponents}
      </Routes>
      <Footer/>
  </Router>
   
  );
}

export default App;
