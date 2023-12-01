import React, {Component} from 'react';
import logo from "./logo.svg";

// /v1/accounts
class Account extends Component{
    state = {
        account: {
            transactions: []
        }
    };

    constructor(props) {
        super(props);
        this.state = {
            createAccountRequest:{
                id: "",
                amount: ""
            }
        }
    }



    async componentDidMount(){
        this.setState({
            createAccountRequest:{
                id: this.props.match.params.id,
                amount: ""
            }
            }
        )
    }

    async handleSubmit(event) {
        event.preventDefault(); // butona basınca tüm sayfanın yenilenmesini engellliyor
        const {item} = this.state;

        await fetch('/v1/accounts', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/clients');
    }

    render() {
        const {createAccountRequest} = this.state
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <div className="App-intro">
                        <h2>Create Account</h2>
                        {createAccountRequest.id}
                        <div></div>
                    </div>
                </header>
            </div>
        );
    }



}

export default Account;