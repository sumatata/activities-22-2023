import { Link } from 'react-router-dom';
export function MenuComponent(){
    return (
        <div className="side-menu">
        <h2>Menu</h2>
        <ul>
          <li><Link to="/view-loans">View Loans</Link></li>
          <li><Link to="/apply-loan">Apply for Loan</Link></li>
          <li><Link to="/loan-status">Loan Status</Link></li>
        </ul>
      </div>
      );
}