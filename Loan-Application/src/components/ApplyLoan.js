import React, { useState } from 'react';
export function ApplyLoan(){
    const [loanType, setLoanType] = useState('');

    const handleLoanTypeChange = (e) => {
      setLoanType(e.target.value);
    };
    return (
        <div className="apply-loan container-fluid">
        <h2>Apply Loan</h2>
        <form>
          <label htmlFor="loanType">Loan Type:</label>
          <select id="loanType" name="loanType" value={loanType} onChange={handleLoanTypeChange}  className="form-control">
            <option value="">Select Loan Type</option>
            <option value="personal">Personal Loan</option>
            <option value="home">Home Loan</option>
            <option value="car">Car Loan</option>
            <option value="gold">Gold Loan</option>
            <option value="educational">Educational Loan</option>
            {/* Add more options as needed */}
          </select>
  <br/>
          {/* Add other form fields and submit button as needed */}
          <button type="submit" className='btn btn-sm btn-info'>Submit</button>
        </form>
      </div>
      );
}