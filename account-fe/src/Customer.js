import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Link, Switch} from 'react-router-dom';
import {Button} from 'reactstrap';


class Customer extends Component {
    state = {
        // [] collection, {} an object
        // customer: {
        //     accounts:[{
        //         transactions:[]
        //     }]
        // }

        customers: [{
            accounts: [{
                transactions: []
            }]

        }]
    };

    async componentDidMount() {
        const response = await fetch('/v1/customers');
        const body = await response.json();
        this.setState({customers: body});
    }

    handleRefreshClick = () => {
        // Reload the page
        window.location.reload();
    };


    render() {
        const {customers} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Customer</h2>
                        {customers.map(customer =>
                            <div key={customer.id}>
                                {customer.name} {customer.surname},
                                {customer.accounts.map(account =>
                                    <p key={account.id}>
                                        {account.balance}, ({account.creationDate}),
                                        {account.transactions.map(transaction => (
                                            <div key={transaction.id}>
                                                transactionInfo: {transaction.amount}, {transaction.transactionDate}, {transaction.transactionType}
                                            </div>
                                        ))}
                                    </p>)}
                                <Router>
                                    <Switch>
                                        <Button color="link"  onClick={this.handleRefreshClick}>
                                            <Link to={`/account/${customer.id}`}>Account</Link>
                                        </Button>
                                    </Switch>
                                </Router>
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default Customer;

