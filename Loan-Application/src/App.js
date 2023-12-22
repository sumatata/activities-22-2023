import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import { RegisterPage } from './components/RegisterPage';
import { LoginPage } from './components/LoginPage';
import { LoanStatus } from './components/LoanStatus';
import { ApplyLoan } from './components/ApplyLoan';
import { LoanView } from './components/LoanView';
import { MenuComponent } from './components/MenuComponent';
import './App.css';

function App() {
  return (
    // <Router>
    //   <Switch>
    //     <Route exact path="/" component={RegisterPage} />
    //     <Route path="/login" component={LoginPage} />
    //     {/* Add other routes as needed */}
    //   </Switch>
    // </Router>
    <Router>
      <div style={{ display: 'flex' }}>
        <MenuComponent />
        <Switch>
          <Route path="/view-loans" component={LoanView} />
          <Route path="/apply-loan" component={ApplyLoan} />
          <Route path="/loan-status" component={LoanStatus} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
