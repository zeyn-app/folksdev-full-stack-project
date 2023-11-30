import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
  state = {
    // [] collection, {} an object
    customer: {
      accounts:[{
        transactions:[]
      }]
    }
  };

  async componentDidMount() {
    const response = await fetch('/v1/customers/8b49c39c-c13e-4129-830d-bf152305fb2c');
    const body = await response.json();
    this.setState({customer: body});
  }

  render() {
    const {customer} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Customer</h2>
              <div key={customer.id}>
                  {customer.name} {customer.surname},
                {customer.accounts.map(account =>
                  <p key={account.id}>
                    {account.balance}, ({account.creationDate}),
                    {account.transactions.map(transaction=>(
                        <div key={transaction.id}>
                          transactionInfo: {transaction.amount}, {transaction.transactionDate}, {transaction.transactionType}
                        </div>
                    ))}
                  </p>)}
              </div>
            </div>
          </header>
        </div>
    );
  }
}
export default App;

