import Table from 'react-bootstrap/Table';
import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Link, Switch} from 'react-router-dom';
import {Button} from 'reactstrap';


class Customer extends Component {
    state = {
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
        const { customers } = this.state;

        return (
            <div className="App">
                <header className="App-header">
                    <div className="App-intro">
                        {customers.map((customer) => (
                            <div key={customer.id}>
                                <h2>{`${customer.name} ${customer.surname}`}</h2>
                                <Table striped bordered hover>
                                    <thead>
                                    <tr>
                                        <th>AccountId</th>
                                        <th>Balance</th>
                                        <th>TransactionDate</th>
                                        <th>TransactionType</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {customer.accounts.map((account) => (
                                        <tr key={account.id}>
                                            <td>{account.id}</td>
                                            <td>{account.balance}</td>
                                            <td>
                                                {account.transactions.map((transaction) => (
                                                    <div key={transaction.id}>
                                                        {transaction.transactionDate}
                                                    </div>
                                                ))}
                                            </td>
                                            <td>
                                                {account.transactions.map((transaction) => (
                                                    <div key={transaction.id}>
                                                        {transaction.transactionType}
                                                    </div>
                                                ))}
                                            </td>
                                        </tr>
                                    ))}
                                    </tbody>
                                </Table>
                                <Router>
                                    <Switch>
                                        <Button color="link" onClick={this.handleRefreshClick}>
                                            <Link to={`/account/${customer.id}`}>Create Account</Link>
                                        </Button>
                                    </Switch>
                                </Router>
                            </div>
                        ))}
                    </div>
                </header>
            </div>
        );
    }
}

export default Customer;