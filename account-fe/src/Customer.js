import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";
import { Link } from 'react-router-dom';
import { Button } from 'reactstrap';
import { BrowserRouter as Router, Switch } from 'react-router-dom';


class Customer extends Component {
    state = {
        // [] collection, {} an object
        customer: {
            accounts:[{
                transactions:[]
            }]
        }
    };

    async componentDidMount() {
        const response = await fetch('/v1/customers/e0598665-6bf7-4a22-9ee8-564e3a9e644f');
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
                            <Router>
                                <Switch>
                                    <Button color="link"><Link to="/account">Account</Link></Button>
                                </Switch>
                            </Router>
                        </div>
                    </div>
                </header>
            </div>
        );
    }
}
export default Customer;

